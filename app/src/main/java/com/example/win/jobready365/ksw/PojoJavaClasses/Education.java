package com.example.win.jobready365.ksw.PojoJavaClasses;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Win on 2/6/2017.
 */
public class Education implements Serializable{
    @SerializedName("user_id")
    private String userId;
    private String university;
    private String degree;
    private String year;


    public Education(String userId, String university, String degree,String year) {
        this.userId = userId;
        this.year = year;
        this.university = university;
        this.degree = degree;
    }

    public Education(String degree, String university, String year) {
        this.degree = degree;
        this.university = university;
        this.year = year;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }



}
