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

    public ButtonRipple(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ButtonRipple);
        ripple(typedArray);
        typedArray.recycle();
    }

    @Override
    public Ripple ripple(TypedArray typedArray) {
        return new Ripple(this, typedArray)
                .setColorRipple(R.styleable.ButtonRipple_colorRipple)
                .setHavaRipple(R.styleable.ButtonRipple_haveRipple).ripple();
    }
}
