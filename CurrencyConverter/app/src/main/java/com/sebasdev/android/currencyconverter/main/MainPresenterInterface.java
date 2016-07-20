package com.sebasdev.android.currencyconverter.main;

/**
 * Created by m4605 on 16/07/16.
 */
public interface MainPresenterInterface {

    void onCreate();
    void loadConfig();
    void loadCurrentExchangeRates(String currency);
    void convertExchangeCurrencies(double value);
    void showData();
}
