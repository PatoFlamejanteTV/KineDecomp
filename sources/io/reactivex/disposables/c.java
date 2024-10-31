package io.reactivex.disposables;

import io.reactivex.internal.disposables.EmptyDisposable;

/* compiled from: Disposables.java */
/* loaded from: classes3.dex */
public final class c {
    public static b a(Runnable runnable) {
        io.reactivex.d.a.b.a(runnable, "run is null");
        return new RunnableDisposable(runnable);
    }

    public static b b() {
        return a(io.reactivex.d.a.a.f28103b);
    }

    public static b a() {
        return EmptyDisposable.INSTANCE;
    }
}
