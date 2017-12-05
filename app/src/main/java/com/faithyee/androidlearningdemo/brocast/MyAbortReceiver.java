package com.faithyee.androidlearningdemo.brocast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.faithyee.androidlearningdemo.utils.LogUtils;

/**
 * 测试拦截广播
 */
public class MyAbortReceiver extends BroadcastReceiver {

    private static final String TAG = "MyAbortReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "msg is aborted !", Toast.LENGTH_SHORT).show();
        LogUtils.i(TAG, "msg is aborted !");
        abortBroadcast();
    }
}
