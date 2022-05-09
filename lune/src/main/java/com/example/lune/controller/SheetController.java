package com.example.lune.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.lune.domain.Sheet;
import com.example.lune.service.SheetService;
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
public class SheetController {

    @Autowired
    SheetService sheetService;

    //添加 sheet
    @RequestMapping(value = "/sheet/addSheet",method = RequestMethod.POST)
    @ResponseBody
    public Object addSheet(HttpServletRequest request, @Param("sheetFile")MultipartFile sheetFile){
        JSONObject jsonObject = new JSONObject();

        String sheetType = request.getParameter("sheetType");
        Integer sheetPieceId = Integer.parseInt(request.getParameter("sheetPieceId"));

        //存储曲谱的文件目录，如果不存在就新建
        String filepath = System.getProperty("user.dir")+System.getProperty("file.separator")+"piece"+System.getProperty("file.separator")+"sheet";
        File file = new File(filepath);
        if (!file.exists()) file.mkdir();

        //曲谱名字
        String sheetName = UUID.randomUUID() + sheetFile.getOriginalFilename();
        //存储曲谱全路径
        File dist = new File(filepath + System.getProperty("file.separator")+sheetName);

        Sheet sheet = new Sheet();
        sheet.setSheetType(sheetType);
        sheet.setSheetPieceId(sheetPieceId);

        try {
            sheetFile.transferTo(dist);
            sheet.setSheetFile("/piece/sheet/"+sheetName);
        } catch (IOException e) {
            jsonObject.put("code",0);
            jsonObject.put("msg",e.getMessage());
            e.printStackTrace();
            return jsonObject;
        }

        Boolean flag = sheetService.insert(sheet);
        if (flag){
            jsonObject.put("code",1);
            jsonObject.put("msg","上传曲谱成功");
        }else {
            jsonObject.put("code",0);
            jsonObject.put("msg","上传曲谱失败");
        }
        return jsonObject;
    }

    //更新 sheet
    @RequestMapping(value = "/sheet/updateSheet",method = RequestMethod.POST)
    @ResponseBody
    public Object updateSheet(HttpServletRequest request, @Param("sheetFile")MultipartFile sheetFile){
        JSONObject jsonObject = new JSONObject();

        Integer sheetId = Integer.parseInt(request.getParameter("sheetId"));
        String sheetType = request.getParameter("sheetType");
        Integer sheetPieceId = Integer.parseInt(request.getParameter("sheetPieceId"));

        //存储曲谱的文件目录，如果不存在就新建
        String filepath = System.getProperty("user.dir")+System.getProperty("file.separator")+"piece"+System.getProperty("file.separator")+"sheet";
        File file = new File(filepath);
        if (!file.exists()) file.mkdir();

        //曲谱名字
        String sheetName = UUID.randomUUID() + sheetFile.getOriginalFilename();
        //存储曲谱全路径
        File dist = new File(filepath + System.getProperty("file.separator")+sheetName);

        Sheet sheet = new Sheet();
        sheet.setSheetId(sheetId);
        sheet.setSheetType(sheetType);
        sheet.setSheetPieceId(sheetPieceId);

        try {
            sheetFile.transferTo(dist);
            sheet.setSheetFile("/piece/sheet/"+sheetName);
        } catch (IOException e) {
            jsonObject.put("code",0);
            jsonObject.put("msg",e.getMessage());
            e.printStackTrace();
            return jsonObject;
        }

        Boolean flag = sheetService.update(sheet);
        if (flag){
            jsonObject.put("code",1);
            jsonObject.put("msg","更新曲谱成功");
        }else {
            jsonObject.put("code",0);
            jsonObject.put("msg","更新曲谱失败");
        }
        return jsonObject;
    }
    //根据 id 删除 sheet
    @RequestMapping(value = "/sheet/delete",method = RequestMethod.GET)
    public Object deleteSheet(HttpServletRequest request){
        Integer sheetId = Integer.parseInt(request.getParameter("sheetId"));
        return sheetService.delete(sheetId);
    }
    //根据 id 返回 sheet
    @RequestMapping(value = "/sheet/sheetOfId",method = RequestMethod.GET)
    public Object sheetOfId(HttpServletRequest request){
        Integer sheetId = Integer.parseInt(request.getParameter("sheetId"));
        return sheetService.sheetOfId(sheetId);
    }
    //根据 曲子 id 返回 sheet
    @RequestMapping(value = "/sheet/sheetOfPiece",method = RequestMethod.GET)
    public Object sheetOfPiece(HttpServletRequest request){
        Integer pieceId = Integer.parseInt(request.getParameter("sheetPieceId"));
        return sheetService.sheetOfPiece(pieceId);
    }
    //根据 曲子 id 和曲谱类型返回 sheet
    @RequestMapping(value = "/sheet/sheetOfPieceAndType",method = RequestMethod.GET)
    public Object sheetOfPieceAndType(HttpServletRequest request){
        Integer pieceId = Integer.parseInt(request.getParameter("sheetPieceId"));
        String sheetType = request.getParameter("sheetType");
        return sheetService.sheetOfTypeAndPiece(pieceId,sheetType);
    }
}
