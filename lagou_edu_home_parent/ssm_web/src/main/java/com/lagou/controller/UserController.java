package com.lagou.controller;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.ResponseResult;
import com.lagou.domain.Role;
import com.lagou.domain.User;
import com.lagou.domain.UserVo;
import com.lagou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    /*用户分页及多条件查询*/
    @RequestMapping("/findAllUserByPage")
    public ResponseResult findAllUserByPage(@RequestBody UserVo userVo){
        PageInfo pageInfo = userService.findAllUserByPage(userVo);
        ResponseResult responseResult = new ResponseResult(true,200,"响应成功",pageInfo);
        List<User> list = pageInfo.getList();
        System.out.println(list);
        return responseResult;
    }
    /*用户登陆查询*/
    @RequestMapping("/login")
    public ResponseResult login( User user, HttpServletRequest request) throws Exception {
        User login = userService.login(user);
        ResponseResult result = null;
        if (login != null) {
            //保存access_token
            Map<String, Object> map = new HashMap<>();
            String access_token = UUID.randomUUID().toString();
            map.put("access_token", access_token);
            map.put("user_id", login.getId());
            HttpSession session = request.getSession();
            session.setAttribute("user_id", login.getId());
            session.setAttribute("access_token", access_token);
            result = new ResponseResult(true, 1, "响应成功", map);
        } else {
            result = new ResponseResult(true, 1, "用户名密码错误", null);
        }
        return result;
    }
    /*分配角色回显，条件用户id*/
    @RequestMapping("/findUserRoleById")
    public ResponseResult findUserRelationRoleById(Integer id)  {
        List<Role> userRelationRoleById = userService.findUserRelationRoleById(id);
        return new ResponseResult(true,200,"角色回显成功",userRelationRoleById);

    }

    /*分配角色*/
    @RequestMapping("/userContextRole")
    public ResponseResult userContextRole(@RequestBody UserVo userVo){
        userService.userContextRole(userVo);
        return new ResponseResult(true,200,"分配角色成功",null);
    }

}
