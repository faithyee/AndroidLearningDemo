package com.faithyee.androidlearningdemo.ui.otto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.faithyee.androidlearningdemo.R;
import com.faithyee.androidlearningdemo.entity.OttoMessage;
import com.squareup.otto.Produce;

public class OttoProduceDemoAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_otto_produce_demo);
        OttoBus.getInstance().register(this);
    }

    @Produce
    public OttoMessage setInitialContent() {
        return new OttoMessage("OttoProduceDemoAct");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        OttoBus.getInstance().unregister(this);
    }
}
