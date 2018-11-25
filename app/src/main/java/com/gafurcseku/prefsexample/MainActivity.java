package com.gafurcseku.prefsexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import io.github.gafurcseku.magicprefs.MagicPrefs;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MagicPrefs magicPrefs = new MagicPrefs(this);
        magicPrefs.setValue("SaveName","Sample Name");
    }
}
