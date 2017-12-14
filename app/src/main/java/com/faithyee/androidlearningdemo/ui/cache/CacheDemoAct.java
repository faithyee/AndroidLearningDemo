package com.faithyee.androidlearningdemo.ui.cache;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.faithyee.androidlearningdemo.MainActivity;
import com.faithyee.androidlearningdemo.R;

public class CacheDemoAct extends AppCompatActivity {

    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_cache_demo);

        rv = (RecyclerView) findViewById(R.id.rv);
        GridLayoutManager layoutManager = new GridLayoutManager(CacheDemoAct.this,3);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(layoutManager);
        PhotoWallAdapter adapter = new PhotoWallAdapter(CacheDemoAct.this, Images.imageThumbUrls);
        rv.setAdapter(adapter);

    }
}
