package com.example.huang.myview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Date: 16-8-2.
 * Email: yifan.huang@renren-inc.com
 */
public class ScaleDiagram extends View {
    private float length = 400;
    private float mCircleXY;
    private float mRadius;
    private float mShowTextSize;
    private float mSwepAngle;
    private Paint mCirclePaint,mArcPaint,mTextPaint;
    private RectF mArcRectF;
    private String mShowText = "ScaleDiagram";
    int w,h;

    public ScaleDiagram(Context context, AttributeSet attrs) {
        super(context, attrs);

        initView();

    }

    private void initView() {
        mCirclePaint = new Paint();
        mArcPaint = new Paint();
        mTextPaint = new Paint();

        mCircleXY = length/2;
        mRadius = (float) (length*0.5/2);

        mArcRectF = new RectF(
                (float)(length*0.15),
                (float)(length*0.15),
                (float)(length*0.85),
                (float)(length*0.85));

        Rect rect = new Rect();
        mTextPaint.getTextBounds(mShowText, 0, mShowText.length(), rect);
        w = rect.width();
        h = rect.height();

    }

    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);

        //绘制圆
        mCirclePaint.setColor(Color.RED);
        canvas.drawCircle(mCircleXY,mCircleXY,mRadius,mCirclePaint);
        //绘制弧线
        mArcPaint.setColor(Color.YELLOW);
        mArcPaint.setStyle(Paint.Style.STROKE);
        mArcPaint.setStrokeWidth(25);
        canvas.drawArc(mArcRectF,270,mSwepAngle,false,mArcPaint);
        //绘制文字
        mTextPaint.setColor(Color.BLUE);
        mTextPaint.setTextSize(20);

        canvas.drawText(mShowText,mCircleXY-w/4*3,mCircleXY+h/2,mTextPaint);
    }

    public void setCircle(float length){
        if (length != 0){
            this.length = length;
        }else {
            this.length = 20;
        }

        this.invalidate();

    }

    public void setArc(float sweepAngle){
        if (sweepAngle != 0){
            this.mSwepAngle = sweepAngle;
        }else {
            this.mSwepAngle = 90;
        }
        this.invalidate();

    }

    public void setText(String str){
        if (str != null){
            this.mShowText = str;
        }else {
            this.mShowText = "ScaleDiagram";
        }

        this.invalidate();

    }

}
