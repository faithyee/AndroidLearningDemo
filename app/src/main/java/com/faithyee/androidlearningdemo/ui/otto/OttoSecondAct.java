package com.faithyee.androidlearningdemo.ui.otto;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.faithyee.androidlearningdemo.R;
import com.faithyee.androidlearningdemo.entity.OttoMessage;

public class OttoSecondAct extends AppCompatActivity {

    private EditText ed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_otto_second);
        ed = (EditText) findViewById(R.id.ed);

    }

    public void sendMsg(View v){

        OttoBus.getInstance().post(new OttoMessage(ed.getText().toString().trim()));
        finish();
    }
}


