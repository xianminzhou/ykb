package com.seecen.dd.xxxsys.service.impl;

import com.seecen.dd.xxxsys.dao.domain.Yrole;
import com.seecen.dd.xxxsys.dao.mapper.YroleMapper;
import com.seecen.dd.xxxsys.service.YroleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.HashSet;
import java.util.Set;

@Service
public class YroleServiceImpl implements YroleService {

    @Autowired
    private YroleMapper yroleMapper;

    /**
     * 获取角色
     * @param roleId
     * @return
     */
    @Override
    public Set<String> findRoleNameByUserId(int roleId) {
        Set<String> strings = new HashSet<>();
        Yrole yrole = yroleMapper.selectByPrimaryKey(roleId);
        strings.add(yrole.getRoleName());
        return strings;
    }
}
