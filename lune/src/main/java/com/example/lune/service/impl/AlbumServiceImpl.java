package com.example.lune.service.impl;

import com.example.lune.domain.Album;
import com.example.lune.mapper.AlbumMapper;
import com.example.lune.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    AlbumMapper albumMapper;

    @Override
    public Boolean insert(Album album) {
        return albumMapper.insert(album) > 0;
    }

    @Override
    public Boolean insertSelective(Album album) {
        return albumMapper.insertSelective(album) > 0;
    }

    @Override
    public Album albumOfId(Integer id) {
        return albumMapper.albumOfId(id);
    }

    @Override
    public Album albumOfName(String name) {
        return albumMapper.albumOfName(name);
    }

    @Override
    public List<Album> albumOfLabel(String albumRecordLabel) {
        return albumMapper.albumOfLabel(albumRecordLabel);
    }

    @Override
    public List<Album> allAlbum() {
        return albumMapper.allAlbum();
    }

    @Override
    public Boolean update(Album album) {
        return albumMapper.update(album) > 0;
    }

    @Override
    public Boolean deleteById(Integer id) {
        return albumMapper.deleteById(id) > 0;
    }
}
