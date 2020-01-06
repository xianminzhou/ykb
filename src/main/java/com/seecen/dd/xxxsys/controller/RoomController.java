package com.seecen.dd.xxxsys.controller;

import com.github.pagehelper.PageInfo;
import com.seecen.dd.xxxsys.dao.domain.*;
import com.seecen.dd.xxxsys.dao.mapper.IProductdao;
import com.seecen.dd.xxxsys.dao.mapper.OrdersMapper;
import com.seecen.dd.xxxsys.dao.mapper.YOrderMapper;
import com.seecen.dd.xxxsys.service.RoomService;
import com.seecen.dd.xxxsys.utils.OrderDateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author xianmin zhou
 * @date 2019/9/18 9:41
 */
@Controller
@RequestMapping("room")
@Component
public class RoomController {
    @Autowired
    private RoomService roomService;

    @Autowired
    private YOrderMapper ordersMapper;

    @Autowired
    private IProductdao productdao;


    public  static final String ORDER_NUM = "ORDER_NUM";
    /*分页查询*/
    @RequestMapping("list")
    public String list(@RequestParam(value = "pageNum",required = false,defaultValue = "1")
                                   Integer pageNum, ZRoom zRoom, Model model ,HttpSession session){

        model.addAttribute("pageInfo",roomService.findRoomByPage(zRoom,pageNum,9));
        Yuser yuser = (Yuser) session.getAttribute("yuser");
        model.addAttribute("user",yuser);
        return "/hotel/index";
    }


    /*房间提交订单*/
    @RequestMapping("reserve")
    public String reserve(YOrder yOrder, String time, String time2, HttpSession session){
        /*用户ID*/
        Yuser yuser = (Yuser) session.getAttribute("yuser");
        yOrder.setUserId(yuser.getUserId());

        String Date1 = OrderDateUtil.DateChange(time);
        String Date2 = OrderDateUtil.DateChange(time2);
        /*预定时间*/
        Date startDate = OrderDateUtil.DateYmd(Date1);
        Date endDate = OrderDateUtil.DateYmd(Date2);
        yOrder.setStaytime(startDate);
        yOrder.setCheckouttime(endDate);
        /*随机流水号*/
        Integer radomNum = OrderDateUtil.orderNumber();
        yOrder.setOrderNumber(radomNum);
        yOrder.setStatus(0);
        System.out.println(yOrder);
        int i = ordersMapper.insert(yOrder);

        BigDecimal bd=yOrder.getEndprice().setScale(0, BigDecimal.ROUND_HALF_UP);
//转化为字符串输出
        String money=bd.toString();

        /*插入商品表*/
        String s = radomNum.toString();
        /*String s1 = s.substring(0, 3);*/
        Product product = new Product();
        product.setId(s);
        /*云镜生态园酒店（高新店）*/
        product.setName("南昌红谷滩希尔顿欢朋酒店");
        product.setPrice(money);
        Integer insert = productdao.Insert(product);
        session.setAttribute(ORDER_NUM,s);
        return "redirect:/aplipay/hotel";
    }

}
