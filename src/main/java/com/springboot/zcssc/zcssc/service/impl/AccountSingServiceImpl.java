package com.springboot.zcssc.zcssc.service.impl;

import com.springboot.zcssc.http.proxy.HaoCaiUserManager;
import com.springboot.zcssc.http.response.SingBean;
import com.springboot.zcssc.zcssc.bean.db.Account;
import com.springboot.zcssc.zcssc.bean.db.AccountSing;
import com.springboot.zcssc.zcssc.service.AccountSingService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
public class AccountSingServiceImpl extends BaseServiceImpl<AccountSing> implements AccountSingService {

    @Override
    public List<AccountSing> selectByIsSinge(boolean b, String createDateTime) {
        AccountSing accountSing = new AccountSing();
        accountSing.setIsSinge(b);
        accountSing.setCreateDateTime(createDateTime);
        mapper.select(accountSing);
        return mapper.select(accountSing);
    }

    @Override
    public SingBean accountSingeByAccount(Account account,AccountSing accountSing) {
        SingBean sing = null;
        try {
            HaoCaiUserManager haoCaiUserManager = new HaoCaiUserManager(account.getUserName(), account.getMd5());
            sing = haoCaiUserManager.sing();
            accountSing.setIsSinge(Boolean.TRUE);
            accountSing.setSingeDateTime(new Date());
            mapper.updateByPrimaryKey(accountSing);
        } catch (IOException e) {
            logger.error("account="+account +"   的用户签到失败.....",e);
            e.printStackTrace();
        }
        return sing;
    }

}
