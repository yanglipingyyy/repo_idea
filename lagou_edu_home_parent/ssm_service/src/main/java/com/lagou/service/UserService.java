package com.lagou.service;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.Role;
import com.lagou.domain.User;
import com.lagou.domain.UserVo;

import java.util.List;

public interface UserService {
    /*用户分页及多条件查询*/
    public PageInfo findAllUserByPage (UserVo userVo);
    /*用户登陆查询*/
    public User login(User user) throws Exception;
    /*分配角色，条件用户id*/
    public  List<Role>  findUserRelationRoleById(Integer id);
    /*用户关联角色*/
    public  void userContextRole(UserVo userVo);
}
