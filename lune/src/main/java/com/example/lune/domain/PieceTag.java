package com.example.lune.domain;

public class PieceTag {
    private Integer tagId;
    private Integer pieceId;

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
        return "PieceTag{" +
                "tagId=" + tagId +
                ", pieceId=" + pieceId +
                '}';
    }
}
