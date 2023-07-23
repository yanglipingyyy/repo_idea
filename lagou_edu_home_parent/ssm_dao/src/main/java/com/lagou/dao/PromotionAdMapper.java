package com.lagou.dao;

import com.lagou.domain.PromotionAd;

import java.util.List;

public interface PromotionAdMapper {
   /* 广告分页查询*/
    public List<PromotionAd> findAllPromotionAdByPage();
    /*广告状态上下线*/
    public Integer updatePromotionAdStatus(PromotionAd promotionAd) ;
}
