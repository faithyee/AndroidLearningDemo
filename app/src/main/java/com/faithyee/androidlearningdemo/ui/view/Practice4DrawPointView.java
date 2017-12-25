package com.faithyee.androidlearningdemo.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice4DrawPointView extends View {

    private Paint paint = new Paint();
    private float[] points = {200,600,300,600,400,600,500,600,200,700,300,700,400,700,500,700};

    public Practice4DrawPointView(Context context) {
        super(context);
    }

    public Practice4DrawPointView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice4DrawPointView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawPoint() 方法画点
//        一个圆点，一个方点
//        圆点和方点的切换使用 paint.setStrokeCap(cap)：`ROUND` 是圆点，`BUTT` 或 `SQUARE` 是方点

        paint.setStrokeWidth(80);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setColor(Color.GRAY);
        paint.setAntiAlias(true);
        canvas.drawPoint(200, 200, paint);

        paint.setStrokeCap(Paint.Cap.SQUARE);
        canvas.drawPoint(400, 200, paint);

        paint.setStrokeCap(Paint.Cap.BUTT);
        canvas.drawPoint(200, 400, paint);

        paint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawPoint(400, 400, paint);

        canvas.drawPoints(points,paint);
    }
}
