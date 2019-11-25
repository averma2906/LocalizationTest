package com.ashish.localizationtest;

import androidx.appcompat.app.AppCompatActivity;
import java.util.*;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.preference.Preference;
import android.util.DisplayMetrics;
import android.content.res.*;
import android.util.Log;
import android.view.View;
public class MainActivity extends AppCompatActivity {


    private Preference preference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        OnClickSetAppLocate("de");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected  void attachBaseContext(Context base)
    {
      super.attachBaseContext(LocaleHelper.onAttach(base));
    }

    private void OnClickSetAppLocate(String locale)
    {
        Resources res = getResources();
        DisplayMetrics displayMetrics = res.getDisplayMetrics();
        Configuration config = res.getConfiguration();
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            config.setLocale(new Locale(locale.toLowerCase()));
            Log.d("Log","I am here1");
        }
        else
        {
            config.locale = new Locale(locale.toLowerCase());
            Log.d("Log","I am here2");
        }



        res.updateConfiguration(config,displayMetrics);

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.N)
        {
            Log.d("Log","locale "+ config.locale.getDisplayLanguage());
        }
        Log.d("Log","I am set");
    }

    public void SetEnglish(View v)
    {
        OnClickSetAppLocate("en");
    }

    public void SetDutch(View v)
    {
        OnClickSetAppLocate("de");
    }

    public void SetRussian(View v){
        OnClickSetAppLocate("ru");
    }
    public void SetHindi(View v){
        OnClickSetAppLocate("hi");
    }

}
