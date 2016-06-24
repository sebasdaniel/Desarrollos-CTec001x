package edu.galileo.android.androidchat.contactlist;

/**
 * Created by m4605 on 19/06/16.
 */
public interface ContactListSessionInteractor {

    void singOff();
    String getCurrentUserEmail();
    void changeConnectionStatus(boolean online);
}
