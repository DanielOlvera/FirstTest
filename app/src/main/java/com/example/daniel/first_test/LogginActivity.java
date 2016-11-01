package com.example.daniel.first_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LogginActivity extends AppCompatActivity {

    private static final String LOG_FRAGMENT = "LogFragmentTAG_";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loggin);

        LogFragment logFragment = new LogFragment();
        getSupportFragmentManager().beginTransaction().add(logFragment, LOG_FRAGMENT);

    }
}
