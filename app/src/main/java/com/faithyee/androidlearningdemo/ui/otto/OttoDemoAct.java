package com.faithyee.androidlearningdemo.ui.otto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.faithyee.androidlearningdemo.R;
import com.faithyee.androidlearningdemo.entity.OttoMessage;
import com.squareup.otto.Subscribe;

public class OttoDemoAct extends AppCompatActivity {

    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_otto_demo);
        result = (TextView) findViewById(R.id.result);

    }

    public void register(View v){
        OttoBus.getInstance().register(this);
    }

    public void unregister(View v){
        OttoBus.getInstance().unregister(this);
    }

    public void startAct(View v){
        startActivity(new Intent(OttoDemoAct.this, OttoSecondAct.class));
    }

    public void startProduce(View v){
        startActivity(new Intent(OttoDemoAct.this, OttoProduceDemoAct.class));
    }

    @Subscribe
    public void setContent(OttoMessage data) {
        result.setText(data.getMessage());
    }

}
