package com.jayhy.gitcha.app.example.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.HashMap;

/**
 * Created by jayhy on 2017. 11. 3..
 */

public class DBManager {

    private SQLiteDatabase db = null;
    private Context context = null;

    private String tbl_member = "member";

    private final static String TAG = "DBManager";

    public DBManager(Context context) {
        Log.d(TAG, "DBManager context ==> " + context);
        this.context = context;
        this.open();
    }

    public void open() throws SQLException {
        try {
            db = (new DBHelper(context).getWritableDatabase());
        } catch (SQLException e) {
            db = (new DBHelper(context).getReadableDatabase());
        }
    }

    public long insertMember(String id, String passwd) {
        long result = 0;
        ContentValues values = null;

        try {
            values = new ContentValues();
            values.put("member_id", id);
            values.put("member_password", passwd);

            result = db.insert(tbl_member,
                    null,
                    values);
        } catch (Exception e) {
            Log.d(TAG, "insertMember Exception : " + e.toString());
            result = 0;
        } finally {
            if(values != null) values = null;
        }

        return result;
    }

    public int updateMember(String id, String passwd) {
        int result = 0;
        try {
            ContentValues values = new ContentValues();
            values.put("member_id", id);
            values.put("member_password", passwd);
            db.update(tbl_member,
                    values,
                    "member_idx = ?",
                    new String[] {String.valueOf("1")});
        } catch (Exception e) {
            result = -1;
            Log.d(TAG, "updateMember Exception : "+e.toString());
        }
        return result;
    }


    public boolean isExistMember() {
        boolean result = false;

        Cursor cursor = null;
        String sql = "";
        try {
            sql += "select member_idx from ";
            sql += tbl_member;
            cursor = db.rawQuery(sql, null);
            if (cursor.getCount() > 0) result = true;

        } catch (Exception e) {
            Log.d(TAG, "isExistMember Exception : "+e.toString());
        } finally {
            if (cursor != null) {
                cursor.close();
                cursor = null;
            }

            if(sql != null) sql = null;
        }

        return result;
    }

    public HashMap<String,String> selectMember() {
        HashMap<String, String> result = new HashMap<>();
        Cursor cursor = null;
        try {
            String sql = "";
            sql += "select member_idx, member_id, member_password from ";
            sql += tbl_member;
//            sql += " where idx = "1";

            cursor = db.rawQuery(sql, null);
            if (cursor.getCount()>0) cursor.moveToNext();

            if(cursor.getCount() == 1) {
                result.put("member_idx", cursor.getString(0));
                result.put("member_id", cursor.getString(1));
                result.put("member_password", cursor.getString(2));
            } else {
//                for (int i=0; i<cursor.getCount(); i++) {
//
///
//                    result.put("member_id", cursor.getString(0));
    //                result.put("member_password", cursor.getString(1));

//                    cursor.moveToNext();
//                }
            }

        } catch (Exception e) {
            Log.d(TAG, "selectLocalAttachAllList Exception : "+e.toString());
        } finally {
            if (cursor!=null) cursor.close();
            cursor = null;
        }

        return result;
    }


}
