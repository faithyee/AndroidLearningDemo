package com.faithyee.androidlearningdemo.ui.service;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Process;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.faithyee.androidlearningdemo.R;
import com.faithyee.androidlearningdemo.service.LocalService;
import com.faithyee.androidlearningdemo.utils.LogUtils;

public class ServiceActivity extends AppCompatActivity {

    private LocalService.MyBinder myBinder;
    private static final String TAG = "ServiceActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtils.i(TAG, "onCreate, Thread id is "+ Thread.currentThread().getId());
        LogUtils.i(TAG, "process id is " + Process.myPid());
        setContentView(R.layout.activity_service);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("服务");
        setSupportActionBar(toolbar);
    }

    private ServiceConnection connection = new ServiceConnection() {

        @Override
        public void onServiceDisconnected(ComponentName name) {
            LogUtils.i(TAG, "onServiceDisconnected 断开连接了");

        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            myBinder = (LocalService.MyBinder) service;
            LogUtils.i(TAG, "onServiceDisconnected 创建连接了");
        }
    };


    public void start(View v) {
        startService(new Intent(ServiceActivity.this, LocalService.class));
    }

    public void stop(View v) {
        stopService(new Intent(ServiceActivity.this, LocalService.class));
    }

    public void bind(View v) {
        bindService(new Intent(ServiceActivity.this, LocalService.class), connection, BIND_AUTO_CREATE);
    }

    public void unbind(View v) {
        unbindService(connection);
        myBinder = null;
    }

    /**
     * 调用服务startDownload()方法
     * @param v
     */
    public void startDownload(View v){
        if(myBinder!=null){
            myBinder.startDownload();
        }
    }

    /**
     * 调用服务stopDownload()方法
     * @param v
     */
    public void stopDownload(View v){
        if(myBinder!=null){
            myBinder.stopDownload();
        }
    }

}
