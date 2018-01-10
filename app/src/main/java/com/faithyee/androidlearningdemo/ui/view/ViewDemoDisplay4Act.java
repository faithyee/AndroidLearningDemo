package com.faithyee.androidlearningdemo.ui.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.faithyee.androidlearningdemo.R;
import com.faithyee.androidlearningdemo.ui.view.practiceDay10.BooheeRuler;
import com.faithyee.androidlearningdemo.ui.view.practiceDay10.RulerCallback;
import com.faithyee.androidlearningdemo.ui.view.practiceDay10.RulerStringUtil;

public class ViewDemoDisplay4Act extends AppCompatActivity {

    private TextView mNum;
    private BooheeRuler mRuler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_view_demo_display4);
        mNum = (TextView) findViewById(R.id.tv_num);
        mRuler = (BooheeRuler) findViewById(R.id.ruler);
        mRuler.setCallback(new RulerCallback() {
            @Override
            public void onScaleChanging(float scale) {
                mNum.setText(RulerStringUtil.resultValueOf(scale, mRuler.getFactor()) + " Kg");
            }
        });
    }
}
