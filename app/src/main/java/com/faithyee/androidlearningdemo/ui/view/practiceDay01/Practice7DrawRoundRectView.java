package com.faithyee.androidlearningdemo.ui.view.practiceDay01;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice7DrawRoundRectView extends View {

    private Paint paint = new Paint();
    private RectF rectF = new RectF(300, 200, 700, 400);

    public Practice7DrawRoundRectView(Context context) {
        super(context);
    }

    public Practice7DrawRoundRectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice7DrawRoundRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawRoundRect() 方法画圆角矩形

        paint.setColor(Color.GRAY);
        paint.setStrokeWidth(12);
        paint.setAntiAlias(true);
        canvas.drawRoundRect(rectF, 40, 40, paint);
    }
}
