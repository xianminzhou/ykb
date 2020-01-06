package com.seecen.dd.xxxsys.dao.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import javax.persistence.*;

@Table(name = "y_movie")
public class Movie{
    /**
     * 电影ID
     */
    @Id
    @Column(name = "movie_id")
    private Integer movieId;

    /**
     * 电影名
     */
    @Column(name = "movie_name")
    private String movieName;

    /**
     * 电影梗概
     */
    @Column(name = "movie_outline")
    private String movieOutline;

    /**
     * 首映日期
     */
    @Column(name = "premiereDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date premieredate;

    /**
     * 主演
     */
    @Column(name = "toStar")
    private String tostar;

    /**
     * 语言
     */
    private String language;

    /**
     * 评分
     */
    @Column(name = "movie_score")
    private Double movieScore;

    /**
     * 票房
     */
    @Column(name = "boxOffice")
    private Double boxoffice;

    /**
     * 图片
     */
    @Column(name = "movie_img")
    private String movieImg;

    /**
     * 获取电影ID
     *
     * @return movie_id - 电影ID
     */
    public Integer getMovieId() {
        return movieId;
    }

    /**
     * 设置电影ID
     *
     * @param movieId 电影ID
     */
    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    /**
     * 获取电影名
     *
     * @return movie_name - 电影名
     */
    public String getMovieName() {
        return movieName;
    }

    /**
     * 设置电影名
     *
     * @param movieName 电影名
     */
    public void setMovieName(String movieName) {
        this.movieName = movieName == null ? null : movieName.trim();
    }

    /**
     * 获取电影梗概
     *
     * @return movie_outline - 电影梗概
     */
    public String getMovieOutline() {
        return movieOutline;
    }

    /**
     * 设置电影梗概
     *
     * @param movieOutline 电影梗概
     */
    public void setMovieOutline(String movieOutline) {
        this.movieOutline = movieOutline == null ? null : movieOutline.trim();
    }

    /**
     * 获取首映日期
     *
     * @return premiereDate - 首映日期
     */
    public Date getPremieredate() {
        return premieredate;
    }

    /**
     * 设置首映日期
     *
     * @param premieredate 首映日期
     */
    public void setPremieredate(Date premieredate) {
        this.premieredate = premieredate;
    }

    /**
     * 获取主演
     *
     * @return toStar - 主演
     */
    public String getTostar() {
        return tostar;
    }

    /**
     * 设置主演
     *
     * @param tostar 主演
     */
    public void setTostar(String tostar) {
        this.tostar = tostar == null ? null : tostar.trim();
    }

    /**
     * 获取语言
     *
     * @return language - 语言
     */
    public String getLanguage() {
        return language;
    }

    /**
     * 设置语言
     *
     * @param language 语言
     */
    public void setLanguage(String language) {
        this.language = language == null ? null : language.trim();
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
     * 获取票房
     *
     * @return boxOffice - 票房
     */
    public Double getBoxoffice() {
        return boxoffice;
    }

    /**
     * 设置票房
     *
     * @param boxoffice 票房
     */
    public void setBoxoffice(Double boxoffice) {
        this.boxoffice = boxoffice;
    }

    /**
     * 获取图片
     *
     * @return movie_img - 图片
     */
    public String getMovieImg() {
        return movieImg;
    }

    /**
     * 设置图片
     *
     * @param movieImg 图片
     */
    public void setMovieImg(String movieImg) {
        this.movieImg = movieImg == null ? null : movieImg.trim();
    }
}