package com.nexstreaming.kinemaster.camcorder;

import android.content.Context;
import android.util.AttributeSet;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;

/* loaded from: classes.dex */
public class SquareOrientedFrameLayout extends FrameLayout {

    /* renamed from: a */
    private OrientationEventListener f19985a;

    /* renamed from: b */
    private int f19986b;

    /* renamed from: c */
    private int f19987c;

    public SquareOrientedFrameLayout(Context context) {
        super(context);
        this.f19986b = -1;
        this.f19987c = -1;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        this.f19985a = new w(this, getContext(), 2, (WindowManager) getContext().getSystemService("window"));
        this.f19985a.enable();
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.f19985a.disable();
        this.f19985a = null;
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

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }

    public SquareOrientedFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19986b = -1;
        this.f19987c = -1;
    }

    public SquareOrientedFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f19986b = -1;
        this.f19987c = -1;
    }
}
