package com.lagou.service.impl;

import com.lagou.dao.RoleMapper;
import com.lagou.domain.Role;
import com.lagou.domain.RoleMenuRelation;
import com.lagou.domain.RoleMenuVo;
import com.lagou.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    public RoleMapper roleMapper;

    @Override
    public List<Role> findAllRole(Role role) {
        List<Role> allRole = roleMapper.findAllRole(role);
        return allRole;
    }

    @Override
    public List<String> findMenuByRoleId(Integer roleId) {
        List<String> list = roleMapper.findMenuByRoleId(roleId);
        return list;
    }

    @Override
    public void RoleContextMenu(RoleMenuVo roleMenuVo) {
        // 清空中间表
        roleMapper.deleteRoleContextMenu(roleMenuVo.getRoleId());
        //封装数据
        for (Integer mid : roleMenuVo.getMenuIdList()) {
            RoleMenuRelation roleMenuRelation= new RoleMenuRelation();
            roleMenuRelation.setRoleId(roleMenuVo.getRoleId());
            roleMenuRelation.setMenuId(mid);
            roleMenuRelation.setCreatedTime(new Date());
            roleMenuRelation.setUpdatedTime(new Date());
            roleMenuRelation.setCreatedBy("system");
            roleMenuRelation.setUpdatedBy("system");
            roleMapper.RoleContextMenu(roleMenuRelation);
        }
    }

    @Override
    public void deleteRole(Integer roleId) {
        //清空角色菜单中间表
        roleMapper.deleteRoleContextMenu(roleId);
        //删除角色
        roleMapper.deleteRole(roleId);
    }
}
