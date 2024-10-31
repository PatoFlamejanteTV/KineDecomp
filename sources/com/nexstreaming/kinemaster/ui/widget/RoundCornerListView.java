package com.nexstreaming.kinemaster.ui.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ListView;
import com.nexstreaming.app.kinemasterfree.b;

/* loaded from: classes.dex */
public class RoundCornerListView extends ListView {

    /* renamed from: a, reason: collision with root package name */
    private float f4378a;
    private Path b;
    private RectF c;

    public RoundCornerListView(Context context) {
        super(context);
        this.b = new Path();
        this.c = new RectF();
        a(null);
    }

    public RoundCornerListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = new Path();
        this.c = new RectF();
        a(attributeSet);
    }

    public RoundCornerListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = new Path();
        this.c = new RectF();
        a(attributeSet);
    }

    @TargetApi(21)
    public RoundCornerListView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.b = new Path();
        this.c = new RectF();
        a(attributeSet);
    }

    void a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            this.f4378a = getContext().getTheme().obtainStyledAttributes(attributeSet, b.a.RoundCornerListView, 0, 0).getDimension(0, 0.0f);
        }
    }

    public float getCornerRadius() {
        return this.f4378a;
    }

    public void setCornerRadius(float f) {
        this.f4378a = f;
        invalidate();
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        this.b.rewind();
        this.c.set(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
        this.b.addRoundRect(this.c, this.f4378a, this.f4378a, Path.Direction.CCW);
        canvas.save();
        canvas.clipPath(this.b);
        super.dispatchDraw(canvas);
        canvas.restore();
    }
}
