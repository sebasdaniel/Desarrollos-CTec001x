package com.sebasdev.android.currencyconverter.main;

import android.widget.Toast;

import com.sebasdev.android.currencyconverter.data.DataInterface;
import com.sebasdev.android.currencyconverter.data.DataResponseInterface;
import com.sebasdev.android.currencyconverter.data.DataSource;
import com.sebasdev.android.currencyconverter.data.local.MyCurrency;
import com.sebasdev.android.currencyconverter.data.remote.ExchangeResponse;
import com.sebasdev.android.currencyconverter.data.remote.Rates;
import com.sebasdev.android.currencyconverter.util.Currencies;

import java.util.List;

/**
 * Created by m4605 on 17/07/16.
 */
public class MainPresenter implements MainPresenterInterface, DataResponseInterface {

    MainViewInterface view;
    DataInterface dataSource;

    List<MyCurrency> currencies;
    MyCurrency mainCurrency;

    public MainPresenter(MainViewInterface view) {
        this.view = view;
        dataSource = new DataSource(this);
    }

    @Override
    public void onCreate() {
        view.showProgress();
        loadConfig();
        String ref = "USD";

        for (MyCurrency currency : currencies) {
            if (currency.isMain()) {
                mainCurrency = currency;
                ref = mainCurrency.getName();
                currencies.remove(currency);
            }
        }

        loadCurrentExchangeRates(ref);
    }

    @Override
    public void loadConfig() {
        currencies = dataSource.getMyCurrencies();
    }

    @Override
    public void loadCurrentExchangeRates(String currency) {
        dataSource.getExchangeCurrencies(currency);
    }

    @Override
    public void convertExchangeCurrencies(double value) {
        for (MyCurrency c : currencies) {
            c.setValue(c.getRate() * value);
        }
        // TODO: 20/07/16 puede ser diferente
        view.setExchangeCurrencies(currencies);
    }

    @Override
    public void showData() {
        view.setMainCurrency(mainCurrency);
        view.setExchangeCurrencies(currencies);
        view.showCurrencies();
    }

    @Override
    public void onExchangeCurrencyLoaded(ExchangeResponse data) {

        view.hideProgress();

        if (currencies.size() == 0) {

            // default set main currency USD and equivalence in EUR
            mainCurrency = new MyCurrency();
            mainCurrency.setName(data.getBase());
            mainCurrency.setMain(true);
            mainCurrency.save();

            MyCurrency exchangeCurrency = new MyCurrency();
            exchangeCurrency.setName(Currencies.EUR.name());
            exchangeCurrency.setMain(false);
            exchangeCurrency.save();

            currencies.add(exchangeCurrency);
        }

        Rates rates = data.getRates();

        for (MyCurrency c : currencies) {
            c.setRate(rates.getValue(c.getName()));
        }

        showData();
    }

    @Override
    public void onError(String error) {
        Toast.makeText((MainActivity) view, "Se produjo error al cargar los datos", Toast.LENGTH_LONG).show();
    }
}
