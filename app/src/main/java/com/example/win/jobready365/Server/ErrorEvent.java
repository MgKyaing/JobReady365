package com.example.win.jobready365.Server;

/**
 * Created by zarni on 1/25/17.
 */

public class ErrorEvent {

private int errorCode;
    private String errroMsg;

    public ErrorEvent(int errorCode,String errroMsg)
    {
        this.errorCode=errorCode;
        this.errroMsg=errroMsg;

    }

    public int getErrorCode(){
        return errorCode;
    }
    public void setErrorCode(int errorCode){
        this.errorCode =errorCode;
    }

    public String getErrroMsg(){
        return errroMsg;
    }
    public void setErrroMsg(String errroMsg){

    }
}
