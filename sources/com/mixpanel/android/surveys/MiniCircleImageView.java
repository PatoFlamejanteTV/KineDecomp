package com.mixpanel.android.surveys;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.ImageView;

/* loaded from: classes.dex */
public class MiniCircleImageView extends ImageView {

    /* renamed from: a, reason: collision with root package name */
    private Paint f3059a;
    private int b;
    private int c;

    public MiniCircleImageView(Context context) {
        super(context);
        a();
    }

    public MiniCircleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public MiniCircleImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        this.f3059a = new Paint(1);
        if (Build.VERSION.SDK_INT >= 23) {
            this.f3059a.setColor(getResources().getColor(R.color.white, null));
        } else {
            this.f3059a.setColor(getResources().getColor(R.color.white));
        }
        this.f3059a.setStyle(Paint.Style.STROKE);
        this.f3059a.setStrokeWidth(TypedValue.applyDimension(1, 2.0f, getResources().getDisplayMetrics()));
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f = this.b / 2;
        float f2 = this.c / 2;
        canvas.drawCircle(f, f2, 0.7f * Math.min(f, f2), this.f3059a);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.b = i;
        this.c = i2;
    }
}
