package com.example.lune.ServiceTest;

import com.example.lune.domain.PieceList;
import com.example.lune.service.PieceListService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PiececListTest {

    @Autowired
    PieceListService pieceListService;

    @Test
    void test(){
        List<PieceList> list= pieceListService.allPieceList();
        for (PieceList pieceList : list) {
            System.out.println(pieceList);
        }
        PieceList pieceList = new PieceList();
        pieceList.setPieceListId(3);
        pieceList.setPieceListName("list_test");
        pieceList.setPieceListPic("listPic111");
//        pieceList.setPieceListDescription("a list");
        pieceList.setUserId(1);
//        pieceListService.insertSelective(pieceList);
//        System.out.println(pieceListService.pieceListOfId(3));
//        List<PieceList> list1 = pieceListService.pieceOfUser(1);
//        for (PieceList pieceList : list1) {
//            System.out.println(pieceList);
//        }
//        pieceListService.deleteById(4);
//        List<PieceList> list = pieceListService.pieceListOfName("list");
//        for (PieceList pieceList : list) {
//            System.out.println(pieceList);
//        }
//        PieceList pieceList1 = new PieceList();
//        pieceList1.setPieceListId(3);
//        pieceList1.setPieceListPic("test");
//        pieceListService.updatePic(pieceList1);
    }
}
