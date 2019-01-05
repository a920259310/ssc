package com.springboot.zcssc.http.request.config;

/**
 * 好彩API配置
 */
public class HaoCaiApi {

    private String HOST_URL = "https://www.6hc6.com/";//主机地址
    private String API_LOGIN = "cashlogin";//主机地址
    private String API_TOU_ZHU = "member/bet";//投注地址

    private String API_ZHU_CE_HOME_CODE = "iRJB000W";//注册主页
    private String API_ZHU_CE_HOME = "register?regcode="+API_ZHU_CE_HOME_CODE;//注册主页
    private String API_ZHU_CE = "reg";//注册地址

    private String API_QIAN_DAO = "member/receiveSign";//签到地址


    public String getHOST_URL() {
        return HOST_URL;
    }

    public void setHOST_URL(String HOST_URL) {
        this.HOST_URL = HOST_URL;
    }

    public String getAPI_LOGIN() {
        return API_LOGIN;
    }

    public void setAPI_LOGIN(String API_LOGIN) {
        this.API_LOGIN = API_LOGIN;
    }

    public String getAPI_TOU_ZHU() {
        return API_TOU_ZHU;
    }

    public void setAPI_TOU_ZHU(String API_TOU_ZHU) {
        this.API_TOU_ZHU = API_TOU_ZHU;
    }

    public String getAPI_ZHU_CE_HOME() {
        return API_ZHU_CE_HOME;
    }

    public void setAPI_ZHU_CE_HOME(String API_ZHU_CE_HOME) {
        this.API_ZHU_CE_HOME = API_ZHU_CE_HOME;
    }

    public String getAPI_ZHU_CE() {
        return API_ZHU_CE;
    }

    public void setAPI_ZHU_CE(String API_ZHU_CE) {
        this.API_ZHU_CE = API_ZHU_CE;
    }

    public String getAPI_QIAN_DAO() {
        return API_QIAN_DAO;
    }

    public void setAPI_QIAN_DAO(String API_QIAN_DAO) {
        this.API_QIAN_DAO = API_QIAN_DAO;
    }

    public String getAPI_ZHU_CE_HOME_CODE() {
        return API_ZHU_CE_HOME_CODE;
    }

    public void setAPI_ZHU_CE_HOME_CODE(String API_ZHU_CE_HOME_CODE) {
        this.API_ZHU_CE_HOME_CODE = API_ZHU_CE_HOME_CODE;
    }

    @Override
    public String toString() {
        return "HaoCaiApi{" +
                "HOST_URL='" + HOST_URL + '\'' +
                ", API_LOGIN='" + API_LOGIN + '\'' +
                ", API_TOU_ZHU='" + API_TOU_ZHU + '\'' +
                ", API_ZHU_CE_HOME_CODE='" + API_ZHU_CE_HOME_CODE + '\'' +
                ", API_ZHU_CE_HOME='" + API_ZHU_CE_HOME + '\'' +
                ", API_ZHU_CE='" + API_ZHU_CE + '\'' +
                ", API_QIAN_DAO='" + API_QIAN_DAO + '\'' +
                '}';
    }
}
