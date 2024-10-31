package com.google.android.gms.internal;

import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
class ef extends eh implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference<ViewTreeObserver.OnGlobalLayoutListener> f1525a;

    public ef(View view, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        super(view);
        this.f1525a = new WeakReference<>(onGlobalLayoutListener);
    }

    @Override // com.google.android.gms.internal.eh
    protected void a(ViewTreeObserver viewTreeObserver) {
        viewTreeObserver.addOnGlobalLayoutListener(this);
    }

    @Override // com.google.android.gms.internal.eh
    protected void b(ViewTreeObserver viewTreeObserver) {
        com.google.android.gms.ads.internal.zzp.g().zza(viewTreeObserver, this);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = this.f1525a.get();
        if (onGlobalLayoutListener != null) {
            onGlobalLayoutListener.onGlobalLayout();
        } else {
            b();
        }
    }
}
