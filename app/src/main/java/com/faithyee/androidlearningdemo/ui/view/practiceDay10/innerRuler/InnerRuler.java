package com.faithyee.androidlearningdemo.ui.view.practiceDay10.innerRuler;

import android.content.Context;
import android.graphics.Paint;
import android.os.Build;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewTreeObserver;
import android.widget.EdgeEffect;
import android.widget.OverScroller;

import com.faithyee.androidlearningdemo.ui.view.practiceDay10.BooheeRuler;
import com.faithyee.androidlearningdemo.ui.view.practiceDay10.RulerCallback;

/**
 * Author：yewmf on 2018/1/10 14:22
 * E-mail：faith_yee@163.com
 */
public abstract class InnerRuler extends View {

    protected BooheeRuler mParent;
    protected Context mContext;

    protected Paint mSmallScalePaint, mBigScalePaint, mTextPaint, mOutLinePaint;
    //当前刻度值
    protected float mCurrentScale = 0;
    //最大刻度数
    protected int mMaxLength = 0;
    //长度、最小可滑动值、最大可滑动值
    protected int mLength, mMinPosition = 0, mMaxPosition = 0;
    //控制滑动
    protected OverScroller mOverScroller;
    //一格大刻度多少格小刻度
    protected int mCount = 10;
    //提前刻画量
    protected int mDrawOffset;
    //速度获取
    protected VelocityTracker mVelocityTracker;
    //惯性最大最小速度
    protected int mMaximumVelocity, mMinimumVelocity;
    //回调接口
    protected RulerCallback mRulerCallback;
    //边界效果
    protected EdgeEffect mStartEdgeEffect,mEndEdgeEffect;
    //边缘效应长度
    protected int mEdgeLength;


    public InnerRuler(Context context, BooheeRuler booheeRuler) {
        super(context);
        mParent = booheeRuler;
        init(context);
    }

    private void init(Context context) {
        mContext = context;

        //parent是BooheeRuler，用于包着尺子的外壳，用于画选取光标、外壳，
        // 在使用的时候已经把InnerRuler的子类通过addview加入布局中
        mMaxLength = mParent.getMaxScale() - mParent.getMinScale();
        mCurrentScale = mParent.getCurrentScale();
        mCount = mParent.getCount(); //一格大刻度多少格小刻度
        mDrawOffset = mCount * mParent.getInterval() / 2;//提前刻画量

        initPaints();

        mOverScroller = new OverScroller(mContext);

//        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        //配置速度
        mVelocityTracker = VelocityTracker.obtain();
        mMaximumVelocity = ViewConfiguration.get(context)
                .getScaledMaximumFlingVelocity();
        mMinimumVelocity = ViewConfiguration.get(context)
                .getScaledMinimumFlingVelocity();

        initEdgeEffects();

        //第一次进入，跳转到设定刻度
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                getViewTreeObserver().removeOnGlobalLayoutListener(this);
                goToScale(mCurrentScale);
            }
        });
        checkAPILevel();

    }

    //API小于18则关闭硬件加速，否则setAntiAlias()方法不生效
    private void checkAPILevel() {
        if (Build.VERSION.SDK_INT < 18){
            setLayerType(LAYER_TYPE_NONE,null);
        }
    }

    //初始化边缘效果
    public void initEdgeEffects(){
        if (mParent.canEdgeEffect()) {
            if (mStartEdgeEffect == null || mEndEdgeEffect == null) {
                mStartEdgeEffect = new EdgeEffect(mContext);
                mEndEdgeEffect = new EdgeEffect(mContext);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    mStartEdgeEffect.setColor(mParent.getEdgeColor());
                    mEndEdgeEffect.setColor(mParent.getEdgeColor());
                }
                //interval 刻度间隔
                mEdgeLength = mParent.getCursorHeight() + mParent.getInterval() * mParent.getCount();
            }
        }
    }

    private void initPaints() {
        mSmallScalePaint = new Paint();
        mSmallScalePaint.setStrokeWidth(mParent.getSmallScaleWidth());
        mSmallScalePaint.setColor(mParent.getScaleColor());
        mSmallScalePaint.setStrokeCap(Paint.Cap.ROUND);

        mBigScalePaint = new Paint();
        mBigScalePaint.setColor(mParent.getScaleColor());
        mBigScalePaint.setStrokeWidth(mParent.getBigScaleWidth());
        mBigScalePaint.setStrokeCap(Paint.Cap.ROUND);

        mTextPaint = new Paint();
        mTextPaint.setAntiAlias(true);
        mTextPaint.setColor(mParent.getTextColor());
        mTextPaint.setTextSize(mParent.getTextSize());
        mTextPaint.setTextAlign(Paint.Align.CENTER);
//        mTextPaint.setStrokeJoin(Paint.Join.ROUND);
        mOutLinePaint = new Paint();
        mOutLinePaint.setStrokeWidth(0);
        mOutLinePaint.setColor(mParent.getScaleColor());
    }

    @Override
    public void computeScroll() {
        if (mOverScroller.computeScrollOffset()) {
            scrollTo(mOverScroller.getCurrX(), mOverScroller.getCurrY());

            //这是最后OverScroller的最后一次滑动，如果这次滑动完了mCurrentScale不是整数，则把尺子移动到最近的整数位置
            if (!mOverScroller.computeScrollOffset() && mCurrentScale != Math.round(mCurrentScale)){
//                Log.d("ruler", "computeScroll: " + mCurrentScale);
                //Fling完进行一次检测回滚
                scrollBackToCurrentScale();
            }
            invalidate();
        }
    }

    protected abstract void scrollBackToCurrentScale();//因为回滚涉及水平和垂直方向，所以让子类来实现该方法
    protected abstract void goToScale(float scale);//同理
    public abstract void refreshSize();//同理


    public void setRulerCallback(RulerCallback RulerCallback) {
        this.mRulerCallback = RulerCallback;
    }

}
