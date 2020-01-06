package com.seecen.dd.xxxsys.dao.domain;

import javax.persistence.*;

@Table(name = "y_hotel")
public class YHotel {
    @Id
    @Column(name = "hotel_id")
    private Integer hotelId;

    @Column(name = "hotel_name")
    private String hotelName;

    @Column(name = "hotel_intro")
    private String hotelIntro;

    @Column(name = "hotel_address")
    private String hotelAddress;

    @Column(name = "hotel_type")
    private String hotelType;

    @Column(name = "hotel_image")
    private String hotelImage;

    @Column(name = "hotel_status")
    private Integer hotelStatus;

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
     * @return hotel_name
     */
    public String getHotelName() {
        return hotelName;
    }

    /**
     * @param hotelName
     */
    public void setHotelName(String hotelName) {
        this.hotelName = hotelName == null ? null : hotelName.trim();
    }

    /**
     * @return hotel_intro
     */
    public String getHotelIntro() {
        return hotelIntro;
    }

    /**
     * @param hotelIntro
     */
    public void setHotelIntro(String hotelIntro) {
        this.hotelIntro = hotelIntro == null ? null : hotelIntro.trim();
    }

    /**
     * @return hotel_address
     */
    public String getHotelAddress() {
        return hotelAddress;
    }

    /**
     * @param hotelAddress
     */
    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress == null ? null : hotelAddress.trim();
    }

    /**
     * @return hotel_type
     */
    public String getHotelType() {
        return hotelType;
    }

    /**
     * @param hotelType
     */
    public void setHotelType(String hotelType) {
        this.hotelType = hotelType == null ? null : hotelType.trim();
    }

    /**
     * @return hotel_image
     */
    public String getHotelImage() {
        return hotelImage;
    }

    /**
     * @param hotelImage
     */
    public void setHotelImage(String hotelImage) {
        this.hotelImage = hotelImage == null ? null : hotelImage.trim();
    }

    /**
     * @return hotel_status
     */
    public Integer getHotelStatus() {
        return hotelStatus;
    }

    /**
     * @param hotelStatus
     */
    public void setHotelStatus(Integer hotelStatus) {
        this.hotelStatus = hotelStatus;
    }
}