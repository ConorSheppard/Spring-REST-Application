package com.sheppard.entity.request;


public class AddNotificationRequest {
    private int id;
    private String message;
    private int timestamp;
    private boolean read;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getTimestamp() {
        return (int) (System.currentTimeMillis() / 1000);
    }

    public boolean getRead() {
        return read;
    }
}
