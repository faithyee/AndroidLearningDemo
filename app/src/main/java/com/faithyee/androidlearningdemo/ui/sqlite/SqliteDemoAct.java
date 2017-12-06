package com.faithyee.androidlearningdemo.ui.sqlite;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.faithyee.androidlearningdemo.R;
import com.faithyee.androidlearningdemo.database.MyDBHelper;
import com.faithyee.androidlearningdemo.utils.StringUtils;

/**
 * sqlite学习类
 * 1、sqlite管理类
 * 2、sqlite 建表
 * 3、sqlite 增删查改
 * 4、sqlite 封装
 * adb命令：
 * 1、复制文件到sd卡：cp xx.db /mnt/sdcard/xx.db
 */
public class SqliteDemoAct extends AppCompatActivity {

    private static final String TAG = "SqliteDemoAct";
    private MyDBHelper myDBHelper;

    private final static String INSERT_DATA = "insert into book values (4,'你好',360,50.5,'SQL教程')";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_sqlite_demo);
//

    }

    public void createDB(View v){
        //执行getWritableDatabase，DBHelper的oncreate回调才执行
        myDBHelper = new MyDBHelper(SqliteDemoAct.this, "bookStore.db", null, 1);
        myDBHelper.getWritableDatabase();
    }

    public void updateDB(View v){
        myDBHelper = new MyDBHelper(SqliteDemoAct.this, "bookStore.db", null, 3);
        myDBHelper.getWritableDatabase();
    }

    public void insertData(View v){
        showBookInsertDialog();
    }

    public void insertBookData(String author, int pages, float price, String name){
        if(myDBHelper == null)
            return;

        SQLiteDatabase db = myDBHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("author", author);
        values.put("pages", pages);
        values.put("price", price);
        values.put("name", name);
        db.insert("book",null, values);
    }


    public void insertDataSql(View v){
//        SQLiteDatabase db = myDBHelper.getWritableDatabase();
//        db.execSQL(INSERT_DATA);
    }

    public void showBookInsertDialog(){

        final AlertDialog.Builder builder = new AlertDialog.Builder(SqliteDemoAct.this);
        final AlertDialog dialog = builder.create();
        View view = LayoutInflater.from(SqliteDemoAct.this).inflate(R.layout.dialog_book_insert, null);
        final EditText author = view.findViewById(R.id.author);
        final EditText price = view.findViewById(R.id.price);
        final EditText pages = view.findViewById(R.id.pages);
        final EditText name = view.findViewById(R.id.name);
        Button sure = view.findViewById(R.id.sure);
        sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String  mAuthor = author.getText().toString().trim();
                int mPages = Integer.parseInt(StringUtils.isEmpty(pages.getText().toString().trim())?"0":"");
                float mPrice = Float.parseFloat(StringUtils.isEmpty(price.getText().toString().trim())?"0":"");
                String mName = name.getText().toString().trim();
                insertBookData(mAuthor, mPages, mPrice, mName);

                dialog.dismiss();
            }
        });
        dialog.setView(view);
        dialog.show();
    }
}
