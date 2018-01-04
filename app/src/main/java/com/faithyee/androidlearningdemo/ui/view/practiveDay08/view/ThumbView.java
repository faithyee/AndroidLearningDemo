package com.faithyee.androidlearningdemo.ui.view.practiveDay08.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.OvershootInterpolator;

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

    private boolean mIsThumbUp;
    private long mLastStartTime;
    //点击的回调
    private ThumbUpClickListener mThumbUpClickListener;

    //被点击的次数，未点击时，未点赞是0，点赞是1，所以点完之后的次数是偶数则就是未点赞，奇数就是点赞
    private int mClickCount;
    private int mEndCount;
    private AnimatorSet mThumbUpAnim;


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

        mRadiusMax = Math.max(mCirclePoint.x - getPaddingLeft(), mCirclePoint.y - getPaddingTop());
        mRadiusMin = TulUtils.dip2px(getContext(), 8);//这个值是根据点击效果调整得到的
        mClipPath = new Path();
        mClipPath.addCircle(mCirclePoint.x, mCirclePoint.y, mRadiusMax, Path.Direction.CW);
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

    public void setIsThumbUp(boolean isThumbUp) {
        this.mIsThumbUp = isThumbUp;
        mClickCount = mIsThumbUp ? 1 : 0;
        mEndCount = mClickCount;
        postInvalidate();
    }

    public boolean isThumbUp() {
        return mIsThumbUp;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mIsThumbUp) {
            if (mClipPath != null) {
                canvas.save();
                canvas.clipPath(mClipPath);
                canvas.drawBitmap(mShining, mShiningPoint.x, mShiningPoint.y, mBitmapPaint);
                canvas.restore();
                canvas.drawCircle(mCirclePoint.x, mCirclePoint.y, mRadius, mCirclePaint);
            }
            canvas.drawBitmap(mThumbUp, mThumbPoint.x, mThumbPoint.y, mBitmapPaint);
        } else {
            canvas.drawBitmap(mThumbNormal, mThumbPoint.x, mThumbPoint.y, mBitmapPaint);
        }
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

    public void setThumbUpClickListener(ThumbUpClickListener thumbUpClickListener) {
        this.mThumbUpClickListener = thumbUpClickListener;
    }

    public interface ThumbUpClickListener {
        //点赞回调
        void thumbUpFinish();

        //取消回调
        void thumbDownFinish();
    }

    public void startAnim() {

        mClickCount++;

        boolean isFastAnim = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - mLastStartTime < 300) {//这个300毫秒是通过设置动画的总时间而算出来的。
            isFastAnim = true;
        }
        mLastStartTime = currentTimeMillis;

        if (mIsThumbUp) {
            if (isFastAnim) {//点击间隔过快，这样每次都会执行该startFastAnim方法
                startFastAnim();
                return;
            }
            startThumbDownAnim();
            mClickCount = 0;
        } else {
            if (mThumbUpAnim != null) {//只要点击过快，动画未执行完，ThumbUpAnim对象就没来得及置空
                mClickCount = 0;
            } else {
                startThumbUpAnim();
                mClickCount = 1;
            }
        }
        mEndCount = mClickCount;
    }

    private void startFastAnim() {
        ObjectAnimator thumbUpScale = ObjectAnimator.ofFloat(this, "thumbUpScale", SCALE_MIN, SCALE_MAX);
        thumbUpScale.setDuration(SCALE_DURING);
        thumbUpScale.setInterpolator(new OvershootInterpolator());

        ObjectAnimator circleScale = ObjectAnimator.ofFloat(this, "circleScale", mRadiusMin, mRadiusMax);
        circleScale.setDuration(RADIUS_DURING);

        AnimatorSet set = new AnimatorSet();
        set.play(thumbUpScale).with(circleScale);
        set.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                //点击过快的关键逻辑,即点击过快数次之后，点击停止后，判断多次点击后的次数是单还是双
                mEndCount++;
                if (mClickCount != mEndCount) {
                    return;
                }
                if (mClickCount % 2 == 0) {
                    startThumbDownAnim();//偶数，即取消点赞
                } else {
                    if (mThumbUpClickListener != null) {
                        mThumbUpClickListener.thumbUpFinish();//奇数，点赞成功
                    }
                }
            }
        });
        set.start();
    }

    /**
     * 点赞动画
     */
    private void startThumbUpAnim() {
        ObjectAnimator notThumbUpScale = ObjectAnimator.ofFloat(this, "notThumbUpScale", SCALE_MAX, SCALE_MIN);
        notThumbUpScale.setDuration(SCALE_DURING);
        notThumbUpScale.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                mIsThumbUp = true;
            }
        });

        ObjectAnimator thumbUpScale = ObjectAnimator.ofFloat(this, "thumbUpScale", SCALE_MIN, SCALE_MAX);
        thumbUpScale.setDuration(SCALE_DURING);
        thumbUpScale.setInterpolator(new OvershootInterpolator());

        ObjectAnimator circleScale = ObjectAnimator.ofFloat(this, "circleScale", mRadiusMin, mRadiusMax);
        circleScale.setDuration(RADIUS_DURING);

        mThumbUpAnim = new AnimatorSet();
        mThumbUpAnim.play(thumbUpScale).with(circleScale);
        mThumbUpAnim.play(thumbUpScale).after(notThumbUpScale);
        mThumbUpAnim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                mThumbUpAnim = null;//!!!
                if (mThumbUpClickListener != null) {
                    mThumbUpClickListener.thumbUpFinish();
                }
            }
        });
        mThumbUpAnim.start();
    }

    private void setNotThumbUpScale(float scale) {
        Matrix matrix = new Matrix();
        matrix.postScale(scale, scale);
        mThumbNormal = BitmapFactory.decodeResource(getResources(), R.drawable.ic_messages_like_unselected);
        mThumbNormal = Bitmap.createBitmap(mThumbNormal, 0, 0, mThumbNormal.getWidth(), mThumbNormal.getHeight(),
                matrix, true);
        postInvalidate();
    }

    private void setThumbUpScale(float scale) {
        Matrix matrix = new Matrix();
        matrix.postScale(scale, scale);
        mThumbUp = BitmapFactory.decodeResource(getResources(), R.drawable.ic_messages_like_selected);
        mThumbUp = Bitmap.createBitmap(mThumbUp, 0, 0, mThumbUp.getWidth(), mThumbUp.getHeight(),
                matrix, true);
        postInvalidate();
    }

    /**
     * 水纹效果，可以重复学习!!
     * @param radius
     */
    public void setCircleScale(float radius) {
        mRadius = radius;
        mClipPath = new Path();
        mClipPath.addCircle(mCirclePoint.x, mCirclePoint.y, mRadius, Path.Direction.CW);
        float fraction = (mRadiusMax - radius) / (mRadiusMax - mRadiusMin);//fraction在(0,1)之间
        mCirclePaint.setColor((int) TulUtils.evaluate(fraction, START_COLOR, END_COLOR));
        postInvalidate();
    }

    /**
     * 取消点赞动画
     */
    private void startThumbDownAnim() {
        ObjectAnimator thumbUpScale = ObjectAnimator.ofFloat(this, "thumbUpScale", SCALE_MIN, SCALE_MAX);
        thumbUpScale.setDuration(SCALE_DURING);
        thumbUpScale.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                mIsThumbUp = false;
                setNotThumbUpScale(SCALE_MAX);
                if (mThumbUpClickListener != null) {
                    mThumbUpClickListener.thumbDownFinish();
                }
            }
        });
        thumbUpScale.start();
    }

}
