package com.faithyee.androidlearningdemo.ui.broadcast;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.faithyee.androidlearningdemo.R;
import com.faithyee.androidlearningdemo.brocast.NetworkChangeReceiver;

/**
 * brocastReceiver学习
 * 1、动态注册广播
 * 2、注销广播
 * 3、有序广播
 * 4、无序广播
 * 5、本地广播
 */
public class BroadcastDemoAct extends AppCompatActivity {

    private NetworkChangeReceiver networkChangeReceiver;
    private LocalBroadcastManager localBroadcastManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_broadcast_demo);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(networkChangeReceiver != null){
            unregisterReceiver(networkChangeReceiver);
            networkChangeReceiver = null;
        }
    }

    /**
     * 往MyReceiver广播发送消息
     * @param v
     */
    public void send(View v){
        Intent intent = new Intent();
        intent.setAction("com.faithyee.androidlearningdemo.brocast.MyReceiver");
        sendBroadcast(intent);
    }

    /**
     * 注册广播
     * @param v
     */
    public void register(View v){
        IntentFilter intentFilter = new IntentFilter();
        //动态注册广播：监听网络状态变化
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        networkChangeReceiver = new NetworkChangeReceiver();
        registerReceiver(networkChangeReceiver, intentFilter);
    }

    /**
     * 注销广播
     * @param v
     */
    public void unregister(View v){
        if(networkChangeReceiver != null){
            unregisterReceiver(networkChangeReceiver);
            networkChangeReceiver = null;
        }
    }

    /**
     * 注册本地广播，其他app不能拦截
     * @param v
     */
    public void registerLocal(View v){
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        IntentFilter intentFilter = new IntentFilter();
        //动态注册广播：监听网络状态变化
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        networkChangeReceiver = new NetworkChangeReceiver();
        localBroadcastManager.registerReceiver(networkChangeReceiver, intentFilter);

    }

    /**
     * 发送本地广播
     * @param v
     */
    public void sendLocal(View v){
        if(localBroadcastManager != null){
            Intent intent = new Intent("android.net.conn.CONNECTIVITY_CHANGE");
            localBroadcastManager.sendBroadcast(intent);
        }
    }

    /**
     * 注销本地广播
     * @param v
     */
    public void unregisterLocal(View v){
        if(networkChangeReceiver != null){
            localBroadcastManager.unregisterReceiver(networkChangeReceiver);
            networkChangeReceiver = null;
        }
    }

    public void sendOrder(View v){
        Intent intent = new Intent();
        intent.setAction("com.faithyee.androidlearningdemo.brocast.MyReceiver");
        sendOrderedBroadcast(intent, null);
    }


}
