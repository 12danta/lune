package com.example.lune.service;

import com.example.lune.domain.Piece;

import java.util.List;

public interface PieceService {
    //添加 piece
    Boolean insert(Piece piece);
    //根据内容添加 piece
    Boolean insertSelective(Piece piece);
    //根据 id 查找 piece
    Piece pieceOfId(Integer id);
    //根据 name 查找 piece
    Piece pieceOfName(String name);
    //返回所有 piece
    List<Piece> allPiece();
    //更新 piece
    Integer update(Piece piece);
    //根据 id 删除 piece
    Boolean deleteById(Integer id);
}
