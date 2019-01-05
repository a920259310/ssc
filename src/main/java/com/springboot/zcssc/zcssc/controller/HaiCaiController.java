package com.springboot.zcssc.zcssc.controller;

import com.springboot.zcssc.http.response.SingBean;
import com.springboot.zcssc.zcssc.bean.db.Account;
import com.springboot.zcssc.zcssc.bean.db.AccountSing;
import com.springboot.zcssc.zcssc.service.AccountOrderService;
import com.springboot.zcssc.zcssc.service.AccountService;
import com.springboot.zcssc.zcssc.service.AccountSingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HaiCaiController {
    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountSingService accountSingService;

    @Autowired
    private AccountOrderService accountOrderService;

    @RequestMapping("/account/singe")
    public void singTodayAccount(){
        List<AccountSing> accountSings = accountSingService.selectByIsSinge(false, "2019-01-05");
        for(AccountSing accountSing : accountSings){
            Account account = accountService.queryById(accountSing.getAccountId());
            SingBean singBean = accountSingService.accountSingeByAccount(account, accountSing);
            System.out.println(singBean);
            //更新账户余额
            int updateYuEBy = accountService.updateYuEBy(account.getId(), singBean.getCouponamount());
        }
    }

    @RequestMapping("/account/regist")
    public void registAccount(){
        List<Account> accounts = accountService.selectNotRegist();
        List<Boolean> booleans = accountService.registAccountBatch(accounts);
        accountService.updateNotNullBatch(accounts);
        System.out.println(accounts);
    }
    @RequestMapping("/account/to_order")
    public void toOrder(String trunkNumber){
        try {
            List<Account> accounts = accountService.selectAccountLtOneSortYeAsc(1, 10);
            accountOrderService.toOrder(accounts, trunkNumber);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @RequestMapping("/account/update_amount")
    public void updateAmount(){
        try {
            List<Account> accounts = accountService.selectAccountAll();
            accountService.updateAccountAmout(accounts);
        }catch (Exception e){
            e.printStackTrace();
        }

    }


}
