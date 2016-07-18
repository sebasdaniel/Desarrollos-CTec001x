package com.sebasdev.android.currencyconverter.data.local;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by m4605 on 17/07/16.
 */
@Table(database = ConfigDatabase.class)
public class MyCurrency extends BaseModel {

    @Column
    @PrimaryKey
    private String name;

    @Column
    private double rate;

    @Column
    private double value;

    @Column
    private boolean main;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

//    public boolean getMain() {
//        return main;
//    }

    public boolean isMain() {
        return main;
    }

    public void setMain(boolean main) {
        this.main = main;
    }

}
