package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

@zzark
/* renamed from: com.google.android.gms.internal.ads.re */
/* loaded from: classes2.dex */
public final class C1066re<T> implements zzbcb<T> {

    /* renamed from: a */
    private final T f12487a;

    /* renamed from: b */
    private final C1080se f12488b = new C1080se();

    public C1066re(T t) {
        this.f12487a = t;
        this.f12488b.a();
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        return false;
    }

    @Override // java.util.concurrent.Future
    public final T get() {
        return this.f12487a;
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzbcb
    public final void zza(Runnable runnable, Executor executor) {
        this.f12488b.a(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public final T get(long j, TimeUnit timeUnit) {
        return this.f12487a;
    }
}
