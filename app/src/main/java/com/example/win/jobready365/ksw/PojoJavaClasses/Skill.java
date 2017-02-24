package com.example.win.jobready365.ksw.PojoJavaClasses;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Win on 2/6/2017.
 */
public class Skill implements Serializable {

    @SerializedName("user_id")
    String userId;

    String type;
    String level;

    public Skill(String userId,String  type, String level) {
        this.userId = userId;
        this.type = type;
        this.level = level;
    }

    public Skill() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}
