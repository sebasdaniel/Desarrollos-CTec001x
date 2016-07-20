package com.sebasdev.android.currencyconverter.config;

import com.sebasdev.android.currencyconverter.data.local.MyCurrency;

import java.util.List;

/**
 * Created by m4605 on 20/07/16.
 */
public interface ConfigViewInterface {

    void showProgress();
    void hideProgress();
    void loadMainCurrency(MyCurrency currency);
    void loadCurrencies(List<MyCurrency> currencies);
}
