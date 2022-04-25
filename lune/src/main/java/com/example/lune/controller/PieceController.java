package com.example.lune.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.lune.service.PieceService;
import com.fasterxml.jackson.annotation.JsonAlias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@Controller
@RestController
public class PieceController {

    @Autowired
    PieceService pieceService;

    //上传作品
    @ResponseBody
    @RequestMapping(value = "/piece/uploud/",method = RequestMethod.POST)
    public Object uploadPiece(HttpServletRequest request, @RequestParam("pieceAudio")MultipartFile audioFile,
                                                          @RequestParam("pieceVideo") MultipartFile pieceVideo,
                                                          @RequestParam("piecePic") MultipartFile piecePic){

        JSONObject jsonObject = new JSONObject();

        String pieceName = request.getParameter("pieceName").trim();


        return jsonObject;
    }
    //修改曲子
    //根据 id 返回作品
    //根据 id 删除曲子
    //返回所有 piece
}
