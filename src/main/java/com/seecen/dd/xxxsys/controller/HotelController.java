package com.seecen.dd.xxxsys.controller;


import com.seecen.dd.xxxsys.dao.domain.Yuser;
import com.seecen.dd.xxxsys.dao.domain.ZOrder;
import com.seecen.dd.xxxsys.dao.domain.ZRoom;

import com.seecen.dd.xxxsys.dao.mapper.ZOrderMapper;
import com.seecen.dd.xxxsys.service.OrderService;

import com.seecen.dd.xxxsys.service.RoomService;
import com.seecen.dd.xxxsys.utils.OrderDateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class HotelController {

    @Autowired
    private RoomService roomService;

    @Autowired
    private ZOrderMapper zOrderMapper;

    /*酒店首页*//*
    @RequestMapping(value = "/hotelHome", method = RequestMethod.GET)
    public String loginPage() {
        return "/hotel/index";
    }*/

    /*预定页面*/
    @RequestMapping(value = "/houseBook/{id}", method = RequestMethod.GET)
    public String houseBook(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("list",roomService.findById(id));
        return "/hotel/booknow";
    }

    @Autowired
    private OrderService orderService;
    /*订单*/
    @RequestMapping(value = "/houseOrder", method = RequestMethod.GET)
    public String BookOrder(Model model, HttpSession session) {
        Yuser yuser = (Yuser) session.getAttribute("yuser");
        ZOrder zOrder = new ZOrder();
        zOrder.setYuser(yuser);
        List<ZOrder> orderAll = zOrderMapper.findOrderAll(zOrder);
        model.addAttribute("list",orderAll);
        return "/hotel/houseOrder";
    }


    /*支付页面*/
    @RequestMapping(value = "/pay", method = RequestMethod.GET)
    public String pay() {
        return "/hotel/roomPay";
    }


    /*预定金额*/
    @RequestMapping(value = "orderMoney",method = RequestMethod.POST)
    @ResponseBody
    public Double orderMoney(String time, String time2, Double oldMoney){

        String startDate = OrderDateUtil.DateChange(time);

        String endDate = OrderDateUtil.DateChange(time2);

        SimpleDateFormat myFormatter = new SimpleDateFormat( "yyyy-MM-dd");

        Date date= null;
        Date mydate = null;
        try {
            date = myFormatter.parse(startDate);
            mydate= myFormatter.parse(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        /*获取房间价格*/
        /*ZRoom room = roomService.findById(1);*/
        /*预定日期*/
        long days=(mydate.getTime()-date.getTime())/(24*60*60*1000);

        Double price = 0.0;
        if(days<=0){
            price = oldMoney;
        }else {
            price = oldMoney*(days+1);
        }
        return price;
    }


    /*分页查询*/
    @RequestMapping(value ="list2",method = RequestMethod.POST)
    @ResponseBody
    public void list2(@RequestParam(value = "pageNum2")
                              Integer pageNum, ZRoom zRoom, Model model){
        model.addAttribute("pageInfo",roomService.findRoomByPage(zRoom,pageNum,9));
    }



}
