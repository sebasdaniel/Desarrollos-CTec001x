package com.sebasdev.android.currencyconverter.main;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.sebasdev.android.currencyconverter.R;
import com.sebasdev.android.currencyconverter.adapters.CurrenciesAdapter;
import com.sebasdev.android.currencyconverter.data.local.MyCurrency;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainViewInterface {

    @BindView(R.id.txtMainCurrency)
    private TextView txtMainCurrency;

    @BindView(R.id.inputCantidad)
    private EditText inputCantidad;

    @BindView(R.id.btnConvert)
    private Button btnConvert;

    @BindView(R.id.recyclerView)
    private RecyclerView recyclerView;
    
    private ProgressDialog progressDialog;
    private List<MyCurrency> currencies;
    private RecyclerView.Adapter adapter;
    private MainPresenterInterface presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        setUp();

        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBtnConvertClick();
            }
        });

        presenter = new MainPresenter(this);
        presenter.onCreate();
    }
    
    private void setUp() {
        setUpProgressDialog();
        //setUpRecyclerView();
    }

    private void setUpProgressDialog() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Cargando");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
    }

    private void setUpRecyclerView() {
        //adapter = new CurrenciesAdapter(null);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
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
    public void setMainCurrency(MyCurrency currency) {
        txtMainCurrency.setText(currency.getName());
        inputCantidad.setText("1");
    }

    @Override
    public void setExchangeCurrencies(List<MyCurrency> currencies) {
        this.currencies = currencies;
    }

    @Override
    public void showCurrencies() {
        adapter = new CurrenciesAdapter(currencies);
        setUpRecyclerView();
    }

    private void onBtnConvertClick() {
        // TODO: 20/07/16 se puede usar el llamado a convert del presenter
        double exchange = Double.parseDouble(inputCantidad.getText().toString());
        for (MyCurrency currency : currencies) {
            currency.setValue(currency.getRate()*exchange);
        }
    }
}
