package com.lagou.service;

import com.lagou.domain.ResourceCategory;

import java.util.List;

public interface ResourceCategoryService {
    //返回资源分类表分类名称
    public List<ResourceCategory> findAllResourceCategory ();
}
