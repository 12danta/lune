package com.example.lune.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.lune.domain.Performer;
import com.example.lune.service.PerformerService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RestController
public class PerformerController {

    @Autowired
    PerformerService performerService;

    //添加 performer
    @RequestMapping(value = "/performer/add/",method = RequestMethod.POST)
    @ResponseBody
    public Object addPerformer(HttpServletRequest request, @Param("performerPic")MultipartFile performerPic){
        JSONObject jsonObject = new JSONObject();

        String performerName = request.getParameter("performerName").trim();
        String performerIntroduction = request.getParameter("performerIntroduction");
        String performerType = request.getParameter("performerType").trim();

        //照片
        //存放演奏者照片的位置，如果没有，就新建一个文件夹
        String performerPicPath = System.getProperty("user.dir")+System.getProperty("file.separator")+"image"+System.getProperty("file.separator")+"performerPic";
        File picFile = new File(performerPicPath);
        if (!picFile.exists()) picFile.mkdir();

        //照片名称
        String picName = UUID.randomUUID()+performerPic.getOriginalFilename();
        //路径
        File picDist = new File(performerPicPath + System.getProperty("file.separator")+picName);

        Performer performer = new Performer();
        performer.setPerformerName(performerName);
        performer.setPerformerType(performerType);
        performer.setPerformerIntroduce(performerIntroduction);

        try {
            performerPic.transferTo(picDist);
            performer.setPerformerPic("/image/performerPic/"+picName);
        } catch (IOException e) {
            jsonObject.put("code",0);
            jsonObject.put("msg",e.getMessage());
            e.printStackTrace();
            return jsonObject;
        }

        Boolean flag = performerService.insertSelective(performer);
        if (flag){
            jsonObject.put("code",1);
            jsonObject.put("msg","添加成功");
        }else {
            jsonObject.put("code",0);
            jsonObject.put("msg","添加失败");
        }
        return jsonObject;
    }
    //更新 performer
    @RequestMapping(value = "/performer/update/",method = RequestMethod.POST)
    @ResponseBody
    public Object updatePerformer(HttpServletRequest request, @Param("performerPic")MultipartFile performerPic){
        JSONObject jsonObject = new JSONObject();

        Integer performerId = Integer.parseInt(request.getParameter("performerId"));
        String performerName = request.getParameter("performerName").trim();
        String performerIntroduction = request.getParameter("performerIntroduction");
        String performerType = request.getParameter("performerType").trim();

        //照片
        //存放演奏者照片的位置，如果没有，就新建一个文件夹
        String performerPicPath = System.getProperty("user.dir")+System.getProperty("file.separator")+"image"+System.getProperty("file.separator")+"performerPic";
        File picFile = new File(performerPicPath);
        if (!picFile.exists()) picFile.mkdir();

        //照片名称
        String picName = UUID.randomUUID()+performerPic.getOriginalFilename();
        //路径
        File picDist = new File(performerPicPath + System.getProperty("file.separator")+picName);

        Performer performer = new Performer();
        performer.setPerformerId(performerId);
        performer.setPerformerName(performerName);
        performer.setPerformerType(performerType);
        performer.setPerformerIntroduce(performerIntroduction);

        try {
            performerPic.transferTo(picDist);
            performer.setPerformerPic("/image/performerPic/"+picName);
        } catch (IOException e) {
            jsonObject.put("code",0);
            jsonObject.put("msg",e.getMessage());
            e.printStackTrace();
            return jsonObject;
        }

        Boolean flag = performerService.update(performer);
        if (flag){
            jsonObject.put("code",1);
            jsonObject.put("msg","更新成功");
        }else {
            jsonObject.put("code",0);
            jsonObject.put("msg","更新失败");
        }
        return jsonObject;
    }
    //根据 id 删除 performer
    @RequestMapping(value = "/performer/delete/",method = RequestMethod.GET)
    public Object delete(HttpServletRequest request){
        Integer performerId = Integer.parseInt(request.getParameter("performerId"));
        return performerService.deleteById(performerId);
    }
    //根据 id 查找 performer
    //根据 id 删除 performer
    @RequestMapping(value = "/performer/performerOfId/",method = RequestMethod.GET)
    public Object performerOfId(HttpServletRequest request){
        Integer performerId = Integer.parseInt(request.getParameter("performerId"));
        return performerService.performerOfId(performerId);
    }
    //根据类型查找 performer
    @RequestMapping(value = "/performer/performerOfType/",method = RequestMethod.GET)
    public Object performerOfType(HttpServletRequest request){
        String performerType = request.getParameter("performerType");
        return performerService.performerOfType(performerType);
    }
    //根据名字查找 performer
    @RequestMapping(value = "/performer/performerOfName/",method = RequestMethod.GET)
    public Object performerOfName(HttpServletRequest request){
        String performerName = request.getParameter("performerName");
        return performerService.performerOfName(performerName);
    }
    //所有 performer
    @RequestMapping(value = "/performer/allPerformer/",method = RequestMethod.GET)
    public Object allPerformer(){
        return performerService.allPerformer();
    }
}
