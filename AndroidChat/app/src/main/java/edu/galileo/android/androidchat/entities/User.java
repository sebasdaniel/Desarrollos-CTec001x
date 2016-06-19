package edu.galileo.android.androidchat.entities;

import java.util.Map;

/**
 * Created by m4605 on 17/06/16.
 */
public class User {

    String email;
    boolean online;
    Map<String, Boolean> contacts;
    public static final boolean ONLINE = true;
    public static final boolean OFFLINE = true;

    public User() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public Map<String, Boolean> getContacts() {
        return contacts;
    }

    public void setContacts(Map<String, Boolean> contacts) {
        this.contacts = contacts;
    }
}
