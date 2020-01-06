package com.seecen.dd.xxxsys.dao.mapper;

import com.seecen.dd.xxxsys.dao.domain.ZOrder;

import java.util.List;

/**
 * @author xianmin zhou
 * @date 2019/9/18 20:59
 */
public interface ZOrderMapper {
    List<ZOrder> findOrderAll(ZOrder zOrder);
}
