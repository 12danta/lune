package com.example.lune.service;

import com.example.lune.domain.Piece_Tag;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Piece_TagService {

    //添加 piece_tag 关联
    Boolean insert(@Param("tagId") Integer userId, @Param("pieceId") Integer pieceId);

    //根据 id 删除 piece_tag 关联
    Boolean deleteById(Integer id);
    //更新 piece_tag
    Boolean update(Piece_Tag piece_tag);
    //根据 pieceId 获取 piece_tag
    List<Piece_Tag> piece_TagOfPiece(Integer pieceId);
    //根据 tagId 获取 piece_tag
    List<Piece_Tag> piece_TagOfTag(Integer tagId);

}
