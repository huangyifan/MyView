package com.example.huang.myview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.Dimension;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.security.PublicKey;

/**
 * Date: 16-8-1.
 * Email: yifan.huang@renren-inc.com
 */
public class TopBar extends RelativeLayout {
    int mLeftTextColor, mRightTextColor, mTitleTextColor;
    Drawable mLeftBackground, mRightBackground;
    String mLeftText, mRightText, mTitle;
    float mTitleTextSize;

    Button mLeftButton, mRightButton;
    TextView mTitleView;

    LayoutParams mLeftParams, mRightParams, mTitleParams;

    topbarClickListener mListener;

    public interface topbarClickListener{
        void leftClick();
        void rightClick();
    }

    public void setOnTopbarClickListener(topbarClickListener mListener){
        this.mListener = mListener;
    }


    public TopBar(Context context, AttributeSet attrs) {
        super(context, attrs);

        //通过这个方法，将你在attrs.xml中定义的declare-styleable的所有属性的值存储到TypedArray中
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.TopBar);
        //从TypedArray中取出对应的值来为要设置的属性赋值
        mLeftTextColor = ta.getColor(R.styleable.TopBar_leftTextColor, 0);
        mLeftBackground = ta.getDrawable(R.styleable.TopBar_leftBackground);
        mLeftText = ta.getString(R.styleable.TopBar_leftText);
        mRightTextColor = ta.getColor(R.styleable.TopBar_rightTextColor, 0);
        mRightBackground = ta.getDrawable(R.styleable.TopBar_rightBackground);
        mRightText = ta.getString(R.styleable.TopBar_rightText);
        mTitleTextSize = ta.getDimension(R.styleable.TopBar_titleTextSize, 10);
        mTitleTextColor = ta.getColor(R.styleable.TopBar_titleTextColor, 0);
        mTitle = ta.getString(R.styleable.TopBar_title);

        //获取完TypedArray的值后，一般要调用
        //recycle方法来避免重新创建的时候的错误
        ta.recycle();

        mLeftButton = new Button(context);
        mRightButton = new Button(context);
        mTitleView = new TextView(context);

        //为创建的组件元素 赋值
        //值就来源于我们在引用的xml文件中给对应属性的赋值
        mLeftButton.setTextColor(mLeftTextColor);
        mLeftButton.setBackground(mLeftBackground);
        mLeftButton.setText(mLeftText);

        mRightButton.setTextColor(mRightTextColor);
        mRightButton.setBackground(mRightBackground);
        mRightButton.setText(mRightText);

        mTitleView.setText(mTitle);
        mTitleView.setTextColor(mTitleTextColor);
        mTitleView.setTextSize(mTitleTextSize);
        mTitleView.setGravity(Gravity.CENTER);

        //为组件元素设置对应的布局元素
        mLeftParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        mLeftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, TRUE);
        //添加到ViewGroup
        addView(mLeftButton, mLeftParams);

        mRightParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        mRightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, TRUE);
        addView(mRightButton, mRightParams);

        mTitleParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        mTitleParams.addRule(RelativeLayout.CENTER_IN_PARENT, TRUE);
        addView(mTitleView, mTitleParams);


            mRightButton.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    mListener.rightClick();
                }
            });

            mLeftButton.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    mListener.leftClick();
                }
            });




    }

    public void setButtonVisable(int id, boolean flag){
        if (flag){
            if (id == 0){
                mLeftButton.setVisibility(View.VISIBLE);
            }else {
                mRightButton.setVisibility(View.VISIBLE);
            }
        }else {
            if (id == 0){
                mLeftButton.setVisibility(View.GONE);
            }else {
                mRightButton.setVisibility(View.GONE);
            }
        }
    }

    public void setTitle(String str){
        mTitleView.setText(str);
    }





}









