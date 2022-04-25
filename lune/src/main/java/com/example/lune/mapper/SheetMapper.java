package com.example.lune.mapper;

import com.example.lune.domain.Piece;
import com.example.lune.domain.Sheet;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SheetMapper {

    //添加曲谱
    Integer insert(Sheet sheet);
    //删除曲谱
    Integer delete(Integer sheetId);
    //修改曲谱
    Integer update(Sheet sheet);
    //根据 id 返回曲谱
    Sheet sheetOfId(Integer sheetId);
    //根据曲子 id 返回曲谱
    List<Sheet> sheetOfPiece(Integer pieceId);
    //根据 曲子 id + 曲谱类型返回曲谱
    Sheet sheetOfTypeAndPiece(Integer pieceId,String sheetType);

}
