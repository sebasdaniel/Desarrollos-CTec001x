package edu.galileo.android.androidchat.login;

/**
 * Created by m4605 on 14/06/16.
 */
public interface LoginInteractor {

    void checkSession();
    void doSingUp(String email, String password);
    void doSingIn(String email, String password);
}
