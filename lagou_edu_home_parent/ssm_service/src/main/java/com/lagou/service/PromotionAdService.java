package com.lagou.service;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.PromotionAd;
import com.lagou.domain.PromotionAdVO;

import java.util.List;

public interface PromotionAdService {
    /* 广告分页查询,接收前端传来的页面参数*/
    public PageInfo<PromotionAd> findAllPromotionAdByPage(PromotionAdVO promotionAdVO);
    /*广告状态上下线*/
    public Integer updatePromotionAdStatus(PromotionAd promotionAd) ;
}
