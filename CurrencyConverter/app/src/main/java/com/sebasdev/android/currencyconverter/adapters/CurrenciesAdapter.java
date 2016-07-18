package com.sebasdev.android.currencyconverter.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sebasdev.android.currencyconverter.R;
import com.sebasdev.android.currencyconverter.data.local.MyCurrency;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by m4605 on 17/07/16.
 */
public class CurrenciesAdapter extends RecyclerView.Adapter<CurrenciesAdapter.ViewHolder> {

    List<MyCurrency> currencies;

    public CurrenciesAdapter(List<MyCurrency> currencies) {
        this.currencies = currencies;
    }

    public void setCurrencies(List<MyCurrency> currencies) {
        this.currencies = currencies;
        notifyDataSetChanged();
    }

    public void removeCurrency(MyCurrency currency) {
        currencies.remove(currency);
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_currrency_main, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MyCurrency currentCurrency = currencies.get(position);
        holder.txtMainCurrencyName.setText(currentCurrency.getName());
        holder.txtCurrencyValue.setText(String.valueOf(currentCurrency.getValue()));
    }

    @Override
    public int getItemCount() {
        return currencies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.txtMainCurrencyName)
        TextView txtMainCurrencyName;

        @BindView(R.id.txtCurrencyValue)
        TextView txtCurrencyValue;

        private View view;

        public ViewHolder(View itemView) {
            super(itemView);
            this.view = itemView;
            ButterKnife.bind(this, view);
        }

    }
}
