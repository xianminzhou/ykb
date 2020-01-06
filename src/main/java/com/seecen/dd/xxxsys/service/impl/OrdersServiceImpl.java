package com.seecen.dd.xxxsys.service.impl;

import com.seecen.dd.xxxsys.dao.domain.Flow;
import com.seecen.dd.xxxsys.dao.domain.Orders;
import com.seecen.dd.xxxsys.dao.mapper.IFlowDao;
import com.seecen.dd.xxxsys.dao.mapper.IOrderDao;
import com.seecen.dd.xxxsys.enums.OrderStatusEnum;
import com.seecen.dd.xxxsys.service.OrdersService;
import idworker.Sid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class OrdersServiceImpl implements OrdersService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrdersServiceImpl.class);

    @Autowired
    private IOrderDao iOrderDao;

    @Autowired
    private IFlowDao iFlowDao;

    @Override
    public void saveOrder(Orders order) {
        iOrderDao.insert(order);
    }

    @Override
    @Transactional
    public void updateOrderStatus(String orderId, String alpayFlowNum, String paidAmount) {
        Orders order = getOrderById(orderId);
        //如果是 待付款 修改订单状态 并且 并且 新增  流水
        if (order.getOrderStatus().equals(OrderStatusEnum.WAIT_PAY.key)) {
            order = new Orders();
            order.setId(orderId);
            order.setOrderStatus(OrderStatusEnum.PAID.key);
            order.setPaidTime(new Date());
            order.setPaidAmount(paidAmount);

            iOrderDao.updateById(order);

            //查询    修改后最新的order
            order = getOrderById(orderId);
            Sid sid = new Sid();
            String flowId = sid.nextShort();
            Flow flow = new Flow();
            flow.setId(flowId);
            flow.setFlowNum(alpayFlowNum);
            flow.setBuyCounts(order.getBuyCounts());
            flow.setCreateTime(new Date());
            flow.setOrderNum(orderId);
            flow.setPaidAmount(paidAmount);
            flow.setPaidMethod(1);
            flow.setProductId(order.getProductId());
            //插入 流水表
            iFlowDao.insert(flow);

        }

    }

    @Override
    public Orders getOrderById(String orderId) {
        LOGGER.info("开始查询订单，订单orderId:{}", orderId);
        return iOrderDao.getOrderById(orderId);
    }
}
