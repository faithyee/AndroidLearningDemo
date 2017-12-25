package com.faithyee.androidlearningdemo.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice10HistogramView extends View {

    private Paint paint = new Paint();
    private Path path = new Path();
    private String[] str = {"Froyo","GB","ICS","JB","KitKat","L","M"};

    public Practice10HistogramView(Context context) {
        super(context);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图
        paint.setStrokeWidth(1);
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);


//        画框框
        path.moveTo(100, 10);
        path.lineTo(100, 600);
        path.lineTo(1000,600);
        canvas.drawPath(path, paint);

//        条形图
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawRect(120, 598, 220, 599, paint);
        canvas.drawRect(240, 590, 340, 599, paint);
        canvas.drawRect(350, 590, 450, 599, paint);
        canvas.drawRect(460, 520, 560, 599, paint);
        canvas.drawRect(570, 450, 670, 599, paint);
        canvas.drawRect(680, 350, 780, 599, paint);
        canvas.drawRect(790, 520, 890, 599, paint);

//        字
        paint.setColor(Color.WHITE);
        paint.setTextSize(26);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(str[0], 170, 630, paint);
        canvas.drawText(str[1], 280, 630, paint);
        canvas.drawText(str[2], 400, 630, paint);
        canvas.drawText(str[3], 510, 630, paint);
        canvas.drawText(str[4], 620, 630, paint);
        canvas.drawText(str[5], 730, 630, paint);
        canvas.drawText(str[6], 840, 630, paint);



    }
}
