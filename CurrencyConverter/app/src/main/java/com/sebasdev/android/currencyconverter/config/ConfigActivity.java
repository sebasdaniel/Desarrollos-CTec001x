package com.sebasdev.android.currencyconverter.config;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.Spinner;

import com.sebasdev.android.currencyconverter.R;
import com.sebasdev.android.currencyconverter.data.local.MyCurrency;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ConfigActivity extends AppCompatActivity implements ConfigViewInterface {


    @BindView(R.id.spinnerMainCurrency)
    private Spinner spinnerMainCurrency;
    @BindView(R.id.recyclerViewConfig)
    private RecyclerView recyclerViewConfig;

    private ProgressDialog progressDialog;
    private List<MyCurrency> currencies;
    private RecyclerView.Adapter adapter;
    private ConfigPresenterInterface presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);
        ButterKnife.bind(this);
    }

    private void setUpProgressDialog() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Cargando");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
    }

    @Override
    public void showProgress() {
        progressDialog.show();
    }

    @Override
    public void hideProgress() {
        progressDialog.hide();
    }

    @Override
    public void loadMainCurrency(MyCurrency currency) {

    }

    @Override
    public void loadCurrencies(List<MyCurrency> currencies) {
        // TODO: 20/07/16 load currencies but show enums in the list and compare them
    }
}
