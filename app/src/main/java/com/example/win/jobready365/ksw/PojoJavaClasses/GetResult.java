package com.example.win.jobready365.ksw.PojoJavaClasses;

/**
 * Created by Win on 1/26/2017.
 */

public class GetResult {
    String category;
    String location;
    String type;


    public GetResult(String category, String location, String type) {
        this.category = category;
        this.location = location;

        this.type = type;
    }

    public GetResult(String category,String location) {
        this.category = category;
    }


    public GetResult(String location) {
        this.location = location;
    }
}
