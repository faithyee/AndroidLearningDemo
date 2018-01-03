package com.faithyee.androidlearningdemo.ui.view.practiveDay08.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.faithyee.androidlearningdemo.R;

/**
 * Author：yewmf on 2018/1/2 10:17
 * E-mail：faith_yee@163.com
 */
public class CountView extends View {

    public static final String DEFAULT_TEXT_COLOR = "#cccccc";//灰色
    public static final float DEFAULT_TEXT_SIZE = 15f;
    private static final int COUNT_ANIM_DURING = 250;

    private Paint mTextPaint;
    private float mTextSize;
    private int mTextColor;
    private int mEndTextColor;

    private int mNum;
    private String[] mTexts;//mTexts[0]是不变的部分，mTexts[1]原来的部分，mTexts[2]变化后的部分
    private TulPoint[] mTextPoints;//表示各部分的坐标

    private float mMaxOffsetY;
    private float mMinOffsetY;

    private float mOldOffsetY;
    private float mNewOffsetY;
    private float mFraction;

    private boolean mCountToBigger;

    public CountView(Context context) {
        this(context, null);
    }

    public CountView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CountView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CountView);
        mNum = typedArray.getInt(R.styleable.CountView_cv_count, 0);
        mTextColor = typedArray.getColor(R.styleable.CountView_cv_text_color, Color.parseColor(DEFAULT_TEXT_COLOR));
        mTextSize = typedArray.getDimension(R.styleable.CountView_cv_text_size, TulUtils.sp2px(context, 15f));
        typedArray.recycle();
        init();
    }

    private void init() {
        mTexts = new String[3];//mTexts[0]是不变的部分，mTexts[1]原来的部分，mTexts[2]变化后的部分
        mTextPoints = new TulPoint[3];//表示各部分的坐标
        mTextPoints[0] = new TulPoint();
        mTextPoints[1] = new TulPoint();
        mTextPoints[2] = new TulPoint();

//        calculateChangeNum(0);
//        mMinOffsetY = 0;
//        mMaxOffsetY = mTextSize;

        //A为0，即完全透明。值范围0~255
        mEndTextColor = Color.argb(0, Color.red(mTextColor), Color.green(mTextColor), Color.blue(mTextColor));

        //字体样式初始化
        mTextPaint = new Paint();
        mTextPaint.setAntiAlias(true);
        mTextPaint.setTextSize(mTextSize);
        mTextPaint.setColor(mTextColor);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //getPaddingLeft/getPaddingRight/getPaddingTop/getPaddingBottom是ThumbUpLayout给其设置的
        //最后setMeasuredDimension是给CountView设置宽高
        setMeasuredDimension(TulUtils.getDefaultSize(widthMeasureSpec, getContentWidth() + getPaddingLeft() + getPaddingRight()),
                TulUtils.getDefaultSize(heightMeasureSpec, getContentHeight() + getPaddingTop() + getPaddingBottom()));
    }

    private int getContentWidth() {
        //返回Text的宽
        return (int) Math.ceil(mTextPaint.measureText(String.valueOf(mNum)));
    }

    private int getContentHeight() {
        return (int) mTextSize;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //不变的部分
        mTextPaint.setColor(mTextColor);
        canvas.drawText(String.valueOf(mTexts[0]), mTextPoints[0].x, mTextPoints[0].y, mTextPaint);

        //变化前部分
        mTextPaint.setColor((Integer) TulUtils.evaluate(mFraction, mEndTextColor, mTextColor));
        canvas.drawText(String.valueOf(mTexts[1]), mTextPoints[1].x, mTextPoints[1].y, mTextPaint);

        //变化后部分
        mTextPaint.setColor((Integer) TulUtils.evaluate(mFraction, mTextColor, mEndTextColor));
        canvas.drawText(String.valueOf(mTexts[2]), mTextPoints[2].x, mTextPoints[2].y, mTextPaint);
    }

    public void setNum(int mNum) {
        this.mNum = mNum;
        calculateChangeNum(0);
        //当我们动态移动一个View的位置，或者View的大小、形状发生了变化的时候，我们可以在view中调用这个方法
        //应该会重新进行布局流程。但是，真实情况略有不同，
        // 如果子View调用了这个方法，其实会从View树重新进行一次测量、布局、绘制这三个流程，
        // 最终就会显示子View的最终情况。
        /**
         * 子View调用requestLayout方法，
         * 会标记当前View及父容器，同时逐层向上提交，
         * 直到ViewRootImpl处理该事件，ViewRootImpl会调用三大流程，
         * 从measure开始，对于每一个含有标记位的view及其子View都会进行测量、布局、绘制。
         */
        requestLayout();
    }

    public void setTextColor(int mTextColor) {
        this.mTextColor = mTextColor;
        mEndTextColor = Color.argb(0, Color.red(mTextColor), Color.green(mTextColor), Color.blue(mTextColor));
        /**
         * 这个方法与invalidate方法的作用是一样的，
         * 都是使View树重绘，但两者的使用条件不同，
         * postInvalidate是在非UI线程中调用，invalidate则是在UI线程中调用。
         */
        postInvalidate();
    }

    public void setTextSize(float mTextSize) {
        this.mTextSize = mTextSize;
        requestLayout();
    }

    /**
     * 计算不变，原来，和改变后各部分的数字
     * 这里是只针对加一和减一去计算的算法，因为直接设置的时候没有动画
     */
    public void calculateChangeNum(int change) {
        if (change == 0) {
            mTexts[0] = String.valueOf(mNum);
            mTexts[1] = "";
            mTexts[2] = "";
            return;
        }

        String oldNum = String.valueOf(mNum);
        String newNum = String.valueOf(mNum + change);

        for (int i = 0; i < oldNum.length(); i++) {
            //把新旧两个数字的每一位都取出来，进行对比
            char oldC = oldNum.charAt(i);
            char newC = newNum.charAt(i);
            if (oldC != newC) {
                mTexts[0] = i == 0 ? "" : newNum.substring(0, i);
                mTexts[1] = oldNum.substring(i);
                mTexts[2] = newNum.substring(i);
                break;
            }
        }
        mNum += change;
        startAnim(change > 0);
    }

    /**
     * 所以这个回调方法肯定是在layout方法之中调用
     * 从上面两张图可以看出两点：
     1）layout方法直接把四个参数赋值给对应的控件坐标变量(mLeft,mTop,mRight,mBottom)，也就是确定了控件的区域；
     2）如果旧的宽度和高度任意一个发生了改变都会调用sizeChange方法，而sizeChange方法里面就是onSizeChange方法。
     ps:layout中发生的onSizeChange回调是属于绘制过程中的。
     * @param w
     * @param h
     * @param oldw
     * @param oldh
     */
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        //发生在onlayout 之后，onDraw之前
        calculateLocation();
    }

    private void calculateLocation() {//在ThumbUpLayout的setNum时会导致该方法回调
        String text = String.valueOf(mNum);
        float textWidth = mTextPaint.measureText(text) / text.length();
        float unChangeWidth = textWidth * mTexts[0].length();

        Paint.FontMetricsInt fontMetrics = mTextPaint.getFontMetricsInt();
        float y = getPaddingTop() + (getContentHeight() - fontMetrics.bottom - fontMetrics.top) / 2;

        mTextPoints[0].x = getPaddingLeft();
        mTextPoints[1].x = getPaddingLeft() + unChangeWidth;
        mTextPoints[2].x = getPaddingLeft() + unChangeWidth;

        mTextPoints[0].y = y;
        mTextPoints[1].y = y - mOldOffsetY;
        mTextPoints[2].y = y - mNewOffsetY;
    }

    public void setTextOffsetY(float offsetY) {
        this.mOldOffsetY = offsetY;//变大是从[0,1]，变小是[0,-1]
        if (mCountToBigger) {//从下到上[-1,0]
            this.mNewOffsetY = offsetY - mMaxOffsetY;
        } else {//从上到下[1,0]
            this.mNewOffsetY = mMaxOffsetY + offsetY;
        }
        //影响字体颜色的变量
        mFraction = (mMaxOffsetY - Math.abs(mOldOffsetY)) / (mMaxOffsetY - mMinOffsetY);
        calculateLocation();
        postInvalidate();
    }

    public float getTextOffsetY() {
        return mMinOffsetY;
    }

    public void startAnim(boolean isToBigger) {
        mCountToBigger = isToBigger;
        ObjectAnimator textOffsetY = ObjectAnimator.ofFloat(this, "textOffsetY", mMinOffsetY, mCountToBigger ? mMaxOffsetY : -mMaxOffsetY);
        textOffsetY.setDuration(COUNT_ANIM_DURING);
        textOffsetY.start();
    }
}
