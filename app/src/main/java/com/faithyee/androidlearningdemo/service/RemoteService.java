package com.faithyee.androidlearningdemo.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.faithyee.androidlearningdemo.ui.service.MyAIDLService;
import com.faithyee.androidlearningdemo.utils.LogUtils;

/**
 * 远程Aidl服务demo
 * Created by faith_yee on 2017/12/4.
 */

public class RemoteService extends Service {

    private static final String TAG = "RemoteService";

    //aidl远程服务
    MyAIDLService.Stub iBinder = new MyAIDLService.Stub() {

        @Override
        public String toUpperCase(String str) throws RemoteException {
            String uppercase = str.toUpperCase();
            LogUtils.i(TAG, "RemoteService -> toUpperCase = "+ uppercase);
            return uppercase;
        }
    };


    public RemoteService() {
        super();
        LogUtils.i(TAG, "RemoteService exe");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        LogUtils.i(TAG, "onCreate exe");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        LogUtils.i(TAG, "onStartCommand exe");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtils.i(TAG, "onDestroy exe");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        LogUtils.i(TAG, "onUnbind exe");
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        LogUtils.i(TAG, "onRebind exe");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        LogUtils.i(TAG, "onBind exe");
        return iBinder;
    }


}
