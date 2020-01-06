
package com.seecen.dd.xxxsys.service.impl;

import com.github.pagehelper.util.StringUtil;
import com.seecen.dd.xxxsys.dao.domain.ZOrder;
import com.seecen.dd.xxxsys.dao.domain.ZRoom;
import com.seecen.dd.xxxsys.dao.mapper.ZOrderMapper;
import com.seecen.dd.xxxsys.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xianmin zhou
 * @date 2019/9/18 20:57
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private ZOrderMapper zOrderMapper;

    @Override
    public List<ZOrder> findOrderAll(){
        List<ZOrder> list = zOrderMapper.findOrderAll(null);
        return list;
    }

}


