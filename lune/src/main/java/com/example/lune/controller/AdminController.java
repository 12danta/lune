package com.example.lune.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.lune.service.AdminService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@Controller
public class AdminController {

    @Autowired
    AdminService adminService;

    @RequestMapping(value = "/admin/login",method = RequestMethod.POST)
    @ResponseBody
    public Object hello(HttpServletRequest request, HttpSession session){

        JSONObject jsonObject = new JSONObject();

        String adminName = request.getParameter("adminName");
        String adminPassword = request.getParameter("adminPassword");
        Boolean flag = adminService.verifyPassword(adminName,adminPassword);

        if (flag){
            jsonObject.put("code",1);
            jsonObject.put("msg","登陆成功");
            session.setAttribute("adminName",adminName);
            return jsonObject;
        }else {
            jsonObject.put("code",0);
            jsonObject.put("msg","登陆失败");
            return jsonObject;
        }

    }

}
