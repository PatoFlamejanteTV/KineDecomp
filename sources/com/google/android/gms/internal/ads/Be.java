package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;

@zzark
/* loaded from: classes2.dex */
abstract class Be {

    /* renamed from: a */
    private final WeakReference<View> f11402a;

    public Be(View view) {
        this.f11402a = new WeakReference<>(view);
    }

    private final ViewTreeObserver c() {
        ViewTreeObserver viewTreeObserver;
        View view = this.f11402a.get();
        if (view == null || (viewTreeObserver = view.getViewTreeObserver()) == null || !viewTreeObserver.isAlive()) {
            return null;
        }
        return viewTreeObserver;
    }

    public final void a() {
        ViewTreeObserver c2 = c();
        if (c2 != null) {
            a(c2);
        }
    }

    protected abstract void a(ViewTreeObserver viewTreeObserver);

    public final void b() {
        ViewTreeObserver c2 = c();
        if (c2 != null) {
            b(c2);
        }
    }

    protected abstract void b(ViewTreeObserver viewTreeObserver);
}
