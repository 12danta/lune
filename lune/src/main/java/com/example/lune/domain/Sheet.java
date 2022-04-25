package com.example.lune.domain;

public class Sheet {
    private Integer sheetId;
    private String sheetFile;
    private String sheetType;
    private Integer sheetPieceId;

    public Integer getSheetId() {
        return sheetId;
    }

    public void setSheetId(Integer sheetId) {
        this.sheetId = sheetId;
    }

    public String getSheetFile() {
        return sheetFile;
    }

    public void setSheetFile(String sheetFile) {
        this.sheetFile = sheetFile;
    }

    public String getSheetType() {
        return sheetType;
    }

    public void setSheetType(String sheetType) {
        this.sheetType = sheetType;
    }

    public Integer getSheetPieceId() {
        return sheetPieceId;
    }

    public void setSheetPieceId(Integer sheetPieceId) {
        this.sheetPieceId = sheetPieceId;
    }

    @Override
    public String toString() {
        return "Sheet{" +
                "sheetId=" + sheetId +
                ", sheetFile='" + sheetFile + '\'' +
                ", sheetType='" + sheetType + '\'' +
                ", sheetPieceId=" + sheetPieceId +
                '}';
    }
}
