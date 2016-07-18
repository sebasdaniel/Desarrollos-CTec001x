package com.sebasdev.android.currencyconverter;

import android.app.Application;

import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;

/**
 * Created by m4605 on 17/07/16.
 */
public class CurrencyConverterApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initDB();
    }

    private void initDB() {
        FlowManager.init(new FlowConfig.Builder(this).build());
    }
}
