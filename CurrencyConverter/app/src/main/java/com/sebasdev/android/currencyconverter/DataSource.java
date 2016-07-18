package com.sebasdev.android.currencyconverter;

import com.raizlabs.android.dbflow.sql.language.Select;
import com.sebasdev.android.currencyconverter.data.DataResponseInterface;
import com.sebasdev.android.currencyconverter.data.local.MyCurrency;
import com.sebasdev.android.currencyconverter.data.remote.ExchangeClient;
import com.sebasdev.android.currencyconverter.data.remote.ExchangeResponse;
import com.sebasdev.android.currencyconverter.data.remote.ExchangeService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by m4605 on 17/07/16.
 */
public class DataSource implements DataInterface {

    private DataResponseInterface event;

    public DataSource(DataResponseInterface event) {
        this.event = event;
    }

    @Override
    public void getExchangeCurrencies(String baseCurrency) {
        ExchangeService service = new ExchangeClient().getExchangeService();

        Call<ExchangeResponse> call = service.getExchageRate(baseCurrency);
        call.enqueue(new Callback<ExchangeResponse>() {
            @Override
            public void onResponse(Call<ExchangeResponse> call, Response<ExchangeResponse> response) {
                ExchangeResponse data = response.body();
                event.onExchangeCurrencyLoaded(data);
            }

            @Override
            public void onFailure(Call<ExchangeResponse> call, Throwable t) {
                event.onError(t.getMessage());
            }
        });
    }

    @Override
    public List<MyCurrency> getMyCurrencies() {
        List<MyCurrency> currencyList = new Select().from(MyCurrency.class).queryList();
        return currencyList;
    }

    @Override
    public void saveMyCurrency() {

    }
}
