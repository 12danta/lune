package com.example.lune.service.impl;

import com.example.lune.domain.Sheet;
import com.example.lune.mapper.SheetMapper;
import com.example.lune.service.SheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SheetServiceImpl implements SheetService {


    @Autowired
    SheetMapper sheetMapper;

    @Override
    public Boolean insert(Sheet sheet) {
        return sheetMapper.insert(sheet) > 0;
    }

    @Override
    public Boolean delete(Integer sheetId) {
        return sheetMapper.delete(sheetId) > 0;
    }

    @Override
    public Boolean update(Sheet sheet) {
        return sheetMapper.update(sheet) > 0;
    }

    @Override
    public Sheet sheetOfId(Integer sheetId) {
        return sheetMapper.sheetOfId(sheetId);
    }

    @Override
    public List<Sheet> sheetOfPiece(Integer pieceId) {
        return sheetMapper.sheetOfPiece(pieceId);
    }

    @Override
    public Sheet sheetOfTypeAndPiece(Integer pieceId, String sheetType) {
        return sheetMapper.sheetOfTypeAndPiece(pieceId,sheetType);
    }
}
