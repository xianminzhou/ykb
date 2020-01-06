package com.seecen.dd.xxxsys.dao.domain;

import javax.persistence.*;

@Table(name = "y_hotel_roomtype")
public class YRoomType {
    @Id
    @Column(name = "roomType_id")
    private Integer roomtypeId;

    @Column(name = "roomType_name")
    private String roomtypeName;

    @Column(name = "roomType_residue")
    private Integer roomtypeResidue;

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
     * @return roomType_name
     */
    public String getRoomtypeName() {
        return roomtypeName;
    }

    /**
     * @param roomtypeName
     */
    public void setRoomtypeName(String roomtypeName) {
        this.roomtypeName = roomtypeName == null ? null : roomtypeName.trim();
    }

    /**
     * @return roomType_residue
     */
    public Integer getRoomtypeResidue() {
        return roomtypeResidue;
    }

    /**
     * @param roomtypeResidue
     */
    public void setRoomtypeResidue(Integer roomtypeResidue) {
        this.roomtypeResidue = roomtypeResidue;
    }
}