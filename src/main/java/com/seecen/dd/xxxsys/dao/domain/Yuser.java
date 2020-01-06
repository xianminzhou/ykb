package com.seecen.dd.xxxsys.dao.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

/**
 * 用户表 Y_USER
 */
@Table(name = "y_user")
public class Yuser implements Serializable {
    @Id
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "user_name")
    private String userName;

    private Integer gender;

    private String password;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date birthday;

    @Column(name = "phoneNumber")
    private String phonenumber;

    @Column(name = "role_id")
    private Integer roleId;

    @Column(name = "salt_value")
    private String saltValue;

    @Column(name = "create_time")
    private Date createTime;

    private Integer status;

    @Column(name = "user_card")
    private String userCard;

    private BigDecimal balance;

    @Override
    public String toString() {
        return "Yuser{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", gender=" + gender +
                ", password='" + password + '\'' +
                ", birthday=" + birthday +
                ", phonenumber='" + phonenumber + '\'' +
                ", roleId=" + roleId +
                ", saltValue='" + saltValue + '\'' +
                ", createTime=" + createTime +
                ", status=" + status +
                ", userCard='" + userCard + '\'' +
                ", balance=" + balance +
                '}';
    }

    /**
     * @return user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return user_name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * @return gender
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * @param gender
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * @return birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * @param birthday
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * @return phoneNumber
     */
    public String getPhonenumber() {
        return phonenumber;
    }

    /**
     * @param phonenumber
     */
    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber == null ? null : phonenumber.trim();
    }

    /**
     * @return role_id
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * @param roleId
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * @return salt_value
     */
    public String getSaltValue() {
        return saltValue;
    }

    /**
     * @param saltValue
     */
    public void setSaltValue(String saltValue) {
        this.saltValue = saltValue == null ? null : saltValue.trim();
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return user_card
     */
    public String getUserCard() {
        return userCard;
    }

    /**
     * @param userCard
     */
    public void setUserCard(String userCard) {
        this.userCard = userCard == null ? null : userCard.trim();
    }

    /**
     * @return balance
     */
    public BigDecimal getBalance() {
        return balance;
    }

    /**
     * @param balance
     */
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}