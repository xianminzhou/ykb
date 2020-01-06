package com.seecen.dd.xxxsys.dao.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author xianmin zhou
 * @date 2019/9/18 20:17
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ZOrder {
    private Integer orderId;
    private Integer roomId;
    private Integer userId;
    private BigDecimal endprice;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date staytime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date checkouttime;
    private Integer orderNumber;
    private Integer status;
    /*房间表*/
    private YRoom yRoom;
    /*用户表*/
    private Yuser yuser;
    /*房间类别表*/
    private YRoomType yRoomType;

}
