package com.seecen.dd.xxxsys.dao.mapper;

import com.seecen.dd.xxxsys.dao.domain.Yrole;
import tk.mybatis.mapper.common.Mapper;

import java.util.Set;

public interface YroleMapper extends Mapper<Yrole> {
    Set<String> findRoleNameByUserId(int userId);
}