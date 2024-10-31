package com.google.firebase.inappmessaging.display.internal.layout.util;

import android.view.View;
import android.widget.ScrollView;

/* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
/* loaded from: classes2.dex */
public class ViewMeasure {

    /* renamed from: a */
    private View f17697a;

    /* renamed from: b */
    private boolean f17698b;

    /* renamed from: c */
    private int f17699c;

    /* renamed from: d */
    private int f17700d;

    public ViewMeasure(View view, boolean z) {
        this.f17697a = view;
        this.f17698b = z;
    }

    public void a(int i, int i2) {
        MeasureUtils.a(this.f17697a, i, i2);
    }

    public int b() {
        return this.f17700d;
    }

    public View c() {
        return this.f17697a;
    }

    public boolean d() {
        return this.f17698b;
    }

    public int a() {
        if (this.f17697a.getVisibility() == 8) {
            return 0;
        }
        View view = this.f17697a;
        if (view instanceof ScrollView) {
            ScrollView scrollView = (ScrollView) view;
            return scrollView.getPaddingBottom() + scrollView.getPaddingTop() + scrollView.getChildAt(0).getMeasuredHeight();
        }
        return view.getMeasuredHeight();
    }

    public void b(int i, int i2) {
        this.f17699c = i;
        this.f17700d = i2;
    }
}
