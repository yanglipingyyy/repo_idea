package com.lagou.controller;

import com.lagou.domain.Course;
import com.lagou.domain.CourseVO;
import com.lagou.domain.ResponseResult;
import com.lagou.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/course")
public class CourseController {
//    private static final String LOCAL_URL = "D:\project\java\ssm_code\lagou_edu_home_parent";
    @Autowired
    private CourseService courseService;

    /**
     * 查询课程信息&条件查询 接口
     */

    @RequestMapping(value="/findCourseByConditioin",method=RequestMethod.POST)
    public ResponseResult findCourseByConditioin(@RequestBody CourseVO courseVO) {
        List<Course> courseList = courseService.findCourseByConditioin(courseVO);
        ResponseResult result = new ResponseResult(true, 200, "响应成功", courseList);
        return result;
    }

    /**
     * 图片上传接口
     * */
   /* @RequestMapping("/courseUpload")
    public ResponseResult fileUpload(@RequestParam("file") MultipartFile file,
     HttpServletRequest request){

        try {
            //1.判断文件是否为空,為空直接拋出異常
            if (file.isEmpty()){
                throw new RuntimeException();
            }
            //2.获取项目部署路径
            String realPath = request.getServletContext().getRealPath("/");
            String webappsPath =
                    realPath.substring(0,realPath.indexOf("ssm_web"));
            //3.获取原文件名
            String fileName = file.getOriginalFilename();
            //4.新文件名
            String newFileName = System.currentTimeMillis() +
                    fileName.substring(fileName.lastIndexOf("."));
            //5.上传文件
            String uploadPath = webappsPath+"upload\\";
            File filePath = new File(uploadPath,newFileName);
            //如果目录不存在就创建目录
            if(!filePath.getParentFile().exists()){
                filePath.getParentFile().mkdirs();
                System.out.println("创建目录: " + filePath);
            }
            file.transferTo(filePath);
            //6.将文件名和文件路径返回
            Map<String,String> map = new HashMap<>();
            map.put("fileName",newFileName);
            map.put("filePath",LOCAL_URL+"/upload/"+newFileName);
            ResponseResult result = new ResponseResult(true,200,"响应成功",map);
            return result;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }*/

    /**
     * 保存&修改课程信息接口
     * */
    @RequestMapping("/saveOrUpdateCourse11")
    public ResponseResult saveCourseOrTeacher(@RequestBody CourseVO courseVO) {
        try {
            if (courseVO.getId() == null) {
                courseService.saveCourseOrTeacher(courseVO);
                ResponseResult result = new ResponseResult(true, 200, "响应成功", null);
                return result;
            } else {
                courseService.updateCourseOrTeacher(courseVO);
                ResponseResult result = new ResponseResult(true, 200, "响应成功", null);
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 根据id获取课程信息
     * */
    @RequestMapping("/findCourseById")
    public ResponseResult findCourseById(@RequestParam int id) {
        try {
            CourseVO courseVO = courseService.findCourseById(id);
            ResponseResult result = new ResponseResult(true,200,"响应成功",courseVO);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 保存&修改课程信息接口
     * */
    @RequestMapping("/saveOrUpdateCourse")
    public ResponseResult saveOrUpdateCourse(@RequestBody CourseVO courseVO) {
        try {
            if (courseVO.getId() == null) {
                courseService.saveCourseOrTeacher(courseVO);
                ResponseResult result = new ResponseResult(true, 200, "响应成功", null);
                return result;
            } else {
                courseService.updateCourseOrTeacher(courseVO);
                ResponseResult result = new ResponseResult(true, 200, "响应成功", null);
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 修改课程状态
     * */
    @RequestMapping("/updateCourseStatus")
    public ResponseResult updateCourseStatus(@RequestParam int id,@RequestParam
            int status){
        try {
            //执行修改操作
            courseService.updateCourseStatus(id, status);
            //保存修改后的状态,并返回
            Map<String,Integer> map = new HashMap<>();
            map.put("status",status);
            ResponseResult result = new ResponseResult(true,200,"响应成功",map);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
