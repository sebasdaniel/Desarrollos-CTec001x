package edu.galileo.android.androidchat.addcontact.ui;

/**
 * Created by m4605 on 26/06/16.
 */
public interface AddContactView {

    void showInput();
    void hideInput();
    void showProgress();
    void hideProgress();
    void contactAdded();
    void contactNotAdded();

}
