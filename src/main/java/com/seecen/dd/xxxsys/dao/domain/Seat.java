package com.seecen.dd.xxxsys.dao.domain;

import javax.persistence.*;

@Table(name = "y_seat")
public class Seat {
    /**
     * 座位ID
     */
    @Id
     @Column(name = "seat_id")
     private Integer seatId;

     /**
      * 座位名
     */
    @Column(name = "seat_name")
    private String seatName;

    /**
     * 影厅ID
     */
    @Column(name = "hall_id")
    private Integer hallId;

    /**
     * 座位状态
     */
    @Column(name = "seat_state")
    private Integer seatState;

    /**
     * 获取座位ID
     *
     * @return seat_id - 座位ID
     */
    public Integer getSeatId() {
        return seatId;
    }

    /**
     * 设置座位ID
     *
     * @param seatId 座位ID
     */
    public void setSeatId(Integer seatId) {
        this.seatId = seatId;
    }

    /**
     * 获取座位名
     *
     * @return seat_name - 座位名
     */
    public String getSeatName() {
        return seatName;
    }

    /**
     * 设置座位名
     *
     * @param seatName 座位名
     */
    public void setSeatName(String seatName) {
        this.seatName = seatName == null ? null : seatName.trim();
    }

    /**
     * 获取影厅ID
     *
     * @return hall_id - 影厅ID
     */
    public Integer getHallId() {
        return hallId;
    }

    /**
     * 设置影厅ID
     *
     * @param hallId 影厅ID
     */
    public void setHallId(Integer hallId) {
        this.hallId = hallId;
    }

    /**
     * 获取座位状态
     *
     * @return seat_state - 座位状态
     */
    public Integer getSeatState() {
        return seatState;
    }

    /**
     * 设置座位状态
     *
     * @param seatState 座位状态
     */
    public void setSeatState(Integer seatState) {
        this.seatState = seatState;
    }
}