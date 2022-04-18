package com.example.lune.domain;

public class Piece_Tag {

    private Integer id;
    private Integer tagId;
    private Integer pieceId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public Integer getPieceId() {
        return pieceId;
    }

    public void setPieceId(Integer pieceId) {
        this.pieceId = pieceId;
    }

    @Override
    public String toString() {
        return "Piece_Tag{" +
                "id=" + id +
                ", tagId=" + tagId +
                ", pieceId=" + pieceId +
                '}';
    }
}
