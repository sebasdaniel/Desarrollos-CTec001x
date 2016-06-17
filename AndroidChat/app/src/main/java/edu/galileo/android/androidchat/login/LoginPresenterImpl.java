package edu.galileo.android.androidchat.login;

import android.util.Log;

import edu.galileo.android.androidchat.lib.EventBus;
import edu.galileo.android.androidchat.lib.GreenRobotEventBus;
import edu.galileo.android.androidchat.login.events.LoginEvent;

/**
 * Created by m4605 on 15/06/16.
 */
public class LoginPresenterImpl implements LoginPresenter {

    private EventBus eventBus;
    private LoginView loginView;
    private LoginInteractor loginInteractor;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        this.loginInteractor = new LoginInteractorImpl();
        this.eventBus = GreenRobotEventBus.getInstance();
    }

    @Override
    public void onCreate() {
        eventBus.register(this);
    }

    @Override
    public void onDestroy() {
        loginView = null;
        eventBus.unregister(this);
    }

    @Override
    public void checkForAuthenticatedUser() {

        if (loginView != null) {
            loginView.disableInputs();
            loginView.showProgress();
        }

        loginInteractor.checkSession();
    }

    @Override
    public void validateLogin(String email, String password) {

        if (loginView != null) {
            loginView.disableInputs();
            loginView.showProgress();
        }

        loginInteractor.doSingIn(email, password);
    }

    @Override
    public void registerNewUser(String email, String password) {

        if (loginView != null) {
            loginView.disableInputs();
            loginView.showProgress();
        }

        loginInteractor.doSingUp(email, password);
    }

    @Override
    public void onEventMainThread(LoginEvent event) {
        switch (event.getEventType()) {
            case LoginEvent.onSignInError:
                onSignInError(event.getErrorMessage());
                break;
            case LoginEvent.onSignInSuccess:
                onSignInSuccess();
                break;
            case LoginEvent.onSignUpError:
                onSignUpError(event.getErrorMessage());
                break;
            case LoginEvent.onSignUpSuccess:
                onSignUpSuccess();
                break;
            case LoginEvent.onFailedToRecoverSession:
                onFailedToRecoverSession();
                break;
        }
    }

    private void onFailedToRecoverSession() {

        if (loginView != null) {
            loginView.hideProgress();
            loginView.enableInputs();
        }

        Log.e("LoginPresenterImpl", " onFailedToRecoverSession");
    }

    private void onSignInSuccess() {

        if (loginView != null) {
            loginView.navigateToMainScreen();
        }
    }

    private void onSignUpSuccess() {

        if (loginView != null) {
            loginView.newUserSuccess();
        }
    }

    private void onSignInError(String error) {

        if (loginView != null) {
            loginView.hideProgress();
            loginView.enableInputs();
            loginView.loginError(error);
        }
    }

    private void onSignUpError(String error) {

        if (loginView != null) {
            loginView.hideProgress();
            loginView.enableInputs();
            loginView.newUserError(error);
        }
    }
}
