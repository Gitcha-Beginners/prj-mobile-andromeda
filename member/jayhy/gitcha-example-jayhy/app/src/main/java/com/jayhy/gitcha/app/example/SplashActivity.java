package com.jayhy.gitcha.app.example;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by jayhy on 2017. 11. 3..
 */

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        setTheme(R.style.AppTheme);

        super.onCreate(savedInstanceState);

        Intent intent = null;
        try {
            intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
        } finally {
            if(intent != null) intent = null;
        }
    }


}
