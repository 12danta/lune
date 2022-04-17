package com.example.lune.mapper;

import com.example.lune.domain.Composer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComposerMapper {

    //插入 composer
    Integer insert(Composer composer);
    //根据 id 删除 composer
    Integer deleteById(Integer id);
    //返回所有 Composer
    List<Composer> allComposer();
    //根据 period 返回 composer
    List<Composer> composerOfPeriod(String period);
    //根据 id 返回 composer
    Composer composerOfId(Integer id);
    //根据姓名查找 composer
    Composer composerOfName(String name);
    //更新 composer
    Integer update(Composer composer);


}
