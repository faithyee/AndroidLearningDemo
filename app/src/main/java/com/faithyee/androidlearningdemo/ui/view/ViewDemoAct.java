package com.faithyee.androidlearningdemo.ui.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.faithyee.androidlearningdemo.R;

public class ViewDemoAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_view_demo);
    }

    public void display(View v) {
        startActivity(new Intent(ViewDemoAct.this, ViewDemoDisplayAct.class));
    }

    public void gesture(View v) {
        startActivity(new Intent(ViewDemoAct.this, ViewDemoDisplay2Act.class));
    }

    public void scroller(View v) {
        startActivity(new Intent(ViewDemoAct.this, ViewDemoDisplay3Act.class));
    }

    public void booheeRuler(View v){
        startActivity(new Intent(ViewDemoAct.this, ViewDemoDisplay4Act.class));
    }


}
