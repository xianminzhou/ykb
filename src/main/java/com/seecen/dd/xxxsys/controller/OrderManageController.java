package com.seecen.dd.xxxsys.controller;

import com.seecen.dd.xxxsys.dao.domain.*;
import com.seecen.dd.xxxsys.dao.mapper.YOrderMapper;
import com.seecen.dd.xxxsys.dao.mapper.ZOrderMapper;
import com.seecen.dd.xxxsys.service.OrderService;
import com.seecen.dd.xxxsys.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("OrderManage")
public class OrderManageController {

    @Autowired
    private ZOrderMapper zOrderMapper;

    @Autowired
    private YOrderMapper yOrderMapper;
    /*分页查询*/
    @RequestMapping("list")
    public String showOrder(ZOrder zOrder,Model model){
        String userName = "";
        if(zOrder.getYuser()!=null){
            if(zOrder.getYuser().getUserName()!=null || zOrder.getYuser().getUserName().length()>0){
                userName = zOrder.getYuser().getUserName();
                Yuser yuser = new Yuser();
                yuser.setUserName("%"+userName+"%");
                zOrder.setYuser(yuser);
            }
        }
        List<ZOrder> orderAll = zOrderMapper.findOrderAll(zOrder);
        model.addAttribute("orders",orderAll);
        return "houtai/hotel/orderManage-list";
    }


    @RequestMapping("delete")
    @ResponseBody
    public JsonResult deleteOrder(Integer id){
        /*Example example = new Example(YOrder.class);
        example.createCriteria().andEqualTo("orderId",id);*/
        int i = yOrderMapper.deleteByPrimaryKey(id);
        if (i>0){
            return new JsonResult(100,"删除成功");
        }
        return new JsonResult(200,"删除失败");
    }


    @RequestMapping("deleteAll")
    @ResponseBody
    public JsonResult deleteOrders(@RequestParam(value = "ids[]") List<Short> ids){
        Example example = new Example(YOrder.class);
        example.createCriteria().andIn("orderId",ids);
        int i = yOrderMapper.deleteByPrimaryKey(example);
        if (i>0){
            return new JsonResult(100,"删除成功");
        }
        return new JsonResult(200,"删除失败");
    }
}
