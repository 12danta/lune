package com.example.lune.service;

import com.example.lune.domain.PieceList_Piece;

import java.util.List;

public interface PieceList_PieceService {

    //添加 pieceList_Piece
    Boolean insert(Integer pieceListId,Integer pieceId);
    //根据 id 返回 pieceList_Piece
    PieceList_Piece pieceList_PieceOfId(Integer id);
    //根据 id 删除 pieceList_Piece
    Boolean delete(Integer id);
    //修改 pieceList_Piece
    Boolean update(PieceList_Piece pieceList_piece);
    //根据 PieceList 返回 pieceList_Piece
    List<PieceList_Piece> pieceList_PieceOfPieceList(Integer pieceListId);

}
