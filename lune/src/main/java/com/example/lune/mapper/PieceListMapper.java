package com.example.lune.mapper;

import com.example.lune.domain.Piece;
import com.example.lune.domain.PieceList;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PieceListMapper {

    //添加 pieceList
    Integer insert(PieceList pieceList);
    //根据内容添加 pieceList
    Integer insertSelective(PieceList pieceList);
    //根据 id 删除 pieceList
    Integer deleteById(Integer id);
    //更新 pieceList
    Integer update(PieceList pieceList);
    //根据 id 返回 pieceList
    PieceList pieceListOfId(Integer id);
    //返回所有 pieceList
    List<PieceList> allPieceList();
    //根据名字返回 pieceList
    List<PieceList> pieceListOfName(String pieceListName);
    //更新 pieceList_pic
    Integer updatePic(PieceList pieceList);
    //根据 userId 返回 pieceList
    List<PieceList> pieceOfUser(Integer userId);

}
