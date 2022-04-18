package com.example.lune.service;

import com.example.lune.domain.Album;

import java.util.List;

public interface AlbumService {

    //添加Album
    Boolean insert(Album album);
    //根据内容添加 album
    Boolean insertSelective(Album album);
    //根据 id 查找 album
    Album albumOfId(Integer id);
    //根据 name 查找 album
    Album albumOfName(String name);
    //根据 label 查找 album
    List<Album> albumOfLabel(String albumRecordLabel);
    //返回所有 Album
    List<Album> allAlbum();
    //更新 album
    Boolean update(Album album);
    //删除
    Boolean deleteById(Integer id);

}
