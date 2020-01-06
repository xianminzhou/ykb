package com.seecen.dd.xxxsys.service.impl;

import com.seecen.dd.xxxsys.service.ResourcesService;
import com.seecen.dd.xxxsys.dao.domain.SysResources;
import com.seecen.dd.xxxsys.dao.mapper.SysResourcesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourcesServiceImpl implements ResourcesService {
    @Autowired
    private SysResourcesMapper sysResourcesMapper;

    @Override
    public List<SysResources> selectAll() {
        List<SysResources> resourcesList = sysResourcesMapper.selectAll();
        return resourcesList;
    }
}
