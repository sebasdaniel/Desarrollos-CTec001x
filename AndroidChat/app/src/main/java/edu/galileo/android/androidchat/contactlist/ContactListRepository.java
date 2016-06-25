package edu.galileo.android.androidchat.contactlist;

/**
 * Created by m4605 on 19/06/16.
 */
public interface ContactListRepository {

    void signOff();
    String getCurrentUserEmail();
    void removeContact(String email);
    void destroyListener();
    void subscribeToContactListEvents();
    void unsubscribeToContactListEvents();
    void checkConnectionStatus(boolean online);

    void changeConnectionStatus(boolean online);
}
