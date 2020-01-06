package com.seecen.dd.xxxsys.dao.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * @author xianmin zhou
 * @date 2019/9/17 19:21
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ZRoom {
    private Integer roomId;
    private Integer roomName;
    private Integer hotelId;
    private Integer roomgradeId;
    private BigDecimal price;
    private BigDecimal vipPrice;
    private Integer status;
    private Integer roomtypeId;
    private String details;
    private Integer bedtypeId;
    private String roomImage;
    /*酒店信息表*/
    private YHotel yHotel;
    /*房间等级*/
    private YRoomGrade yRoomGrade;
    /*房间类别表*/
    private YRoomType yRoomType;
    /*床型表*/
    private YBedType yBedType;

}
