package com.nexstreaming.kinemaster.camcorder;

import android.content.Context;
import android.view.TextureView;
import android.view.View;

/* compiled from: FixedRatioTextureView.java */
/* loaded from: classes.dex */
public class t extends TextureView {

    /* renamed from: a, reason: collision with root package name */
    private float f3284a;

    public t(Context context) {
        super(context);
        this.f3284a = 1.7777778f;
    }

    public void setAspectRatio(float f) {
        this.f3284a = f;
        requestLayout();
    }

    public float getAspectRatio() {
        return this.f3284a;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (this.f3284a > 0.0f) {
            if (size2 * this.f3284a > size) {
                size2 = (int) (size / this.f3284a);
            } else {
                size = (int) (size2 * this.f3284a);
            }
        }
        setMeasuredDimension(size, size2);
    }
}
