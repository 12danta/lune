package com.example.lune.ServiceTest;

import com.example.lune.domain.Piece;
import com.example.lune.service.PieceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PieceServiceTest {

    @Autowired
    PieceService pieceService;

    @Test
    void test(){
//        List<Piece> list = pieceService.allPiece();
//        for (Piece piece : list) {
//            System.out.println(piece);
//        }
//        System.out.println(pieceService.pieceOfId(1));
        Piece piece = new Piece();
        piece.setPieceId(4);
        piece.setPieceName("test");
        piece.setPiecePic("12.png");
        piece.setPieceAudio("111");
        piece.setPieceVideo("222");
        pieceService.insert(piece);
//        pieceService.insertSelective(piece);
//        pieceService.deleteById(5);
//        System.out.println(pieceService.pieceOfName("12test"));
        System.out.println(pieceService.update(piece));
    }


}
