package com.google.firebase.inappmessaging.display.internal.layout;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import com.google.firebase.inappmessaging.display.R;
import com.google.firebase.inappmessaging.display.internal.Logging;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
/* loaded from: classes2.dex */
public abstract class BaseModalLayout extends FrameLayout {

    /* renamed from: a */
    private float f17680a;

    /* renamed from: b */
    private float f17681b;

    /* renamed from: c */
    private DisplayMetrics f17682c;

    /* renamed from: d */
    private List<View> f17683d;

    public BaseModalLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17683d = new ArrayList();
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.ModalLayout, 0, 0);
        try {
            this.f17680a = obtainStyledAttributes.getFloat(R.styleable.ModalLayout_maxWidthPct, -1.0f);
            this.f17681b = obtainStyledAttributes.getFloat(R.styleable.ModalLayout_maxHeightPct, -1.0f);
            obtainStyledAttributes.recycle();
            this.f17682c = context.getResources().getDisplayMetrics();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public int a(int i) {
        if (getMaxHeightPct() > 0.0f) {
            Logging.a("Height: restrict by pct");
            return a((int) (getDisplayMetrics().heightPixels * getMaxHeightPct()), 4);
        }
        Logging.a("Height: restrict by spec");
        return View.MeasureSpec.getSize(i);
    }

    public int b(int i) {
        if (getMaxWidthPct() > 0.0f) {
            Logging.a("Width: restrict by pct");
            return a((int) (getDisplayMetrics().widthPixels * getMaxWidthPct()), 4);
        }
        Logging.a("Width: restrict by spec");
        return View.MeasureSpec.getSize(i);
    }

    public FrameLayout.LayoutParams c(View view) {
        return (FrameLayout.LayoutParams) view.getLayoutParams();
    }

    public View d(int i) {
        View findViewById = findViewById(i);
        if (findViewById != null) {
            return findViewById;
        }
        throw new IllegalStateException("No such child: " + i);
    }

    public DisplayMetrics getDisplayMetrics() {
        return this.f17682c;
    }

    public float getMaxHeightPct() {
        return this.f17681b;
    }

    public float getMaxWidthPct() {
        return this.f17680a;
    }

    public List<View> getVisibleChildren() {
        return this.f17683d;
    }

    @Override // android.view.ViewGroup
    protected void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        Logging.a("\tdesired (w,h)", view.getMeasuredWidth(), view.getMeasuredHeight());
        super.measureChildWithMargins(view, i, i2, i3, i4);
        Logging.a("\tactual  (w,h)", view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Logging.b("BEGIN LAYOUT");
        Logging.a("onLayout: l: " + i + ", t: " + i2 + ", r: " + i3 + ", b: " + i4);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        Logging.b("BEGIN MEASURE");
        Logging.a("Display", getDisplayMetrics().widthPixels, getDisplayMetrics().heightPixels);
        this.f17683d.clear();
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                this.f17683d.add(childAt);
            } else {
                Logging.a("Skipping GONE child", i3);
            }
        }
    }

    public int c(int i) {
        return (int) Math.floor(TypedValue.applyDimension(1, i, this.f17682c));
    }

    public void a(View view, int i, int i2) {
        a(view, i, i2, i + b(view), i2 + a(view));
    }

    public int b(View view) {
        if (view.getVisibility() == 8) {
            return 0;
        }
        return view.getMeasuredWidth();
    }

    public void a(View view, int i, int i2, int i3, int i4) {
        Logging.a("\tleft, right", i, i3);
        Logging.a("\ttop, bottom", i2, i4);
        view.layout(i, i2, i3, i4);
    }

    public int a(View view) {
        if (view.getVisibility() == 8) {
            return 0;
        }
        return view.getMeasuredHeight();
    }

    protected int a(int i, int i2) {
        return i2 * Math.round(i / i2);
    }
}
