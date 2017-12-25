package com.faithyee.androidlearningdemo.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class Practice11PieChartView extends View {

    private Paint paint = new Paint();

    private static final String TAG = "Practice11PieChartView";

    public Practice11PieChartView(Context context) {
        super(context);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图

//        画饼图
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
        canvas.drawArc(new RectF(200, 0, 800, 600), 180, 133, true, paint);

        paint.setColor(Color.YELLOW);
        canvas.drawArc(new RectF(220, 20, 820, 620), 315, 43, true, paint);

        paint.setColor(Color.WHITE);
        canvas.drawArc(new RectF(220, 20, 820, 620), 0, 15, true, paint);

        paint.setColor(Color.GRAY);
        canvas.drawArc(new RectF(220, 20, 820, 620), 17, 16, true, paint);

        paint.setColor(Color.GREEN);
        canvas.drawArc(new RectF(220, 20, 820, 620), 36, 31, true, paint);

        paint.setColor(Color.BLUE);
        canvas.drawArc(new RectF(220, 20, 820, 620), 70, 108, true, paint);


//        画连线
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(4);
        canvas.drawLine(150, 30, 300, 30, paint);
        canvas.drawLine(300, 30, 330, 50, paint);

        canvas.drawLine(800, 220, 850, 180, paint);
        canvas.drawLine(850, 180, 890, 180, paint);

        canvas.drawLine(820, 330, 840, 330, paint);
        canvas.drawLine(840, 330, 860, 350, paint);
        canvas.drawLine(860, 350, 880, 350, paint);

        canvas.drawLine(805, 456, 830, 456, paint);
        canvas.drawLine(830, 456, 850, 480, paint);
        canvas.drawLine(850, 480, 870, 480, paint);

        canvas.drawLine(387, 565, 300, 565, paint);
        canvas.drawLine(300, 565, 280, 535, paint);
        canvas.drawLine(280, 535, 200, 535, paint);

        canvas.drawLine(711, 562, 722, 580, paint);
        canvas.drawLine(722, 580, 822, 580, paint);

//        字
        paint.setTextSize(28);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText("Lollipop", 75, 30, paint);
        canvas.drawText("Marshmallow", 980, 180, paint);
        canvas.drawText("Gingerbread", 970, 350, paint);
        canvas.drawText("Ice Cream Sandwich", 920, 520, paint);
        canvas.drawText("KitKat", 150, 535, paint);
        canvas.drawText("Jelly Bean", 880, 580, paint);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                break;

            case MotionEvent.ACTION_UP:
                Log.i(TAG,"X==="+event.getX()+",y==="+event.getY());


                break;

            case MotionEvent.ACTION_MOVE:
                break;
        }
        return true;
    }
}
