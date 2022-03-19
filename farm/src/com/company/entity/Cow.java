package com.company.entity;

public class Cow {

    private final int cowId;
    private final String nickName;

    public Cow(int id, String name) {
        this.cowId = id;
        this.nickName = name;
    }

    @Override
    public String toString() {
        return cowId + nickName;
    }

    public int getCowId() {
        return cowId;
    }
}
