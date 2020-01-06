package com.seecen.dd.xxxsys.dao.domain;

import javax.persistence.*;

@Table(name = "y_cinematicket")
public class Cinematicket {
    /**
     * 影票id
     */
    @Id
    @Column(name = "cinemaTicket_id")
    private Integer cinematicketId;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 放映id
     */
    @Column(name = "projection_id")
    private Integer projectionId;

    /**
     * 座位id
     */
    @Column(name = "seat_id")
    private Integer seatId;

    /**
     * 评分
     */
    @Column(name = "movie_score")
    private Double movieScore;

    /**
     * 金额
     */
    private Double money;

    /**
     * 获取影票id
     *
     * @return cinemaTicket_id - 影票id
     */
    public Integer getCinematicketId() {
        return cinematicketId;
    }

    /**
     * 设置影票id
     *
     * @param cinematicketId 影票id
     */
    public void setCinematicketId(Integer cinematicketId) {
        this.cinematicketId = cinematicketId;
    }

    /**
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

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
     * 获取座位id
     *
     * @return seat_id - 座位id
     */
    public Integer getSeatId() {
        return seatId;
    }

    /**
     * 设置座位id
     *
     * @param seatId 座位id
     */
    public void setSeatId(Integer seatId) {
        this.seatId = seatId;
    }

    /**
     * 获取评分
     *
     * @return movie_score - 评分
     */
    public Double getMovieScore() {
        return movieScore;
    }

    /**
     * 设置评分
     *
     * @param movieScore 评分
     */
    public void setMovieScore(Double movieScore) {
        this.movieScore = movieScore;
    }

    /**
     * 获取金额
     *
     * @return money - 金额
     */
    public Double getMoney() {
        return money;
    }

    /**
     * 设置金额
     *
     * @param money 金额
     */
    public void setMoney(Double money) {
        this.money = money;
    }
}