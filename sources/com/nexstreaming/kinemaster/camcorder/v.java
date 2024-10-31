package com.nexstreaming.kinemaster.camcorder;

import android.content.Context;
import android.view.TextureView;
import android.view.View;

/* compiled from: FixedRatioTextureView.java */
/* loaded from: classes.dex */
public class v extends TextureView {

    /* renamed from: a */
    private float f20011a;

    public v(Context context) {
        super(context);
        this.f20011a = 1.7777778f;
    }

    public float getAspectRatio() {
        return this.f20011a;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        float f2 = this.f20011a;
        if (f2 > 0.0f) {
            float f3 = size2;
            float f4 = size;
            if (f3 * f2 > f4) {
                size2 = (int) (f4 / f2);
            } else {
                size = (int) (f3 * f2);
            }
        }
        setMeasuredDimension(size, size2);
    }

    public void setAspectRatio(float f2) {
        this.f20011a = f2;
        requestLayout();
    }
}
