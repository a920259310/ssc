package com.springboot.zcssc.zcssc.service.impl;

import com.springboot.zcssc.http.request.config.HaoCaiApi;
import com.springboot.zcssc.zcssc.bean.db.Account;
import com.springboot.zcssc.zcssc.service.AccountOrderService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AccountOrderServiceImpl extends BaseServiceImpl implements AccountOrderService {
    //API配置类
    HaoCaiApi haoCaiApi = new HaoCaiApi();


    @Override
    public void toOrder(List<Account> accounts, String trunkNumber) {

    }

}
