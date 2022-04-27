package com.example.lune.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.lune.domain.Tag;
import com.example.lune.service.TagService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Controller
@RestController
public class TagController {


    @Autowired
    TagService tagService;


    //添加tag
    @ResponseBody
    @RequestMapping(value = "/tag/addTag/",method = RequestMethod.POST)
    public Object addTag(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();

        String tagName = request.getParameter("tagName");

        Tag tag = new Tag();
        tag.setTagName(tagName);

        Boolean flag = tagService.insert(tag);
        if (flag){
            jsonObject.put("code",1);
            jsonObject.put("msg","添加 tag 成功");
        }else {
            jsonObject.put("code",0);
            jsonObject.put("msg","添加 tag 失败");
        }
        return jsonObject;
    }

    //根据 id 删除tag
    @RequestMapping(value = "/tag/delete/" ,method = RequestMethod.GET)
    public Object deleteById(HttpServletRequest request){

        Integer tagId = Integer.parseInt(request.getParameter("tagId"));

        return tagService.deleteTagById(tagId);

    }
    //修改tag
    @ResponseBody
    @RequestMapping(value = "/tag/updateTag/",method = RequestMethod.POST)
    public Object updateTag(HttpServletRequest request){

        JSONObject jsonObject = new JSONObject();

        Integer tagId = Integer.parseInt(request.getParameter("tagId"));
        String tagName = request.getParameter("tagName");

        Tag tag = new Tag();
        tag.setTagId(tagId);
        tag.setTagName(tagName);

        Boolean flag = tagService.update(tag);

        if (flag){
            jsonObject.put("code",1);
            jsonObject.put("msg","修改 tag 成功");
        }else {
            jsonObject.put("code",0);
            jsonObject.put("msg","修改 tag 失败");
        }
        return jsonObject;
    }

    //根据 id 返回tag
    @RequestMapping(value = "/tag/tagOfId/",method = RequestMethod.GET)
    public Object tagOfId(HttpServletRequest request){

        Integer tagId = Integer.parseInt(request.getParameter("tagId"));
        return tagService.tagOfId(tagId);

    }

    //根据 name 返回tag
    @RequestMapping(value = "/tag/tagOfName/",method = RequestMethod.GET)
    public Object tagOfName(HttpServletRequest request){
        String tagName = request.getParameter("tagName");
        return tagService.tagOfName(tagName);
    }

    //所有 tag
    @RequestMapping(value = "/tag/allTag/",method = RequestMethod.GET)
    public Object allTag(){
        return tagService.allTag();
    }
}

