package com.springboot.zcssc.zcssc.service;

import com.springboot.zcssc.http.response.SingBean;
import com.springboot.zcssc.zcssc.bean.db.Account;
import com.springboot.zcssc.zcssc.bean.db.AccountSing;

import java.util.List;

public interface AccountSingService extends BaseService<AccountSing>{
    /**
     * 按是否签到查询签到记录
     * @param b
     * @param createDateTime
     * @return
     */
    public List<AccountSing> selectByIsSinge(boolean b, String createDateTime);

    /**
     * 通过id签到
     * @param account
     * @param accountSing
     * @return
     */
    public SingBean accountSingeByAccount(Account account,AccountSing accountSing);
}
