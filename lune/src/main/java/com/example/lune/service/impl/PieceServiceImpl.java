package com.example.lune.service.impl;

import com.example.lune.domain.Piece;
import com.example.lune.mapper.PieceMapper;
import com.example.lune.service.PieceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PieceServiceImpl implements PieceService {

    @Autowired
    PieceMapper pieceMapper;
    @Override
    public Boolean insert(Piece piece) {
        return pieceMapper.insert(piece) > 0;
    }

    @Override
    public Boolean insertSelective(Piece piece) {
        return pieceMapper.insertSelective(piece) > 0;
    }

    @Override
    public Piece pieceOfId(Integer id) {
        return pieceMapper.pieceOfId(id);
    }

    @Override
    public Piece pieceOfName(String name) {
        return pieceMapper.pieceOfName(name);
    }

    @Override
    public List<Piece> allPiece() {
        return pieceMapper.allPiece();
    }

    @Override
    public Integer update(Piece piece) {
        return pieceMapper.update(piece);
    }

    @Override
    public Boolean deleteById(Integer id) {
        return pieceMapper.deleteById(id) > 0;
    }
}
