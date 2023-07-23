package com.lagou.dao;

import com.lagou.domain.ResourceCategory;

import java.util.List;

public interface ResourceCategoryMapper {
    //返回资源分类表分类名称
    public List<ResourceCategory> findAllResourceCategory ();
}
