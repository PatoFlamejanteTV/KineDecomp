package com.nexstreaming.kinemaster.ui.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ListView;

/* loaded from: classes2.dex */
public class RoundCornerListView extends ListView {

    /* renamed from: a */
    private float f23806a;

    /* renamed from: b */
    private Path f23807b;

    /* renamed from: c */
    private RectF f23808c;

    public RoundCornerListView(Context context) {
        super(context);
        this.f23807b = new Path();
        this.f23808c = new RectF();
        a(null);
    }

    void a(AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        this.f23806a = getContext().getTheme().obtainStyledAttributes(attributeSet, com.nexstreaming.app.kinemasterfree.c.RoundCornerListView, 0, 0).getDimension(0, 0.0f);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        this.f23807b.rewind();
        this.f23808c.set(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
        Path path = this.f23807b;
        RectF rectF = this.f23808c;
        float f2 = this.f23806a;
        path.addRoundRect(rectF, f2, f2, Path.Direction.CCW);
        canvas.save();
        canvas.clipPath(this.f23807b);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public float getCornerRadius() {
        return this.f23806a;
    }

    public void setCornerRadius(float f2) {
        this.f23806a = f2;
        invalidate();
    }

    public RoundCornerListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23807b = new Path();
        this.f23808c = new RectF();
        a(attributeSet);
    }

    public RoundCornerListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f23807b = new Path();
        this.f23808c = new RectF();
        a(attributeSet);
    }

    @TargetApi(21)
    public RoundCornerListView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f23807b = new Path();
        this.f23808c = new RectF();
        a(attributeSet);
    }
}
