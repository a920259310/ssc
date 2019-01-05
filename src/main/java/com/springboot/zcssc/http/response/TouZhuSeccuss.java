package com.springboot.zcssc.http.response;

import java.util.List;

public class TouZhuSeccuss {

    /**
     * account : {"balance":1.7400000000000002,"betting":1,"freeze":0}
     * ids : ["19010500260954"]
     * odds : ["9.95"]
     * status : 0
     */

    private AccountBean account;
    private int status;
    private List<String> ids;
    private List<String> odds;

    public AccountBean getAccount() {
        return account;
    }

    public void setAccount(AccountBean account) {
        this.account = account;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        this.ids = ids;
    }

    public List<String> getOdds() {
        return odds;
    }

    public void setOdds(List<String> odds) {
        this.odds = odds;
    }

    public static class AccountBean {
        /**
         * balance : 1.7400000000000002
         * betting : 1.0
         * freeze : 0
         */

        private double balance;
        private double betting;
        private int freeze;

        public double getBalance() {
            return balance;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }

        public double getBetting() {
            return betting;
        }

        public void setBetting(double betting) {
            this.betting = betting;
        }

        public int getFreeze() {
            return freeze;
        }

        public void setFreeze(int freeze) {
            this.freeze = freeze;
        }
    }
}
