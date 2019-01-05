package com.springboot.zcssc.zcssc.bean.db;

import javax.persistence.*;

public class Account {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 账户
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 明文密码
     */
    private String password;

    /**
     * md5登陆密码
     */
    private String md5;

    /**
     * 取款密码
     */
    @Column(name = "take_password")
    private String takePassword;

    /**
     * 余额
     */
    @Column(name = "yu_e")
    private Double yuE;

    /**
     * 是否已激活
     */
    @Column(name = "is_active")
    private Boolean isActive;

    /**
     * 是否已经绑卡
     */
    @Column(name = "is_bang")
    private Boolean isBang;

    /**
     * 卡号
     */
    @Column(name = "card_no")
    private String cardNo;

    /**
     * 是否已注册
     */
    @Column(name = "is_regist")
    private Boolean isRegist;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取账户
     *
     * @return user_name - 账户
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置账户
     *
     * @param userName 账户
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 获取明文密码
     *
     * @return password - 明文密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置明文密码
     *
     * @param password 明文密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取md5登陆密码
     *
     * @return md5 - md5登陆密码
     */
    public String getMd5() {
        return md5;
    }

    /**
     * 设置md5登陆密码
     *
     * @param md5 md5登陆密码
     */
    public void setMd5(String md5) {
        this.md5 = md5 == null ? null : md5.trim();
    }

    /**
     * 获取取款密码
     *
     * @return take_password - 取款密码
     */
    public String getTakePassword() {
        return takePassword;
    }

    /**
     * 设置取款密码
     *
     * @param takePassword 取款密码
     */
    public void setTakePassword(String takePassword) {
        this.takePassword = takePassword == null ? null : takePassword.trim();
    }

    /**
     * 获取余额
     *
     * @return yu_e - 余额
     */
    public Double getYuE() {
        return yuE;
    }

    /**
     * 设置余额
     *
     * @param yuE 余额
     */
    public void setYuE(Double yuE) {
        this.yuE = yuE;
    }

    /**
     * 获取是否已激活
     *
     * @return is_active - 是否已激活
     */
    public Boolean getIsActive() {
        return isActive;
    }

    /**
     * 设置是否已激活
     *
     * @param isActive 是否已激活
     */
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    /**
     * 获取是否已经绑卡
     *
     * @return is_bang - 是否已经绑卡
     */
    public Boolean getIsBang() {
        return isBang;
    }

    /**
     * 设置是否已经绑卡
     *
     * @param isBang 是否已经绑卡
     */
    public void setIsBang(Boolean isBang) {
        this.isBang = isBang;
    }

    /**
     * 获取卡号
     *
     * @return card_no - 卡号
     */
    public String getCardNo() {
        return cardNo;
    }

    /**
     * 设置卡号
     *
     * @param cardNo 卡号
     */
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo == null ? null : cardNo.trim();
    }

    /**
     * 获取是否已注册
     *
     * @return is_regist - 是否已注册
     */
    public Boolean getIsRegist() {
        return isRegist;
    }

    /**
     * 设置是否已注册
     *
     * @param isRegist 是否已注册
     */
    public void setIsRegist(Boolean isRegist) {
        this.isRegist = isRegist;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userName=").append(userName);
        sb.append(", password=").append(password);
        sb.append(", md5=").append(md5);
        sb.append(", takePassword=").append(takePassword);
        sb.append(", yuE=").append(yuE);
        sb.append(", isActive=").append(isActive);
        sb.append(", isBang=").append(isBang);
        sb.append(", cardNo=").append(cardNo);
        sb.append(", isRegist=").append(isRegist);
        sb.append("]");
        return sb.toString();
    }
}