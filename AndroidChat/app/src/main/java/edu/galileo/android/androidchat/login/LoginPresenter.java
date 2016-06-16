package edu.galileo.android.androidchat.login;

/**
 * Created by m4605 on 14/06/16.
 */
public interface LoginPresenter {

    void onDestroy();
    void checkForAuthenticatedUser();
    void validateLogin(String email, String password);
    void registerNewUser(String email, String password);
}
