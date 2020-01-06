package com.seecen.dd.xxxsys.service;

import com.github.pagehelper.PageInfo;
import com.seecen.dd.xxxsys.dao.domain.YRoom;
import com.seecen.dd.xxxsys.dao.domain.ZRoom;

import java.util.List;

/**
 * @author xianmin zhou
 * @date 2019/9/17 15:30
 */
public interface RoomService {
    /*分页查询*/
    public PageInfo<ZRoom> findRoomByPage(ZRoom zRoom, Integer pageNum, Integer pageSize);
    /*查询*/
    public ZRoom findById(Integer id);
    /*添加*/
    public boolean add(YRoom yRoom);
    /*批量删除*/
    public boolean delAll(List<Integer> ids);
    /*修改*/
    public boolean update(YRoom yRoom);
    /*删除*/
    public boolean del(Integer id);

}
