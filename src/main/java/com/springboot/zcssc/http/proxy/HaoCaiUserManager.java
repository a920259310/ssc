package com.springboot.zcssc.http.proxy;

import com.springboot.zcssc.http.request.bean.HaoCaiXiaBean;
import com.springboot.zcssc.http.request.config.HaoCaiApi;
import com.springboot.zcssc.http.response.*;
import com.springboot.zcssc.utils.ImgUtil;
import com.springboot.zcssc.utils.JSONUtils;
import com.springboot.zcssc.zcssc.service.impl.BaseServiceImpl;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.LoggerFactory;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

public class HaoCaiUserManager {
    protected org.slf4j.Logger logger = LoggerFactory.getLogger(BaseServiceImpl.class);
    //API配置类
    HaoCaiApi haoCaiApi = new HaoCaiApi();
    //http访问类
    HttpClient httpClient = new HttpClient();

    private String userName;
    private String password;

    {
        httpClient.getParams().setParameter(
                HttpMethodParams.HTTP_CONTENT_CHARSET, "utf-8");
    }

    public HaoCaiUserManager(String userName, String password) throws IOException {

        this.userName = userName;
        this.password = password;
        Boolean login = login(this.userName, this.password);

        int i = 0;
        while (!login){
            if(i > 10){
                throw new RuntimeException("登陆失败");
            }
            logger.warn("userName:"+userName+"   password:"+password+",第"+(i+1)+"次登陆失败,准备第"+(i+2)+"次登陆......");
            login=login(this.userName, this.password);

            if(login){
                break;
            }
            i++;
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        System.setProperty("javax.net.ssl.trustStore", "D:\\openSources\\jdk1.8\\lib\\security\\jssecacerts");
        HaoCaiUserManager account = new HaoCaiUserManager("a920259310", "678b557478a23722cba4e963d48bd620");
//        System.out.println(account);
//        HaoCaiXiaBean haoCaiXiaBean = new HaoCaiXiaBean();
//        haoCaiXiaBean.setUniqueId(1);
//        haoCaiXiaBean.setDrawNumber("724142");
//        List<HaoCaiXiaBean.BetsBean> bets = new ArrayList<HaoCaiXiaBean.BetsBean>();
//        haoCaiXiaBean.setBets(bets);
//        HaoCaiXiaBean.BetsBean bet = new HaoCaiXiaBean.BetsBean();
//        bets.add(bet);
//        bet.setGame("B1");
//        bet.setContents("9");
//        bet.setAmount(1);
//        bet.setOdds(9.95);
//
//        Boolean aBoolean = account.toOrder(haoCaiXiaBean);
//        System.out.println(aBoolean);
    }

    /**
     * 余额查询
     * @return
     * @throws IOException
     */
    public YuEBean queryYuE() throws IOException {
        GetMethod postMethodLogin = new GetMethod(haoCaiApi.getHOST_URL() + haoCaiApi.getAPI_QUERY_YU_E()+"?_=" + new Date().getTime());
        int i = httpClient.executeMethod(postMethodLogin);
        String responseBodyAsString = postMethodLogin.getResponseBodyAsString();
        YuEBean yuEBean = JSONUtils.toBean(responseBodyAsString, YuEBean.class);
        return yuEBean;
    }

    /**
     * 下单接口
     */
    public Boolean toOrder(HaoCaiXiaBean haoCaiXiaBean) throws IOException {
        logger.info("下注接口请求参数haoCaiXiaBean:"+haoCaiXiaBean);
//        https://www.6hc6.com/member/bet
        PostMethod postMethodLogin = new PostMethod(haoCaiApi.getHOST_URL() + haoCaiApi.getAPI_TOU_ZHU());
        String toJSONString = JSONUtils.toJSONString(haoCaiXiaBean);
        postMethodLogin.setRequestBody(toJSONString);
        int i = httpClient.executeMethod(postMethodLogin);

        if(i != 200 ){
            return Boolean.FALSE;
        }

        String responseBodyAsString = postMethodLogin.getResponseBodyAsString();
        //{"message":"无法解析投注内容","status":3}
        logger.info("下注接口响应参数responseBodyAsString:"+responseBodyAsString);
        //{"account":{"balance":1.7400000000000002,"betting":1.000,"freeze":0},"ids":["19010500260954"],"odds":["9.95"],"status":0}
        try {
            TouZhuSeccuss touZhuSeccuss = JSONUtils.toBean(responseBodyAsString, TouZhuSeccuss.class);
            if(touZhuSeccuss != null && touZhuSeccuss.getStatus() == 0){
                return Boolean.TRUE;
            }
        } catch (Exception e) {
            logger.error("投注失败...",e);
        }
        return Boolean.FALSE;
    }


    /**
     * 签到方法
     * @throws IOException
     */
    public SingBean sing() throws IOException {
        /**
         * 签到
         */
        PostMethod postMethodQianDao = new PostMethod(haoCaiApi.getHOST_URL() + haoCaiApi.getAPI_QIAN_DAO());
        int i = httpClient.executeMethod(postMethodQianDao);
        if(i != 200){
            throw new RuntimeException("访问签到接口失败");
        }

        String responseBodyAsString = postMethodQianDao.getResponseBodyAsString();
        System.out.println("签到响应responseBodyAsString:" + responseBodyAsString);
        //签到失败响应:  {"message":"会话已失效，请重新登录系统","status":3}
        //签到成功响应:  {"suceess":true,"couponamount":2.695,"integralNum":6}
        //今日已签到:    {"suceess":false, "msg":"签到失败,您今天已签到"}

        SingBean singBean = JSONUtils.toBean(responseBodyAsString, SingBean.class);

        if(singBean == null || !singBean.isSuceess()){
            throw new RuntimeException("签到接口消息解析失败");
        }
        return singBean;
    }


    /**
     * 获取注册验证码
     * @throws InterruptedException
     * @throws IOException
     */
    public void getRegistPic() throws InterruptedException, IOException {
        Thread.sleep(300l);
        GetMethod getMethod = new GetMethod(haoCaiApi.getHOST_URL()+haoCaiApi.getAPI_ZHU_CE_HOME());
        int executeMethod = httpClient.executeMethod(getMethod);
        Document parse = Jsoup.parse(getMethod.getResponseBodyAsString());
        Elements select = parse.select("#codeimg");
        String src = select.attr("src");

        GetMethod getMethodSrc = new GetMethod(haoCaiApi.getHOST_URL() + src);
        httpClient.executeMethod(getMethodSrc);
        InputStream responseBodyAsStream = getMethodSrc.getResponseBodyAsStream();
        IOUtils.copy(responseBodyAsStream,new FileOutputStream("D:\\haocai\\regist\\" + new Date().getTime() + ".png"));
    }

    /**
     * 账号注册方法
     * @param username
     * @param password
     * @param regcode
     * @throws IOException
     */
    public static Boolean regist(String username,String password,String regcode,HttpClient httpClient,String hostUrl,String zhuCeHomeUri,String zhuCeUri) throws IOException {
        /**
         * 获取验证码
         */
        GetMethod getMethod = new GetMethod(hostUrl+zhuCeHomeUri);
        int executeMethod = httpClient.executeMethod(getMethod);
        Document parse = Jsoup.parse(getMethod.getResponseBodyAsString());
        Elements select = parse.select("#codeimg");
        String src = select.attr("src");

        GetMethod getMethodSrc = new GetMethod(hostUrl + src);

        httpClient.executeMethod(getMethodSrc);
        InputStream responseBodyAsStream = getMethodSrc.getResponseBodyAsStream();
        String regist = "D:\\haocai\\regist\\" + new Date().getTime() + ".jpg";
        IOUtils.copy(responseBodyAsStream,new FileOutputStream(regist));

//        System.err.println("请输入注册验证码:.....");
//        Scanner lll = new Scanner(System.in);
//        String code = lll.next();

        String code = ImgUtil.getCodeByImg(regist);
        /**
         * 注册
         */
        //username=q10003&password=a666666&code=8421&regcode=iRJB000W
        PostMethod postMethodLogin = new PostMethod(hostUrl + zhuCeUri);
        NameValuePair[] postData = {
                new NameValuePair("username", username),
                new NameValuePair("password", password),
                new NameValuePair("regcode", regcode),
                new NameValuePair("code", code)
        };
        postMethodLogin.setRequestBody(postData);
        System.out.println("账号注册参数....username:" + username + "    password:" +  password + "   code:" + code);
        int i = httpClient.executeMethod(postMethodLogin);
        if(i != 200){
            return Boolean.FALSE;
        }
        String responseBodyAsString = postMethodLogin.getResponseBodyAsString();
        System.out.println("注册响应responseBodyAsString:" + responseBodyAsString);
        Regist regist1 = JSONUtils.toBean(responseBodyAsString, Regist.class);

        if(regist1 == null || !regist1.isSuccess()){
            return Boolean.FALSE;
        }
        return Boolean.TRUE;

    }

    /**
     * 初始化登陆
     * @password 密码MD5两次加密
     * @throws IOException
     */
    private Boolean login(String account,String password ) throws IOException {
        /**
         * 获取验证码
         */
        GetMethod getMethod = new GetMethod(haoCaiApi.getHOST_URL());
        int executeMethod = httpClient.executeMethod(getMethod);
        Document parse = Jsoup.parse(getMethod.getResponseBodyAsString());
        Elements select = parse.select("#codeimg");
        String src = select.attr("src");

        GetMethod getMethodSrc = new GetMethod(haoCaiApi.getHOST_URL() + src);
        httpClient.executeMethod(getMethodSrc);
        InputStream responseBodyAsStream = getMethodSrc.getResponseBodyAsStream();
        String login = "D:\\haocai\\login\\" + new Date().getTime() + ".jpg";
        IOUtils.copy(responseBodyAsStream,new FileOutputStream(login));

//        System.err.println("请输入登陆验证码:.....");
//        Scanner lll = new Scanner(System.in);
//        String code = lll.next();

        String code = ImgUtil.getCodeByImg(login);

        /**
         * 登陆
         */
        PostMethod postMethodLogin = new PostMethod(haoCaiApi.getHOST_URL() + haoCaiApi.getAPI_LOGIN() );
        NameValuePair[] postData = {
                new NameValuePair("account", account),
                new NameValuePair("password", password),
//                new NameValuePair("pwdtext", "a19931006"),
                new NameValuePair("code", code)
        };
        postMethodLogin.setRequestBody(postData);
        System.out.println("账号登陆参数....account:" + account + "    password:" +  password + "   code:" + code);
        int i = httpClient.executeMethod(postMethodLogin);
        if(i != 200){
            return Boolean.FALSE;
        }
        String responseBodyAsString = postMethodLogin.getResponseBodyAsString();
        System.out.println("登陆响应responseBodyAsString:" + responseBodyAsString);

        LoginBean loginBean = JSONUtils.toBean(responseBodyAsString, LoginBean.class);

        if(loginBean == null || !loginBean.isSuccess()){
            return Boolean.FALSE;
        }
        return Boolean.TRUE;

        //{"message":"_OLID_=2f65475d916cb0538e5c1df4bd13a0c4","success":true,"httpsEnable":1}
        //{"message":"验证码有误","success":false}
    }

}
