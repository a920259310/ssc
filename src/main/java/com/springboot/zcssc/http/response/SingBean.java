package com.springboot.zcssc.http.response;

/**
 * 签到响应实体
 */
public class SingBean {

    /**
     * suceess : true
     * couponamount : 2.695
     * integralNum : 6
     */

    private boolean suceess;
    private double couponamount;
    private int integralNum;

    public boolean isSuceess() {
        return suceess;
    }

    public void setSuceess(boolean suceess) {
        this.suceess = suceess;
    }

    public double getCouponamount() {
        return couponamount;
    }

    public void setCouponamount(double couponamount) {
        this.couponamount = couponamount;
    }

    public int getIntegralNum() {
        return integralNum;
    }

    public void setIntegralNum(int integralNum) {
        this.integralNum = integralNum;
    }

    @Override
    public String toString() {
        return "SingBean{" +
                "suceess=" + suceess +
                ", couponamount=" + couponamount +
                ", integralNum=" + integralNum +
                '}';
    }
}
