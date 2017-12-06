package com.faithyee.androidlearningdemo.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.faithyee.androidlearningdemo.utils.LogUtils;

/**
 * Author：yewmf on 2017/12/6 09:47
 * E-mail：faith_yee@163.com
 */
public class MyDBHelper extends SQLiteOpenHelper {

    private static final String TAG = "MyDBHelper";

    private final static String CREATE_BOOK = "create table book (" +
            "id integer primary key autoincrement, " +
            "author text, " +
            "price real, " +
            "pages integer, " +
            "name text)";

    private final static String CREATE_CATEGORY = "create table category (" +
            "id integer primary key autoincrement, " +
            "category_name, " +
            "category_code integer)";



    private Context mContext;


    /**
     * @param context
     * @param name 表名
     * @param factory to use for creating cursor objects, or null for the default
     * @param version 数据表版本号，1开始
     */
    public MyDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_BOOK);
        db.execSQL(CREATE_CATEGORY);
        LogUtils.i(TAG, "bookStore.db create successed!");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists book");
        db.execSQL("drop table if exists category");

        onCreate(db);
    }
}
