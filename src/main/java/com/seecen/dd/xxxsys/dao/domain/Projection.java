package com.seecen.dd.xxxsys.dao.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "y_projection")
public class Projection {
    /**
     * 放映id
     */
    @Id
    @Column(name = "projection_id")
    private Integer projectionId;

    /**
     * 电影id
     */
    @Column(name = "movie_id")
    private Integer movieId;

    /**
     * 放映时间
     */
    @Column(name = "projection_date")
    private Date projectionDate;

    /**
     * 影厅id
     */
    @Column(name = "hall_id")
    private Integer hallId;

    /**
     * 票价
     */
    @Column(name = "ticketPrice")
    private Double ticketprice;

    /**
     * 剩余座位数
     */
    @Column(name = "surplus_seat")
    private Integer surplusSeat;

    /**
     * 获取放映id
     *
     * @return projection_id - 放映id
     */
    public Integer getProjectionId() {
        return projectionId;
    }

    /**
     * 设置放映id
     *
     * @param projectionId 放映id
     */
    public void setProjectionId(Integer projectionId) {
        this.projectionId = projectionId;
    }

    /**
     * 获取电影id
     *
     * @return movie_id - 电影id
     */
    public Integer getMovieId() {
        return movieId;
    }

    /**
     * 设置电影id
     *
     * @param movieId 电影id
     */
    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    /**
     * 获取放映时间
     *
     * @return projection_date - 放映时间
     */
    public Date getProjectionDate() {
        return projectionDate;
    }

    /**
     * 设置放映时间
     *
     * @param projectionDate 放映时间
     */
    public void setProjectionDate(Date projectionDate) {
        this.projectionDate = projectionDate;
    }

    /**
     * 获取影厅id
     *
     * @return hall_id - 影厅id
     */
    public Integer getHallId() {
        return hallId;
    }

    /**
     * 设置影厅id
     *
     * @param hallId 影厅id
     */
    public void setHallId(Integer hallId) {
        this.hallId = hallId;
    }

    /**
     * 获取票价
     *
     * @return ticketPrice - 票价
     */
    public Double getTicketprice() {
        return ticketprice;
    }

    /**
     * 设置票价
     *
     * @param ticketprice 票价
     */
    public void setTicketprice(Double ticketprice) {
        this.ticketprice = ticketprice;
    }

    /**
     * 获取剩余座位数
     *
     * @return surplus_seat - 剩余座位数
     */
    public Integer getSurplusSeat() {
        return surplusSeat;
    }

    /**
     * 设置剩余座位数
     *
     * @param surplusSeat 剩余座位数
     */
    public void setSurplusSeat(Integer surplusSeat) {
        this.surplusSeat = surplusSeat;
    }
}