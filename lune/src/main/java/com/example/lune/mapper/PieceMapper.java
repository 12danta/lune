package com.example.lune.mapper;

import com.example.lune.domain.Piece;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PieceMapper {
    //添加 piece
    Integer insert(Piece piece);
    //根据内容添加 piece
    Integer insertSelective(Piece piece);
    //根据 id 查找 piece
    Piece pieceOfId(Integer id);
    //根据 name 查找 piece
    Piece pieceOfName(String name);
    //返回所有 piece
    List<Piece> allPiece();
    //更新 piece
    Integer update(Piece piece);
    //根据 id 删除 piece
    Integer deleteById(Integer id);
}
