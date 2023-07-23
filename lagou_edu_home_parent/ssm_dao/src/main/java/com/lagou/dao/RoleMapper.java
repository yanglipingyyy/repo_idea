package com.lagou.dao;

import com.lagou.domain.Role;
import com.lagou.domain.RoleMenuRelation;

import java.util.List;

public interface RoleMapper {
    /*查询所有角色（条件name）*/
    public List<Role> findAllRole(Role role);
    /*根据角色ID查询菜单信息*/
    public List<String> findMenuByRoleId(Integer roleId);
    /*根据roleId清空中间表的关联关系*/
    public void deleteRoleContextMenu(Integer rid);
    /*角色菜单关联*/
    public void  RoleContextMenu(RoleMenuRelation roleMenuRelation);
    /*删除角色*/
    public void deleteRole(Integer roleId);
}
