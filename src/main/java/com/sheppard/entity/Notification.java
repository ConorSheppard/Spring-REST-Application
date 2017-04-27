package com.sheppard.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Notification {
    @Id
    @GeneratedValue
    private long _id;

    private int id;
    private int timestamp;
    private String message;
    private boolean read;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public int setTimestamp(int timestamp) {
        return this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public boolean getRead() {
        return read;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long get_Id() {
        return _id;
    }

    public void set_Id(int _id) {
        this._id = _id;
    }

    public void setRead(boolean read) {
        this.read = read;
    }
}
