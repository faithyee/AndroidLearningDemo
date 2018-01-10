package com.faithyee.androidlearningdemo.ui.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.faithyee.androidlearningdemo.R;
import com.faithyee.androidlearningdemo.ui.view.practiceDay08.thumbUpview.ThumbUpLayout;
import com.faithyee.androidlearningdemo.ui.view.practiceDay08.thumbUpview.ThumbView;
import com.faithyee.androidlearningdemo.ui.view.practiceDay09.view.ScrollerView;
import com.faithyee.androidlearningdemo.utils.LogUtils;

public class ViewDemoDisplay2Act extends AppCompatActivity {

    private static final String TAG = "ViewDemoDisplay2Act";

    private ThumbUpLayout mThumbUpLayout;
    private EditText edNum;
    private Button mBuntton;
    private ScrollerView mScrollerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_view_demo_display2);

        edNum = (EditText) findViewById(R.id.ed_num);
        mBuntton = (Button) findViewById(R.id.bt_set_num);
        mThumbUpLayout = (ThumbUpLayout)findViewById(R.id.thumbUpView);
        mThumbUpLayout.setThumbUpClickListener(new ThumbView.ThumbUpClickListener() {
            @Override
            public void thumbUpFinish() {
                LogUtils.i(TAG, "点赞");
            }

            @Override
            public void thumbDownFinish() {
                LogUtils.i(TAG, "取消点赞");
            }
        });

        mBuntton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int num = Integer.valueOf(edNum.getText().toString().trim());
                    mThumbUpLayout.setCount(num).setThumbUp(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        mScrollerView = (ScrollerView) findViewById(R.id.sv);
        mScrollerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mScrollerView.smoothScrollTo(-400, 0);
            }
        });
    }
}
