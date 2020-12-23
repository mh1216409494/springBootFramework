package com.ccb.controller;

import com.ccb.bean.Role;
import com.ccb.bean.UserInfo;
import com.ccb.norepeatsubmit.NoRepeatSubmit;
import com.ccb.service.UserInfoService;
import com.google.gson.*;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.*;
import java.net.URLEncoder;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ResponseBody;


import java.util.*;

import net.sf.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName UserInfoController
 * @Descridtion
 * @Author MaHuanHuan
 * @Date 2020/12/11 9:34
 **/
@Controller
@RequestMapping("/userInfo")
public class UserInfoController extends Thread {

    @Autowired
    private UserInfoService userInfoService;
    private Logger logger = LogManager.getLogger(UserInfoController.class);

    public boolean tese(){
        //trace级别的信息，单独列出来是希望你在某个方法或者程序逻辑开始的时候调用，和logger.trace("entry")基本一个意思
        logger.trace("entry");
        logger.error("Did it again!");
        logger.info("我是info信息");
        logger.debug("我是debug信息");
        logger.warn("我是warn信息");
        logger.fatal("我是fatal信息");
        //这个就是制定Level类型的调用：谁闲着没事调用这个，也不一定哦！
        logger.log(Level.DEBUG, "我是debug信息");
        //和entry()对应的结束方法，和logger.trace("exit");一个意思
        logger.trace("exit");
        return false;
    }




    @RequestMapping("/findByName")
    @ResponseBody
    public String findName(UserInfo user,Model model){
        Gson gson=new Gson();
        List<UserInfo> list = userInfoService.findName(user.getUserName());
        String str=gson.toJson(list);
        logger.trace("entry");
        logger.error("Did it again!");
        logger.info("我是info信息");
        logger.debug("我是debug信息");
        logger.warn("我是warn信息");
        logger.fatal("我是fatal信息");
        //这个就是制定Level类型的调用：谁闲着没事调用这个，也不一定哦！
        logger.log(Level.DEBUG, "我是debug信息");
        //和entry()对应的结束方法，和logger.trace("exit");一个意思
        logger.trace("exit");


        return str;
    }

    //    传字符串
    @RequestMapping("/string")
    public String test3(Model model){
        model.addAttribute("str","mahuan");
        return "index";
    }

    //    传对象
    @RequestMapping("/Object")
    public String test2(Model model){
        UserInfo user=new UserInfo();
        user.setUserId(1);
        user.setUserName("Tom");
        user.setUserPwd("123456");
        model.addAttribute("user",user);
        return "index";
    }

//    传map
    @RequestMapping("/map")
    public String test4(Model model){
        UserInfo user=new UserInfo();
        UserInfo user1=new UserInfo();
        UserInfo user2=new UserInfo();
        user.setUserName("mh");
        user1.setUserName("mh1");
        user2.setUserName("mh2");
        List<UserInfo> list=new ArrayList<>();
        list.add(user);
        list.add(user1);
        list.add(user2);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("mes","mahuan");
        map.put("user",user);
        map.put("list",list);
        model.addAttribute("map",map);
        return "html/index";
    }

    @RequestMapping("/myBatis")
    public String myBatis(UserInfo user,Model model){
        model.addAttribute("user",user);
        return "index";
    }


    @RequestMapping("/html")
    public String html(){
        System.out.println("sadfasfdasfdads");
        return "html/index";
    }

    @RequestMapping("/jsp")
    public String jsp(){

        System.out.println("123123132131231");
        return "index";
    }

    @RequestMapping("/findById")
    @ResponseBody
    public String findNameById(UserInfo userInfo){
        Gson gson=new Gson();
        UserInfo userInfo1 = userInfoService.findById(userInfo.getUserId());
        String str=gson.toJson(userInfo1);
        return str;
    }

    @RequestMapping("/findNameById")
    @ResponseBody
    public String findNameById(String userName){
        Gson gson=new Gson();
        UserInfo user=userInfoService.findNameById(userName);
        String str=gson.toJson(user);
        return str;
    }

    /**
     * @Author maHuan
     * @Description 多对多
     * @Date 2020/12/13 18:09
     * @Patam [userId]
     * @return java.lang.String
     **/
    @RequestMapping("/findUser")
    @ResponseBody
    public JSONObject findUser(int roleId) {
        JSONObject json = new JSONObject();
        List<UserInfo> userList=userInfoService.findUsers(roleId);
        json.put("user",userList);
        return json;
    }


    @RequestMapping("/findRoelById")
    @ResponseBody
    public JSONObject f(int userId){
        JSONObject json=new JSONObject();

        return json;
    }

    /**
     * 登录
     * @return
     */
    @RequestMapping("/login")
    @NoRepeatSubmit
    public String login(){
        System.out.println("1231231231313132131321313123132121");
        return "html/login";
    }

    @RequestMapping("/htmla3")
    public String htmla1(){
        return "html/a3";
    }

    @RequestMapping("/htmlToWord")
    public String htmlToWord(){
        return "html/htmlToWord";
    }

    @RequestMapping("/classpathDownload")
    public void classpathDownload(String unitid, HttpServletRequest req, HttpServletResponse res) throws IOException {

        String filePath=req.getSession().getServletContext().getRealPath("/");
        String fileSaveName=filePath.substring(filePath.lastIndexOf("/")+1);
        File file = ResourceUtils.getFile(filePath+"upload/word/word1.docx");
        FileInputStream fis=new FileInputStream(file);
        BufferedInputStream bris=new BufferedInputStream(fis);

        OutputStream fos=res.getOutputStream();

        res.setCharacterEncoding("utf-8");
        res.setContentType("application/msword");
//        res.addHeader("Content-Disposition","attachment;filename=word.docx");
        res.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode("word.docx", "UTF-8"));

        byte b[]=new byte[1024];
        int len=0;
        while((len=bris.read(b))!=-1){
            fos.write(b,0,len);
        }
    }

   @RequestMapping("/classpa")
    public void classpath(HttpServletRequest req){
        String classpaths=this.getClass().getResource("/").getPath();
        String str= req.getSession().getServletContext().getRealPath("/");
        System.out.println(classpaths);
        System.out.println(str);
    }
    }
