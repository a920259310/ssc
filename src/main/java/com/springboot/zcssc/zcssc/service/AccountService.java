package com.springboot.zcssc.zcssc.service;

import com.springboot.zcssc.zcssc.bean.db.Account;

import java.util.List;


public interface AccountService extends BaseService<Account> {
    /**
     * 修改余额
     * @param id
     * @param yuE
     * @return
     */
    public int updateYuEBy(int id, double yuE);

    /**
     * 查询未注册的账号
     * @return
     */
    public List<Account> selectNotRegist();

    /**
     * 注册账号
     * @param account
     * @return
     */
    public Boolean registAccount(Account account);

    /**
     * 批量注册账号
     * @param accounts
     * @return
     */
    public List<Boolean> registAccountBatch(List<Account> accounts);


    /**
     * 查询账户余额大于1元的账号.
     * 账户需要从小到大排序
     * @return
     */
    public List<Account> selectAccountLtOneSortYeAsc();
}
