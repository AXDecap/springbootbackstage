package com.atdecap.springbootbackstage.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * <p>
 *
 * </p>
 *
 * @author Decap
 * @since 2022-05-03
 */
@TableName("sys_user")
@ApiModel(value = "User对象", description = "")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty("id")
        @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      @ApiModelProperty("用户名")
      private String username;


      @ApiModelProperty("密码")
      private String password;

     @ApiModelProperty("昵称")
     private String nickname;

    @ApiModelProperty("邮箱")
      private String email;

      @ApiModelProperty("手机号")
      private String telephone;

      @ApiModelProperty("地址")
      private String address;

      @ApiModelProperty("创建时间")
      private Date createTime;

      @ApiModelProperty("头像")
      private String avatarUrl;

      @ApiModelProperty("信息总和")
      private String integration;

      @ApiModelProperty("角色")
      private String role;

      @TableField(exist = false)
      private List<Course> courses;

      @TableField(exist = false)
      private List<Course> stuCourses;


    public Integer getId() {
        return id;
    }

      public void setId(Integer id) {
          this.id = id;
      }

    public String getUsername() {
        return username;
    }

      public void setUsername(String username) {
          this.username = username;
      }

    public String getPassword() {
        return password;
    }

      public void setPassword(String password) {
          this.password = password;
      }

      public String getNickname(){return  nickname; }

    public void setNickname(String nickname) {this.nickname = nickname;}

    public String getEmail() {
        return email;
    }

      public void setEmail(String email) {
          this.email = email;
      }

    public String getTelephone() {
        return telephone;
    }

      public void setTelephone(String telephone) {
          this.telephone = telephone;
      }

    public String getAddress() {
        return address;
    }

      public void setAddress(String address) {
          this.address = address;
      }

    public Date getCreateTime() {
        return createTime;
    }

      public void setCreateTime(Date createTime) {
          this.createTime = createTime;
      }

    public String getAvatarUrl() {
        return avatarUrl;
    }

      public void setAvatarUrl(String avatarUrl) {
          this.avatarUrl = avatarUrl;
      }

    public String getIntegration() {
        return integration;
    }

      public void setIntegration(String integration) {
          this.integration = integration;
      }

      public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
    public List<Course> getStuCourses() {
        return stuCourses;
    }
    public void setStuCourses(List<Course> stuCourses) {
        this.stuCourses = stuCourses;
    }


    @Override
    public String toString() {
        return "User{" +
              "id=" + id +
                  ", username=" + username +
                  ", password=" + password +
                  ", nickname=" + nickname +
                  ", email=" + email +
                  ", telephone=" + telephone +
                  ", address=" + address +
                  ", createTime=" + createTime +
                  ", avatarUrl=" + avatarUrl +
                  ", integration=" + integration +
                  ", role=" + role +
              "}";
    }
}
