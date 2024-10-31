package com.qq.e.ads.nativ;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.qq.e.comm.util.GDTLogger;

/* loaded from: classes3.dex */
public final class MediaView extends FrameLayout {

    /* renamed from: a */
    private int f24876a;

    /* renamed from: b */
    private int f24877b;

    public MediaView(Context context) {
        super(context);
    }

    public MediaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MediaView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.view.ViewGroup, android.view.View
    @SuppressLint({"NewApi"})
    protected final void onAttachedToWindow() {
        GDTLogger.d("onAttachedToWindow");
        super.onAttachedToWindow();
        if (Build.VERSION.SDK_INT < 11 || isHardwareAccelerated()) {
            return;
        }
        GDTLogger.e("Hardware acceleration is off");
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected final void onMeasure(int i, int i2) {
        if (this.f24876a > 0 && this.f24877b > 0) {
            int size = View.MeasureSpec.getSize(i);
            int size2 = View.MeasureSpec.getSize(i2);
            int i3 = this.f24877b;
            int i4 = size * i3;
            int i5 = this.f24876a;
            if (i4 < i5 * size2 || size2 == 0) {
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec((size * this.f24877b) / this.f24876a, 1073741824);
                i = makeMeasureSpec;
            } else {
                if (i3 * size > i5 * size2 || size == 0) {
                    size = (this.f24876a * size2) / this.f24877b;
                }
                i = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(size2, 1073741824);
            }
        }
        super.onMeasure(i, i2);
    }

    public final void setRatio(int i, int i2) {
        this.f24876a = i;
        this.f24877b = i2;
    }
}
