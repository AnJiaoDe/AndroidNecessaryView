package com.cy.androidview.rippleview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatButton;

import com.cy.androidview.R;


/**
 * Created by cy on 2018/10/27.
 */

public class ButtonRipple extends AppCompatButton implements IRipple {
    private Ripple ripple;

    public ButtonRipple(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ButtonRipple);
        ripple = ripple(typedArray);
        typedArray.recycle();
    }
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        ripple.ripple();
    }
    @Override
    public Ripple ripple(TypedArray typedArray) {
        return new Ripple(this, typedArray)
                .setColorRipple(R.styleable.ButtonRipple_cy_colorRipple)
                .setHavaRipple(R.styleable.ButtonRipple_cy_haveRipple);
    }

    @Override
    public Ripple getRipple() {
        return ripple;
    }
}
