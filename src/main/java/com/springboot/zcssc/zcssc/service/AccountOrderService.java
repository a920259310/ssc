package com.springboot.zcssc.zcssc.service;

import com.springboot.zcssc.zcssc.bean.db.Account;

import java.util.List;

public interface AccountOrderService {
   void toOrder(List<Account> accounts,String trunkNumber);
}
