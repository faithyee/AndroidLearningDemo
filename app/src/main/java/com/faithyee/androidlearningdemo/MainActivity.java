package com.faithyee.androidlearningdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.faithyee.androidlearningdemo.ui.service.ServiceActivity;

public class MainActivity extends AppCompatActivity {

    private String[] datas = {
      "服务","广播"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rv = (RecyclerView) findViewById(R.id.rv);
        GridLayoutManager layoutManager = new GridLayoutManager(MainActivity.this,3);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(layoutManager);
        RvAdapter adapter = new RvAdapter(datas);
        rv.setAdapter(adapter);
        adapter.setOnItemClickListener(new RvAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                switch (position){
                    case 0:
                        // TODO: 2017/12/4 服务demo
                        startActivity(new Intent(MainActivity.this, ServiceActivity.class));
                        break;

                    case 1:
                        // TODO: 2017/12/4 广播demo
                        break;
                }

            }
        });



    }
}
