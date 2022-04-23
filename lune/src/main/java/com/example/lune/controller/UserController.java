package com.example.lune.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.lune.domain.User;
import com.example.lune.service.UserService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;


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


}
