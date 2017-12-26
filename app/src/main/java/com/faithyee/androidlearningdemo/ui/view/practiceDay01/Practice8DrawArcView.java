package com.faithyee.androidlearningdemo.ui.view.practiceDay01;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice8DrawArcView extends View {

    private Paint paint = new Paint();
    private RectF part1 = new RectF(300, 120, 680, 300);
    private RectF part2 = new RectF(290, 60, 670, 290);
    private RectF part3 = new RectF(310, 50, 690, 310);

    public Practice8DrawArcView(Context context) {
        super(context);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawArc() 方法画弧形和扇形
        paint.setColor(Color.GRAY);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setStrokeWidth(10);
        canvas.drawArc(part1, 0, 180, true, paint);

        paint.setStrokeWidth(1);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawArc(part2, 180, 60, false, paint);

        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawArc(part3, 240, 100, true, paint);


    }
}
