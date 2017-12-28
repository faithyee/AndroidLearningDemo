package com.faithyee.androidlearningdemo.ui.view.practiceDay06;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.faithyee.androidlearningdemo.R;


public class Practice03Scale extends RelativeLayout {
    Button animateBt;
    ImageView imageView;

    private int state = 0;

    public Practice03Scale(Context context) {
        super(context);
    }

    public Practice03Scale(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice03Scale(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        animateBt = (Button) findViewById(R.id.animateBt);
        imageView = (ImageView) findViewById(R.id.imageView);

        animateBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                switch (state){
                    case 0:
                        imageView.animate().scaleX(1.5f);
                        break;
                    case 1:
                        imageView.animate().scaleX(1f);
                        break;
                    case 2:
                        imageView.animate().scaleY(1.5f);
                        break;
                    case 3:
                        imageView.animate().scaleY(1f);
                        break;
                    case 4:
                        imageView.animate().scaleX(1.5f);
                        imageView.animate().scaleY(1.5f);
                        break;
                    case 5:
                        imageView.animate().scaleX(1f);
                        imageView.animate().scaleY(1f);
                        break;
                }
                state++;
                if(state == 6){
                    state = 0;
                }

            }
        });
    }
}
