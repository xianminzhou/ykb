package com.seecen.dd.xxxsys.dao.domain;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;


@Table(name = "y_hotel_room")
@Data
public class YRoom {
    @Id
    @Column(name = "room_id")
    private Integer roomId;

    @Column(name = "room_name")
    private Integer roomName;

    @Column(name = "hotel_id")
    private Integer hotelId;

    @Column(name = "roomgrade_id")
    private Integer roomgradeId;

    private BigDecimal price;

    @Column(name = "vip_price")
    private BigDecimal vipPrice;

    private Integer status;

    @Column(name = "roomType_id")
    private Integer roomtypeId;

    private String details;

    @Column(name = "bedType_id")
    private Integer bedtypeId;

    @Column(name = "room_image")
    private String roomImage;

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
     * @return room_name
     */
    public Integer getRoomName() {
        return roomName;
    }

    /**
     * @param roomName
     */
    public void setRoomName(Integer roomName) {
        this.roomName = roomName;
    }

    /**
     * @return hotel_id
     */
    public Integer getHotelId() {
        return hotelId;
    }

    /**
     * @param hotelId
     */
    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    /**
     * @return roomgrade_id
     */
    public Integer getRoomgradeId() {
        return roomgradeId;
    }

    /**
     * @param roomgradeId
     */
    public void setRoomgradeId(Integer roomgradeId) {
        this.roomgradeId = roomgradeId;
    }

    /**
     * @return price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * @param price
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * @return vip_price
     */
    public BigDecimal getVipPrice() {
        return vipPrice;
    }

    /**
     * @param vipPrice
     */
    public void setVipPrice(BigDecimal vipPrice) {
        this.vipPrice = vipPrice;
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
     * @return roomType_id
     */
    public Integer getRoomtypeId() {
        return roomtypeId;
    }

    /**
     * @param roomtypeId
     */
    public void setRoomtypeId(Integer roomtypeId) {
        this.roomtypeId = roomtypeId;
    }

    /**
     * @return details
     */
    public String getDetails() {
        return details;
    }

    /**
     * @param details
     */
    public void setDetails(String details) {
        this.details = details == null ? null : details.trim();
    }

    /**
     * @return bedType_id
     */
    public Integer getBedtypeId() {
        return bedtypeId;
    }

    /**
     * @param bedtypeId
     */
    public void setBedtypeId(Integer bedtypeId) {
        this.bedtypeId = bedtypeId;
    }

    /**
     * @return room_image
     */
    public String getRoomImage() {
        return roomImage;
    }

    /**
     * @param roomImage
     */
    public void setRoomImage(String roomImage) {
        this.roomImage = roomImage == null ? null : roomImage.trim();
    }
}