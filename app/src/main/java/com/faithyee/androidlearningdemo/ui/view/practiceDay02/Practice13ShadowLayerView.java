package com.faithyee.androidlearningdemo.ui.view.practiceDay02;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice13ShadowLayerView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Practice13ShadowLayerView(Context context) {
        super(context);
    }

    public Practice13ShadowLayerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice13ShadowLayerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        // 使用 Paint.setShadowLayer() 设置阴影
        setLayerType(LAYER_TYPE_SOFTWARE, null); // 硬件加速下 ComposeShader 不能使用两个同类型的 Shader
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setShadowLayer(30, 0, 0, Color.RED);
        paint.setTextSize(120);
        canvas.drawText("Hello World!!!", 50, 200, paint);
    }
}
