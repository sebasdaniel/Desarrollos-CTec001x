package com.sebasdev.android.currencyconverter.data.remote;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by m4605 on 17/07/16.
 */
public interface ExchangeService {

    @GET("latest")
    Call<ExchangeResponse> getExchageRate(@Query("base") String base);

}
