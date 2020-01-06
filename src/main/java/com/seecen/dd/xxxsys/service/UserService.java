package com.seecen.dd.xxxsys.service;

import com.seecen.dd.xxxsys.dao.domain.SysUser;

import java.util.Set;

public interface UserService {
    /***
     * 获取用户
     *
     * @param user
     * @return
     */
    SysUser getUser(SysUser user);

    /**
     * 获取用户权限
     *
     * @param userId userId
     * @return 用户权限
     */
    Set<String> findPermissionsByUserId(int userId);
}
