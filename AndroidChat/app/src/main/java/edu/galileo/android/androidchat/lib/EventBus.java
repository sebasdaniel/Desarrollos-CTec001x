package edu.galileo.android.androidchat.lib;

/**
 * Created by m4605 on 16/06/16.
 */
public interface EventBus {

    void register(Object subscriber);
    void unregister(Object subscriber);
    void post(Object event);
}
