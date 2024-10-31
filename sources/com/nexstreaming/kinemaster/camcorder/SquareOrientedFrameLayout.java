package com.nexstreaming.kinemaster.camcorder;

import android.content.Context;
import android.util.AttributeSet;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;

/* loaded from: classes.dex */
public class SquareOrientedFrameLayout extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private OrientationEventListener f3264a;
    private int b;
    private int c;

    public SquareOrientedFrameLayout(Context context) {
        super(context);
        this.b = -1;
        this.c = -1;
    }

    public SquareOrientedFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = -1;
        this.c = -1;
    }

    public SquareOrientedFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = -1;
        this.c = -1;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        this.f3264a = new u(this, getContext(), 2, (WindowManager) getContext().getSystemService("window"));
        this.f3264a.enable();
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.f3264a.disable();
        this.f3264a = null;
        super.onDetachedFromWindow();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (View.MeasureSpec.getSize(i) < View.MeasureSpec.getSize(i2)) {
            super.onMeasure(i, i);
        } else {
            super.onMeasure(i2, i2);
        }
    }
}
