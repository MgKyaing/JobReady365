package com.example.win.jobready365.datastore;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by zarni on 2/6/17
 */

public class User implements Serializable {

    @SerializedName("id")
    private String id;

    @SerializedName("login_name")
    private String login_name;

    @SerializedName("user_type")
    private int user_type;


    public User(String id, String login_name,int user_type) {
        this.id = id;
        this.login_name = login_name;
        this.user_type=user_type;
    }
    public String getId(){
        return id;
    }
    public int getuser_type(){
        return user_type;
    }
    public String getuser_name(){
        return login_name;
    }
}
