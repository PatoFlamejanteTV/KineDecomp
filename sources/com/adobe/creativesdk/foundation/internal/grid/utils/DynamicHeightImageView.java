package com.adobe.creativesdk.foundation.internal.grid.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

/* loaded from: classes.dex */
public class DynamicHeightImageView extends ImageView {

    /* renamed from: a */
    private double f5061a;

    /* renamed from: b */
    Path f5062b;

    /* renamed from: c */
    RectF f5063c;

    @TargetApi(11)
    public DynamicHeightImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5062b = new Path();
        this.f5063c = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        if (Build.VERSION.SDK_INT < 18) {
            setLayerType(1, null);
        }
    }

    public double getHeightRatio() {
        return this.f5061a;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        RectF rectF = this.f5063c;
        rectF.left = 0.0f;
        rectF.top = 0.0f;
        rectF.right = getWidth();
        this.f5063c.bottom = getHeight();
        this.f5062b.addRoundRect(this.f5063c, 2.0f, 2.0f, Path.Direction.CW);
        canvas.clipPath(this.f5062b);
        super.onDraw(canvas);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.f5061a > 0.0d) {
            int size = View.MeasureSpec.getSize(i);
            double d2 = size;
            double d3 = this.f5061a;
            Double.isNaN(d2);
            setMeasuredDimension(size, (int) (d2 * d3));
            return;
        }
        super.onMeasure(i, i2);
    }

    public void setHeightRatio(double d2) {
        if (d2 != this.f5061a) {
            this.f5061a = d2;
            requestLayout();
        }
    }

    @TargetApi(11)
    public DynamicHeightImageView(Context context) {
        super(context);
        this.f5062b = new Path();
        this.f5063c = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        if (Build.VERSION.SDK_INT < 18) {
            setLayerType(1, null);
        }
    }
}
