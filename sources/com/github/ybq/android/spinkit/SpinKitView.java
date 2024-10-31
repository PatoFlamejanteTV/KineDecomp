package com.github.ybq.android.spinkit;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.github.ybq.android.spinkit.b.q;

/* loaded from: classes.dex */
public class SpinKitView extends ProgressBar {

    /* renamed from: a, reason: collision with root package name */
    private Style f9865a;

    /* renamed from: b, reason: collision with root package name */
    private int f9866b;

    /* renamed from: c, reason: collision with root package name */
    private q f9867c;

    public SpinKitView(Context context) {
        this(context, null);
    }

    private void a() {
        q a2 = e.a(this.f9865a);
        a2.b(this.f9866b);
        setIndeterminateDrawable(a2);
    }

    @Override // android.view.View
    public void onScreenStateChanged(int i) {
        q qVar;
        super.onScreenStateChanged(i);
        if (i != 0 || (qVar = this.f9867c) == null) {
            return;
        }
        qVar.stop();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && this.f9867c != null && getVisibility() == 0) {
            this.f9867c.start();
        }
    }

    public void setColor(int i) {
        this.f9866b = i;
        q qVar = this.f9867c;
        if (qVar != null) {
            qVar.b(i);
        }
        invalidate();
    }

    @Override // android.widget.ProgressBar
    public void setIndeterminateDrawable(Drawable drawable) {
        if (drawable instanceof q) {
            setIndeterminateDrawable((q) drawable);
            return;
        }
        throw new IllegalArgumentException("this d must be instanceof Sprite");
    }

    @Override // android.view.View
    public void unscheduleDrawable(Drawable drawable) {
        super.unscheduleDrawable(drawable);
        if (drawable instanceof q) {
            ((q) drawable).stop();
        }
    }

    public SpinKitView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.SpinKitViewStyle);
    }

    @Override // android.widget.ProgressBar
    public q getIndeterminateDrawable() {
        return this.f9867c;
    }

    public SpinKitView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, b.SpinKitView);
    }

    @TargetApi(21)
    public SpinKitView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.SpinKitView, i, i2);
        this.f9865a = Style.values()[obtainStyledAttributes.getInt(c.SpinKitView_SpinKit_Style, 0)];
        this.f9866b = obtainStyledAttributes.getColor(c.SpinKitView_SpinKit_Color, -1);
        obtainStyledAttributes.recycle();
        a();
        setIndeterminate(true);
    }

    public void setIndeterminateDrawable(q qVar) {
        super.setIndeterminateDrawable((Drawable) qVar);
        this.f9867c = qVar;
        if (this.f9867c.a() == 0) {
            this.f9867c.b(this.f9866b);
        }
        onSizeChanged(getWidth(), getHeight(), getWidth(), getHeight());
        if (getVisibility() == 0) {
            this.f9867c.start();
        }
    }
}
