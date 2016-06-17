package edu.galileo.android.androidchat.login;

/**
 * Created by m4605 on 14/06/16.
 */
public interface LoginRepository {

    void signUp(String email, String password);
    void signIn(String email, String password);
    void checkSession();
}
