package com.faithyee.aidlclient;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.faithyee.androidlearningdemo.ui.service.MyAIDLService;

import java.util.List;

import utils.LogUtils;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private MyAIDLService iMyAidlInterface;
    private TextView tv;
    private EditText ed;

    ServiceConnection conn = new ServiceConnection() {
        //绑定上服务的时候
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            //接受到了远程的服务
            LogUtils.i(TAG, "onServiceConnected");
            iMyAidlInterface = MyAIDLService.Stub.asInterface(iBinder);

        }

        // 当服务断开的时候调用
        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            LogUtils.i(TAG, "onServiceDisconnected");
            //回收资源
            iMyAidlInterface = null;

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed = (EditText) findViewById(R.id.ed);
        tv = (TextView) findViewById(R.id.tv);
    }

    /**
     * 调用远程服务方法
     * @param v
     */
    public void uppercase(View v){
            if(iMyAidlInterface != null){
                final String result = ed.getText().toString().trim();
                try {
                    tv.setText("结果：" +iMyAidlInterface.toUpperCase(result));
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }else {
                Toast.makeText(MainActivity.this, "断开未连接", Toast.LENGTH_SHORT).show();
            }
    }

    public void conn(View v){
        Intent mIntent = new Intent();
        mIntent.setAction("com.faithyee.androidlearningdemo.service.RemoteService");
        Intent eintent = new Intent(getExplicitIntent(this,mIntent));
        bindService(eintent, conn, Context.BIND_AUTO_CREATE);
        LogUtils.i(TAG, "conn exe()");
    }

    public void disconn(View v){
        unbindService(conn);
        //回收资源
        iMyAidlInterface = null;
        LogUtils.i(TAG, "disconn exe()");
    }

    /**
     * 因为android 5.0 不允许隐形启用service 所有用getExplicitIntent转一下
     * @param context
     * @param implicitIntent
     * @return
     */
    public static Intent getExplicitIntent(Context context, Intent implicitIntent) {
        // Retrieve all services that can match the given intent
        PackageManager pm = context.getPackageManager();
        List<ResolveInfo> resolveInfo = pm.queryIntentServices(implicitIntent, 0);
        // Make sure only one match was found
        if (resolveInfo == null || resolveInfo.size() != 1) {
            return null;
        }
        // Get component info and create ComponentName
        ResolveInfo serviceInfo = resolveInfo.get(0);
        String packageName = serviceInfo.serviceInfo.packageName;
        String className = serviceInfo.serviceInfo.name;
        ComponentName component = new ComponentName(packageName, className);
        // Create a new intent. Use the old one for extras and such reuse
        Intent explicitIntent = new Intent(implicitIntent);
        // Set the component to be explicit
        explicitIntent.setComponent(component);
        return explicitIntent;
    }
}
