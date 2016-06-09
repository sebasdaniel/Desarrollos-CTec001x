package edu.galileo.android.tipcalc;

import android.app.Application;

/**
 * Created by m4605 on 6/06/16.
 */
public class TipCalcApp extends Application {

    private static final String ABOUT_URL = "http://about.me/adriancatalan";

    public String getAboutUrl() {
        return ABOUT_URL;
    }
}
