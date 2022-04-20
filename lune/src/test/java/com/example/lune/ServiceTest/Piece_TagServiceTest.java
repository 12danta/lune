package com.example.lune.ServiceTest;

import com.example.lune.domain.Piece_Tag;
import com.example.lune.service.Piece_TagService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class Piece_TagServiceTest {

    @Autowired
    Piece_TagService piece_tagService;

    @Test
    void test(){

//        piece_tagService.insert(1,2);
//        List<Piece_Tag> list = piece_tagService.piece_TagOfTag(1);
//        for (Piece_Tag piece_tag : list) {
//            System.out.println(piece_tag);
//        }
//        List<Piece_Tag> list2 = piece_tagService.piece_TagOfPiece(1);
//        for (Piece_Tag piece_tag : list2) {
//            System.out.println(piece_tag);
//        }
//
        Piece_Tag piece_tag = new Piece_Tag();
        piece_tag.setId(9);
        piece_tag.setPieceId(8);
        piece_tagService.deleteById(8);
        piece_tagService.update(piece_tag);
    }
}
