package com.faithyee.androidlearningdemo.ui.view.practiceDay10;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

import com.faithyee.androidlearningdemo.R;
import com.faithyee.androidlearningdemo.ui.view.practiceDay10.innerRuler.InnerRuler;
import com.faithyee.androidlearningdemo.ui.view.practiceDay10.innerRuler.TopHeadRuler;

/**
 * 用于包着尺子的外壳，用于画选取光标、外壳
 * Author：yewmf on 2018/1/10 14:09
 * E-mail：faith_yee@163.com
 */
public class BooheeRuler extends ViewGroup {

    private final String TAG = "ruler";
    private Context mContext;

    //内部的尺子
    private InnerRuler mInnerRuler;

    //最小最大刻度值(以0.1kg为单位)
    private int mMinScale = 464, mMaxScale = 2000;
    //光标宽度、高度
    private int mCursorWidth = 8, mCursorHeight = 70;
    //大小刻度的长度
    private int mSmallScaleLength = 30, mBigScaleLength = 60;
    //大小刻度的粗细
    private int mSmallScaleWidth = 3, mBigScaleWidth = 5;
    //数字字体大小
    private int mTextSize = 28;
    //数字Text距离顶部高度
    private int mTextMarginHead = 120;
    //刻度间隔
    private int mInterval = 18;
    //数字Text颜色
    private
    @ColorInt
    int mTextColor = getResources().getColor(R.color.colorLightBlack);
    //刻度颜色
    private
    @ColorInt
    int mScaleColor = getResources().getColor(R.color.colorGray);
    //初始的当前刻度
    private float mCurrentScale = 0;
    //一格大刻度多少格小刻度
    private int mCount = 10;
    //光标drawable
    private Drawable mCursorDrawable;
    //尺子两端的padding
    private int mPaddingStartAndEnd = 0;
    private int mPaddingLeft = 0, mPaddingTop = 0, mPaddingRight = 0, mPaddingBottom = 0;
    //尺子背景
    private Drawable mRulerBackGround;
    private int mRulerBackGroundColor = getResources().getColor(R.color.colorDirtyWithe);
    //是否启用边缘效应
    private boolean mCanEdgeEffect = true;
    //边缘颜色
    private
    @ColorInt
    int mEdgeColor = getResources().getColor(R.color.colorForgiven);
    //刻度乘积因子
    private float mFactor = 0.1f;


    public BooheeRuler(Context context) {
        super(context);
        initRuler(context);
    }

    public BooheeRuler(Context context, AttributeSet attrs) {
        super(context, attrs);
        initAttrs(context, attrs);
        initRuler(context);
    }

    public BooheeRuler(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttrs(context, attrs);
        initRuler(context);
    }

    @SuppressWarnings("WrongConstant")
    private void initAttrs(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.BooheeRuler, 0, 0);
        mMinScale = typedArray.getInteger(R.styleable.BooheeRuler_minScale, mMinScale);
        mMaxScale = typedArray.getInteger(R.styleable.BooheeRuler_maxScale, mMaxScale);
        mCursorWidth = typedArray.getDimensionPixelSize(R.styleable.BooheeRuler_cursorWidth, mCursorWidth);
        mCursorHeight = typedArray.getDimensionPixelSize(R.styleable.BooheeRuler_cursorHeight, mCursorHeight);
        mSmallScaleWidth = typedArray.getDimensionPixelSize(R.styleable.BooheeRuler_smallScaleWidth, mSmallScaleWidth);
        mSmallScaleLength = typedArray.getDimensionPixelSize(R.styleable.BooheeRuler_smallScaleLength, mSmallScaleLength);
        mBigScaleWidth = typedArray.getDimensionPixelSize(R.styleable.BooheeRuler_bigScaleWidth, mBigScaleWidth);
        mBigScaleLength = typedArray.getDimensionPixelSize(R.styleable.BooheeRuler_bigScaleLength, mBigScaleLength);
        mTextSize = typedArray.getDimensionPixelSize(R.styleable.BooheeRuler_numberTextSize, mTextSize);
        mTextMarginHead = typedArray.getDimensionPixelSize(R.styleable.BooheeRuler_textMarginHead, mTextMarginHead);
        mInterval = typedArray.getDimensionPixelSize(R.styleable.BooheeRuler_scaleInterval, mInterval);
        mTextColor = typedArray.getColor(R.styleable.BooheeRuler_numberTextColor, mTextColor);
        mScaleColor = typedArray.getColor(R.styleable.BooheeRuler_scaleColor, mScaleColor);
        mCurrentScale = typedArray.getFloat(R.styleable.BooheeRuler_currentScale, (mMaxScale + mMinScale) / 2);
        mCount = typedArray.getInt(R.styleable.BooheeRuler_count, mCount);
        mCursorDrawable = typedArray.getDrawable(R.styleable.BooheeRuler_cursorDrawable);
        if (mCursorDrawable == null) {
            mCursorDrawable = getResources().getDrawable(R.drawable.cursor_shape);
        }
        mPaddingStartAndEnd = typedArray.getDimensionPixelSize(R.styleable.BooheeRuler_paddingStartAndEnd, mPaddingStartAndEnd);
//        mStyle = typedArray.getInt(R.styleable.BooheeRuler_rulerStyle,mStyle);
        mRulerBackGround = typedArray.getDrawable(R.styleable.BooheeRuler_rulerBackGround);
        if (mRulerBackGround == null) {
            mRulerBackGroundColor = typedArray.getColor(R.styleable.BooheeRuler_rulerBackGround, mRulerBackGroundColor);
        }
        mCanEdgeEffect = typedArray.getBoolean(R.styleable.BooheeRuler_canEdgeEffect, mCanEdgeEffect);
        mEdgeColor = typedArray.getColor(R.styleable.BooheeRuler_edgeColor, mEdgeColor);
        mFactor = typedArray.getFloat(R.styleable.BooheeRuler_factor, mFactor);
        typedArray.recycle();
    }

    private void initRuler(Context context) {
        mContext = context;
        mInnerRuler = new TopHeadRuler(context, this);
        paddingHorizontal();
        //设置全屏，加入InnerRuler
        LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mInnerRuler.setLayoutParams(layoutParams);
        addView(mInnerRuler);
        //设置ViewGroup可画
        setWillNotDraw(false);

        initDrawable();
        initRulerBackground();
    }


    private void initRulerBackground() {
        if (mRulerBackGround != null){
            mInnerRuler.setBackground(mRulerBackGround);
        }else {
            mInnerRuler.setBackgroundColor(mRulerBackGroundColor);
        }
    }

    //在宽高初始化之后定义光标Drawable的边界
    private void initDrawable() {
        getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                getViewTreeObserver().removeOnPreDrawListener(this);
                mCursorDrawable.setBounds((getWidth() - mCursorWidth) / 2, 0
                        , (getWidth() + mCursorWidth) / 2, mCursorHeight);

                return false;
            }
        });
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        //画中间的选定光标，要在这里画，因为dispatchDraw()执行在onDraw()后面，这样子光标才能不被尺子的刻度遮蔽
        mCursorDrawable.draw(canvas);

    }


    private void paddingHorizontal() {
        mPaddingLeft = mPaddingStartAndEnd;
        mPaddingRight = mPaddingStartAndEnd;
        mPaddingTop = 0;
        mPaddingBottom = 0;
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        if (changed) {
            mInnerRuler.layout(mPaddingLeft, mPaddingTop, r - l - mPaddingRight, b - t - mPaddingBottom);
        }
    }

    //如果控件尺寸变化，中间光标的位置也要重新定义
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        initDrawable();
    }

    //设置回调
    public void setCallback(RulerCallback rulerCallback) {
        mInnerRuler.setRulerCallback(rulerCallback);

    }

    public int getMinScale() {
        return mMinScale;
    }

    public void setMinScale(int mMinScale) {
        this.mMinScale = mMinScale;
    }

    public int getMaxScale() {
        return mMaxScale;
    }

    public void setMaxScale(int mMaxScale) {
        this.mMaxScale = mMaxScale;
    }

    public int getCursorWidth() {
        return mCursorWidth;
    }

    public void setCursorWidth(int mCursorWidth) {
        this.mCursorWidth = mCursorWidth;
    }

    public int getCursorHeight() {
        return mCursorHeight;
    }

    public void setCursorHeight(int mCursorHeight) {
        this.mCursorHeight = mCursorHeight;
    }

    public int getSmallScaleLength() {
        return mSmallScaleLength;
    }

    public void setSmallScaleLength(int mSmallScaleLength) {
        this.mSmallScaleLength = mSmallScaleLength;
    }

    public int getBigScaleLength() {
        return mBigScaleLength;
    }

    public void setBigScaleLength(int mBigScaleLength) {
        this.mBigScaleLength = mBigScaleLength;
    }

    public int getSmallScaleWidth() {
        return mSmallScaleWidth;
    }

    public void setSmallScaleWidth(int mSmallScaleWidth) {
        this.mSmallScaleWidth = mSmallScaleWidth;
    }

    public int getBigScaleWidth() {
        return mBigScaleWidth;
    }

    public void setBigScaleWidth(int mBigScaleWidth) {
        this.mBigScaleWidth = mBigScaleWidth;
    }

    public int getTextSize() {
        return mTextSize;
    }

    public void setTextSize(int mTextSize) {
        this.mTextSize = mTextSize;
    }

    public int getTextMarginHead() {
        return mTextMarginHead;
    }

    public void setTextMarginHead(int mTextMarginHead) {
        this.mTextMarginHead = mTextMarginHead;
    }

    public int getInterval() {
        return mInterval;
    }

    public void setInterval(int mInterval) {
        this.mInterval = mInterval;
    }

    public int getTextColor() {
        return mTextColor;
    }

    public void setTextColor(int mTextColor) {
        this.mTextColor = mTextColor;
    }

    public int getScaleColor() {
        return mScaleColor;
    }

    public void setScaleColor(int mScaleColor) {
        this.mScaleColor = mScaleColor;
    }

    public float getCurrentScale() {
        return mCurrentScale;
    }

    public void setCurrentScale(float mCurrentScale) {
        this.mCurrentScale = mCurrentScale;
    }

    public int getCount() {
        return mCount;
    }

    public void setCount(int mCount) {
        this.mCount = mCount;
    }

    public Drawable getCursorDrawable() {
        return mCursorDrawable;
    }

    public void setCursorDrawable(Drawable mCursorDrawable) {
        this.mCursorDrawable = mCursorDrawable;
    }

    public int getPaddingStartAndEnd() {
        return mPaddingStartAndEnd;
    }

    public void setPaddingStartAndEnd(int mPaddingStartAndEnd) {
        this.mPaddingStartAndEnd = mPaddingStartAndEnd;
    }

    public int getPaddingLeft() {
        return mPaddingLeft;
    }

    public void setPaddingLeft(int mPaddingLeft) {
        this.mPaddingLeft = mPaddingLeft;
    }

    public int getPaddingTop() {
        return mPaddingTop;
    }

    public void setPaddingTop(int mPaddingTop) {
        this.mPaddingTop = mPaddingTop;
    }

    public int getPaddingRight() {
        return mPaddingRight;
    }

    public void setPaddingRight(int mPaddingRight) {
        this.mPaddingRight = mPaddingRight;
    }

    public int getPaddingBottom() {
        return mPaddingBottom;
    }

    public void setPaddingBottom(int mPaddingBottom) {
        this.mPaddingBottom = mPaddingBottom;
    }

    public Drawable getRulerBackGround() {
        return mRulerBackGround;
    }

    public void setRulerBackGround(Drawable mRulerBackGround) {
        this.mRulerBackGround = mRulerBackGround;
    }

    public int getRulerBackGroundColor() {
        return mRulerBackGroundColor;
    }

    public void setRulerBackGroundColor(int mRulerBackGroundColor) {
        this.mRulerBackGroundColor = mRulerBackGroundColor;
    }

    public boolean canEdgeEffect(){
        return mCanEdgeEffect;
    }

    public void setCanEdgeEffect(boolean mCanEdgeEffect) {
        this.mCanEdgeEffect = mCanEdgeEffect;
    }

    public int getEdgeColor() {
        return mEdgeColor;
    }

    public void setEdgeColor(int mEdgeColor) {
        this.mEdgeColor = mEdgeColor;
    }

    public float getFactor() {
        return mFactor;
    }

    public void setFactor(float mFactor) {
        this.mFactor = mFactor;
    }
}
