package com.springboot.zcssc.zcssc.service.impl;

import com.springboot.zcssc.http.proxy.HaoCaiUserManager;
import com.springboot.zcssc.http.request.config.HaoCaiApi;
import com.springboot.zcssc.zcssc.bean.db.Account;
import com.springboot.zcssc.zcssc.service.AccountService;
import org.apache.commons.httpclient.HttpClient;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Service
public class AccountServiceImpl extends BaseServiceImpl<Account> implements AccountService {
    //API配置类
    HaoCaiApi haoCaiApi = new HaoCaiApi();

    @Override
    public int updateYuEBy(int id, double yuE) {
        Account account = new Account();
        account.setId(id);
        account.setYuE(yuE);
        return mapper.updateByPrimaryKeySelective(account);
    }

    @Override
    public List<Account> selectNotRegist() {
        Account account = new Account();
        account.setIsRegist(Boolean.FALSE);
        return mapper.select(account);
    }

    @Override
    public Boolean registAccount(Account account) {
        try {
            Boolean regist = HaoCaiUserManager.regist(account.getUserName(), account.getPassword(), haoCaiApi.getAPI_ZHU_CE_HOME_CODE(), new HttpClient(), haoCaiApi.getHOST_URL(), haoCaiApi.getAPI_ZHU_CE_HOME(), haoCaiApi.getAPI_ZHU_CE());

            int i = 0;
            while (!regist){
                if(i > 10){
                    regist = Boolean.FALSE;
                    break;
                }
                logger.warn("userName:"+account.getUserName()+"   password:"+account.getPassword()+",第"+(i+1)+"次注册失败,准备第"+(i+2)+"次注册......");
                regist = HaoCaiUserManager.regist(account.getUserName(), account.getPassword(), haoCaiApi.getAPI_ZHU_CE_HOME_CODE(), new HttpClient(), haoCaiApi.getHOST_URL(), haoCaiApi.getAPI_ZHU_CE_HOME(), haoCaiApi.getAPI_ZHU_CE());

                if(regist){
                    break;
                }
                i++;
            }
            account.setIsRegist(regist);
            return regist;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Boolean.FALSE;
    }

    @Override
    public List<Boolean> registAccountBatch(List<Account> accounts) {
        if(CollectionUtils.isEmpty(accounts)) return null;
        ArrayList<Boolean> booleans = new ArrayList<>();
        for(Account account : accounts){
            Boolean aBoolean = registAccount(account);
            booleans.add(aBoolean);
        }
        return booleans;
    }
}
