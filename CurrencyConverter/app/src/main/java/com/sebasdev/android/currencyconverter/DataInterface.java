package com.sebasdev.android.currencyconverter;

import com.sebasdev.android.currencyconverter.data.local.MyCurrency;

import java.util.List;

/**
 * Created by m4605 on 16/07/16.
 */
public interface DataInterface {

    void getExchangeCurrencies(String baseCurrency);
    List<MyCurrency> getMyCurrencies();
    void saveMyCurrency();
}
