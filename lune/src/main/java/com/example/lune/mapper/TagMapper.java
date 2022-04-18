package com.example.lune.mapper;

import com.example.lune.domain.Tag;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagMapper {

    //添加 tag
    Integer insert(Tag tag);
    //删除 tag
    Integer deleteTagById(Integer id);
    //修改 tag
    Integer update(Tag tag);
    //根据 id 查找 tag
    Tag tagOfId(Integer id);
    //根据 name 查找 tag
    Tag tagOfName(String name);
    //返回所有 tag
    List<Tag> allTag();

}
