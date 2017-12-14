package com.faithyee.androidlearningdemo.ui.eventBus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.faithyee.androidlearningdemo.R;
import com.faithyee.androidlearningdemo.entity.Message;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class EventBusDemoAct extends AppCompatActivity {

    private TextView result;
    private EditText ed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_event_bus_demo);
        result = (TextView) findViewById(R.id.result);
        ed = (EditText) findViewById(R.id.ed);
    }

    public void startAct(View v){
        startActivity(new Intent(EventBusDemoAct.this, SecondAct.class));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    public void register(View v){

        //注册事件
        EventBus.getDefault().register(this);
    }

    public void unregister(View v){
        //注销事件
        EventBus.getDefault().unregister(this);
    }

    public void postSticky(View v){
        //发送粘性事件
        String stickyMsg = ed.getText().toString().trim();
        EventBus.getDefault().postSticky(new Message(stickyMsg));
    }

    //注册接受eventbus的方法
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(Message messageEvent){
        result.setText(messageEvent.getMessage());
    }
}
