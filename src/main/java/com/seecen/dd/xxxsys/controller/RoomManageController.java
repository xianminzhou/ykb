package com.seecen.dd.xxxsys.controller;

import com.seecen.dd.xxxsys.dao.domain.Json;
import com.seecen.dd.xxxsys.dao.domain.YRoom;
import com.seecen.dd.xxxsys.dao.domain.ZRoom;
import com.seecen.dd.xxxsys.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author xianmin zhou
 * @date 2019/9/19 14:28
 */
@Controller
@RequestMapping("RoomManage")
public class  RoomManageController {
    @Autowired
    private RoomService roomService;
    /*分页查询*/
    @RequestMapping("list")
    public String showRoom(@RequestParam(value = "pageNum",required = false,defaultValue = "1")
                                       Integer pageNum, ZRoom zRoom, Model model){
        model.addAttribute("pageInfo",roomService.findRoomByPage(zRoom,pageNum,5));
        if (zRoom!=null){
            model.addAttribute("zRoom",zRoom);
        }
        return "houtai/hotel/roomManage-list";
    }
    /*添加*/
    /*显示页面*/
    @RequestMapping(value = "add",method = RequestMethod.GET)
    public String add(){
        return "houtai/hotel/roomManage-add";
    }
    /*拦截请求*/
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public Json add(YRoom yRoom){
        yRoom.setRoomImage("/hotel_jpg/img_5.jpg");
        if (roomService.add(yRoom)){
            return new Json(200,"添加成功");
        }else {
            return new Json(500,"添加失败");
        }
    }
    /*批量删除*/
    @RequestMapping("/delAll")
    @ResponseBody
    public Json delAll(@RequestParam("ids[]") List<Integer> ids) {
        if (roomService.delAll(ids)) {
            return new Json(200, "删除成功");
        } else {
            return new Json(500, "删除失败");
        }
    }
    /*修改*/
    @RequestMapping("update/{id}")
    public String update(@PathVariable("id") Integer roomId, Model model){
        model.addAttribute("yRoom",roomService.findById(roomId));
        return "houtai/hotel/roomManage-update";
    }
    @RequestMapping(value = "update",method = RequestMethod.POST)
    @ResponseBody
    public Json update(YRoom yRoom){
        if (roomService.update(yRoom)){
            return new Json(200,"修改成功");
        }else {
            return new Json(500,"修改失败");
        }
    }
    /*删除*/
    @RequestMapping("del")
    @ResponseBody
    public Json del(@RequestParam("id") Integer id){
        if (roomService.del(id)){
            return new Json(200,"删除成功");
        }else {
            return new Json(500,"删除失败");
        }
    }
    /*桌面跳转*/
    @RequestMapping("zhuomian")
    public String zhuomian(){
        return "houtai/welcome";
    }
}
