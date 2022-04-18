package com.example.lune.mapper;

import com.example.lune.domain.Album;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumMapper {

    //添加Album
    Integer insert(Album album);
    //根据内容添加 album
    Integer insertSelective(Album album);
    //根据 id 查找 album
    Album albumOfId(Integer id);
    //根据 name 查找 album
    Album albumOfName(String name);
    //根据 label 查找 album
    List<Album> albumOfLabel(String albumRecordLabel);
    //返回所有 Album
    List<Album> allAlbum();
    //更新 album
    Integer update(Album album);
    //删除
    Integer deleteById(Integer id);

}
