package com.example.lune.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.lune.domain.PieceList;
import com.example.lune.service.PieceListService;
import com.sun.org.apache.xpath.internal.operations.Bool;
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
public class PieceListController {

    @Autowired
    PieceListService pieceListService;

    //添加 pieceList
    @ResponseBody
    @RequestMapping(value = "/pieceList/addPieceList/",method = RequestMethod.POST)
    public Object addPieceList(HttpServletRequest request, @Param("pieceListPic")MultipartFile pieceListPic){

        JSONObject jsonObject = new JSONObject();

        String pieceListName = request.getParameter("pieceListName");
        String pieceListDescription = request.getParameter("pieceListDescription");
        Integer userId = Integer.parseInt(request.getParameter("userId"));
        //存放 pieceList 的文件夹，如果不存在，则新建一个
        String path = System.getProperty("user.dir")+System.getProperty("file.separator")+"image"+System.getProperty("file.separator")+"pieceListPic";
        File file = new File(path);
        if (!file.exists()) file.mkdir();

        //歌单图片名称
        String picName = UUID.randomUUID() + pieceListPic.getOriginalFilename();

        //存放歌曲的全路径文件
        File dist = new File(path+System.getProperty("file.separator")+picName);

        PieceList pieceList = new PieceList();
        pieceList.setPieceListName(pieceListName);
        pieceList.setPieceListDescription(pieceListDescription);
        pieceList.setUserId(userId);

        try {
            pieceListPic.transferTo(dist);
            pieceList.setPieceListPic("/image/pieceListPic/"+picName);
        } catch (IOException e) {
            jsonObject.put("code",0);
            jsonObject.put("msg",e.getMessage());
            e.printStackTrace();
            return jsonObject;
        }

        Boolean flag = pieceListService.insertSelective(pieceList);
        if (flag){
            jsonObject.put("code",1);
            jsonObject.put("msg","添加歌单成功");
        }else {
            jsonObject.put("code",0);
            jsonObject.put("msg","添加歌曲失败");
        }
        return jsonObject;
    }
    //更新 pieceList
    @ResponseBody
    @RequestMapping(value = "/pieceList/updatePieceList/",method = RequestMethod.POST)
    public Object updatePieceList(HttpServletRequest request, @Param("pieceListPic")MultipartFile pieceListPic){

        JSONObject jsonObject = new JSONObject();

        Integer pieceListId = Integer.parseInt(request.getParameter("pieceListId"));
        String pieceListName = request.getParameter("pieceListName");
        String pieceListDescription = request.getParameter("pieceListDescription");
        Integer userId = Integer.parseInt(request.getParameter("userId"));
        //存放 pieceList 的文件夹，如果不存在，则新建一个
        String path = System.getProperty("user.dir")+System.getProperty("file.separator")+"image"+System.getProperty("file.separator")+"pieceListPic";
        File file = new File(path);
        if (!file.exists()) file.mkdir();

        //歌单图片名称
        String picName = UUID.randomUUID() + pieceListPic.getOriginalFilename();

        //存放歌曲的全路径文件
        File dist = new File(path+System.getProperty("file.separator")+picName);

        PieceList pieceList = new PieceList();
        pieceList.setPieceListId(pieceListId);
        pieceList.setPieceListName(pieceListName);
        pieceList.setPieceListDescription(pieceListDescription);
        pieceList.setUserId(userId);

        try {
            pieceListPic.transferTo(dist);
            pieceList.setPieceListPic("/image/pieceListPic/"+picName);
        } catch (IOException e) {
            jsonObject.put("code",0);
            jsonObject.put("msg",e.getMessage());
            e.printStackTrace();
            return jsonObject;
        }

        Boolean flag = pieceListService.update(pieceList);
        if (flag){
            jsonObject.put("code",1);
            jsonObject.put("msg","更新歌单成功");
        }else {
            jsonObject.put("code",0);
            jsonObject.put("msg","更新歌曲失败");
        }
        return jsonObject;
    }

    //更新 pieceList pic
    @ResponseBody
    @RequestMapping(value = "/pieceList/updatePic/",method = RequestMethod.POST)
    public Object updatePic( @Param("pieceListPic")MultipartFile pieceListPic,HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();

        Integer pieceListId = Integer.parseInt(request.getParameter("pieceListId"));

        //存放 pieceList 的文件夹，如果不存在，则新建一个
        String path = System.getProperty("user.dir")+System.getProperty("file.separator")+"image"+System.getProperty("file.separator")+"pieceListPic";
        File file = new File(path);
        if (!file.exists()) file.mkdir();

        //歌单图片名称
        String picName = UUID.randomUUID() + pieceListPic.getOriginalFilename();

        //存放歌曲的全路径文件
        File dist = new File(path+System.getProperty("file.separator")+picName);

        PieceList pieceList = new PieceList();
        pieceList.setPieceListId(pieceListId);


        try {
            pieceListPic.transferTo(dist);
            pieceList.setPieceListPic("/image/pieceListPic/"+picName);
        } catch (IOException e) {
            jsonObject.put("code",0);
            jsonObject.put("msg",e.getMessage());
            e.printStackTrace();
            return jsonObject;
        }

        Boolean flag = pieceListService.update(pieceList);
        if (flag){
            jsonObject.put("code",1);
            jsonObject.put("msg","更新列表照片成功");
        }else {
            jsonObject.put("code",0);
            jsonObject.put("msg","更新列表照片失败");
        }
        return jsonObject;
    }

    //根据 id 删除 pieceList
    @RequestMapping(value = "/pieceList/delete/",method = RequestMethod.GET)
    public Object delete(HttpServletRequest request){
        Integer pieceListId = Integer.parseInt(request.getParameter("pieceListId"));
        return pieceListService.deleteById(pieceListId);
    }

    //根据 id 返回 pieceList
    @RequestMapping(value = "/pieceList/pieceListOfId/",method = RequestMethod.GET)
    public Object pieceListOfId(HttpServletRequest request){
        Integer pieceListId = Integer.parseInt(request.getParameter("pieceListId"));
        return pieceListService.pieceListOfId(pieceListId);
    }

    //根据名字返回 pieceList
    @RequestMapping(value = "/pieceList/pieceListOfName/",method = RequestMethod.GET)
    public Object pieceListOfName(HttpServletRequest request){
        String pieceListName = request.getParameter("pieceListName");
        return pieceListService.pieceListOfName(pieceListName);
    }

    //根据 用户 id 返回 pieceList
    @RequestMapping(value = "/pieceList/pieceListOfUserId/",method = RequestMethod.GET)
    public Object pieceListOfUserId(HttpServletRequest request){
        Integer userId = Integer.parseInt(request.getParameter("userId"));
        return pieceListService.pieceListOfUser(userId);
    }
    //返回所有的 pieceList
    @RequestMapping(value = "/pieceList/allPieceList",method = RequestMethod.GET)
    public Object allPieceList(){
        return pieceListService.allPieceList();
    }
}
