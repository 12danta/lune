package com.example.lune.service;

import com.example.lune.domain.PieceList;

import java.util.List;

public interface PieceListService {

    //添加 pieceList
    Boolean insert(PieceList pieceList);
    //根据内容添加 pieceList
    Boolean insertSelective(PieceList pieceList);
    //根据 id 删除 pieceList
    Boolean deleteById(Integer id);
    //更新 pieceList
    Boolean update(PieceList pieceList);
    //根据 id 返回 pieceList
    PieceList pieceListOfId(Integer id);
    //返回所有 pieceList
    List<PieceList> allPieceList();
    //根据名字返回 pieceList
    List<PieceList> pieceListOfName(String pieceListName);
    //更新 pieceList_pic
    Boolean updatePic(PieceList pieceList);
    //根据 userId 返回 pieceList
    List<PieceList> pieceOfUser(Integer userId);

}
