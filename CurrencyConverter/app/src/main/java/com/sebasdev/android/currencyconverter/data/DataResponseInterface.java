package com.sebasdev.android.currencyconverter.data;

import com.sebasdev.android.currencyconverter.data.remote.ExchangeResponse;

/**
 * Created by m4605 on 17/07/16.
 */
public interface DataResponseInterface {

    void onExchangeCurrencyLoaded(ExchangeResponse data);
    void onError(String error);
}
