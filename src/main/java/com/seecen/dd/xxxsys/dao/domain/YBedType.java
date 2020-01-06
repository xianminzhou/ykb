package com.seecen.dd.xxxsys.dao.domain;

import javax.persistence.*;

@Table(name = "y_hotel_bedtype")
public class YBedType {
    @Id
    @Column(name = "bedType_id")
    private Integer bedtypeId;

    @Column(name = "bedType_name")
    private String bedtypeName;

    /**
     * @return bedType_id
     */
    public Integer getBedtypeId() {
        return bedtypeId;
    }

    /**
     * @param bedtypeId
     */
    public void setBedtypeId(Integer bedtypeId) {
        this.bedtypeId = bedtypeId;
    }

    /**
     * @return bedType_name
     */
    public String getBedtypeName() {
        return bedtypeName;
    }

    /**
     * @param bedtypeName
     */
    public void setBedtypeName(String bedtypeName) {
        this.bedtypeName = bedtypeName == null ? null : bedtypeName.trim();
    }
}