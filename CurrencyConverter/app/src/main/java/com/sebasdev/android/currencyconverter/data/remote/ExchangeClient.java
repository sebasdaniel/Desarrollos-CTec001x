package com.sebasdev.android.currencyconverter.data.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by m4605 on 17/07/16.
 */
public class ExchangeClient {

    private Retrofit retrofit;
    private final static String BASE_URL = "http://api.fixer.io/";

    public ExchangeClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public ExchangeService getExchangeService() {
        return retrofit.create(ExchangeService.class);
    }
}
