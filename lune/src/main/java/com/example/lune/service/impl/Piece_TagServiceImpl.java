package com.example.lune.service.impl;

import com.example.lune.domain.Piece_Tag;
import com.example.lune.mapper.Piece_TagMapper;
import com.example.lune.service.Piece_TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Piece_TagServiceImpl implements Piece_TagService {

    @Autowired
    Piece_TagMapper piece_tagMapper;

    @Override
    public Boolean insert(Integer userId, Integer pieceId) {
        return piece_tagMapper.insert(userId,pieceId) > 0;
    }

    @Override
    public Boolean deleteById(Integer id) {
        return piece_tagMapper.deleteById(id) > 0;
    }

    @Override
    public Boolean update(Piece_Tag piece_tag) {
        return piece_tagMapper.update(piece_tag) > 0;
    }

    @Override
    public List<Piece_Tag> piece_TagOfPiece(Integer pieceId) {
        return piece_tagMapper.piece_TagOfPiece(pieceId);
    }

    @Override
    public List<Piece_Tag> piece_TagOfTag(Integer tagId) {
        return piece_tagMapper.piece_TagOfTag(tagId);
    }
}
