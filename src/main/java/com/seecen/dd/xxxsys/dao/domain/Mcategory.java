package com.seecen.dd.xxxsys.dao.domain;

import javax.persistence.*;

@Table(name = "y_mcategory")
public class Mcategory {
    /**
     * 电影id
     */
    @Column(name = "movie_id")
    private Integer movieId;

    /**
     * 类别id
     */
    @Column(name = "catepory_id")
    private Integer cateporyId;

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
     * 获取类别id
     *
     * @return catepory_id - 类别id
     */
    public Integer getCateporyId() {
        return cateporyId;
    }

    /**
     * 设置类别id
     *
     * @param cateporyId 类别id
     */
    public void setCateporyId(Integer cateporyId) {
        this.cateporyId = cateporyId;
    }
}