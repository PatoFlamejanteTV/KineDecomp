package com.google.firebase.inappmessaging.display.internal;

import android.R;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;

/* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
/* loaded from: classes2.dex */
public class SwipeDismissTouchListener implements View.OnTouchListener {

    /* renamed from: a */
    private int f17563a;

    /* renamed from: b */
    private int f17564b;

    /* renamed from: c */
    private int f17565c;

    /* renamed from: d */
    private long f17566d;

    /* renamed from: e */
    private View f17567e;

    /* renamed from: f */
    private DismissCallbacks f17568f;

    /* renamed from: g */
    private int f17569g = 1;

    /* renamed from: h */
    private float f17570h;
    private float i;
    private boolean j;
    private int k;
    private Object l;
    private VelocityTracker m;
    private float n;

    /* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
    /* loaded from: classes2.dex */
    public interface DismissCallbacks {
        void a(View view, Object obj);

        boolean a(Object obj);
    }

    public SwipeDismissTouchListener(View view, Object obj, DismissCallbacks dismissCallbacks) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(view.getContext());
        this.f17563a = viewConfiguration.getScaledTouchSlop();
        this.f17564b = viewConfiguration.getScaledMinimumFlingVelocity() * 16;
        this.f17565c = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f17566d = view.getContext().getResources().getInteger(R.integer.config_shortAnimTime);
        this.f17567e = view;
        this.l = obj;
        this.f17568f = dismissCallbacks;
    }

    /* JADX WARN: Code restructure failed: missing block: B:70:0x0141, code lost:            if (r9.m.getXVelocity() > 0.0f) goto L156;     */
    @Override // android.view.View.OnTouchListener
    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouch(android.view.View r10, android.view.MotionEvent r11) {
        /*
            Method dump skipped, instructions count: 391
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.inappmessaging.display.internal.SwipeDismissTouchListener.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public void c() {
        ViewGroup.LayoutParams layoutParams = this.f17567e.getLayoutParams();
        int height = this.f17567e.getHeight();
        ValueAnimator duration = ValueAnimator.ofInt(height, 1).setDuration(this.f17566d);
        duration.addListener(new i(this, layoutParams, height));
        duration.addUpdateListener(new j(this, layoutParams));
        duration.start();
    }

    protected float a() {
        return this.f17567e.getTranslationX();
    }

    public void b(float f2) {
        this.f17567e.setTranslationX(f2);
    }

    public void a(float f2) {
        this.f17567e.setAlpha(f2);
    }

    protected void b() {
        a(0.0f, 1.0f, null);
    }

    protected void a(boolean z) {
        a(z ? this.f17569g : -this.f17569g, 0.0f, new g(this));
    }

    private void a(float f2, float f3, AnimatorListenerAdapter animatorListenerAdapter) {
        float a2 = a();
        float f4 = f2 - a2;
        float alpha = this.f17567e.getAlpha();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(this.f17566d);
        ofFloat.addUpdateListener(new h(this, a2, f4, alpha, f3 - alpha));
        if (animatorListenerAdapter != null) {
            ofFloat.addListener(animatorListenerAdapter);
        }
        ofFloat.start();
    }
}
