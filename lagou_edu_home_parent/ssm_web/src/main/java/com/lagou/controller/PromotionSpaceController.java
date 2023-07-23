package com.lagou.controller;

import com.lagou.domain.PromotionSpace;
import com.lagou.domain.ResponseResult;
import com.lagou.domain.Test;
import com.lagou.service.PromotionSpaceService;
import com.lagou.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/PromotionSpace")
public class PromotionSpaceController {
    @Autowired
    private PromotionSpaceService promotionSpaceService;

//    @Autowired
//    private TestService testService;
    /*获取所有的广告位*/
//    @RequestMapping("/findAllTest111")
//    public List<Test> findAllTest(){
//        List<Test> allTest = testService.findAllTest();
//        return allTest;
//    }
/*获取所有的广告位*/
    @RequestMapping("/findAllPromotionSpace")
    public ResponseResult findAllPromotionSpace(){
        System.out.println(1);
        List<PromotionSpace> allPromotionSpace = promotionSpaceService.findAllPromotionSpace();
        ResponseResult responseResult = new ResponseResult(true,200,"响应成功",allPromotionSpace);
        return responseResult;
    }
    /*添加-更新广告位*/
    @RequestMapping("/saveOrUpdatePromotionSpace")
    public ResponseResult saveOrUpdatePromotionSpace( @RequestBody PromotionSpace promotionSpace){
        if (promotionSpace.getId() == null){
            promotionSpaceService.savePromotionSpace(promotionSpace);
            return new ResponseResult(true,200,"添加广告位成功",null);
        }else {
            promotionSpaceService.updatePromotionSpace(promotionSpace);
            return new ResponseResult(true,200,"更新广告位成功",null);
        }


    }
    /*根据id回显数据*/
    @RequestMapping("/findPromotionSpaceById")
    public ResponseResult findPromotionSpaceById( @RequestParam int id){
        PromotionSpace promotionSpaceById = promotionSpaceService.findPromotionSpaceById(id);
        ResponseResult responseResult = new ResponseResult(true,200,"添加广告位成功",promotionSpaceById);
        return responseResult;
    }
}
