package com.faithyee.androidlearningdemo.service;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.faithyee.androidlearningdemo.R;
import com.faithyee.androidlearningdemo.ui.service.MyAIDLService;
import com.faithyee.androidlearningdemo.utils.LogUtils;

/**
 * 本地服务demo
 * Author：yewmf on 2017/12/4 10:50
 * E-mail：faith_yee@163.com
 */
public class LocalService extends Service {

    private static final String TAG = "LocalService";

    //本地远程服务
    private MyBinder mBinder = new MyBinder();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        LogUtils.i(TAG, "onBind");
        return mBinder;
    }

    public LocalService() {
        super();
        LogUtils.i(TAG, "LocalService");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        LogUtils.i(TAG, "onCreate, Thread id is " + Thread.currentThread().getId());
        LogUtils.i(TAG, "process id is " + Process.myPid());
        startForegroundService();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        LogUtils.i(TAG, "onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtils.i(TAG, "onDestroy");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        LogUtils.i(TAG, "onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        LogUtils.i(TAG, "onRebind");
    }

    /**
     * 本地服务
     */
    public class MyBinder extends Binder {

        public void startDownload() {
            LogUtils.i(TAG, "startDownload() executed");
        }

        public void stopDownload() {
            LogUtils.i(TAG, "stopDownload() executed");
        }

    }

    /**
     * 注册前台服务
     */
    public void startForegroundService() {
        //实例化NotificationCompat.Builde并设置相关属性
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                //设置小图标
                .setSmallIcon(R.mipmap.ic_launcher)
                //设置通知标题
                .setContentTitle("最简单的Notification")
                //设置通知内容
                .setContentText("只有小图标、标题、内容");
        //设置通知时间，默认为系统发出通知的时间，通常不用设置
        //.setWhen(System.currentTimeMillis());
        //通过builder.build()方法生成Notification对象,并发送通知,id=1
        Notification notification = builder.build();
        //注册为前端服务
        startForeground(1, notification);

    }

}
