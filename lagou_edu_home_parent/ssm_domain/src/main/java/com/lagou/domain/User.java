package com.lagou.domain;

import java.util.Date;

public class User {
     private Integer id;
     private String name;
     private String portrait;
     private String phone;
     private String password;
     private String regIp;
     private Integer accountNonExpired;
     private Integer accountNonLocked;
     private String status;
     private Integer isDel;
     private Date createTime;
     private Date updateTime;

     @Override
     public String toString() {
          return "User{" +
                  "id=" + id +
                  ", name='" + name + '\'' +
                  ", portrait='" + portrait + '\'' +
                  ", phone='" + phone + '\'' +
                  ", password='" + password + '\'' +
                  ", regIp='" + regIp + '\'' +
                  ", accountNonExpired=" + accountNonExpired +
                  ", accountNonLocked=" + accountNonLocked +
                  ", status='" + status + '\'' +
                  ", isDel=" + isDel +
                  ", createTime=" + createTime +
                  ", updateTime=" + updateTime +
                  '}';
     }

     public Integer getId() {
          return id;
     }

     public void setId(Integer id) {
          this.id = id;
     }

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

     public String getPortrait() {
          return portrait;
     }

     public void setPortrait(String portrait) {
          this.portrait = portrait;
     }

     public String getPhone() {
          return phone;
     }

     public void setPhone(String phone) {
          this.phone = phone;
     }

     public String getPassword() {
          return password;
     }

     public void setPassword(String password) {
          this.password = password;
     }

     public String getRegIp() {
          return regIp;
     }

     public void setRegIp(String regIp) {
          this.regIp = regIp;
     }

     public Integer getAccountNonExpired() {
          return accountNonExpired;
     }

     public void setAccountNonExpired(Integer accountNonExpired) {
          this.accountNonExpired = accountNonExpired;
     }

     public Integer getAccountNonLocked() {
          return accountNonLocked;
     }

     public void setAccountNonLocked(Integer accountNonLocked) {
          this.accountNonLocked = accountNonLocked;
     }

     public String getStatus() {
          return status;
     }

     public void setStatus(String status) {
          this.status = status;
     }

     public Integer getIsDel() {
          return isDel;
     }

     public void setIsDel(Integer isDel) {
          this.isDel = isDel;
     }

     public Date getCreateTime() {
          return createTime;
     }

     public void setCreateTime(Date createTime) {
          this.createTime = createTime;
     }

     public Date getUpdateTime() {
          return updateTime;
     }

     public void setUpdateTime(Date updateTime) {
          this.updateTime = updateTime;
     }
}
