package com.seecen.dd.xxxsys.controller;

import com.seecen.dd.xxxsys.dao.domain.Json;
import com.seecen.dd.xxxsys.dao.domain.Yuser;
import com.seecen.dd.xxxsys.service.YuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/yuser")
public class YuserController {

    @Autowired
    private YuserService yuserService;
    /*分页查询*/
    @RequestMapping("list")
    public String showRoom(@RequestParam(value = "pageNum",required = false,defaultValue = "1")
                                   Integer pageNum, Yuser yuser, Model model){
        model.addAttribute("pageInfo",yuserService.findRoomByPage(yuser,pageNum,5));
        return "houtai/hotel/yuser-list";
    }
    /*添加*/
    /*显示页面*/
    @RequestMapping(value = "/yuser",method = RequestMethod.GET)
    public String add(){
        return "houtai/hotel/roomManage-add";
    }
//    /*拦截请求*/
//    @RequestMapping(value = "add",method = RequestMethod.POST)
//    @ResponseBody
//    public Json add(Yuser yuser){
//        yuser.setBalance("/hotel_jpg/img_5.jpg");
//        if (yuserService.add(yRoom)){
//            return new Json(200,"添加成功");
//        }else {
//            return new Json(500,"添加失败");
//        }
//    }
    /*批量删除*/
    @RequestMapping("/delAll")
    @ResponseBody
    public Json delAll(@RequestParam("ids[]") List<Integer> ids) {
        if (yuserService.delAll(ids)) {
            return new Json(200, "删除成功");
        } else {
            return new Json(500, "删除失败");
        }
    }
    /*修改*/
    @RequestMapping("update/{id}")
    public String update(@PathVariable("id") Integer roomId, Model model){
        Yuser zRoom = yuserService.findById(roomId);
        model.addAttribute(zRoom);
        return "text/study_update";
    }
    @RequestMapping(value = "update",method = RequestMethod.POST)
    @ResponseBody
    public Json update(Yuser yRoom){
        if (yuserService.update(yRoom)){
            return new Json(200,"修改成功");
        }else {
            return new Json(500,"修改失败");
        }
    }
    /*删除*/
    @RequestMapping("del")
    @ResponseBody
    public Json del(@RequestParam("id") Integer id){
        if (yuserService.del(id)){
            return new Json(200,"删除成功");
        }else {
            return new Json(500,"删除失败");
        }
    }
}
