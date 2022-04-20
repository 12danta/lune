package com.example.lune.mapper;

import com.example.lune.domain.PieceList_Piece;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PieceList_PieceMapper {

    //添加 pieceList_Piece
    Integer insert(Integer pieceListId,Integer pieceId);
    //根据 id 返回 pieceList_Piece
    PieceList_Piece pieceList_PieceOfId(Integer id);
    //根据 id 删除 pieceList_Piece
    Integer delete(Integer id);
    //修改 pieceList_Piece
    Integer update(PieceList_Piece pieceList_piece);
    //根据 PieceList 返回 pieceList_Piece
    List<PieceList_Piece> pieceList_PieceOfPieceList(Integer pieceListId);

}
