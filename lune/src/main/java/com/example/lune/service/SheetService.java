package com.example.lune.service;

import com.example.lune.domain.Sheet;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SheetService {
    //添加曲谱
    Boolean insert(Sheet sheet);
    //删除曲谱
    Boolean delete(Integer sheetId);
    //修改曲谱
    Boolean update(Sheet sheet);
    //根据 id 返回曲谱
    Sheet sheetOfId(Integer sheetId);
    //根据曲子 id 返回曲谱
    List<Sheet> sheetOfPiece(Integer pieceId);
    //根据 曲子 id + 曲谱类型返回曲谱
    Sheet sheetOfTypeAndPiece(Integer pieceId,String sheetType);
}
