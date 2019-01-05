package com.springboot.zcssc.zcssc.service;

import com.springboot.zcssc.zcssc.bean.db.Account;

import java.io.IOException;
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
     * 修改账户余额
     * @param account  账户
     * @param yuE      修改的余额
     * @return
     */
    public int updateAccountByamout(Account account, double yuE);
    /**
     * 批量修改账户余额
     * @param accounts  账户
     * @param yuE      修改的余额
     * @return
     */
    public List<Integer> updateAccountByamout(List<Account> accounts, double yuE);

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
     * 查询账户余额大于amount元的账号numbers个.
     * 账户需要从小到大排序
     * @param amount
     * @param numbers
     * @return 符合条件的账户
     */
    public List<Account> selectAccountLtOneSortYeAsc(int amount,int numbers);

    /**
     * 更新账户余额
     */
    public void updateAccountAmout(List<Account> accounts) throws IOException;

    /**
     * 查询所有用户
     * @return
     */
    public List<Account> selectAccountAll();
}
