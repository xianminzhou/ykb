package com.seecen.dd.xxxsys.dao.mapper;

import com.seecen.dd.xxxsys.dao.domain.Flow;
import org.springframework.stereotype.Component;

@Component
public interface IFlowDao {



    void insert(Flow flow);
}
