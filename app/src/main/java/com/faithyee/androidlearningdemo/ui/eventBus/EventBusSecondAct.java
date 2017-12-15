package com.faithyee.androidlearningdemo.ui.eventBus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.faithyee.androidlearningdemo.R;
import com.faithyee.androidlearningdemo.entity.EventBusMessage;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class EventBusSecondAct extends AppCompatActivity {

    private EditText ed;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_event_bus_second);
        ed = (EditText) findViewById(R.id.ed);
        result = (TextView) findViewById(R.id.result);
        EventBus.getDefault().register(this);
    }

    public void sendMsg(View v){
        String str = ed.getText().toString().trim();
        EventBus.getDefault().post(new EventBusMessage("我是从SecondAct来的消息：" + str));
    }

    //类似广播，该Act注册了Event，并且定义可该方法，就能接受来之EventBusDemoAct的粘性消息
    @Subscribe(threadMode = ThreadMode.POSTING,sticky = true)
    public void onStickyEvent(EventBusMessage eventBusMessageEvent){
        result.setText(eventBusMessageEvent.getMessage());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
