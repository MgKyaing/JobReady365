package com.example.win.jobready365.Server;

/**
 * Created by zarni on 1/25/17.
 */


public class ServerEvent {
    private ServerResponse serverResponse;
    private  ServerResponseRegister  serverResponseRegister;
    public ServerEvent(ServerResponse serverResponse) {
        this.serverResponse = serverResponse;
    }

    public ServerResponse getServerResponse() {
        return serverResponse;
    }

    public ServerEvent(ServerResponseRegister serverResponseRegister) {
        this.serverResponseRegister = serverResponseRegister;
    }
    public ServerResponseRegister getServerResponseRegister(){
        return serverResponseRegister;
    }

    public void setServerResponse(ServerResponse serverResponse) {
        this.serverResponse = serverResponse;
    }

}
