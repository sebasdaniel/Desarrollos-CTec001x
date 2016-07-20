package com.sebasdev.android.currencyconverter.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sebasdev.android.currencyconverter.R;
import com.sebasdev.android.currencyconverter.data.local.MyCurrency;
import com.sebasdev.android.currencyconverter.util.Currencies;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by m4605 on 17/07/16.
 */
public class CurrenciesConfigAdapter extends RecyclerView.Adapter<CurrenciesConfigAdapter.ViewHolder> {

    List<Currencies> currencies;

    public CurrenciesConfigAdapter(List<Currencies> currencies) {
        this.currencies = currencies;
    }

    public void setCurrencies(List<Currencies> currencies) {
        this.currencies = currencies;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_currency_config, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Currencies currentCurrency = currencies.get(position);
        holder.txtMainCurrencyName.setText(currentCurrency.name());
        //holder.txtCurrencyValue.setText(String.valueOf(currentCurrency.getValue()));
    }

    @Override
    public int getItemCount() {
        return currencies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.txtMainCurrencyName)
        TextView txtMainCurrencyName;

        @BindView(R.id.imgFav)
        TextView imgFav;

        private View view;

        public ViewHolder(View itemView) {
            super(itemView);
            this.view = itemView;
            ButterKnife.bind(this, view);
        }

    }
}
