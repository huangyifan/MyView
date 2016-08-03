package com.example.huang.myview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

/**
 * Date: 16-8-3.
 * Email: yifan.huang@renren-inc.com
 */
public class BarChart extends View{
    private int mRectCount;
    private float mWidth;
    private float mRectWidth;
    private float mRectHeight;
    private float offset;
    private float currentHeight;
    private Paint mPaint;
    private LinearGradient mLinearGradient;
    public BarChart(Context context, AttributeSet attrs) {
        super(context, attrs);

        initView();
    }

    private void initView() {
        mRectCount = 5;   //小矩形的多少
        offset = 5;     //每个小矩形的间隔
        mPaint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for (int i=0;i<mRectCount;i++){
            double mRandom = Math.random();
            currentHeight = (float) (mRectHeight*mRandom);

            canvas.drawRect(
                    (float) (mWidth*0.4/2+mRectWidth*i+offset),
                    currentHeight,   //每个小矩形的高
                    (float) (mWidth*0.4/2+mRectWidth*(i+1)),
                    mRectHeight,
                    mPaint);
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = getWidth();
        mRectHeight = getHeight()-200;//小矩形底端距离屏幕Top的距离
        mRectWidth = (int)(mWidth*0.6/mRectCount);  //每个小矩形的宽度

        mLinearGradient = new LinearGradient(
                0,
                0,
                mRectWidth,
                mRectHeight,
                Color.YELLOW,
                Color.BLUE,
                Shader.TileMode.CLAMP);
        mPaint.setShader(mLinearGradient);
    }
}
