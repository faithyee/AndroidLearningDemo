package com.faithyee.androidlearningdemo.ui.view.practiveDay08.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.faithyee.androidlearningdemo.R;

/**
 * Author：yewmf on 2018/1/2 10:18
 * E-mail：faith_yee@163.com
 */
public class ThumbView extends View {

    //圆圈颜色
    private static final int START_COLOR = Color.parseColor("#00e24d3d");
    private static final int END_COLOR = Color.parseColor("#88e24d3d");
    //缩放动画的时间
    private static final int SCALE_DURING = 150;
    //圆圈扩散动画的时间
    private static final int RADIUS_DURING = 100;

    private static final float SCALE_MIN = 0.9f;
    private static final float SCALE_MAX = 1f;

    private Bitmap mThumbUp;
    private Bitmap mShining;
    private Bitmap mThumbNormal;
    private Paint mBitmapPaint;

    private float mThumbWidth;
    private float mThumbHeight;
    private float mShiningWidth;
    private float mShiningHeight;

    private TulPoint mShiningPoint;
    private TulPoint mThumbPoint;
    private TulPoint mCirclePoint;

    private float mRadiusMax;
    private float mRadiusMin;
    private float mRadius;
    private Path mClipPath;
    private Paint mCirclePaint;


    public ThumbView(Context context) {
        this(context, null);
    }

    public ThumbView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ThumbView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        initBitmapInfo();

        mCirclePaint = new Paint();
        mCirclePaint.setAntiAlias(true);
        mCirclePaint.setStyle(Paint.Style.STROKE);
        mCirclePaint.setStrokeWidth(TulUtils.dip2px(getContext(), 2));

        mCirclePoint = new TulPoint();
        mCirclePoint.x = mThumbPoint.x + mThumbWidth / 2;
        mCirclePoint.y = mThumbPoint.y + mThumbHeight / 2;
    }

    private void initBitmapInfo() {
        mBitmapPaint = new Paint();
        mBitmapPaint.setAntiAlias(true);

        resetBitmap();

        mThumbWidth = mThumbUp.getWidth();
        mThumbHeight = mThumbUp.getHeight();

        mShiningWidth = mShining.getWidth();
        mShiningHeight = mShining.getHeight();

        mShiningPoint = new TulPoint();
        mThumbPoint = new TulPoint();
        //这个相对位置是在布局中试出来的
        mShiningPoint.x = getPaddingLeft() + TulUtils.dip2px(getContext(), 2);
        mShiningPoint.y = getPaddingTop();
        mThumbPoint.x = getPaddingLeft();
        mThumbPoint.y = getPaddingTop() + TulUtils.dip2px(getContext(), 8);
    }

    private void resetBitmap() {
        mThumbUp = BitmapFactory.decodeResource(getResources(), R.drawable.ic_messages_like_selected);
        mThumbNormal = BitmapFactory.decodeResource(getResources(), R.drawable.ic_messages_like_unselected);
        mShining = BitmapFactory.decodeResource(getResources(), R.drawable.ic_messages_like_selected_shining);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        if (mIsThumbUp) {
//            if (mClipPath != null) {
//                canvas.save();
//                canvas.clipPath(mClipPath);
//                canvas.drawBitmap(mShining, mShiningPoint.x, mShiningPoint.y, mBitmapPaint);
//                canvas.restore();
//                canvas.drawCircle(mCirclePoint.x, mCirclePoint.y, mRadius, mCirclePaint);
//            }
//            canvas.drawBitmap(mThumbUp, mThumbPoint.x, mThumbPoint.y, mBitmapPaint);
//        } else {
//            canvas.drawBitmap(mThumbNormal, mThumbPoint.x, mThumbPoint.y, mBitmapPaint);
//        }
        canvas.drawBitmap(mThumbNormal, mThumbPoint.x, mThumbPoint.y, mBitmapPaint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(
                TulUtils.getDefaultSize(widthMeasureSpec, getContentWidth() + getPaddingLeft() + getPaddingRight()),
                TulUtils.getDefaultSize(heightMeasureSpec, getContentHeight() + getPaddingTop() + getPaddingBottom())
        );
    }

    private int getContentWidth() {
        float minLeft = Math.min(mShiningPoint.x, mThumbPoint.x);
        float maxRight = Math.max(mShiningPoint.x + mShiningWidth, mThumbPoint.x + mThumbWidth);
        return (int) (maxRight - minLeft);
    }

    private int getContentHeight() {
        float minTop = Math.min(mShiningPoint.y, mThumbPoint.y);
        float maxBottom = Math.max(mShiningPoint.y + mShiningHeight, mThumbPoint.y + mThumbHeight);
        return (int) (maxBottom - minTop);
    }

    public TulPoint getCirclePoint() {
        return mCirclePoint;
    }


}
