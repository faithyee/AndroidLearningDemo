package com.faithyee.androidlearningdemo.ui.view.practiceDay06;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.faithyee.androidlearningdemo.R;

public class Practice04Alpha extends RelativeLayout {
    Button animateBt;
    ImageView imageView;
    private int status = 0;

    public Practice04Alpha(Context context) {
        super(context);
    }

    public Practice04Alpha(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice04Alpha(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        animateBt = (Button) findViewById(R.id.animateBt);
        imageView = (ImageView) findViewById(R.id.imageView);

        animateBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(final View v) {
                switch (status){
                    case 0:
                        imageView.animate().alpha(0.1f);
                        break;

                    case 1:
                        imageView.animate().alpha(1);
                        break;
                }

                status ++;
                if(status == 2){
                    status = 0;
                }

            }
        });
    }
}