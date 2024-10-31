package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

@zzark
/* renamed from: com.google.android.gms.internal.ads.qe */
/* loaded from: classes2.dex */
final class C1053qe<T> implements zzbcb<T> {

    /* renamed from: a */
    private final Throwable f12454a;

    /* renamed from: b */
    private final C1080se f12455b = new C1080se();

    public C1053qe(Throwable th) {
        this.f12454a = th;
        this.f12455b.a();
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        return false;
    }

    @Override // java.util.concurrent.Future
    public final T get() throws ExecutionException {
        throw new ExecutionException(this.f12454a);
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
        this.f12455b.a(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public final T get(long j, TimeUnit timeUnit) throws ExecutionException {
        throw new ExecutionException(this.f12454a);
    }
}
