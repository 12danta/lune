package com.example.lune.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.lune.domain.PieceList_Piece;
import com.example.lune.service.PieceList_PieceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Controller
@RestController
public class PieceList_PieceController {

    @Autowired
    PieceList_PieceService pieceList_pieceService;

    //向曲目表添加 piece
    @ResponseBody
    @RequestMapping(value = "/ListPiece/addListPiece",method = RequestMethod.POST)
    public Object addListPiece(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();

        Integer pieceListId = Integer.parseInt(request.getParameter("pieceListId"));
        Integer pieceId = Integer.parseInt(request.getParameter("pieceId"));

        Boolean flag = pieceList_pieceService.insert(pieceListId,pieceId);
        if (flag){
            jsonObject.put("code",1);
            jsonObject.put("msg","添加成功");
        }else {
            jsonObject.put("code",0);
            jsonObject.put("msg","添加失败");
        }
        return jsonObject;
    }
    //修改 pieceList_piece
    @ResponseBody
    @RequestMapping(value = "/ListPiece/updateListPiece",method = RequestMethod.POST)
    public Object updateListPiece(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();

        Integer id = Integer.parseInt(request.getParameter("id"));
        Integer pieceListId = Integer.parseInt(request.getParameter("pieceListId"));
        Integer pieceId = Integer.parseInt(request.getParameter("pieceId"));

        PieceList_Piece pieceList_piece = new PieceList_Piece();
        pieceList_piece.setId(id);
        pieceList_piece.setPieceId(pieceId);
        pieceList_piece.setPieceListId(pieceListId);

        Boolean flag = pieceList_pieceService.update(pieceList_piece);
        if (flag){
            jsonObject.put("code",1);
            jsonObject.put("msg","更新成功");
        }else {
            jsonObject.put("code",0);
            jsonObject.put("msg","更新失败");
        }
        return jsonObject;
    }
    //根据 id 删除 pieceList_piece
    @RequestMapping(value = "/ListPiece/delete",method = RequestMethod.GET)
    public Object delete(HttpServletRequest request){
        Integer id = Integer.parseInt(request.getParameter("id"));
        return pieceList_pieceService.delete(id);
    }
    //根据 id 返回 pieceList_piece
    @RequestMapping(value = "/ListPiece/ListPieceOfId",method = RequestMethod.GET)
    public Object ListPieceOfId(HttpServletRequest request){
        Integer id = Integer.parseInt(request.getParameter("id"));
        return pieceList_pieceService.pieceList_PieceOfId(id);
    }

    //根据 PieceList 返回 pieceList_piece
    @RequestMapping(value = "/ListPiece/ListPieceOfList",method = RequestMethod.GET)
    public Object ListPieceOfList(HttpServletRequest request){
        Integer pieceListId = Integer.parseInt(request.getParameter("pieceListId"));
        return pieceList_pieceService.pieceList_PieceOfPieceList(pieceListId);
    }

}
