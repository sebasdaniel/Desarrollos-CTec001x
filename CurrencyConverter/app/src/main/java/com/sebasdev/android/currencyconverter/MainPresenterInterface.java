package com.sebasdev.android.currencyconverter;

/**
 * Created by m4605 on 16/07/16.
 */
public interface MainPresenterInterface {

    void loadConfig();
    void loadCurrentExchangeRates(String currency);
    void convertExchangeCurrencies();
    void showData();
}
