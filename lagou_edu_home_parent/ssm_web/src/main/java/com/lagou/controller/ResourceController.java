package com.lagou.controller;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.Resource;
import com.lagou.domain.ResourceVo;
import com.lagou.domain.ResponseResult;
import com.lagou.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resource")
public class ResourceController {
    @Autowired
    public ResourceService resourceService;

    /*资源信息分页&条件查询*/
    @RequestMapping("/findAllResource")
    public ResponseResult  findAllResource( @RequestBody ResourceVo resourceVo){
        PageInfo<Resource> allResource = resourceService.findAllResource(resourceVo);
        return new ResponseResult(true,200,"响应成功",allResource);
    }
}
