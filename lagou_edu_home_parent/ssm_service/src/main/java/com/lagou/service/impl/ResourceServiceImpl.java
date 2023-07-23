package com.lagou.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lagou.dao.ResourceMapper;
import com.lagou.domain.Resource;
import com.lagou.domain.ResourceVo;
import com.lagou.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ResourceServiceImpl implements ResourceService {
    @Autowired
    public ResourceMapper resourceMapper;
    @Override
    public PageInfo<Resource>findAllResource(ResourceVo resourceVo) {
        //分页
       PageHelper.startPage(resourceVo.getCurrentPage(), resourceVo.getPageSize());
        List<Resource> allResource = resourceMapper.findAllResource(resourceVo);
        PageInfo<Resource> resourcePageInfo = new PageInfo<Resource>(allResource);
        return resourcePageInfo;
    }
}
