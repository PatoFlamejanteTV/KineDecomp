package com.google.android.gms.internal;

import java.util.concurrent.TimeUnit;

@zzgr
/* loaded from: classes.dex */
public class zzio<T> implements zziq<T> {
    private final ee zzJA = new ee();
    private final T zzJy;

    public zzio(T t) {
        this.zzJy = t;
        this.zzJA.a();
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        return false;
    }

    @Override // java.util.concurrent.Future
    public T get() {
        return this.zzJy;
    }

    @Override // java.util.concurrent.Future
    public T get(long j, TimeUnit timeUnit) {
        return this.zzJy;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return true;
    }

    @Override // com.google.android.gms.internal.zziq
    public void zzc(Runnable runnable) {
        this.zzJA.a(runnable);
    }
}
