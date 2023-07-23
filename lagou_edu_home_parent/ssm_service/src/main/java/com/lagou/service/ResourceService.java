package com.lagou.service;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.Resource;
import com.lagou.domain.ResourceVo;

public interface ResourceService {
    /*资源信息分页&条件查询*/
    public PageInfo<Resource> findAllResource(ResourceVo resourceVo);
}
