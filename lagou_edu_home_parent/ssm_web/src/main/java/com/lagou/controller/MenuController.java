package com.lagou.controller;

import com.lagou.domain.Menu;
import com.lagou.domain.ResponseResult;
import com.lagou.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    public MenuService menuService;

    @RequestMapping("/findAllMenu")
    public ResponseResult findAllMenu(){
        List<Menu> allMenu = menuService.findAllMenu();
        return new ResponseResult(true,200,"查询",allMenu);
    }
    /**
     * 回显菜单信息(包括父子菜单的全部信息)
     * */
    @RequestMapping("/findMenuInfoById")
    public ResponseResult findSubMenuListByPid() {
            List<Menu> subMenuList = menuService.findSubMenuListByPid(-1);
            Map<String,Object> map = new HashMap<>();
            map.put("menuInfo",null);
            map.put("parentMenuList",subMenuList);
            ResponseResult result = new ResponseResult(true, 200, "响应成功", map);
            return result;

    }
    @RequestMapping("/saveOrUpdateMenu")
    public ResponseResult findSubMenuList( Integer id) {
        Menu menu = menuService.findAllMenuById(id);
        List<Menu> subMenuList = menuService.findSubMenuListByPid(-1);
        Map<String,Object> map = new HashMap<>();
        map.put("menuInfo",menu);
        map.put("parentMenuList",subMenuList);
        ResponseResult result = new ResponseResult(true, 200, "响应成功", map);
        return result;

    }
}
