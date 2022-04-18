package com.example.lune.domain;

public class piece_Performer {
    private Integer id;
    private Integer pieceId;
    private Integer performerId;

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

    public Integer getPerformerId() {
        return performerId;
    }

    public void setPerformerId(Integer performerId) {
        this.performerId = performerId;
    }

    @Override
    public String toString() {
        return "piece_performer{" +
                "id=" + id +
                ", pieceId=" + pieceId +
                ", performerId=" + performerId +
                '}';
    }
}
