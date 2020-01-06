package com.seecen.dd.xxxsys.controller;

import com.seecen.dd.xxxsys.dao.domain.Orders;
import com.seecen.dd.xxxsys.dao.domain.Product;
import com.seecen.dd.xxxsys.enums.OrderStatusEnum;
import com.seecen.dd.xxxsys.service.OrdersService;
import com.seecen.dd.xxxsys.service.ProductService;
import com.seecen.dd.xxxsys.utils.LeeJSONResult;
import idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
@Controller
@RequestMapping
public class ProductController {


    @Autowired
    private ProductService productService;

    @Autowired
    private OrdersService ordersService;

    /**
     * 获取产品列表
     *
     * @return
     * @throws Exception
     */

    @RequestMapping("aplipay/index")
    public String index(Map map) {
        List<Product> pList = productService.getProducts();
        map.put("pList", pList);
        return "aplipay/index";
    }

    /**
     * 进入确认页面
     *
     * @param productId
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/goConfirm/{productId}")
    public String goConfirm(@PathVariable("productId") String productId, Map map) {
        Product p = productService.getProductById(productId);
        map.put("p", p);
        return "/aplipay/goConfirm";
    }

    /**
     * 分段提交
     * 第一段：保存订单
     *
     * @param order
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/createOrder")
    @ResponseBody
    public LeeJSONResult createOrder(Orders order) throws Exception {

        Product p = productService.getProductById(order.getProductId());
        Sid sid = new Sid();
        String orderId = sid.nextShort();
        order.setId(orderId);
        order.setOrderNum(orderId);
        order.setCreateTime(new Date());
        order.setOrderAmount(String.valueOf(Float.valueOf(p.getPrice()) * order.getBuyCounts()));
        order.setOrderStatus(OrderStatusEnum.WAIT_PAY.key);
        ordersService.saveOrder(order);

        return LeeJSONResult.ok(orderId);
    }

    /**
     * 分段提交
     * 第二段
     *
     * @param orderId
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/goPay/{orderId}")
    public String goPay(@PathVariable("orderId") String orderId, Map map) {

        Orders order = ordersService.getOrderById(orderId);

        Product p = productService.getProductById(order.getProductId());

        map.put("order", order);
        map.put("p", p);

        return "aplipay/goPay";
    }

    @RequestMapping("aplipay/hotel")
    public String hotel( Map map, HttpServletRequest request,HttpSession session) {
        String parameter = (String) session.getAttribute(RoomController.ORDER_NUM);
        List<Product> pList = new ArrayList<>();
        pList.add(productService.getProductById(parameter));
        map.put("pList", pList);
        return "aplipay/index";
    }

    @RequestMapping("aplipay/hoteled/{id}")
    public String hotel2(@PathVariable("id")Integer id, Map map, HttpServletRequest request, HttpSession session) {
        String s = id.toString();

        session.setAttribute(RoomController.ORDER_NUM,s);
/*        String parameter = request.getParameter(RoomController.ORDER_NUM);*/
        List<Product> pList = new ArrayList<>();
        pList.add(productService.getProductById(s));
        map.put("pList", pList);
        return "aplipay/index";
    }
}
