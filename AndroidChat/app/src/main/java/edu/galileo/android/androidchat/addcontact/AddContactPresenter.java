package edu.galileo.android.androidchat.addcontact;

/**
 * Created by m4605 on 26/06/16.
 */
public interface AddContactPresenter {

    void onShow();
    void onDestroy();
    void addContact(String email);
    void onEventMainThread(AddContactEvent event);
}
