package com.seecen.dd.xxxsys.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.seecen.dd.xxxsys.dao.domain.*;
import com.seecen.dd.xxxsys.dao.mapper.YRoomMapper;
import com.seecen.dd.xxxsys.dao.mapper.YpermissionMapper;
import com.seecen.dd.xxxsys.dao.mapper.YuserMapper;
import com.seecen.dd.xxxsys.dao.mapper.YuserPermissionMapper;
import com.seecen.dd.xxxsys.service.YuserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class YuserServiceImpl implements YuserService {


    @Autowired
    private YuserMapper yuserMapper;

    /**
     * 判断该用户名是否存在
     * @param userName
     * @return
     */
    @Override
    public int selectByuserName(String userName) {
        Example example = new Example(Yuser.class);
        if (userName != null){
            example.createCriteria().andLike("userName",userName);
            List<Yuser> list = yuserMapper.selectByExample(example);
            return list.size();
        }
        return 0;
    }

    /**
     * 验证手机号是否已被注册
     * @param phonenumber
     * @return
     */
    @Override
    public int selectByphonenumber(String phonenumber) {
        Example example = new Example(Yuser.class);
        if (phonenumber != null){
            example.createCriteria().andLike("phonenumber",phonenumber);
            List<Yuser> list = yuserMapper.selectByExample(example);
            return list.size();
        }
        return 0;
    }

    /**
     * 注册
     * @param yuser
     * @return
     */
    @Override
    public int insertYuser(Yuser yuser) {
        return yuserMapper.insert(yuser);
    }

    /**
     * 获取用户
     * @param yuser
     * @return
     */
    @Override
    public Yuser getUser(Yuser yuser) {
        return yuserMapper.selectOne(yuser);
    }



    @Autowired
    private YpermissionMapper ypermissionMapper;

    @Autowired
    private YuserPermissionMapper yuserPermissionMapper;
    /**
     * 获取用户权限
     * @param userId userId
     * @return
     */
    @Override
    public Set<String> findPermissionsByUserId(int userId) {
        YuserPermission yuserPermission = yuserPermissionMapper.selectByPrimaryKey(userId);
        Ypermission ypermission = ypermissionMapper.selectByPrimaryKey(yuserPermission.getPermissionId());
            Set<String> result = new HashSet<>();
           result.add(ypermission.getPermissionName());
            return result;
    }

    @Override
    public int updateByPhonenumer(Yuser yuser) {
        Example example = new Example(Yuser.class);
        example.createCriteria().andLike("phonenumber",yuser.getPhonenumber());
        return yuserMapper.updateByExampleSelective(yuser,example);
    }


    /*分页查询*/
    @Override
    public PageInfo<Yuser> findRoomByPage(Yuser yuser, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        Example example = new Example(Yuser.class);
        if (yuser != null){
           Example.Criteria criteria = example.createCriteria();
                if (!StringUtil.isEmpty(yuser.getUserName())){
                    criteria.andLike("userName",yuser.getUserName());
                }
        }
        List<Yuser> list = yuserMapper.selectByExample(example);
        return new PageInfo<>(list);
    }
    /*添加*/
    @Override
    public boolean add(Yuser yuser) {
        int row = yuserMapper.insert(yuser);
        return row>0;
    }
    /*批量删除*/
    @Override
    public boolean delAll(List<Integer> ids) {
        Example example = new Example(Yuser.class);
        Example.Criteria cri = example.createCriteria();
        cri.andIn("userId",ids);
        int row = yuserMapper.deleteByExample(example);
        return row>0;
    }
    /*修改*/
    /*查询一条*/
    @Override
    public Yuser findById(Integer id) {
        Yuser yuser = new Yuser();
        yuser.setUserId(id);
        List<Yuser> list =yuserMapper.select(yuser);
        return list.get(0);
    }
    /*修改*/
    @Override
    public boolean update(Yuser y) {
        int row = yuserMapper.updateByPrimaryKeySelective(y);
        return row>0;
    }
    /*删除*/
    @Override
    public boolean del(Integer id) {
        int row = yuserMapper.deleteByPrimaryKey(id);
        return row>0;
    }
}
