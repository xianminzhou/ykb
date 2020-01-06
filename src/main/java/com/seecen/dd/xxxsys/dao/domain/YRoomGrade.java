package com.seecen.dd.xxxsys.dao.domain;

import javax.persistence.*;

@Table(name = "y_hotel_roomgrade")
public class YRoomGrade {
    @Id
    @Column(name = "roomgrade_id")
    private Integer roomgradeId;

    @Column(name = "roomgrade_name")
    private String roomgradeName;

    @Column(name = "privileges_id")
    private Integer privilegesId;

    /**
     * @return roomgrade_id
     */
    public Integer getRoomgradeId() {
        return roomgradeId;
    }

    /**
     * @param roomgradeId
     */
    public void setRoomgradeId(Integer roomgradeId) {
        this.roomgradeId = roomgradeId;
    }

    /**
     * @return roomgrade_name
     */
    public String getRoomgradeName() {
        return roomgradeName;
    }

    /**
     * @param roomgradeName
     */
    public void setRoomgradeName(String roomgradeName) {
        this.roomgradeName = roomgradeName == null ? null : roomgradeName.trim();
    }

    /**
     * @return privileges_id
     */
    public Integer getPrivilegesId() {
        return privilegesId;
    }

    /**
     * @param privilegesId
     */
    public void setPrivilegesId(Integer privilegesId) {
        this.privilegesId = privilegesId;
    }
}