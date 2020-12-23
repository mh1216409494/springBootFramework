package com.ccb.service;

import com.ccb.bean.Role;
import com.ccb.bean.UserInfo;

import java.util.List;

public interface UserInfoService {
    public List<UserInfo> findName(String userName);

    /**
     * @Author maHuan
     * @Description 查询用户表所有信息
     * @Date 2020/12/12 20:24
     * @Patam [userId]
     * @return void
     **/
    public UserInfo findById(int userId);

    /**
     * @Author maHuan
     * @Description 查询用户表所有信息
     * @Date 2020/12/12 22:40
     * @Patam []
     * @return com.ccb.bean.UserInfo
     **/
    public UserInfo findNameById(String userName);

    /**
     * @Author maHuan
     * @Description 多对多查询
     * @Date 2020/12/13 18:05
     * @Patam [userId]
     * @return java.util.List<com.ccb.bean.UserInfo>
     **/
    public List<UserInfo> findUsers(int roleId);

    /**
     * @Author maHuan
     * @Description 查询roleId
     * @Date 2020/12/13 21:23
     * @Patam [userId]
     * @return com.ccb.bean.Role
     **/
    /*public Role findRoelById(int userId);*/



}
