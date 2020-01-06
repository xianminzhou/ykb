package com.seecen.dd.xxxsys.service;

import com.seecen.dd.xxxsys.dao.domain.ZOrder;

import java.util.List;

/**
 * @author xianmin zhou
 * @date 2019/9/18 20:55
 */
public interface OrderService {
    public List<ZOrder> findOrderAll();
}
