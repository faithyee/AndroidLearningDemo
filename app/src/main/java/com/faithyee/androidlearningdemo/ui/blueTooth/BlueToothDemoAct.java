package com.faithyee.androidlearningdemo.ui.blueTooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.faithyee.androidlearningdemo.R;
import com.faithyee.androidlearningdemo.utils.LogUtils;

import java.util.Set;

public class BlueToothDemoAct extends AppCompatActivity {

    private static final int REQUEST_ENABLE = 0x1;
    private static final String BLUETOOTH_NAME = "faith_yee";//指定搜索的设备名
    private BluetoothAdapter mBluetoothAdapter;
    private static final String TAG = "BlueToothDemoAct";
    private BlueToothReceiver mBluetoothReceiver;
    private AlertDialog progress;
    private AlertDialog.Builder builder;
    private TextView devicesResult;
    private StringBuffer sb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_blue_tooth_demo);

        builder = new AlertDialog.Builder(BlueToothDemoAct.this);
        progress = builder.create();
        builder.setCancelable(false);
        View view = LayoutInflater.from(BlueToothDemoAct.this).inflate(R.layout.dialog_progress, null);
        view.findViewById(R.id.stopSearch).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBluetoothAdapter.cancelDiscovery();
                progress.dismiss();

                devicesResult.setText(sb.toString());
            }
        });
        progress.setView(view);

        //获取蓝牙适配器
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        registerBlueToothReceiver();

        devicesResult = (TextView) findViewById(R.id.devices_result);
        sb = new StringBuffer();

    }

    public void open(View v){
        if(!mBluetoothAdapter.isEnabled()){
            //弹出对话框提示用户是后打开
//            Intent enabler = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
//            startActivityForResult(enabler, REQUEST_ENABLE);
            //不做提示，直接打开，不建议用下面的方法，有的手机会有问题。
            // mBluetoothAdapter.enable();

            //开启蓝牙时设置蓝牙可见性
            if (mBluetoothAdapter.getScanMode() !=
                    BluetoothAdapter.SCAN_MODE_CONNECTABLE_DISCOVERABLE) {
                Intent discoverableIntent = new Intent(
                        BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                discoverableIntent.putExtra(
                        BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 120);
                startActivity(discoverableIntent);
            }
        }
    }

    public void checkLocal(View v){
        //获取本机蓝牙名称
        String name = mBluetoothAdapter.getName();
        //获取本机蓝牙地址
        String address = mBluetoothAdapter.getAddress();
        LogUtils.i(TAG, "bluetooth name ="+name+" address ="+address);

        //获取已配对蓝牙设备
        Set<BluetoothDevice> devices = mBluetoothAdapter.getBondedDevices();
        LogUtils.i(TAG, "bonded device size ="+devices.size());
        for(BluetoothDevice bonddevice:devices){
            LogUtils.i(TAG, "bonded device name ="+bonddevice.getName()+" address"+bonddevice.getAddress());
        }
    }

    public void search(View v){
        sb.replace(0,sb.length(),"");
        devicesResult.setText(sb.toString());
        mBluetoothAdapter.startDiscovery();
        progress.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_ENABLE){

        }
    }

    /**
     * 注册搜索蓝牙设备广播
     */
    public void registerBlueToothReceiver(){
        mBluetoothReceiver = new BlueToothReceiver();
        IntentFilter filter = new IntentFilter();
        //发现设备
        filter.addAction(BluetoothDevice.ACTION_FOUND);
        //设备连接状态改变
        filter.addAction(BluetoothDevice.ACTION_BOND_STATE_CHANGED);
        //蓝牙设备状态改变
        filter.addAction(BluetoothAdapter.ACTION_STATE_CHANGED);
        registerReceiver(mBluetoothReceiver, filter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mBluetoothReceiver != null){
            unregisterReceiver(mBluetoothReceiver);
        }
    }

    /**
     * 蓝牙广播
     */
    class BlueToothReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            LogUtils.i(TAG,"mBluetoothReceiver action ="+action);
            if(BluetoothDevice.ACTION_FOUND.equals(action)){//每扫描到一个设备，系统都会发送此广播。
                //获取蓝牙设备
                BluetoothDevice scanDevice = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                if(scanDevice == null || scanDevice.getName() == null) return;
                LogUtils.i(TAG, "name="+scanDevice.getName()+"/address="+scanDevice.getAddress());
                sb.append("name="+scanDevice.getName()+"/address="+scanDevice.getAddress() + "\n");
                //蓝牙设备名称
                String name = scanDevice.getName();
                if(name != null && name.equals(BLUETOOTH_NAME)){
                    mBluetoothAdapter.cancelDiscovery();
                    progress.dismiss();
                    //取消扫描
//                    mProgressDialog.setTitle(getResources().getString(R.string.progress_connecting));                   //连接到设备。
//                    mBlthChatUtil.connect(scanDevice);
                }
            }else if (BluetoothAdapter.ACTION_DISCOVERY_FINISHED.equals(action)){

            }
        }
    }

}
