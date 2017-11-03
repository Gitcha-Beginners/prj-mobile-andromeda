package com.jayhy.gitcha.app.example.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.jayhy.gitcha.app.example.common.CommonValues;

/**
 * Created by jayhy on 2017. 11. 3..
 */

public class DBHelper extends SQLiteOpenHelper {

    private final static int version = 1;

    private final static String TAG = "DBHelper";

    public DBHelper(Context context) {
        super(context, CommonValues.dbPath, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        init(db);
    }

    /**
     *  SQLite 버전 관리
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        switch (oldVersion) {
            case 1:
                init(db);
                break;
        }
    }

    private void init(SQLiteDatabase db) {
        createTableMember(db);
    }

    private void createTableMember(SQLiteDatabase db) {
        String sql = "";
        try {
            sql = "create table member";
            sql += "(";
            sql += "member_idx integer primary key autoincrement not null,";
            sql += "member_id text not null,";
            sql += "member_password text not null";
            sql += ");";
            db.execSQL(sql);
        } catch(Exception e) {
            Log.d(TAG, "createTableMember Exception : " + e.toString());
        } finally {
            if(sql != null) sql = null;
        }
    }
}
