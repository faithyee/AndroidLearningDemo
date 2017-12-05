package com.faithyee.androidlearningdemo.brocast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import com.faithyee.androidlearningdemo.utils.LogUtils;

/**
 * 动态注册广播，测试网络状态改变
 * Author：yewmf on 2017/12/5 15:15
 * E-mail：faith_yee@163.com
 */
public class NetworkChangeReceiver extends BroadcastReceiver {

    private static final String TAG = "NetworkChangeReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {

        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if(activeNetworkInfo != null && activeNetworkInfo.isAvailable()){
            Toast.makeText(context, "network is available", Toast.LENGTH_SHORT).show();
            LogUtils.i(TAG, "network is available");
        }else {
            Toast.makeText(context, "network is unavailable", Toast.LENGTH_SHORT).show();
            LogUtils.i(TAG, "network is unavailable");
        }

    }
}
