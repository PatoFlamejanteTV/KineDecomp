package com.google.android.gms.internal;

import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
class eg extends eh implements ViewTreeObserver.OnScrollChangedListener {

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference<ViewTreeObserver.OnScrollChangedListener> f1526a;

    public eg(View view, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        super(view);
        this.f1526a = new WeakReference<>(onScrollChangedListener);
    }

    @Override // com.google.android.gms.internal.eh
    protected void a(ViewTreeObserver viewTreeObserver) {
        viewTreeObserver.addOnScrollChangedListener(this);
    }

    @Override // com.google.android.gms.internal.eh
    protected void b(ViewTreeObserver viewTreeObserver) {
        viewTreeObserver.removeOnScrollChangedListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public void onScrollChanged() {
        ViewTreeObserver.OnScrollChangedListener onScrollChangedListener = this.f1526a.get();
        if (onScrollChangedListener != null) {
            onScrollChangedListener.onScrollChanged();
        } else {
            b();
        }
    }
}
