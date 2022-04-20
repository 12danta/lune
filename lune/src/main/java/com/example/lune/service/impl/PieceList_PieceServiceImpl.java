package com.example.lune.service.impl;

import com.example.lune.domain.PieceList_Piece;
import com.example.lune.mapper.PieceList_PieceMapper;
import com.example.lune.service.PieceList_PieceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PieceList_PieceServiceImpl implements PieceList_PieceService {

    @Autowired
    PieceList_PieceMapper pieceList_pieceMapper;

    @Override
    public Boolean insert(Integer pieceListId, Integer pieceId) {
        return pieceList_pieceMapper.insert(pieceListId,pieceId) > 0;
    }

    @Override
    public PieceList_Piece pieceList_PieceOfId(Integer id) {
        return pieceList_pieceMapper.pieceList_PieceOfId(id);
    }

    @Override
    public Boolean delete(Integer id) {
        return pieceList_pieceMapper.delete(id) > 0;
    }

    @Override
    public Boolean update(PieceList_Piece pieceList_piece) {
        return pieceList_pieceMapper.update(pieceList_piece) > 0;
    }

    @Override
    public List<PieceList_Piece> pieceList_PieceOfPieceList(Integer pieceListId) {
        return pieceList_pieceMapper.pieceList_PieceOfPieceList(pieceListId);
    }
}
