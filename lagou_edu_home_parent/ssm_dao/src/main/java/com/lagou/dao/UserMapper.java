package com.lagou.dao;

import com.lagou.domain.Role;
import com.lagou.domain.User;
import com.lagou.domain.UserRoleRelation;
import com.lagou.domain.UserVo;

import java.util.List;

public interface UserMapper {
   /*用户分页及多条件查询*/
    public List<User> findAllUserByPage (UserVo userVo);
    /*用户登陆查询*/
    public User login(User user);
    /*分配角色，条件用户id*/
    public  List<Role>  findUserRelationRoleById(Integer id);
    /* 根据用户ID清空中间表 */
    public  void deleteUserContextRole(Integer userId);
    /* 分配角色*/
    public void userContextRole(UserRoleRelation userRoleRelation);
}
