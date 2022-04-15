package com.example.lune.domain;

public class piece_performer {
    private Integer pieceId;
    private Integer performerId;

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
                "pieceId=" + pieceId +
                ", performerId=" + performerId +
                '}';
    }
}
