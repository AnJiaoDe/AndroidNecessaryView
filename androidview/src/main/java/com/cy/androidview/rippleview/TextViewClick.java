package com.cy.androidview.rippleview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;

import com.cy.androidview.R;


/**
 * Created by cy on 2018/10/27.
 */

public class TextViewClick extends AppCompatTextView {
    public TextViewClick(Context context) {
        this(context, null);
    }

    public TextViewClick(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray arr = context.obtainStyledAttributes(attrs, R.styleable.TextViewClick);
        //水波纹的颜色,默认是0x66000000，建议自定义水波纹颜色的时候，用argb,rgb都设置为0，a可随意，调整透明度为了水波纹看起来更美观
        int colorRipple = arr.getColor(R.styleable.TextViewClick_colorRipple, 0x66000000);
        boolean havaRipple = arr.getBoolean(R.styleable.TextViewClick_haveRipple, true);//设置是否有水波纹点击效果，默认有
        arr.recycle();
        //5.0以上才有效,
        if (havaRipple&&android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            Drawable drawable = getBackground();

            //当控件设置了点击监听器，并且控件点击有效，时，才能产生水波纹
            RippleDrawable rippleDrawable = new RippleDrawable(ColorStateList.valueOf(colorRipple), drawable, null);

            setBackground(rippleDrawable);
        }

    }
}
