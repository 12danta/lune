package com.example.lune.domain;

public class Piece {
    private Integer pieceId;
    private String pieceName;
    private String piecePic;
    private String pieceAudio;
    private String pieceVideo;



    public Integer getPieceId() {
        return pieceId;
    }

    public void setPieceId(Integer pieceId) {
        this.pieceId = pieceId;
    }

    public String getPieceName() {
        return pieceName;
    }

    public void setPieceName(String pieceName) {
        this.pieceName = pieceName;
    }

    public String getPiecePic() {
        return piecePic;
    }

    public void setPiecePic(String piecePic) {
        this.piecePic = piecePic;
    }

    public String getPieceAudio() {
        return pieceAudio;
    }

    public void setPieceAudio(String pieceAudio) {
        this.pieceAudio = pieceAudio;
    }

    public String getPieceVideo() {
        return pieceVideo;
    }

    public void setPieceVideo(String pieceVideo) {
        this.pieceVideo = pieceVideo;
    }

    @Override
    public String toString() {
        return "Piece{" +
                "pieceId=" + pieceId +
                ", pieceName='" + pieceName + '\'' +
                ", piecePic='" + piecePic + '\'' +
                ", pieceAudio='" + pieceAudio + '\'' +
                ", pieceVideo='" + pieceVideo + '\'' +
                '}';
    }
}
