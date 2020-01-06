package com.seecen.dd.xxxsys.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.seecen.dd.xxxsys.dao.domain.YRoom;
import com.seecen.dd.xxxsys.dao.domain.ZRoom;
import com.seecen.dd.xxxsys.dao.mapper.YRoomMapper;
import com.seecen.dd.xxxsys.dao.mapper.ZRoomMapper;
import com.seecen.dd.xxxsys.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author xianmin zhou
 * @date 2019/9/17 15:38
 */
@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private ZRoomMapper zRoomMapper;

    /*分页查询*/
    @Override
    public PageInfo<ZRoom> findRoomByPage(ZRoom zRoom, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        if (zRoom != null){
            if (zRoom.getYRoomType() != null ){
                if (!StringUtil.isEmpty(zRoom.getYRoomType().getRoomtypeName()) && zRoom.getYRoomType().getRoomtypeName().length()>0){
                    zRoom.getYRoomType().setRoomtypeName("%"+zRoom.getYRoomType().getRoomtypeName()+"%");
                }
            }
            if (zRoom.getYBedType() != null){
                if (!StringUtil.isEmpty(zRoom.getYBedType().getBedtypeName()) && zRoom.getYBedType().getBedtypeName().length()>0){
                    zRoom.getYBedType().setBedtypeName("%"+zRoom.getYBedType().getBedtypeName()+"%");
                }
            }
            if (zRoom.getPrice() != null){
                zRoom.setPrice(zRoom.getPrice());
            }
            if (zRoom.getRoomName() != null){
                zRoom.setRoomName(zRoom.getRoomName());
            }
        }
        List<ZRoom> list = zRoomMapper.findAll(zRoom);
        return new PageInfo<>(list);
    }

    @Autowired
    private YRoomMapper yRoomMapper;
    /*添加*/
    @Override
    public boolean add(YRoom yRoom) {
        int row = yRoomMapper.insert(yRoom);
        return row>0;
    }
    /*批量删除*/
    @Override
    public boolean delAll(List<Integer> ids) {
        Example example = new Example(YRoom.class);
        Example.Criteria cri = example.createCriteria();
        cri.andIn("roomId",ids);
        int row = yRoomMapper.deleteByExample(example);
        return row>0;
    }
    /*修改*/
    /*查询一条*/
    @Override
    public ZRoom findById(Integer id) {
        ZRoom zRoom = new ZRoom();
        zRoom.setRoomId(id);
        List<ZRoom> list = zRoomMapper.findAll(zRoom);
        return list.get(0);
    }
    /*修改*/
    @Override
    public boolean update(YRoom yRoom) {
        int row = yRoomMapper.updateByPrimaryKeySelective(yRoom);
        return row>0;
    }
    /*删除*/
    @Override
    public boolean del(Integer id) {
        int row = yRoomMapper.deleteByPrimaryKey(id);
        return row>0;
    }
}
