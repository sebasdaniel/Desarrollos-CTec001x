package edu.galileo.android.androidchat.contactlist;

/**
 * Created by m4605 on 24/06/16.
 */
public class ContactListSessionInteractorImpl implements ContactListSessionInteractor {

    ContactListRepository repository;

    public ContactListSessionInteractorImpl() {
        repository = new ContactListRepositoryImpl();
    }

    @Override
    public void singOff() {
        repository.signOff();
    }

    @Override
    public String getCurrentUserEmail() {
        return repository.getCurrentUserEmail();
    }

    @Override
    public void changeConnectionStatus(boolean online) {
        repository.changeConnectionStatus(online);
    }
}
