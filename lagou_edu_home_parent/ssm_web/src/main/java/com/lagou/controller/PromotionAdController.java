package com.lagou.controller;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.PromotionAd;
import com.lagou.domain.PromotionAdVO;
import com.lagou.domain.ResponseResult;
import com.lagou.service.PromotionAdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/PromotionAd")
public class PromotionAdController {
    @Autowired
    public PromotionAdService promotionAdService;

    @RequestMapping("/findAllPromotionAdByPage")
    public ResponseResult findAllPromotionAdByPage(PromotionAdVO promotionAdVO){
        PageInfo<PromotionAd> pageInfo = promotionAdService.findAllPromotionAdByPage(promotionAdVO);
        ResponseResult responseResult = new ResponseResult(true, 200, "分页查询成功", pageInfo);
        return responseResult;
    }

    @RequestMapping("/updatePromotionAdStatus")
    public ResponseResult updatePromotionAdStatus(PromotionAd promotionAd){
        Integer integer = promotionAdService.updatePromotionAdStatus(promotionAd);
        if (integer == 1){
            ResponseResult responseResult = new ResponseResult(true, 200, "状态修改成功", integer);
            return responseResult;
        }else {
            ResponseResult responseResult = new ResponseResult(false, 500, "状态状态修改失败", integer);
            return responseResult;
        }
    }
}
