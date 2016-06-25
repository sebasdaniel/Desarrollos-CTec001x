package edu.galileo.android.androidchat.contactlist.events;

import edu.galileo.android.androidchat.entities.User;

/**
 * Created by m4605 on 19/06/16.
 */
public class ContactListEvent {

    public static final int onContactAdded = 0;
    public static final int onContactChanged = 1;
    public static final int onContactRemove = 2;

    private User user;
    private int eventType;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getEventType() {
        return eventType;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }
}
