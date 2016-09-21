package com.study.runningsnail.snailapp.domain;

/**
 * Created by snail on 2016/9/20.
 */

public class Animal {
    private String aName;
    private String aSpeak;
    private boolean checkFlag;
    private int aIcon;

    public Animal(String aName,String aSpeak,int aIcon,boolean checkFlag){
        this.aName = aName;
        this.aSpeak = aSpeak;
        this.aIcon  = aIcon;
        this.checkFlag = checkFlag;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public String getaSpeak() {
        return aSpeak;
    }

    public void setaSpeak(String aSpeak) {
        this.aSpeak = aSpeak;
    }

    public int getaIcon() {
        return aIcon;
    }

    public void setaIcon(int aIcon) {
        this.aIcon = aIcon;
    }

    public boolean isCheckFlag() {
        return checkFlag;
    }

    public void setCheckFlag(boolean checkFlag) {
        this.checkFlag = checkFlag;
    }
}
