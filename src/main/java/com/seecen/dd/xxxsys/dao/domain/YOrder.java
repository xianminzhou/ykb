package com.seecen.dd.xxxsys.dao.domain;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "y_hotel_order")
public class YOrder {
    @Id
    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "room_id")
    private Integer roomId;

    @Column(name = "user_id")
    private Integer userId;

    private BigDecimal endprice;

    private Date staytime;

    private Date checkouttime;

    @Column(name = "order_number")
    private Integer orderNumber;

    private Integer status;

    /**
     * @return order_id
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * @param orderId
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    /**
     * @return room_id
     */
    public Integer getRoomId() {
        return roomId;
    }

    /**
     * @param roomId
     */
    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
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
     * @return endprice
     */
    public BigDecimal getEndprice() {
        return endprice;
    }

    /**
     * @param endprice
     */
    public void setEndprice(BigDecimal endprice) {
        this.endprice = endprice;
    }

    /**
     * @return staytime
     */
    public Date getStaytime() {
        return staytime;
    }

    /**
     * @param staytime
     */
    public void setStaytime(Date staytime) {
        this.staytime = staytime;
    }

    /**
     * @return checkouttime
     */
    public Date getCheckouttime() {
        return checkouttime;
    }

    /**
     * @param checkouttime
     */
    public void setCheckouttime(Date checkouttime) {
        this.checkouttime = checkouttime;
    }

    /**
     * @return order_number
     */
    public Integer getOrderNumber() {
        return orderNumber;
    }

    /**
     * @param orderNumber
     */
    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
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
}