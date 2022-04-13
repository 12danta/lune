package com.example.lune.domain;

public class Sheet {
    private Integer sheetId;
    private Integer sheetGroupId;
    private String sheetPic;

    public Integer getSheetId() {
        return sheetId;
    }

    public void setSheetId(Integer sheetId) {
        this.sheetId = sheetId;
    }

    public Integer getSheetGroupId() {
        return sheetGroupId;
    }

    public void setSheetGroupId(Integer sheetGroupId) {
        this.sheetGroupId = sheetGroupId;
    }

    public String getSheetPic() {
        return sheetPic;
    }

    public void setSheetPic(String sheetPic) {
        this.sheetPic = sheetPic;
    }

    @Override
    public String toString() {
        return "Sheet{" +
                "sheetId=" + sheetId +
                ", sheetGroupId=" + sheetGroupId +
                ", sheetPic='" + sheetPic + '\'' +
                '}';
    }
}
