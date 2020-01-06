package com.seecen.dd.xxxsys.service.impl;

import com.seecen.dd.xxxsys.service.SysRoleService;
import com.seecen.dd.xxxsys.dao.mapper.SysRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Override
    public Set<String> findRoleNameByUserId(int userId) {
        return sysRoleMapper.findRoleNameByUserId(userId);
    }
}
