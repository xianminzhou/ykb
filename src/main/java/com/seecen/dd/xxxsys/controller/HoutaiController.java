package com.seecen.dd.xxxsys.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("houtai")
public class HoutaiController {

    @RequestMapping("index")
    @RequiresRoles(value = "管理员")
    public String show(){
        return "houtai/index";
    }
}
