package com.seecen.dd.xxxsys.dao.domain;

import javax.persistence.*;

@Table(name = "y_hall")
public class Hall {
    /**
     * 影厅ID
     */
    @Id
    @Column(name = "hall_id")
    private Integer hallId;

    /**
     * 影厅名
     */
    @Column(name = "hall_name")
    private String hallName;

    /**
     * 座位数
     */
    @Column(name = "seat_num")
    private Integer seatNum;

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
     * 获取影厅名
     *
     * @return hall_name - 影厅名
     */
    public String getHallName() {
        return hallName;
    }

    /**
     * 设置影厅名
     *
     * @param hallName 影厅名
     */
    public void setHallName(String hallName) {
        this.hallName = hallName == null ? null : hallName.trim();
    }

    /**
     * 获取座位数
     *
     * @return seat_num - 座位数
     */
    public Integer getSeatNum() {
        return seatNum;
    }

    /**
     * 设置座位数
     *
     * @param seatNum 座位数
     */
    public void setSeatNum(Integer seatNum) {
        this.seatNum = seatNum;
    }
}