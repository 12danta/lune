package com.example.lune.service;

import com.example.lune.domain.Composer;

import java.util.List;

public interface ComposerService {
    //插入 composer
    Boolean insert(Composer composer);
    //根据 id 删除 composer
    Boolean deleteById(Integer id);
    //返回所有 Composer
    List<Composer> allComposer();
    //根据 period 返回 composer
    List<Composer> composerOfPeriod(String period);
    //根据 id 返回 composer
    Composer composerOfId(Integer id);
    //根据姓名查找 composer
    Composer composerOfName(String name);
    //更新 composer
    Boolean update(Composer composer);
}
