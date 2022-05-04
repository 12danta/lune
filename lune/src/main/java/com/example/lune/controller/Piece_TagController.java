package com.example.lune.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.lune.domain.Piece_Tag;
import com.example.lune.service.Piece_TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Controller
@RestController
public class Piece_TagController {

    @Autowired
    Piece_TagService piece_tagService;

    //给歌曲添加 tag
    @RequestMapping(value = "/pieceTag/addPieceTag/",method = RequestMethod.POST)
    @ResponseBody
    public Object addPieceTag(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();

        Integer tagId = Integer.parseInt(request.getParameter("tagId"));
        Integer pieceId = Integer.parseInt(request.getParameter("pieceId"));

        Boolean flag = piece_tagService.insert(tagId,pieceId);

        if (flag){
            jsonObject.put("code",1);
            jsonObject.put("msg","添加成功");
        }else {
            jsonObject.put("code",0);
            jsonObject.put("msg","添加失败");
        }
        return jsonObject;
    }
    //更新 piece_tag
    @RequestMapping(value = "/pieceTag/updatePieceTag/",method = RequestMethod.POST)
    @ResponseBody
    public Object updatePieceTag(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();

        Integer id = Integer.parseInt(request.getParameter("id"));
        Integer tagId = Integer.parseInt(request.getParameter("tagId"));
        Integer pieceId = Integer.parseInt(request.getParameter("pieceId"));

        Piece_Tag piece_tag = new Piece_Tag();
        piece_tag.setId(id);
        piece_tag.setPieceId(pieceId);
        piece_tag.setTagId(tagId);
        Boolean flag = piece_tagService.update(piece_tag);

        if (flag){
            jsonObject.put("code",1);
            jsonObject.put("msg","更新成功");
        }else {
            jsonObject.put("code",0);
            jsonObject.put("msg","更新失败");
        }
        return jsonObject;
    }
    //根据 id 删除 piece_Tag 关联
    @RequestMapping(value = "/pieceTag/delete/",method = RequestMethod.GET)
    public Object delete(HttpServletRequest request){
        Integer id = Integer.parseInt(request.getParameter("id"));
        return piece_tagService.deleteById(id);
    }
    //根据 pieceId 获取 piece_tag
    @RequestMapping(value = "/pieceTag/pieceTagOfPiece/",method = RequestMethod.GET)
    public Object pieceTagOfPiece(HttpServletRequest request){
        Integer pieceId = Integer.parseInt(request.getParameter("pieceId"));
        return piece_tagService.piece_TagOfPiece(pieceId);
    }
    //根据 tagId 获取 pieceId
    @RequestMapping(value = "/pieceTag/PieceTagOfTag/",method = RequestMethod.GET)
    public Object pieceTagOfTag(HttpServletRequest request){
        Integer tagId = Integer.parseInt(request.getParameter("tagId"));
        return piece_tagService.piece_TagOfTag(tagId);
    }

}
