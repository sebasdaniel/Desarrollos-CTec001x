package edu.galileo.android.androidchat;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by m4605 on 13/06/16.
 */
public class AndroidChatApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        setupFirebase();
    }

    private void setupFirebase() {
        Firebase.setAndroidContext(this);
        Firebase.getDefaultConfig().setPersistenceEnabled(true);
    }
}
