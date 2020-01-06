package com.seecen.dd.xxxsys.service;

import com.github.pagehelper.PageInfo;
import com.seecen.dd.xxxsys.dao.domain.YRoom;
import com.seecen.dd.xxxsys.dao.domain.Yuser;
import com.seecen.dd.xxxsys.dao.domain.ZRoom;

import java.util.List;
import java.util.Set;

public interface YuserService {

//    验证用户名是否已被使用
    int selectByuserName(String userName);

//    验证手机号是否被注册
    int selectByphonenumber(String phonenumber);

//    注册账号
    int insertYuser(Yuser yuser);

    /**
     * 获取用户
     */
    Yuser getUser(Yuser yuser);

    /**
     * 获取用户权限
     *
     * @param userId userId
     * @return 用户权限
     */
    Set<String> findPermissionsByUserId(int userId);

    int updateByPhonenumer(Yuser yuser);



    /*分页查询*/
    public PageInfo<Yuser> findRoomByPage(Yuser yuser, Integer pageNum, Integer pageSize);
    /*查询*/
    public Yuser findById(Integer id);
    /*添加*/
    public boolean add(Yuser yuser);
    /*批量删除*/
    public boolean delAll(List<Integer> ids);
    /*修改*/
    public boolean update(Yuser yuser);
    /*删除*/
    public boolean del(Integer id);
}
