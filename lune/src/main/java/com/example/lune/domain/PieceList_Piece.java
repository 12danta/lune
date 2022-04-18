package com.example.lune.domain;

public class PieceList_Piece {

    private Integer id;
    private Integer pieceId;
    private Integer PieceListId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPieceId() {
        return pieceId;
    }

    public void setPieceId(Integer pieceId) {
        this.pieceId = pieceId;
    }

    public Integer getPieceListId() {
        return PieceListId;
    }

    public void setPieceListId(Integer pieceListId) {
        PieceListId = pieceListId;
    }

    @Override
    public String toString() {
        return "pieceList_piece{" +
                "id=" + id +
                ", pieceId=" + pieceId +
                ", PieceListId=" + PieceListId +
                '}';
    }
}
