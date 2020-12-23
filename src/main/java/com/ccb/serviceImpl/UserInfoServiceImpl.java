package com.ccb.serviceImpl;

import com.ccb.bean.Role;
import com.ccb.bean.UserInfo;
import com.ccb.mapper.UserInfoDao;
import com.ccb.service.UserInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserInfoService
 * @Descridtion
 * @Author MaHuanHuan
 * @Date 2020/12/11 9:27
 **/
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;
    @Override
    public List<UserInfo> findName(String userName) {
        PageHelper.startPage(1,10);
        List<UserInfo> list=userInfoDao.findName(userName);
        PageInfo<UserInfo> pageInfo = new PageInfo<>();

        System.out.println("pageNume：------"+pageInfo.getPageNum());
        System.out.println("pagesize:-------"+pageInfo.getPageSize());
        return list;
    }

    /**
     * @Author maHuan
     * @Description 查询用户表所有信息
     * @Date 2020/12/12 20:25
     * @Patam [userId]
     * @return void
     **/
    @Override
    public UserInfo findById(int userId) {


        UserInfo user=userInfoDao.findById(userId);

        return user;
    }

    /**
     * @Author maHuan
     * @Description 查询用户表所有信息
     * @Date 2020/12/12 22:40
     * @Patam []
     * @return com.ccb.bean.UserInfo
     **/
    @Override
    public UserInfo findNameById(String userName){
        return userInfoDao.findNameById(userName);
    }

    @Override
    public List<UserInfo> findUsers(int roleId) {
        return userInfoDao.findUsers(roleId);
    }

    /*@Override
    public Role findRoelById(int userId) {
        return userInfoDao.findRoelById(userId);
    }*/
}
