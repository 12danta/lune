package com.example.lune.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.lune.domain.Composer;
import com.example.lune.service.ComposerService;
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

@Controller
@RestController
public class ComposerController {

    @Autowired
    ComposerService composerService;

    //添加 composer
    @RequestMapping(value = "/composer/addComposer",method = RequestMethod.POST)
    @ResponseBody
    public Object addComposer(HttpServletRequest request, @Param("composerPic")MultipartFile composerPic){

        JSONObject jsonObject = new JSONObject();

        String composerName = request.getParameter("composerName");
        String composerIntroduction = request.getParameter("composerIntroduction");
        String composerLifeAndDeath = request.getParameter("composerLifeAndDeath");
        String composerPeriod = request.getParameter("composerPeriod");

        //存储图片的路径不能为空，为空则新建文件夹
        String filePath = System.getProperty("user.dir")+System.getProperty("file.separator")+"image"+System.getProperty("file.separator")+"composerPic";
        File file = new File(filePath);
        if (!file.exists())  file.mkdir();


        //图片名字
        String picName = composerPic.getOriginalFilename();
        //图片路径
        String distPath = filePath + System.getProperty("file.separator") + picName;
        File dist = new File(distPath);

        Composer composer = new Composer();
        composer.setComposerName(composerName);
        composer.setComposerPeriods(composerPeriod);
        composer.setComposerIntroduction(composerIntroduction);
        composer.setComposerLifeAndDeath(composerLifeAndDeath);


        try {
            composerPic.transferTo(dist);
            composer.setComposerPic("/image/composerPic/");
        } catch (IOException e) {
            jsonObject.put("code",0);
            jsonObject.put("msg","上传图片失败");
            e.printStackTrace();
            return jsonObject;
        }

        Boolean flag = composerService.insertSelective(composer);
        if (flag){
            jsonObject.put("code",1);
            jsonObject.put("msg","添加 composer 成功");
        }else {
            jsonObject.put("code",0);
            jsonObject.put("msg","添加失败");
        }

        return jsonObject;
    }

    //修改 composer
    @RequestMapping(value = "/composer/updateComposer",method = RequestMethod.POST)
    @ResponseBody
    public Object updateComposer(HttpServletRequest request, @Param("composerPic")MultipartFile composerPic){

        JSONObject jsonObject = new JSONObject();

        Integer composerId = Integer.parseInt(request.getParameter("composerId"));
        String composerName = request.getParameter("composerName");
        String composerIntroduction = request.getParameter("composerIntroduction");
        String composerLifeAndDeath = request.getParameter("composerLifeAndDeath");
        String composerPeriod = request.getParameter("composerPeriod");

        //存储图片的路径不能为空，为空则新建文件夹
        String filePath = System.getProperty("user.dir")+System.getProperty("file.separator")+"image"+System.getProperty("file.separator")+"composerPic";
        File file = new File(filePath);
        if (!file.exists())  file.mkdir();


        //图片名字
        String picName = composerPic.getOriginalFilename();
        //图片路径
        String distPath = filePath + System.getProperty("file.separator") + picName;
        File dist = new File(distPath);

        Composer composer = new Composer();
        composer.setComposerId(composerId);
        composer.setComposerName(composerName);
        composer.setComposerPeriods(composerPeriod);
        composer.setComposerIntroduction(composerIntroduction);
        composer.setComposerLifeAndDeath(composerLifeAndDeath);


        try {
            composerPic.transferTo(dist);
            composer.setComposerPic("/image/composerPic/");
        } catch (IOException e) {
            jsonObject.put("code",0);
            jsonObject.put("msg","上传图片失败");
            e.printStackTrace();
            return jsonObject;
        }

        Boolean flag = composerService.update(composer);
        if (flag){
            jsonObject.put("code",1);
            jsonObject.put("msg","修改 composer 成功");
        }else {
            jsonObject.put("code",0);
            jsonObject.put("msg","修改失败");
        }

        return jsonObject;
    }

    //根据 id 删除 composer
    @RequestMapping(value = "/composer/delete",method = RequestMethod.GET)
    public Object deleteComposer(HttpServletRequest request){
        return composerService.deleteById(Integer.parseInt(request.getParameter("composerId")));
    }

    //所有的 composer
    @RequestMapping(value = "/composer/allComposer",method = RequestMethod.GET)
    public Object allComposer(){
        return composerService.allComposer();
    }

    //根据 period 返回 composer
    @RequestMapping(value = "/composer/composerOfPeriod")
    public Object composerOfPeriod(HttpServletRequest request){
        return composerService.composerOfPeriod(request.getParameter("composerPeriod"));
    }

    //根据 id 返回 composer
    @RequestMapping(value = "/composer/composerOfId")
    public Object composerOfId(HttpServletRequest request){
        return composerService.composerOfId(Integer.parseInt(request.getParameter("composerId")));
    }

    //根据 name 返回 composer
    @RequestMapping(value = "/composer/composerOfName")
    public Object composerOfName(HttpServletRequest request){
        return composerService.composerOfName(request.getParameter("composerName"));
    }


}
