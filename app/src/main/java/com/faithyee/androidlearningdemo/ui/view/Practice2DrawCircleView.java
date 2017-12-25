package com.faithyee.androidlearningdemo.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.faithyee.androidlearningdemo.R;


public class Practice2DrawCircleView extends View {

//    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);初始化时设置抗锯齿
    Paint paint = new Paint();
    Path path = new Path();
    Path path2 = new Path();
    Path path3 = new Path();
    Path path4 = new Path();

    public Practice2DrawCircleView(Context context) {
        super(context);
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawCircle() 方法画圆

//        一共四个圆：1.实心圆 2.空心圆 3.蓝色实心圆 4.线宽为 20 的空心圆
        drawSolidCircle(canvas);

        drawHollowCircle(canvas);

        drawSolidCircle2(canvas);

        drawHollowCircle2(canvas);


    }

    //空心圆
    private void drawHollowCircle2(Canvas canvas) {
        paint.setColor(Color.GRAY);
        paint.setAntiAlias(true);//抗锯齿
        path4.addCircle(720, 500, 160, Path.Direction.CW);
        path4.addCircle(720, 500, 110, Path.Direction.CCW);
        canvas.drawPath(path4, paint);
    }

    //实心圆
    private void drawSolidCircle2(Canvas canvas) {
        paint.setColor(getResources().getColor(R.color.colorPrimary));
        paint.setAntiAlias(true);//抗锯齿
        paint.setStyle(Paint.Style.FILL);
        path3.addCircle(350, 500, 150, Path.Direction.CW);
        canvas.drawPath(path3, paint);
    }

    //空心圆
    private void drawHollowCircle(Canvas canvas) {
        paint.setColor(Color.GRAY);
        paint.setAntiAlias(true);//抗锯齿
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(4);// 线条宽度为 4 像素
        path2.addCircle(720, 160, 150, Path.Direction.CW);
        canvas.drawPath(path2, paint);
    }

    //实心圆
    private void drawSolidCircle(Canvas canvas) {
        paint.setColor(Color.GRAY);
        paint.setAntiAlias(true);//抗锯齿
        paint.setStyle(Paint.Style.FILL);
        path.addCircle(350, 160, 150, Path.Direction.CW);
        canvas.drawPath(path, paint);
    }
}
