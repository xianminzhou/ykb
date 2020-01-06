package com.seecen.dd.xxxsys.controller;

import com.seecen.dd.xxxsys.dao.domain.Yuser;
import com.seecen.dd.xxxsys.service.YuserService;
import com.seecen.dd.xxxsys.utils.RequestUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;


@Controller
@RequestMapping(value = "/music")
public class MusicInfoController {


    @Autowired
    private YuserService yuserService;

    @RequestMapping("/login")
    @RequiresPermissions({"/usersPage"})
    @ResponseBody
    public String login(){
        Yuser user = RequestUtils.currentLoginUser();
        Set<String> authorization = yuserService.findPermissionsByUserId(user.getUserId());
        return "该用户有如下权限" + authorization;
    }

}
