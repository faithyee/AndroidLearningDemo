package com.faithyee.androidlearningdemo.ui.view.practiveDay08;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.faithyee.androidlearningdemo.R;
import com.faithyee.androidlearningdemo.ui.view.practiveDay08.thumbUpview.ThumbUpLayout;
import com.faithyee.androidlearningdemo.ui.view.practiveDay08.thumbUpview.ThumbView;
import com.faithyee.androidlearningdemo.utils.LogUtils;


public class PracticeThumbUpViewLayout extends LinearLayout {

    private static final String TAG = "PracticeThumbUpViewLayout";

    private ThumbUpLayout mThumbUpLayout;
    private EditText edNum;
    private Button mBuntton;

    public PracticeThumbUpViewLayout(Context context) {
        super(context);
    }

    public PracticeThumbUpViewLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PracticeThumbUpViewLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
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

        mBuntton.setOnClickListener(new OnClickListener() {
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

    }

}
