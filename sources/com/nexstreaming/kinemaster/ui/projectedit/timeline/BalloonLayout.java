package com.nexstreaming.kinemaster.ui.projectedit.timeline;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;

/* loaded from: classes2.dex */
public class BalloonLayout extends LinearLayout {

    /* renamed from: a */
    private int f22559a;

    /* renamed from: b */
    private int f22560b;

    /* renamed from: c */
    private int f22561c;

    /* renamed from: d */
    private int f22562d;

    public BalloonLayout(Context context) {
        this(context, null, 0);
    }

    private int a(float f2) {
        return (int) TypedValue.applyDimension(1, f2, getResources().getDisplayMetrics());
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        this.f22559a = 0;
        this.f22560b = 0;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i, i2);
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (measuredWidth > 0 && measuredHeight > 0) {
                    this.f22559a = Math.max(measuredWidth, measuredHeight);
                    this.f22560b += measuredHeight;
                }
            }
        }
        int max = Math.max(getMinimumWidth(), this.f22559a + getPaddingLeft() + getPaddingRight());
        int paddingTop = this.f22560b + this.f22562d + getPaddingTop() + getPaddingBottom();
        this.f22561c = max / 8;
        setMeasuredDimension(max, paddingTop + this.f22561c);
        a(getMeasuredWidth(), getMeasuredHeight());
    }

    public BalloonLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(int i, int i2) {
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        float f2 = i;
        path.lineTo(f2, 0.0f);
        path.lineTo(f2, this.f22560b + getPaddingTop() + getPaddingBottom());
        int i3 = i / 5;
        path.lineTo(i3 * 3, this.f22560b + getPaddingTop() + getPaddingBottom());
        path.lineTo(i / 2, this.f22560b + this.f22561c + getPaddingTop() + getPaddingBottom());
        path.lineTo(i3 * 2, this.f22560b + getPaddingTop() + getPaddingBottom());
        path.lineTo(0.0f, this.f22560b + getPaddingTop() + getPaddingBottom());
        path.lineTo(0.0f, 0.0f);
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(-1);
        canvas.drawPath(path, paint);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(1.0f);
        paint.setColor(-7829368);
        canvas.drawPath(path, paint);
        setBackground(new BitmapDrawable(getResources(), createBitmap));
    }

    public BalloonLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setOrientation(1);
        this.f22562d = a(8.0f);
    }
}
