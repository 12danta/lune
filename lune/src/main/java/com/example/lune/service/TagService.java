package com.example.lune.service;

import com.example.lune.domain.Tag;

import java.util.List;

public interface TagService {

    //添加 tag
    Boolean insert(Tag tag);
    //删除 tag
    Boolean deleteTagById(Integer id);
    //修改 tag
    Boolean update(Tag tag);
    //根据 id 查找 tag
    Tag tagOfId(Integer id);
    //根据 name 查找 tag
    Tag tagOfName(String name);
    //返回所有 tag
    List<Tag> allTag();

}
