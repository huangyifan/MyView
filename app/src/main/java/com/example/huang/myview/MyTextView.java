package com.example.huang.myview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Date: 16-8-1.
 * Email: yifan.huang@renren-inc.com
 */

public class MyTextView extends TextView {
    Paint mPaint1;
    Paint mPaint2;
    Paint mPaint;
    LinearGradient mLinearGradient;
    Matrix mGradientMatrix;
    /*public MyTextView(Context context) {
        super(context);
        initView();
    }*/
    int mViewWidth;
    int mTranslate;
    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    private void initView() {
        mPaint1 = new Paint();
        mPaint1.setColor(Color.BLUE);
        mPaint1.setStyle(Paint.Style.FILL);
        mPaint2 = new Paint();
        mPaint2.setColor(Color.YELLOW);
        mPaint2.setStyle(Paint.Style.FILL);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        /*//绘制外层矩形
        canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), mPaint1);
        //绘制内层矩形
        canvas.drawRect(0, 0, getMeasuredWidth()-10, getMeasuredHeight()-10, mPaint2);

        canvas.save();
        //绘制文字前平移10像素
        canvas.translate(10,0);*/

        //父类完成的方法，及绘制文本
        super.onDraw(canvas);

        /*canvas.restore();*/


        if (mGradientMatrix != null){
            mTranslate += mViewWidth/5;
            if (mTranslate > 2*mViewWidth){
                mTranslate = -mViewWidth;
            }
            mGradientMatrix.setTranslate(mTranslate,0);
            mLinearGradient.setLocalMatrix(mGradientMatrix);
            postInvalidateDelayed(100);
        }
    }

    /*
    组件大小改变时回调
     */
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        if (mViewWidth == 0){
            mViewWidth = getMeasuredWidth();
            if (mViewWidth > 0){
                mPaint = getPaint();
                mLinearGradient = new LinearGradient(0,0,mViewWidth,0,new int[]{Color.BLUE,0xffffffff,Color.BLUE},null, Shader.TileMode.CLAMP);
                mPaint.setShader(mLinearGradient);
                mGradientMatrix = new Matrix();
            }
        }
    }
}
