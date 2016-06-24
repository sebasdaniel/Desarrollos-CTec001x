package edu.galileo.android.androidchat.contactlist.ui.adapters;

import edu.galileo.android.androidchat.entities.User;

/**
 * Created by m4605 on 23/06/16.
 */
public interface OnItemClickListener {

    void onItemClick(User user);
    void onItemLongClick(User user);
}
