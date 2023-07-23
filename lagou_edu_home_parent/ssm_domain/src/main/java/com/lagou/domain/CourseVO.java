package com.lagou.domain;

public class CourseVO {
//    (View Object表现层对象：主要用于表现层来接收参数的)
    private Integer  id;
    /**
     * 课程名称
     * */
    private String courseName;
    /**
     * 课程状态
     * */
    private Integer status;

    @Override
    public String toString() {
        return "CourseVO{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", status=" + status +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
