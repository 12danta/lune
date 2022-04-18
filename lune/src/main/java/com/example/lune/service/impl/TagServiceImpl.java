package com.example.lune.service.impl;

import com.example.lune.domain.Tag;
import com.example.lune.mapper.TagMapper;
import com.example.lune.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    TagMapper tagMapper;

    @Override
    public Boolean insert(Tag tag) {
        return tagMapper.insert(tag) > 0;
    }

    @Override
    public Boolean deleteTagById(Integer id) {
        return tagMapper.deleteTagById(id) > 0;
    }

    @Override
    public Boolean update(Tag tag) {
        return tagMapper.update(tag) > 0;
    }

    @Override
    public Tag tagOfId(Integer id) {
        return tagMapper.tagOfId(id);
    }

    @Override
    public Tag tagOfName(String name) {
        return tagMapper.tagOfName(name);
    }

    @Override
    public List<Tag> allTag() {
        return tagMapper.allTag();
    }
}
