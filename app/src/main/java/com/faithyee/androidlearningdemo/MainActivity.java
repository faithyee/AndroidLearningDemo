package com.faithyee.androidlearningdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.faithyee.androidlearningdemo.ui.otto.OttoDemoAct;
import com.faithyee.androidlearningdemo.ui.blueTooth.BlueToothDemoAct;
import com.faithyee.androidlearningdemo.ui.broadcast.BroadcastDemoAct;
import com.faithyee.androidlearningdemo.ui.cache.CacheDemoAct;
import com.faithyee.androidlearningdemo.ui.eventBus.EventBusDemoAct;
import com.faithyee.androidlearningdemo.ui.network.NetworkDemoAct;
import com.faithyee.androidlearningdemo.ui.okhttp.OkhttpDemoAct;
import com.faithyee.androidlearningdemo.ui.retrofit.RetrofitDemoAct;
import com.faithyee.androidlearningdemo.ui.rxjava.RxJavaDemoAct;
import com.faithyee.androidlearningdemo.ui.service.ServiceDemoAct;
import com.faithyee.androidlearningdemo.ui.sqlite.SqliteDemoAct;
import com.faithyee.androidlearningdemo.ui.volley.VolleyDemoAct;

public class MainActivity extends AppCompatActivity {

    private String[] datas = {
      "服务","广播","Sqlite", "蓝牙", "HttpURLConnection",
            "Volley","okhttp","retrofit2","RxJava","三级缓存",
            "EventBus","OttoBus"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);

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
                        //服务demo
                        startActivity(new Intent(MainActivity.this, ServiceDemoAct.class));
                        break;

                    case 1:
                        //广播demo
                        startActivity(new Intent(MainActivity.this, BroadcastDemoAct.class));
                        break;

                    case 2:
                        //sqlite demo
                        startActivity(new Intent(MainActivity.this, SqliteDemoAct.class));
                        break;

                    case 3:
                        //蓝牙demo
                        startActivity(new Intent(MainActivity.this, BlueToothDemoAct.class));
                        break;

                    case 4:
                        //HttpURLConnection
                        startActivity(new Intent(MainActivity.this, NetworkDemoAct.class));
                        break;

                    case 5:
                        //volley demo
                        startActivity(new Intent(MainActivity.this, VolleyDemoAct.class));
                        break;

                    case 6:
                        //okhttp demo
                        startActivity(new Intent(MainActivity.this, OkhttpDemoAct.class));
                        break;

                    case 7:
                        //retrofit2 demo
                        startActivity(new Intent(MainActivity.this, RetrofitDemoAct.class));
                        break;

                    case 8:
                        //rxjava demo
                        startActivity(new Intent(MainActivity.this, RxJavaDemoAct.class));
                        break;

                    case 9:
                        //cache demo
                        startActivity(new Intent(MainActivity.this, CacheDemoAct.class));
                        break;

                    case 10:
                        //eventBus demo
                        startActivity(new Intent(MainActivity.this, EventBusDemoAct.class));
                        break;

                    case 11:
                        //otto demo
                        startActivity(new Intent(MainActivity.this, OttoDemoAct.class));
                        break;


                }

            }
        });



    }

}
