package com.faithyee.androidlearningdemo.ui.sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
    private SQLiteDatabase db;
    private TextView selectResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_sqlite_demo);
//
        myDBHelper = new MyDBHelper(SqliteDemoAct.this, "bookStore.db", null, 3);
        myDBHelper.getWritableDatabase();
        db = myDBHelper.getWritableDatabase();

        selectResult = (TextView) findViewById(R.id.select_result);

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


    public void updateData(View v){
        if(myDBHelper == null)
            return;

        ContentValues values = new ContentValues();
        values.put("author", "晓明");
        values.put("name", "黑暗中的星光");
        //更新第n条数据
        String[] whereArgs = {String.valueOf(2)};
        db.update("book", values, "id = ?", whereArgs );
    }

    public void deleteData(View v){
        if(myDBHelper == null)
            return;

        String[] whereArgs = {String.valueOf(3)};
        db.delete("book", "id = ?", whereArgs);
    }

    public void selectDatas(View v){
        if(myDBHelper == null)
            return;

        Cursor cursor = db.query("book", null, null, null, null, null, null);
        StringBuilder builder = new StringBuilder();
        builder.append("查询结果：\n");
        if(cursor.moveToFirst()){
            do{
                String author = cursor.getString(cursor.getColumnIndex("author"));
                builder.append("author:" + author + "/");
                float price = cursor.getFloat(cursor.getColumnIndex("price"));
                builder.append("price:" + price + "/");
                int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                builder.append("pages:" + pages + "/");
                String bookName = cursor.getString(cursor.getColumnIndex("name"));
                builder.append("bookName:" + bookName + "/");
                builder.append("\n");

            }while (cursor.moveToNext());
            cursor.close();
        }

        selectResult.setText(builder.toString());


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
                int mPages = Integer.parseInt(StringUtils.isEmpty(pages.getText().toString().trim())?"0":pages.getText().toString().trim());
                float mPrice = Float.parseFloat(StringUtils.isEmpty(price.getText().toString().trim())?"0":price.getText().toString().trim());
                String mName = name.getText().toString().trim();
                insertBookData(mAuthor, mPages, mPrice, mName);

                dialog.dismiss();
            }
        });
        dialog.setView(view);
        dialog.show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        db.close();
    }
}
