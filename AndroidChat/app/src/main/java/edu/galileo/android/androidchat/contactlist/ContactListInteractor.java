package edu.galileo.android.androidchat.contactlist;

/**
 * Created by m4605 on 19/06/16.
 */
public interface ContactListInteractor {

    void subscribe();
    void unsubscribe();
    void destroyListener();
    void removeContacts(String email);
}
