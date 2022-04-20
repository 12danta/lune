package com.example.lune.mapper;

import com.example.lune.domain.Piece_Tag;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Piece_TagMapper {

    //添加 piece_tag 关联
    Integer insert(Integer userId,Integer pieceId);

    //根据 id 删除 piece_tag 关联
    Integer deleteById(Integer id);
    //更新 piece_tag
    Integer update(Piece_Tag piece_tag);
    //根据 pieceId 获取 piece_tag
    List<Piece_Tag> piece_TagOfPiece(Integer pieceId);
    //根据 tagId 获取 piece_tag
    List<Piece_Tag> piece_TagOfTag(Integer tagId);

}
