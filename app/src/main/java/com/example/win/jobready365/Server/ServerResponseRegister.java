package com.example.win.jobready365.Server;

import com.google.gson.annotations.SerializedName;

/**
 * Created by zarni on 1/25/17.
 */

public class ServerResponseRegister {


    @SerializedName("login_name")
    private String login_name;
    @SerializedName("email")
    private String email;
    @SerializedName("password")
    private String password;
    @SerializedName("password_confirmation")
    private String password_confirmation;
    @SerializedName("message")
    private String message;
    @SerializedName("error_code")
    private int errorCode;
    private int status=1;
    private String error;

    public ServerResponseRegister(String login_name,String email,String password,String password_confirmation,String message,int errorCode,int status,String error){
        this.login_name=login_name;
        this.email=email;
        this.password=password;
        this.password_confirmation=password_confirmation;
        this.message=message;
        this.errorCode=errorCode;
        this.status=status;
        this.error=error;



    }

    public String getLogin_name() {
    return login_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


}

