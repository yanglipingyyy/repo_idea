package com.lagou.service;

import com.lagou.domain.Role;
import com.lagou.domain.RoleMenuVo;

import java.util.List;

public interface RoleService {
    /*查询所有角色（条件name）*/
    public List<Role> findAllRole(Role role);
    /**
     * 根据ID查询角色关联菜单
     * */
    public  List<String> findMenuByRoleId(Integer roleId);
    /*添加角色菜单*/
    public void RoleContextMenu(RoleMenuVo roleMenuVo);
    /*删除角色*/
    public void deleteRole(Integer roleId);
}
