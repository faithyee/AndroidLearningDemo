package com.faithyee.androidlearningdemo.ui.view.practiceDay02;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ComposePathEffect;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.DiscretePathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.PathEffect;
import android.graphics.SumPathEffect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice12PathEffectView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Path path = new Path();

    public Practice12PathEffectView(Context context) {
        super(context);
    }

    public Practice12PathEffectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice12PathEffectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        paint.setStyle(Paint.Style.STROKE);

        path.moveTo(50, 100);
        path.rLineTo(50, 100);
        path.rLineTo(80, -150);
        path.rLineTo(100, 100);
        path.rLineTo(70, -120);
        path.rLineTo(150, 80);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 使用 Paint.setPathEffect() 来设置不同的 PathEffect

        // 第一处：CornerPathEffect
        PathEffect cornerPathEffect = new CornerPathEffect(20);
        paint.setPathEffect(cornerPathEffect);
        paint.setStrokeWidth(2);
        canvas.drawPath(path, paint);


        // 第二处：DiscretePathEffect
        canvas.save();
        canvas.translate(500, 0);
        PathEffect discretePathEffect = new DiscretePathEffect(12, 3);
        paint.setPathEffect(discretePathEffect);
        canvas.drawPath(path, paint);
        canvas.restore();

        // 第三处：DashPathEffect
        canvas.save();
        canvas.translate(0, 200);
        PathEffect dashPathEffect = new DashPathEffect(new float[]{2f, 5f, 10f, 2f}, 0);
        paint.setPathEffect(dashPathEffect);
        canvas.drawPath(path, paint);
        canvas.restore();

//        canvas.save();
//        canvas.translate(500, 0);
//        // 第四处：PathDashPathEffect
//        Path path = new Path();
//        path.addCircle(10, 10, 10, Path.Direction.CW);
////        path
//        PathEffect pathDashPathEffect = new PathDashPathEffect(path, 2, 0, PathDashPathEffect.Style.ROTATE);
//        paint.setPathEffect(pathDashPathEffect);
//        canvas.drawPath(path, paint);
//        canvas.restore();

        canvas.save();
        canvas.translate(0, 400);
        // 第五处：SumPathEffect
        PathEffect sumPathEffect = new SumPathEffect(cornerPathEffect, discretePathEffect);
        paint.setPathEffect(sumPathEffect);
        canvas.drawPath(path, paint);
        canvas.restore();

        canvas.save();
        canvas.translate(500, 400);
        PathEffect composePathEffect = new ComposePathEffect(cornerPathEffect, discretePathEffect);
        paint.setPathEffect(composePathEffect);
        // 第六处：ComposePathEffect
        canvas.drawPath(path, paint);
        canvas.restore();
    }
}
