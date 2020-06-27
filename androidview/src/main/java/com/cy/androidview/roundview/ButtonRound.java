package com.cy.androidview.roundview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import androidx.appcompat.widget.AppCompatButton;

import com.cy.androidview.R;
import com.cy.androidview.rectangleview.IRectangle;
import com.cy.androidview.rectangleview.RectangleRatio;
import com.cy.androidview.rippleview.IRipple;
import com.cy.androidview.rippleview.Ripple;


/**
 * @Description:
 * @Author: cy
 * @CreateDate: 2020/6/9 15:50
 * @UpdateUser:
 * @UpdateDate: 2020/6/9 15:50
 * @UpdateRemark:
 * @Version:
 */
public class ButtonRound extends AppCompatButton implements IRound, IRectangle, IRipple {


    private RectangleRatio rectangleRatio;
    private Round round;
    public ButtonRound(Context context) {
        this(context, null);
    }

    public ButtonRound(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ButtonRound);
        ripple(typedArray);
        round=round(typedArray);
        rectangleRatio = rectangle(typedArray);
        typedArray.recycle();
    }
    @Override
    public void setBackgroundColor(int color) {
        super.setBackgroundColor(0x00000000);
    }

    @Override
    public void setBackgroundResource(int resid) {
    }

    //实现4
    @Override
    protected void dispatchDraw(Canvas canvas) {
        round.saveLayer(canvas);
        super.dispatchDraw(canvas);
        round.round(canvas);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        rectangleRatio.rectangle(new RectangleRatio.MeasureSizeCallback() {
            @Override
            public void setMeasuredSize(int measuredWidth, int measuredHeight) {
                setMeasuredDimension(measuredWidth, measuredHeight);
            }
        });
    }
    @Override
    public Round round(TypedArray typedArray) {
        return new Round(this,typedArray)
                .setRadius(R.styleable.ButtonRound_radiusCorner)
                .setTopLeftRadius(R.styleable.ButtonRound_radiusTopLeft)
                .setTopRightRadius(R.styleable.ButtonRound_radiusTopRight)
                .setBottomLeftRadius(R.styleable.ButtonRound_radiusBottomLeft)
                .setBottomRightRadius(R.styleable.ButtonRound_radiusBottomRight);
    }
    @Override
    public RectangleRatio rectangle(TypedArray typedArray) {
        return new RectangleRatio(this,typedArray)
                .setBaseOnWidthOrHeight(R.styleable.ButtonRound_baseOnWidthOrHeight)
                .setHeightWidthRatio(R.styleable.ButtonRound_heightWidthRatio,0);
    }


    @Override
    public Ripple ripple(TypedArray typedArray) {
        return new Ripple(this, typedArray)
                .setColorRipple(R.styleable.ButtonRound_colorRipple)
                .setHavaRipple(R.styleable.ButtonRound_haveRipple).ripple();
    }


}
