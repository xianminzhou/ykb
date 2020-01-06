package com.seecen.dd.xxxsys.dao.mapper;

import com.seecen.dd.xxxsys.dao.domain.Ypermission;
import tk.mybatis.mapper.common.Mapper;

import java.util.Set;

public interface YpermissionMapper extends Mapper<Ypermission> {
    Set<String> findRoleNameByUserId(int userId);
}