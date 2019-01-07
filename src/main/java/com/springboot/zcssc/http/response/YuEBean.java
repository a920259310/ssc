package com.springboot.zcssc.http.response;

public class YuEBean {

    /**
     * balance : 2.695
     * betting : 0
     * freeze : 0
     * result : 0
     */

    private double balance;
    private int betting;
    private int freeze;
    private int result;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getBetting() {
        return betting;
    }

    public void setBetting(int betting) {
        this.betting = betting;
    }

    public int getFreeze() {
        return freeze;
    }

    public void setFreeze(int freeze) {
        this.freeze = freeze;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "YuEBean{" +
                "balance=" + balance +
                ", betting=" + betting +
                ", freeze=" + freeze +
                ", result=" + result +
                '}';
    }
}
