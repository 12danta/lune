package com.example.lune.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.lune.config.EncryptUtil;
import com.example.lune.domain.User;
import com.example.lune.service.UserService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;


@RestController
@Controller
public class UserController {

    @Autowired
    UserService userService;


    // 用户注册
    @RequestMapping(value = "/user/signUp",method = RequestMethod.POST)
    @ResponseBody
    public Object insertUser(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();

        String userName = request.getParameter("userName");
        String userPassword = request.getParameter("userPassword");
        String userEmail = request.getParameter("userEmail");
        Integer userAuthority = Integer.parseInt(request.getParameter("userAuthority"));

        String userAvatar = "/image/avatar/default.jpg";


        userPassword = EncryptUtil.generator(userPassword);

        User user = new User();
        user.setUserName(userName);
        user.setUserPassword(userPassword);
        user.setUserAvatar(userAvatar);
        user.setUserEmail(userEmail);
        user.setUserAuthority(userAuthority);
        user.setUserRegistrationTime(new Date());

        Boolean flag = userService.insert(user);
        System.out.println(flag);

        try {
            if (flag) {
                jsonObject.put("code", 1);
                jsonObject.put("msg", "注册成功");
            } else {
                jsonObject.put("code", 0);
                jsonObject.put("msg", "注册失败");
            }
            return jsonObject;
        }catch (DuplicateKeyException e){
            jsonObject.put("code",0);
            jsonObject.put("msg","注册失败");
            return jsonObject;
        }

    }
    // 更新用户信息
    @RequestMapping(value = "/user/update",method = RequestMethod.POST)
    @ResponseBody
    public Object updateUser(HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject();

        Integer userId = Integer.parseInt(request.getParameter("userId"));
        String userName = request.getParameter("userName");
        String userPassword = request.getParameter("userPassword");
        String userEmail = request.getParameter("userEmail");
        Integer userAuthority = Integer.parseInt(request.getParameter("userAuthority"));


        User user = new User();
        user.setUserId(userId);
        user.setUserName(userName);
        user.setUserPassword(userPassword);
        user.setUserEmail(userEmail);
        user.setUserAuthority(userAuthority);

        Boolean flag = userService.update(user);
        System.out.println(flag);

        try {
            if (flag) {
                jsonObject.put("code", 1);
                jsonObject.put("msg", "更新成功");
            } else {
                jsonObject.put("code", 0);
                jsonObject.put("msg", "更新失败");
            }
            return jsonObject;
        } catch (DuplicateKeyException e) {
            jsonObject.put("code", 0);
            jsonObject.put("msg", "更新失败");
            return jsonObject;
        }
    }

        //根据 id 删除用户

        @RequestMapping(value = "/user/deleteById",method = RequestMethod.GET)
        public Object deleteUser (HttpServletRequest request){

            JSONObject jsonObject = new JSONObject();
            Integer id = Integer.parseInt(request.getParameter("userId"));
            Boolean flag = userService.deleteById(id);
//
//            if (flag){
//                jsonObject.put("code",1);
//                jsonObject.put("msg","删除成功");
//            }else {
//                jsonObject.put("code",0);
//                jsonObject.put("msg","删除失败");
//            }
            return flag;
        }
     //根据 id 获取用户
    @RequestMapping(value = "/user/userOfId",method = RequestMethod.GET)
    public Object FindUserById(HttpServletRequest request){
        Integer userId = Integer.parseInt(request.getParameter("userId"));
        return userService.FindUserById(userId);
    }
    //用户登录
    @ResponseBody
    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
    public Object UserLogin(HttpServletRequest request, HttpSession session){

        JSONObject jsonObject = new JSONObject();

        String userName = request.getParameter("userName");
        String userPassword = request.getParameter("userPassword");

        String md5psw = userService.verifyPassword(userName);

        Boolean flag = EncryptUtil.verify(userPassword,md5psw);
        if (flag) {
            jsonObject.put("code",1);
            jsonObject.put("msg","登陆成功");
            session.setAttribute("userName",userName);
        }else {
            jsonObject.put("code",0);
            jsonObject.put("msg","登陆失败");
        }
        return jsonObject;

    }
    //更换头像
    @ResponseBody
    @RequestMapping(value = "/user/updateAvatar",method = RequestMethod.POST)
    public Object updateAvatar(@RequestParam("userId") Integer userId, @RequestParam("avatarFile")MultipartFile avatarFile){

        JSONObject jsonObject = new JSONObject();



        //头像图片的存放位置 C:\lune\image\avatar
        String avatarPath = System.getProperty("user.dir")+System.getProperty("file.separator")+"image"+System.getProperty("file.separator")+"avatar";
        System.out.println(avatarPath);
        //如果这个文件夹是空的那么久建立这个文件夹
        File file = new File(avatarPath);
        if (!file.exists()) file.mkdir();


        //头像名称
        String avatarName = UUID.randomUUID().toString() + avatarFile.getOriginalFilename();

        //把头像存储下来,创建一个用于存储的全路径file
        File fileDest = new File(avatarPath+System.getProperty("file.separator")+avatarName);

        try {
            avatarFile.transferTo(fileDest);
            User user = new User();
            user.setUserId(userId);
            user.setUserAvatar("/image/avatar/"+avatarName);
            Boolean flag = userService.updateAvatar(user);
            if (flag){
                jsonObject.put("code",1);
                jsonObject.put("msg","更新头像成功");
            }else {
                jsonObject.put("code",0);
                jsonObject.put("msg","更新头像失败");
            }
        } catch (IOException e) {
            jsonObject.put("code",0);
            jsonObject.put("msg",e.getMessage());
            e.printStackTrace();
        }


        return jsonObject;
    }
    //修改密码
    @ResponseBody
    @RequestMapping(value = "/user/changePsw",method = RequestMethod.POST)
    public Object changePsw(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();

        User user = new User();
        user.setUserId(Integer.parseInt(request.getParameter("userId")));
        String userPassword = EncryptUtil.generator(request.getParameter("userPassword"));
        user.setUserPassword(userPassword);
        Boolean flag = userService.updatePassword(user);

        if (flag){
            jsonObject.put("code",1);
            jsonObject.put("msg","更新密码成功");
        }else {
            jsonObject.put("code",0);
            jsonObject.put("msg","更新密码失败");
        }
        return jsonObject;
    }


}
