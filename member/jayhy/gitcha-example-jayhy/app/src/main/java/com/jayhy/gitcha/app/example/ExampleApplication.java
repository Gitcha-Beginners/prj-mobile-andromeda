package com.jayhy.gitcha.app.example;

import android.app.Application;
import android.os.Environment;

import com.jayhy.gitcha.app.example.common.CommonValues;

/**
 * Created by jayhy on 2017. 11. 3..
 */

public class ExampleApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        CommonValues.dbPath = Environment.getExternalStorageDirectory() + "/Android/data/" + getApplicationContext().getPackageName() + "/DB.db";
    }
}
