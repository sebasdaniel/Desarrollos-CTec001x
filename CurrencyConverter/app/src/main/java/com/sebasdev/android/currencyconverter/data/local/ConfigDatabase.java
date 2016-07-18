package com.sebasdev.android.currencyconverter.data.local;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by m4605 on 17/07/16.
 */
@Database(name = ConfigDatabase.NAME, version = ConfigDatabase.VERSION)
public class ConfigDatabase {

    public static final String NAME = "Config";
    public static final int VERSION = 1;
}
