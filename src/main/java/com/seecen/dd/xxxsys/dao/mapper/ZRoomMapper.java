package com.seecen.dd.xxxsys.dao.mapper;

import com.seecen.dd.xxxsys.dao.domain.ZRoom;

import java.util.List;

/**
 * @author xianmin zhou
 * @date 2019/9/17 16:57
 */
public interface ZRoomMapper {
    /*查询*/
    List<ZRoom> findAll(ZRoom zRoom);
    /*添加*/
    int roomAdd(ZRoom zRoom);
}
