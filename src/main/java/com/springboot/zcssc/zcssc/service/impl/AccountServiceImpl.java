package com.springboot.zcssc.zcssc.service.impl;

import com.springboot.zcssc.http.proxy.HaoCaiUserManager;
import com.springboot.zcssc.http.request.config.HaoCaiApi;
import com.springboot.zcssc.http.response.YuEBean;
import com.springboot.zcssc.zcssc.bean.db.Account;
import com.springboot.zcssc.zcssc.service.AccountService;
import org.apache.commons.httpclient.HttpClient;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


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

    public int updateAccountByamout(Account account, double yuE) {
        account.setYuE(account.getYuE() - yuE);
        return mapper.updateByPrimaryKeySelective(account);
    }

    public List<Integer> updateAccountByamout(List<Account> accounts, double yuE) {
        ArrayList<Integer> objects = new ArrayList<>();
        for (Account account : accounts){
            int i = updateAccountByamout(account, yuE);
            objects.add(i);
        }
        return objects;
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

    public List<Account> selectAccountLtOneSortYeAsc(int amount, int numbers) {
        Account account = new Account();
        List<Account> accounts = mapper.selectAll();

        List<Account> collect = accounts.stream().filter(x -> {
            return x.getYuE() > amount;
        }).collect(Collectors.toList());

        Collections.sort(collect,new Comparator<Account>() {
            public int compare(Account o1, Account o2) {
                return o1.getYuE().compareTo(o2.getYuE());
            }
        });

        if(!CollectionUtils.isEmpty(collect) && collect.size() >= numbers){
            return collect.subList(0, numbers);
        }

        if(!CollectionUtils.isEmpty(collect) && collect.size() < numbers){
            return collect;
        }

        return null;
    }

    public void updateAccountAmout(List<Account> accounts) throws IOException {
        for(Account account : accounts){
            HaoCaiUserManager haoCaiUserManager = new HaoCaiUserManager(account.getUserName(), account.getMd5());
            YuEBean yuEBean = haoCaiUserManager.queryYuE();
            account.setYuE(yuEBean.getBalance());
            mapper.updateByPrimaryKey(account);
        }

    }

    public List<Account> selectAccountAll() {
        return mapper.selectAll();
    }
}
