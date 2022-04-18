package com.example.lune.ServiceTest;

import com.example.lune.domain.Tag;
import com.example.lune.service.TagService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TagServiceTest {

    @Autowired
    TagService tagService;

    @Test
    void test(){
//        List list = tagService.allTag();
//        for (Object o : list) {
//            System.out.println(o);
//        }
        System.out.println(tagService.tagOfId(9));
        System.out.println(tagService.tagOfName("Mozart"));
        Tag tag = new Tag();
        tag.setTagId(11);
        tag.setTagName("test111");
//        tagService.insert(tag);
//        tagService.deleteTagById(10);
        tagService.update(tag);
    }
}
