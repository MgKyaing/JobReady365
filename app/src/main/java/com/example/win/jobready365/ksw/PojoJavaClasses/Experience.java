package com.example.win.jobready365.ksw.PojoJavaClasses;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Win on 2/6/2017.
 */
public class Experience implements Serializable{
    @SerializedName("user_id")
    private String userId;
    private String organization;
    private String rank;
    @SerializedName("start_date")
    private String startDate;
    @SerializedName("end_date")
    private String endDate;


    public Experience(String userId,String organization, String rank, String startDate, String endDate) {
        this.userId = userId;
        this.organization = organization;
        this.rank = rank;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}



