package android.support.v4.app;

import android.view.View;
import android.view.ViewTreeObserver;

/* loaded from: classes.dex */
class OneShotPreDrawListener implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* renamed from: a */
    private final View f1021a;

    /* renamed from: b */
    private ViewTreeObserver f1022b;

    /* renamed from: c */
    private final Runnable f1023c;

    private OneShotPreDrawListener(View view, Runnable runnable) {
        this.f1021a = view;
        this.f1022b = view.getViewTreeObserver();
        this.f1023c = runnable;
    }

    public static OneShotPreDrawListener add(View view, Runnable runnable) {
        OneShotPreDrawListener oneShotPreDrawListener = new OneShotPreDrawListener(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(oneShotPreDrawListener);
        view.addOnAttachStateChangeListener(oneShotPreDrawListener);
        return oneShotPreDrawListener;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        removeListener();
        this.f1023c.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        this.f1022b = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        removeListener();
    }

    public void removeListener() {
        if (this.f1022b.isAlive()) {
            this.f1022b.removeOnPreDrawListener(this);
        } else {
            this.f1021a.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.f1021a.removeOnAttachStateChangeListener(this);
    }
}
