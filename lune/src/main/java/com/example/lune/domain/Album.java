package com.example.lune.domain;

public class Album {
    private Integer albumId;
    private String albumName;
    private String albumPic;
    private String albumRelaseTime;
    private String albumRecordLabel;

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getAlbumPic() {
        return albumPic;
    }

    public void setAlbumPic(String albumPic) {
        this.albumPic = albumPic;
    }

    public String getAlbumRelaseTime() {
        return albumRelaseTime;
    }

    public void setAlbumRelaseTime(String albumRelaseTime) {
        this.albumRelaseTime = albumRelaseTime;
    }

    public String getAlbumRecordLabel() {
        return albumRecordLabel;
    }

    public void setAlbumRecordLabel(String albumRecordLabel) {
        this.albumRecordLabel = albumRecordLabel;
    }

    @Override
    public String toString() {
        return "Album{" +
                "albumId=" + albumId +
                ", albumName='" + albumName + '\'' +
                ", albumPic='" + albumPic + '\'' +
                ", albumRelaseTime='" + albumRelaseTime + '\'' +
                ", albumRecordLabel='" + albumRecordLabel + '\'' +
                '}';
    }
}
