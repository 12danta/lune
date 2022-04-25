package com.example.lune.ServiceTest;

import com.example.lune.domain.Sheet;
import com.example.lune.service.SheetService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class SheetServiceTest {

    @Autowired
    SheetService sheetService;

    @Test
    void test(){
//        Sheet sheet = new Sheet();
//        sheet.setSheetId(4);
//        sheet.setSheetFile("/sheet/file111");
////        sheet.setSheetType("violin");
//        sheet.setSheetPieceId(2);
//        sheetService.insert(sheet);
////        sheetService.delete(3);
//        System.out.println(sheetService.sheetOfId(1));
//        sheetService.update(sheet);
//        List<Sheet> list = sheetService.sheetOfPiece(2);
//        for (Sheet sheet : list) {
//            System.out.println(sheet);
//        }
        System.out.println(sheetService.sheetOfTypeAndPiece(2, "piano"));
    }
}
