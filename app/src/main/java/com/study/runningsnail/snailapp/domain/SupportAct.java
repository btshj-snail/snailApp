package com.study.runningsnail.snailapp.domain;

/**
 * Created by snail on 2016/9/21.
 */

public class SupportAct {
    private int image;
    private String name;
    private String id;

    public SupportAct (String id,String name ,int image){
        this.image = image;
        this.name = name;
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
