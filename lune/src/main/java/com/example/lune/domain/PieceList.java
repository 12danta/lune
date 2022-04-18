package com.example.lune.domain;

public class PieceList {

    private Integer pieceListId;
    private String pieceListName;
    private String pieceListPic;
    private String pieceListDescription;
    private Integer userId;

    public Integer getPieceListId() {
        return pieceListId;
    }

    public void setPieceListId(Integer pieceListId) {
        this.pieceListId = pieceListId;
    }

    public String getPieceListName() {
        return pieceListName;
    }

    public void setPieceListName(String pieceListName) {
        this.pieceListName = pieceListName;
    }

    public String getPieceListPic() {
        return pieceListPic;
    }

    public void setPieceListPic(String pieceListPic) {
        this.pieceListPic = pieceListPic;
    }

    public String getPieceListDescription() {
        return pieceListDescription;
    }

    public void setPieceListDescription(String pieceListDescription) {
        this.pieceListDescription = pieceListDescription;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "PieceList{" +
                "pieceListId=" + pieceListId +
                ", pieceListName='" + pieceListName + '\'' +
                ", pieceListPic='" + pieceListPic + '\'' +
                ", pieceListDescription='" + pieceListDescription + '\'' +
                ", userId=" + userId +
                '}';
    }
}
