package com.seecen.dd.xxxsys.dao.domain;

import javax.persistence.*;

@Table(name = "y_comment")
public class Comment {
    /**
     * 评论id
     */
    @Id
    @Column(name = "movie_comment_id")
    private Integer movieCommentId;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 评论内容
     */
    @Column(name = "movie_comment_content")
    private String movieCommentContent;

    /**
     * 获取评论id
     *
     * @return movie_comment_id - 评论id
     */
    public Integer getMovieCommentId() {
        return movieCommentId;
    }

    /**
     * 设置评论id
     *
     * @param movieCommentId 评论id
     */
    public void setMovieCommentId(Integer movieCommentId) {
        this.movieCommentId = movieCommentId;
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
     * 获取评论内容
     *
     * @return movie_comment_content - 评论内容
     */
    public String getMovieCommentContent() {
        return movieCommentContent;
    }

    /**
     * 设置评论内容
     *
     * @param movieCommentContent 评论内容
     */
    public void setMovieCommentContent(String movieCommentContent) {
        this.movieCommentContent = movieCommentContent == null ? null : movieCommentContent.trim();
    }
}