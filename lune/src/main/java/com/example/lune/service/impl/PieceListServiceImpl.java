package com.example.lune.service.impl;

import com.example.lune.domain.PieceList;
import com.example.lune.mapper.PieceListMapper;
import com.example.lune.service.PieceListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PieceListServiceImpl implements PieceListService {

    @Autowired
    PieceListMapper pieceListMapper;

    @Override
    public Boolean insert(PieceList pieceList) {
        return pieceListMapper.insert(pieceList) > 0;
    }

    @Override
    public Boolean insertSelective(PieceList pieceList) {
        return pieceListMapper.insertSelective(pieceList) > 0;
    }

    @Override
    public Boolean deleteById(Integer id) {
        return pieceListMapper.deleteById(id) > 0;
    }

    @Override
    public Boolean update(PieceList pieceList) {
        return pieceListMapper.update(pieceList) > 0;
    }

    @Override
    public PieceList pieceListOfId(Integer id) {
        return pieceListMapper.pieceListOfId(id);
    }

    @Override
    public List<PieceList> allPieceList() {
        return pieceListMapper.allPieceList();
    }

    @Override
    public List<PieceList> pieceListOfName(String pieceListName) {
        return pieceListMapper.pieceListOfName(pieceListName);
    }

    @Override
    public Boolean updatePic(PieceList pieceList) {
        return pieceListMapper.updatePic(pieceList) > 0;
    }

    @Override
    public List<PieceList> pieceOfUser(Integer userId) {
        return pieceListMapper.pieceOfUser(userId);
    }
}
