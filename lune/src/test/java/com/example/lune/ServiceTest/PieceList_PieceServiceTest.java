package com.example.lune.ServiceTest;

import com.example.lune.domain.PieceList_Piece;
import com.example.lune.service.PieceList_PieceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PieceList_PieceServiceTest {

    @Autowired
    PieceList_PieceService pieceList_pieceService;

    @Test
    void test(){


        System.out.println("----------"+pieceList_pieceService.pieceList_PieceOfId(1));
        PieceList_Piece pieceList_piece = new PieceList_Piece();
        pieceList_piece.setId(3);
        pieceList_piece.setPieceListId(3);
        pieceList_piece.setPieceId(2);
//        pieceList_pieceService.insert(2,2);
//        List<PieceList_Piece> list= pieceList_pieceService.pieceList_PieceOfPieceList(2);
//        for (PieceList_Piece pieceListPiece : list) {
//            System.out.println(pieceListPiece);
//        }
//        pieceList_pieceService.delete(4);
        pieceList_pieceService.update(pieceList_piece);

    }
}
