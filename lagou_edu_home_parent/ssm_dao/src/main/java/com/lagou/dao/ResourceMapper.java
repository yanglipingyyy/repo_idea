package com.lagou.dao;

import com.lagou.domain.Resource;
import com.lagou.domain.ResourceVo;

import java.util.List;

public interface ResourceMapper  {
    /*资源信息分页&条件查询*/
    public List<Resource> findAllResource(ResourceVo resourceVo);


}
