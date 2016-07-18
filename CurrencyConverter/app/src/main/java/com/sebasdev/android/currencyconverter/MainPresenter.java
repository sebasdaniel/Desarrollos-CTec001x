package com.sebasdev.android.currencyconverter;

import com.sebasdev.android.currencyconverter.data.DataResponseInterface;
import com.sebasdev.android.currencyconverter.data.local.MyCurrency;
import com.sebasdev.android.currencyconverter.data.remote.ExchangeResponse;
import com.sebasdev.android.currencyconverter.data.remote.Rates;

import java.util.List;

/**
 * Created by m4605 on 17/07/16.
 */
public class MainPresenter implements MainPresenterInterface, DataResponseInterface {

    MainViewInterface view;
    DataInterface dataSource;

    public MainPresenter(MainViewInterface view) {
        this.view = view;
        dataSource = new DataSource(this);
    }

    @Override
    public void loadConfig() {

    }

    @Override
    public void loadCurrentExchangeRates(String currency) {

    }

    @Override
    public void convertExchangeCurrencies() {

    }

    @Override
    public void showData() {

    }

    @Override
    public void onExchangeCurrencyLoaded(ExchangeResponse data) {
        List<MyCurrency> currencies = dataSource.getMyCurrencies();

        if (currencies.size() == 0) {

            // default set main currency USD and equivalence in EUR
            MyCurrency mainCurrency = new MyCurrency();
            mainCurrency.setName(data.getBase());
            mainCurrency.setMain(true);
            mainCurrency.save();

            MyCurrency exchangeCurrency = new MyCurrency();
            exchangeCurrency.setName(Currencies.EUR.name());
            exchangeCurrency.setMain(false);
            exchangeCurrency.save();

            currencies.add(mainCurrency);
            currencies.add(exchangeCurrency);

        }

        Rates rates = data.getRates();

        for (MyCurrency c : currencies) {
            c.setRate(rates.getValue(c.getName()));
        }
    }

    @Override
    public void onError(String error) {

    }
}
