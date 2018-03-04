package com.example.application;

import android.content.Context;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;

public class RefreshProgress extends android.support.v7.widget.AppCompatImageView {

    private Matrix m = new Matrix();
    private LinearInterpolator lir = new LinearInterpolator();
    public RefreshProgress(Context context) {
        super(context);
    }

    public RefreshProgress(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void Animation(){
        RotateAnimation rotate = new RotateAnimation(0, 720,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setRepeatCount(-1);
        rotate.setInterpolator(lir);
        rotate.setDuration(10000);
        rotate.setFillAfter(true);
        this.startAnimation(rotate);
    }

}