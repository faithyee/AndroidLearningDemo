package com.faithyee.androidlearningdemo.ui.view.practiceDay02;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.EmbossMaskFilter;
import android.graphics.MaskFilter;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.faithyee.androidlearningdemo.R;


public class Practice14MaskFilterView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;

    public Practice14MaskFilterView(Context context) {
        super(context);
    }

    public Practice14MaskFilterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice14MaskFilterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.what_the_fuck);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 用 Paint.setMaskFilter 来设置不同的 BlurMaskFilter

        // 第一个：NORMAL
        MaskFilter normal = new BlurMaskFilter(30, BlurMaskFilter.Blur.NORMAL);
        paint.setMaskFilter(normal);
        canvas.drawBitmap(bitmap, 100, 50, paint);

        // 第二个：INNER
        MaskFilter inner = new BlurMaskFilter(30, BlurMaskFilter.Blur.INNER);
        paint.setMaskFilter(inner);
        canvas.drawBitmap(bitmap, bitmap.getWidth() + 200, 50, paint);

        // 第三个：OUTER
        MaskFilter outer = new BlurMaskFilter(30, BlurMaskFilter.Blur.OUTER);
        paint.setMaskFilter(outer);
        canvas.drawBitmap(bitmap, 100, bitmap.getHeight() + 100, paint);

        // 第四个：SOLID
        MaskFilter solid = new BlurMaskFilter(30, BlurMaskFilter.Blur.SOLID);
        paint.setMaskFilter(solid);
        canvas.drawBitmap(bitmap, bitmap.getWidth() + 200, bitmap.getHeight() + 100, paint);

        // 第五个：EmbossMaskFilter
        float [] direction = {0.4f,0.5f,0.1f};
        MaskFilter embossMaskFilter = new EmbossMaskFilter(direction, 0.5f, 0.5f, 0.5f);
        paint.setMaskFilter(embossMaskFilter);
        canvas.drawBitmap(bitmap, 100, bitmap.getHeight() * 2 + 200, paint);
    }
}
