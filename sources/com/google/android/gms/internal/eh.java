package com.google.android.gms.internal;

import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
abstract class eh {

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference<View> f1527a;

    public eh(View view) {
        this.f1527a = new WeakReference<>(view);
    }

    public final void a() {
        ViewTreeObserver c = c();
        if (c != null) {
            a(c);
        }
    }

    protected abstract void a(ViewTreeObserver viewTreeObserver);

    public final void b() {
        ViewTreeObserver c = c();
        if (c != null) {
            b(c);
        }
    }

    protected abstract void b(ViewTreeObserver viewTreeObserver);

    protected ViewTreeObserver c() {
        View view = this.f1527a.get();
        if (view == null) {
            return null;
        }
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver == null || !viewTreeObserver.isAlive()) {
            return null;
        }
        return viewTreeObserver;
    }
}
