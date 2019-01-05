package com.springboot.zcssc.zcssc.bean.db;

import java.util.Date;
import javax.persistence.*;

@Table(name = "account_sing")
public class AccountSing {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户外键
     */
    @Column(name = "account_id")
    private Integer accountId;

    /**
     * 创建日期
     */
    @Column(name = "create_date_time")
    private String createDateTime;

    /**
     * 是否已经签到
     */
    @Column(name = "is_singe")
    private Boolean isSinge;

    /**
     * 签到时间
     */
    @Column(name = "singe_date_time")
    private Date singeDateTime;

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
     * 获取用户外键
     *
     * @return account_id - 用户外键
     */
    public Integer getAccountId() {
        return accountId;
    }

    /**
     * 设置用户外键
     *
     * @param accountId 用户外键
     */
    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    /**
     * 获取创建日期
     *
     * @return create_date_time - 创建日期
     */
    public String getCreateDateTime() {
        return createDateTime;
    }

    /**
     * 设置创建日期
     *
     * @param createDateTime 创建日期
     */
    public void setCreateDateTime(String createDateTime) {
        this.createDateTime = createDateTime == null ? null : createDateTime.trim();
    }

    /**
     * 获取是否已经签到
     *
     * @return is_singe - 是否已经签到
     */
    public Boolean getIsSinge() {
        return isSinge;
    }

    /**
     * 设置是否已经签到
     *
     * @param isSinge 是否已经签到
     */
    public void setIsSinge(Boolean isSinge) {
        this.isSinge = isSinge;
    }

    /**
     * 获取签到时间
     *
     * @return singe_date_time - 签到时间
     */
    public Date getSingeDateTime() {
        return singeDateTime;
    }

    /**
     * 设置签到时间
     *
     * @param singeDateTime 签到时间
     */
    public void setSingeDateTime(Date singeDateTime) {
        this.singeDateTime = singeDateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", accountId=").append(accountId);
        sb.append(", createDateTime=").append(createDateTime);
        sb.append(", isSinge=").append(isSinge);
        sb.append(", singeDateTime=").append(singeDateTime);
        sb.append("]");
        return sb.toString();
    }
}