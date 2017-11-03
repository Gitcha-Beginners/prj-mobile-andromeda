package com.jayhy.gitcha.app.example;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.jayhy.gitcha.app.example.databinding.ActivityMainBinding;
import com.jayhy.gitcha.app.example.db.DBManager;

import java.util.HashMap;

/**
 * Created by jayhy on 2017. 11. 3..
 */

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding = null;

    private final static String TAG = "MainActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        DBManager dbManager = new DBManager(this);

        HashMap<String,String> map = dbManager.selectMember();
        Log.d(TAG, "map ==> " + map);

        if(map != null) {
            binding.memberIdx.setText(getResources().getString(R.string.key) + map.get("member_idx"));
            binding.memberId.setText(getResources().getString(R.string.key) + map.get("member_id"));
            binding.memberPassword.setText(getResources().getString(R.string.key) + map.get("member_password"));
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        finish();
    }
}
