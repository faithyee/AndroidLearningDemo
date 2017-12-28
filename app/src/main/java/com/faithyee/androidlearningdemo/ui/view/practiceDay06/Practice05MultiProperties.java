package com.faithyee.androidlearningdemo.ui.view.practiceDay06;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.faithyee.androidlearningdemo.R;

import static com.faithyee.androidlearningdemo.utils.PixelUtils.dpToPixel;


public class Practice05MultiProperties extends ConstraintLayout {
    Button animateBt;
    ImageView imageView;
    boolean animated = true;

    public Practice05MultiProperties(Context context) {
        super(context);
    }

    public Practice05MultiProperties(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice05MultiProperties(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        animateBt = (Button) findViewById(R.id.animateBt);
        imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setScaleX(0);
        imageView.setScaleY(0);
        imageView.setAlpha(0f);
        animateBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(animated){
                    imageView.animate()
                            .rotation(360)
                            .translationX(dpToPixel(200))
                            .alpha(1f)
                            .scaleX(1.5f)
                            .scaleY(1.5f);
                }else {
                    imageView.animate()
                            .rotation(0)
                            .translationX(0)
                            .alpha(0)
                            .scaleX(0)
                            .scaleY(0);
                }

                animated = !animated;


            }
        });
    }
}
