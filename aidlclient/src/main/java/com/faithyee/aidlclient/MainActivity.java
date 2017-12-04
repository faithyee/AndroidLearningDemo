package com.faithyee.aidlclient;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.faithyee.androidlearningdemo.ui.service.MyAIDLService;

import utils.LogUtils;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private MyAIDLService iMyAidlInterface;
//
    private ServiceConnection conn = new ServiceConnection() {
        //绑定上服务的时候
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            //接受到了远程的服务
            LogUtils.i(TAG, "onServiceConnected: ");
            iMyAidlInterface = MyAIDLService.Stub.asInterface(iBinder);

        }

        // 当服务断开的时候调用
        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            LogUtils.i(TAG, "onServiceDisconnected: ");
            //回收资源
            iMyAidlInterface = null;

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void plus(View v){
        try {
            iMyAidlInterface.plus(1,2);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void uppercase(View v){
        try {
            iMyAidlInterface.toUpperCase("hello");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void conn(View v){
        //获取到服务端, 5.0 之后必须显示绑定服务
        Intent intent = new Intent();
//        intent.setComponent(new ComponentName("com.faithyee.androidlearningdemo.service"
//                , "com.faithyee.androidlearningdemo.service.RemoteService"));
        intent.setAction("com.faithyee.androidlearningdemo.service.RemoteService");
        //从 Android 5.0开始 隐式Intent绑定服务的方式已不能使用,所以这里需要设置Service所在服务端的包名
//        intent.setPackage("com.faithyee.androidlearningdemo.service");
        intent.setClassName("com.faithyee.androidlearningdemo.service","com.faithyee.androidlearningdemo.service.RemoteService");
        bindService(intent, conn, BIND_AUTO_CREATE);
//        LogUtils.i(TAG, "bindServce: bind on end");
    }
}
