package com.example.lune.ServiceTest;

import com.example.lune.domain.Album;
import com.example.lune.mapper.AlbumMapper;
import com.example.lune.service.AlbumService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
public class AlbumServiceTest {

    @Autowired
    AlbumService albumService;

    @Test
    void test(){
//        List<Album> list = albumService.allAlbum();
//        for (Album album : list) {
//            System.out.println(album);
//        }
        Album album = new Album();
        album.setAlbumId(2);
        album.setAlbumName("test");
        album.setAlbumPic("test");
//        album.setAlbumRelaseTime(new Date());
//        album.setAlbumRecordLabel("test");
//        albumService.insert(album);
//        albumService.insertSelective(album);
//        System.out.println(albumService.albumOfId(3));
////        System.out.println(albumService.albumOfLabel("test"));
//        List<Album> list2 = albumService.albumOfLabel("test");
//        for (Album album1 : list2) {
//            System.out.println(album1);
//        }
//        System.out.println(albumService.albumOfName("test1111"));
        albumService.update(album);
        albumService.deleteById(3);
    }
}
