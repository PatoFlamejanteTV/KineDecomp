package com.google.android.gms.internal.ads;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.ParametersAreNonnullByDefault;

@zzark
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public class zzbcl<T> implements zzbcb<T> {
    private T mValue;
    private boolean zzdnk;
    private Throwable zzepv;
    private boolean zzepw;
    private final Object mLock = new Object();
    private final C1080se zzepx = new C1080se();

    private final boolean zzaay() {
        return this.zzepv != null || this.zzepw;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        if (!z) {
            return false;
        }
        synchronized (this.mLock) {
            if (zzaay()) {
                return false;
            }
            this.zzdnk = true;
            this.zzepw = true;
            this.mLock.notifyAll();
            this.zzepx.a();
            return true;
        }
    }

    @Override // java.util.concurrent.Future
    public T get() throws CancellationException, ExecutionException, InterruptedException {
        T t;
        synchronized (this.mLock) {
            if (!zzaay()) {
                try {
                    this.mLock.wait();
                } catch (InterruptedException e2) {
                    throw e2;
                }
            }
            if (this.zzepv == null) {
                if (!this.zzdnk) {
                    t = this.mValue;
                } else {
                    throw new CancellationException("SettableFuture was cancelled.");
                }
            } else {
                throw new ExecutionException(this.zzepv);
            }
        }
        return t;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzdnk;
        }
        return z;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        boolean zzaay;
        synchronized (this.mLock) {
            zzaay = zzaay();
        }
        return zzaay;
    }

    public final void set(T t) {
        synchronized (this.mLock) {
            if (this.zzdnk) {
                return;
            }
            if (zzaay()) {
                com.google.android.gms.ads.internal.zzbv.i().zzb(new IllegalStateException("Provided SettableFuture with multiple values."), "SettableFuture.set");
                return;
            }
            this.zzepw = true;
            this.mValue = t;
            this.mLock.notifyAll();
            this.zzepx.a();
        }
    }

    public final void setException(Throwable th) {
        synchronized (this.mLock) {
            if (this.zzdnk) {
                return;
            }
            if (zzaay()) {
                com.google.android.gms.ads.internal.zzbv.i().zzb(new IllegalStateException("Provided SettableFuture with multiple values."), "SettableFuture.setException");
                return;
            }
            this.zzepv = th;
            this.mLock.notifyAll();
            this.zzepx.a();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbcb
    public final void zza(Runnable runnable, Executor executor) {
        this.zzepx.a(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public T get(long j, TimeUnit timeUnit) throws CancellationException, ExecutionException, InterruptedException, TimeoutException {
        T t;
        synchronized (this.mLock) {
            if (!zzaay()) {
                try {
                    long millis = timeUnit.toMillis(j);
                    if (millis != 0) {
                        this.mLock.wait(millis);
                    }
                } catch (InterruptedException e2) {
                    throw e2;
                }
            }
            if (this.zzepv == null) {
                if (this.zzepw) {
                    if (!this.zzdnk) {
                        t = this.mValue;
                    } else {
                        throw new CancellationException("SettableFuture was cancelled.");
                    }
                } else {
                    throw new TimeoutException("SettableFuture timed out.");
                }
            } else {
                throw new ExecutionException(this.zzepv);
            }
        }
        return t;
    }
}
