package com.example.lune.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.lune.domain.Album;
import com.example.lune.service.AlbumService;
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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Controller
@RestController
public class AlbumController {

    @Autowired
    AlbumService albumService;

    //添加专辑
    @RequestMapping(value = "/album/addAlbum/",method = RequestMethod.POST)
    @ResponseBody
    public Object addAlbum(HttpServletRequest request, @Param("albumPic")MultipartFile albumPic){
        JSONObject jsonObject = new JSONObject();
        String albumName = request.getParameter("albumName");
        String albumReleaseTime = request.getParameter("albumReleaseTime");
        String albumRecordLabel = request.getParameter("albumRecordLabel");

        //格式化日期
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date releaseTime = new Date();
        try {
            releaseTime = dateFormat.parse(albumReleaseTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //处理图片
        //存储图片的文件夹，如果不存在就新建
        String path = System.getProperty("user.dir")+System.getProperty("file.separator")+"image"+System.getProperty("file.separator")+"albumPic";
        File file = new File(path);
        if (!file.exists())  file.mkdir();

        //图片名称
        String picName = UUID.randomUUID() + albumPic.getOriginalFilename();
        //存储全路径
        File dist = new File(path + System.getProperty("file.separator"));

        Album album = new Album();
        album.setAlbumName(albumName);
        album.setAlbumRecordLabel(albumRecordLabel);
        album.setAlbumRelaseTime(releaseTime);

        try {
            albumPic.transferTo(dist);
            album.setAlbumPic("/image/albumPic/"+picName);
        } catch (IOException e) {
            jsonObject.put("code",0);
            jsonObject.put("msg",e.getMessage());
            e.printStackTrace();
            return jsonObject;
        }

        Boolean flag = albumService.insertSelective(album);

        if (flag){
            jsonObject.put("code",1);
            jsonObject.put("msg","上传专辑成功");
        }else {
            jsonObject.put("code",0);
            jsonObject.put("msg","上传专辑失败");
        }

        return jsonObject;
    }
    //更新专辑
    @RequestMapping(value = "/album/updateAlbum/",method = RequestMethod.POST)
    @ResponseBody
    public Object updateAlbum(HttpServletRequest request, @Param("albumPic")MultipartFile albumPic){
        JSONObject jsonObject = new JSONObject();
        Integer albumId = Integer.parseInt(request.getParameter("albumId"));
        String albumName = request.getParameter("albumName");
        String albumReleaseTime = request.getParameter("albumReleaseTime");
        String albumRecordLabel = request.getParameter("albumRecordLabel");

        //格式化日期
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date releaseTime = new Date();
        try {
            releaseTime = dateFormat.parse(albumReleaseTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //处理图片
        //存储图片的文件夹，如果不存在就新建
        String path = System.getProperty("user.dir")+System.getProperty("file.separator")+"image"+System.getProperty("file.separator")+"albumPic";
        File file = new File(path);
        if (!file.exists())  file.mkdir();

        //图片名称
        String picName = UUID.randomUUID() + albumPic.getOriginalFilename();
        //存储全路径
        File dist = new File(path + System.getProperty("file.separator"));

        Album album = new Album();
        album.setAlbumName(albumName);
        album.setAlbumRecordLabel(albumRecordLabel);
        album.setAlbumRelaseTime(releaseTime);

        try {
            albumPic.transferTo(dist);
            album.setAlbumPic("/image/albumPic/"+picName);
        } catch (IOException e) {
            jsonObject.put("code",0);
            jsonObject.put("msg",e.getMessage());
            e.printStackTrace();
            return jsonObject;
        }

        Boolean flag = albumService.update(album);

        if (flag){
            jsonObject.put("code",1);
            jsonObject.put("msg","更新专辑成功");
        }else {
            jsonObject.put("code",0);
            jsonObject.put("msg","更新专辑失败");
        }

        return jsonObject;
    }
    //根据 id 删除 album
    @RequestMapping(value = "/album/delete/",method = RequestMethod.GET)
    public Object delete(HttpServletRequest request){
        Integer albumId = Integer.parseInt(request.getParameter("albumId"));
        return albumService.deleteById(albumId);
    }
    //根据 id 查找 album
    @RequestMapping(value = "/album/albumOfId/",method = RequestMethod.GET)
    public Object albumOfId(HttpServletRequest request){
        Integer albumId = Integer.parseInt(request.getParameter("albumId"));
        return albumService.albumOfId(albumId);
    }
    //根据 name 查找 album
    @RequestMapping(value = "/album/albumOfName/",method = RequestMethod.GET)
    public Object albumOfName(HttpServletRequest request){
        String albumName = request.getParameter("albumName");
        return albumService.albumOfName(albumName);
    }
    //根据 label 查找 album
    @RequestMapping(value = "/album/albumOfLabel/",method = RequestMethod.GET)
    public Object albumOfLabel(HttpServletRequest request){
        String albumLabel = request.getParameter("albumLabel");
        return albumService.albumOfName(albumLabel);
    }
    //返回所有的 album
    @RequestMapping(value = "/album/allAlbum",method = RequestMethod.GET)
    public Object allAlbum(){
        return albumService.allAlbum();
    }
}
