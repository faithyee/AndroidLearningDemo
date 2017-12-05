package com.faithyee.androidlearningdemo.brocast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.faithyee.androidlearningdemo.utils.LogUtils;

/**
 * 静态注册广播
 * Author：yewmf on 2017/12/5 14:40
 * E-mail：faith_yee@163.com
 */
public class MyReceiver extends BroadcastReceiver {

    private static final String TAG = "MyReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "MyReceiver receive msg ! ", Toast.LENGTH_SHORT).show();
        LogUtils.i(TAG, "MyReceiver receiver msg !");
    }
}
