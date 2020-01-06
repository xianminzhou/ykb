package com.seecen.dd.xxxsys.dao.domain;

import java.util.Date;

public class ProjectionExpand  {
    private Integer projectionId;

    private String movieName;

    private Date projectionDate;

    private String hallName;

    private Double ticketprice;

    private Integer surplusSeat;

    private String language;

    public Integer getProjectionId() {
        return projectionId;
    }

    public void setProjectionId(Integer projectionId) {
        this.projectionId = projectionId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Date getProjectionDate() {
        return projectionDate;
    }

    public void setProjectionDate(Date projectionDate) {
        this.projectionDate = projectionDate;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public Double getTicketprice() {
        return ticketprice;
    }

    public void setTicketprice(Double ticketprice) {
        this.ticketprice = ticketprice;
    }

    public Integer getSurplusSeat() {
        return surplusSeat;
    }

    public void setSurplusSeat(Integer surplusSeat) {
        this.surplusSeat = surplusSeat;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
