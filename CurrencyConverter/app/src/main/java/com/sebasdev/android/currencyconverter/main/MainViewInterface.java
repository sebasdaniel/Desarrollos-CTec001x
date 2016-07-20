package com.sebasdev.android.currencyconverter.main;

import com.sebasdev.android.currencyconverter.data.local.MyCurrency;

import java.util.List;

/**
 * Created by m4605 on 16/07/16.
 */
public interface MainViewInterface {

    void showProgress();
    void hideProgress();
    void setMainCurrency(MyCurrency currency);
    void setExchangeCurrencies(List<MyCurrency> currencies);
    void showCurrencies();
    //void showCurrencies();
}
