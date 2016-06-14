package edu.galileo.android.androidchat;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;

import java.util.Map;

/**
 * Created by Azuan on 14/06/2016.
 */
public class FirebaseHelper {

    private Firebase dataReference;
    private static final String SEPARATOR = "___";
    private static final String CHATS_PATH = "chats";
    private static final String USERS_PATH = "users";
    private static final String CONTACTS_PATH = "contact";
    private static final String FIREBASE_URL = "url de firebase aqui";

    private static class SingletonHolder {
        private static final FirebaseHelper INSTANCE = new FirebaseHelper();
    }

    public FirebaseHelper getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public FirebaseHelper() {
        this.dataReference = new Firebase(FIREBASE_URL);
    }

    public Firebase getDataReference() {
        return dataReference;
    }

    public String getAuthUserEmail() {
        AuthData authData = dataReference.getAuth();
        String email = null;
        if (authData != null) {
            Map<String, Object> providerData = authData.getProviderData();
            email = providerData.get("email").toString();
        }
        return email;
    }
}
