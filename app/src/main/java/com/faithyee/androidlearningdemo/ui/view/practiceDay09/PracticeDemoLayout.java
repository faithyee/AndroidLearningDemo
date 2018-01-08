package com.faithyee.androidlearningdemo.ui.view.practiceDay09;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.faithyee.androidlearningdemo.R;
import com.faithyee.androidlearningdemo.ui.view.practiceDay09.view.ScrollerView;


public class PracticeDemoLayout extends LinearLayout {

    private static final String TAG = "PracticeThumbUpViewLayout";
    private ScrollerView mScrollerView;


    public PracticeDemoLayout(Context context) {
        super(context);
    }

    public PracticeDemoLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PracticeDemoLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        mScrollerView = findViewById(R.id.sv);
        mScrollerView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                mScrollerView.smoothScrollTo(-400, 0);
            }
        });

    }

}
