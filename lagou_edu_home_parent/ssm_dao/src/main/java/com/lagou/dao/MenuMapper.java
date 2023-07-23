package com.lagou.dao;

import com.lagou.domain.Menu;

import java.util.List;

public interface MenuMapper{
    /*查询全部的父子菜单信息*/
    public List<Menu> findSubMenuListByPid( Integer pid);
    /*查询所有菜单*/
    public List<Menu> findAllMenu();
    /*根据id回显菜单信息*/
    public Menu findAllMenuById (Integer id);
}
