package com.example.lune.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.lune.domain.Piece;
import com.example.lune.service.PieceService;
import com.fasterxml.jackson.annotation.JsonAlias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.MultipartConfigElement;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RestController
public class PieceController {

    @Autowired
    PieceService pieceService;

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //文件最大10M,DataUnit提供5中类型B,KB,MB,GB,TB
        factory.setMaxFileSize(DataSize.of(500, DataUnit.MEGABYTES));
        /// 设置总上传数据总大小10M
        factory.setMaxRequestSize(DataSize.of(500, DataUnit.MEGABYTES));
        return factory.createMultipartConfig();
    }


    //上传作品
    @ResponseBody
    @RequestMapping(value = "/piece/upload/",method = RequestMethod.POST)
    public Object uploadPiece(HttpServletRequest request, @RequestParam("pieceAudio")MultipartFile pieceAudio,
                                                          @RequestParam("pieceVideo") MultipartFile pieceVideo,
                                                          @RequestParam("piecePic") MultipartFile piecePic){

        JSONObject jsonObject = new JSONObject();

        String pieceName = request.getParameter("pieceName").trim();
//处理图片

        //存放图片的位置,如果不存在该文件夹就新建一个
         String piecePicPath = System.getProperty("user.dir")+System.getProperty("file.separator")+"image"+System.getProperty("file.separator")+"piecePic";
        File picFile = new File(piecePicPath);
         if (!picFile.exists()) picFile.mkdir();

         //歌曲图片的名称
        String picName = UUID.randomUUID().toString() + piecePic.getOriginalFilename();

        //存储图片的全路径
        File picDist = new File(piecePicPath+System.getProperty("file.separator")+picName);


//处理音频
        //存放音频，如果不存在该文件夹就新建一个
        String pieceAudioPath = System.getProperty("user.dir")+System.getProperty("file.separator")+"piece"+System.getProperty("file.separator")+"audio";
        File audioFile = new File(pieceAudioPath);
        if (!audioFile.exists()) audioFile.mkdir();

        //歌曲音频名称
        String audioName = UUID.randomUUID().toString() + pieceAudio.getOriginalFilename();

        //存储音频的全路径
        File audioDist = new File(pieceAudioPath+System.getProperty("file.separator")+audioName);

//处理视频
        //存放视频，如果不存在该文件夹就新建一个
        String pieceVideoPath = System.getProperty("user.dir")+System.getProperty("file.separator")+"piece"+System.getProperty("file.separator")+"video";
        File videoFile = new File(pieceVideoPath);
        if (!videoFile.exists()) videoFile.mkdir();

        //歌曲视频的名称
        String videoName = UUID.randomUUID().toString() + pieceVideo.getOriginalFilename();

        //存储视频的全路径
        File videoDist = new File(pieceVideoPath+System.getProperty("file.separator")+videoName);

        //存储图像
        Piece piece = new Piece();
        piece.setPieceName(pieceName);
        try {
            piecePic.transferTo(picDist);
            piece.setPiecePic("/image/piecePic/"+picName);
        } catch (IOException e) {
            jsonObject.put("code",0);
            jsonObject.put("msg",e.getMessage());
            return jsonObject;
        }
        //存储音频
        try {
            pieceAudio.transferTo(audioDist);
            piece.setPieceAudio("/piece/audio/"+audioName);
        } catch (IOException e) {
            jsonObject.put("code",0);
            jsonObject.put("msg",e.getMessage());
            return jsonObject;
        }
        //存储视频
        try {
            pieceVideo.transferTo(videoDist);
            piece.setPieceVideo("/piece/video/"+videoName);
        } catch (IOException e) {
            jsonObject.put("code",0);
            jsonObject.put("msg",e.getMessage());
            return jsonObject;
        }

        Boolean flag = pieceService.insertSelective(piece);
        if (flag){
            jsonObject.put("code",1);
            jsonObject.put("msg","上传歌曲成功");
        }else {
            jsonObject.put("code",0);
            jsonObject.put("msg","上传歌曲失败");
        }

        return jsonObject;
    }
    //修改曲子
    @ResponseBody
    @RequestMapping(value = "/piece/update/",method = RequestMethod.POST)
    public Object updatePiece(HttpServletRequest request, @RequestParam("pieceAudio")MultipartFile pieceAudio,
                              @RequestParam("pieceVideo") MultipartFile pieceVideo,
                              @RequestParam("piecePic") MultipartFile piecePic){

        JSONObject jsonObject = new JSONObject();

        Integer pieceId = Integer.parseInt(request.getParameter("pieceId").trim());
        String pieceName = request.getParameter("pieceName").trim();
//处理图片

        //存放图片的位置,如果不存在该文件夹就新建一个
        String piecePicPath = System.getProperty("user.dir")+System.getProperty("file.separator")+"image"+System.getProperty("file.separator")+"piecePic";
        File picFile = new File(piecePicPath);
        if (!picFile.exists()) picFile.mkdir();

        //歌曲图片的名称
        String picName = UUID.randomUUID().toString() + piecePic.getOriginalFilename();

        //存储图片的全路径
        File picDist = new File(piecePicPath+System.getProperty("file.separator")+picName);


//处理音频
        //存放音频，如果不存在该文件夹就新建一个
        String pieceAudioPath = System.getProperty("user.dir")+System.getProperty("file.separator")+"piece"+System.getProperty("file.separator")+"audio";
        File audioFile = new File(pieceAudioPath);
        if (!audioFile.exists()) audioFile.mkdir();

        //歌曲音频名称
        String audioName = UUID.randomUUID().toString() + pieceAudio.getOriginalFilename();

        //存储音频的全路径
        File audioDist = new File(pieceAudioPath+System.getProperty("file.separator")+audioName);

//处理视频
        //存放视频，如果不存在该文件夹就新建一个
        String pieceVideoPath = System.getProperty("user.dir")+System.getProperty("file.separator")+"piece"+System.getProperty("file.separator")+"video";
        File videoFile = new File(pieceVideoPath);
        if (!videoFile.exists()) videoFile.mkdir();

        //歌曲视频的名称
        String videoName = UUID.randomUUID().toString() + pieceVideo.getOriginalFilename();

        //存储视频的全路径
        File videoDist = new File(pieceVideoPath+System.getProperty("file.separator")+videoName);

        //存储图像
        Piece piece = new Piece();
        piece.setPieceId(pieceId);
        piece.setPieceName(pieceName);
        try {
            piecePic.transferTo(picDist);
            piece.setPiecePic("/image/piecePic/"+picName);
        } catch (IOException e) {
            jsonObject.put("code",0);
            jsonObject.put("msg",e.getMessage());
            return jsonObject;
        }
        //存储音频
        try {
            pieceAudio.transferTo(audioDist);
            piece.setPieceAudio("/piece/audio/"+audioName);
        } catch (IOException e) {
            jsonObject.put("code",0);
            jsonObject.put("msg",e.getMessage());
            return jsonObject;
        }
        //存储视频
        try {
            pieceVideo.transferTo(videoDist);
            piece.setPieceVideo("/piece/video/"+videoName);
        } catch (IOException e) {
            jsonObject.put("code",0);
            jsonObject.put("msg",e.getMessage());
            return jsonObject;
        }

        System.out.println(pieceName);
        System.out.println(audioName);
        System.out.println(videoName);
        Boolean flag = pieceService.update(piece);
        if (flag){
            jsonObject.put("code",1);
            jsonObject.put("msg","更新歌曲成功");
        }else {
            jsonObject.put("code",0);
            jsonObject.put("msg","更新歌曲失败");
        }

        return jsonObject;
    }
    //根据 id 返回作品
    //根据 id 删除曲子
    //返回所有 piece
}
