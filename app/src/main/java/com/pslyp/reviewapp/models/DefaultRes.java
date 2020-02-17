package com.pslyp.reviewapp.models;

public class DefaultRes {

    private boolean status;
    private String messages;

    public DefaultRes(boolean status, String messages) {
        this.status = status;
        this.messages = messages;
    }

    public boolean isStatus() {
        return status;
    }

    public String getMessages() {
        return messages;
    }

}
