package com.sebasdev.android.currencyconverter.data;

import com.raizlabs.android.dbflow.sql.language.Select;
import com.sebasdev.android.currencyconverter.data.DataInterface;
import com.sebasdev.android.currencyconverter.data.DataResponseInterface;
import com.sebasdev.android.currencyconverter.data.local.MyCurrency;
import com.sebasdev.android.currencyconverter.data.remote.ExchangeClient;
import com.sebasdev.android.currencyconverter.data.remote.ExchangeResponse;
import com.sebasdev.android.currencyconverter.data.remote.ExchangeService;
import com.sebasdev.android.currencyconverter.util.Currencies;

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
    public void setMainCurrency(Currencies name) {
        List<MyCurrency> currencyList = new Select().from(MyCurrency.class).queryList();

        for (MyCurrency currency : currencyList) {

            if (currency.isMain() && !currency.getName().equals(name.name())) {
                currency.setMain(false);
            }

            if (currency.getName().equals(name.name())) {
                currency.setMain(true);
            }

        }
    }

    @Override
    public void saveNewCurrency(Currencies name) {
        MyCurrency currency = new MyCurrency();
        currency.setName(name.name());
        currency.setMain(false);
    }

    @Override
    public void deleteCurrency(Currencies name) {
        List<MyCurrency> currencyList = new Select().from(MyCurrency.class).queryList();

        for (MyCurrency currency : currencyList) {
            if (currency.getName().equals(name.name())) {
                currency.delete();
                return;
            }
        }
    }

}
