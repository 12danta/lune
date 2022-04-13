package com.example.lune.domain;

public class Composer {
    private Integer composerId;
    private String composerName;
    private String composerPic;
    private String composerIntroduction;
    private String composerLifeAndDeath;
    private String composerPeriods;

    public Integer getComposerId() {
        return composerId;
    }

    public void setComposerId(Integer composerId) {
        this.composerId = composerId;
    }

    public String getComposerName() {
        return composerName;
    }

    public void setComposerName(String composerName) {
        this.composerName = composerName;
    }

    public String getComposerPic() {
        return composerPic;
    }

    public void setComposerPic(String composerPic) {
        this.composerPic = composerPic;
    }

    public String getComposerIntroduction() {
        return composerIntroduction;
    }

    public void setComposerIntroduction(String composerIntroduction) {
        this.composerIntroduction = composerIntroduction;
    }

    public String getComposerLifeAndDeath() {
        return composerLifeAndDeath;
    }

    public void setComposerLifeAndDeath(String composerLifeAndDeath) {
        this.composerLifeAndDeath = composerLifeAndDeath;
    }

    public String getComposerPeriods() {
        return composerPeriods;
    }

    public void setComposerPeriods(String composerPeriods) {
        this.composerPeriods = composerPeriods;
    }

    @Override
    public String toString() {
        return "Composer{" +
                "composerId=" + composerId +
                ", composerName='" + composerName + '\'' +
                ", composerPic='" + composerPic + '\'' +
                ", composerIntroduction='" + composerIntroduction + '\'' +
                ", composerLifeAndDeath='" + composerLifeAndDeath + '\'' +
                ", composerPeriods='" + composerPeriods + '\'' +
                '}';
    }
}
