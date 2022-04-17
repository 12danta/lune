package com.example.lune.mapper;

import com.example.lune.domain.Performer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PerformerMapper {

    //添加 performer
    Integer insert(Performer performer);
    //根据内容添加 performer
    Integer insertSelective(Performer performer);
    //根据 id 删除 performer
    Integer deleteById(Integer id);
    //返回所有的 performer
    List<Performer> allPerformer();
    //根据 id 查找 performer
    Performer performerOfId(Integer id);
    //根据类型查找 performer
    List<Performer> performerOfType(String type);
    //根据名字查找 perfomer
    Performer performerOfName(String name);
    //更新 performer
    Integer update(Performer performer);
}
