package com.example.lune.domain;

import java.util.Date;

public class Album {
    private Integer albumId;
    private String albumName;
    private String albumPic;
    private Date albumReleaseTime;
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

    public Date getAlbumRelaseTime() {
        return albumReleaseTime;
    }

    public void setAlbumRelaseTime(Date albumReleaseTime) {
        this.albumReleaseTime = albumReleaseTime;
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
                ", albumRelaseTime='" + albumReleaseTime + '\'' +
                ", albumRecordLabel='" + albumRecordLabel + '\'' +
                '}';
    }
}
