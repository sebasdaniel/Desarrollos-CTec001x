package com.sebasdev.android.currencyconverter.data;

import com.sebasdev.android.currencyconverter.data.local.MyCurrency;
import com.sebasdev.android.currencyconverter.util.Currencies;

import java.util.List;

/**
 * Created by m4605 on 16/07/16.
 */
public interface DataInterface {

    void getExchangeCurrencies(String baseCurrency);
    List<MyCurrency> getMyCurrencies();
    void setMainCurrency(Currencies name);
    void saveNewCurrency(Currencies name);
    void deleteCurrency(Currencies name);
}
