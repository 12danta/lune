package com.example.lune.domain;

public class Performer {
    private Integer performerId;
    private String performerName;
    private String performerPic;
    private String performerIntroduce;
    private String performerType;

    public Integer getPerformerId() {
        return performerId;
    }

    public void setPerformerId(Integer performerId) {
        this.performerId = performerId;
    }

    public String getPerformerName() {
        return performerName;
    }

    public void setPerformerName(String performerName) {
        this.performerName = performerName;
    }

    public String getPerformerPic() {
        return performerPic;
    }

    public void setPerformerPic(String performerPic) {
        this.performerPic = performerPic;
    }

    public String getPerformerIntroduce() {
        return performerIntroduce;
    }

    public void setPerformerIntroduce(String performerIntroduce) {
        this.performerIntroduce = performerIntroduce;
    }

    public String getPerformerType() {
        return performerType;
    }

    public void setPerformerType(String performerType) {
        this.performerType = performerType;
    }

    @Override
    public String toString() {
        return "Performer{" +
                "performerId=" + performerId +
                ", performerName='" + performerName + '\'' +
                ", performerPic='" + performerPic + '\'' +
                ", performerIntroduce='" + performerIntroduce + '\'' +
                ", performerType='" + performerType + '\'' +
                '}';
    }
}
