package com.google.android.gms.internal;

import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@zzgr
/* loaded from: classes.dex */
public class zzin<T> implements zziq<T> {
    private final Object zzpd = new Object();
    private T zzJy = null;
    private boolean zzJz = false;
    private boolean zzzD = false;
    private final ee zzJA = new ee();

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        boolean z2 = false;
        if (z) {
            synchronized (this.zzpd) {
                if (!this.zzJz) {
                    this.zzzD = true;
                    this.zzJz = true;
                    this.zzpd.notifyAll();
                    this.zzJA.a();
                    z2 = true;
                }
            }
        }
        return z2;
    }

    @Override // java.util.concurrent.Future
    public T get() {
        T t;
        synchronized (this.zzpd) {
            if (!this.zzJz) {
                try {
                    this.zzpd.wait();
                } catch (InterruptedException e) {
                }
            }
            if (this.zzzD) {
                throw new CancellationException("CallbackFuture was cancelled.");
            }
            t = this.zzJy;
        }
        return t;
    }

    @Override // java.util.concurrent.Future
    public T get(long j, TimeUnit timeUnit) throws TimeoutException {
        T t;
        synchronized (this.zzpd) {
            if (!this.zzJz) {
                try {
                    long millis = timeUnit.toMillis(j);
                    if (millis != 0) {
                        this.zzpd.wait(millis);
                    }
                } catch (InterruptedException e) {
                }
            }
            if (!this.zzJz) {
                throw new TimeoutException("CallbackFuture timed out.");
            }
            if (this.zzzD) {
                throw new CancellationException("CallbackFuture was cancelled.");
            }
            t = this.zzJy;
        }
        return t;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        boolean z;
        synchronized (this.zzpd) {
            z = this.zzzD;
        }
        return z;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        boolean z;
        synchronized (this.zzpd) {
            z = this.zzJz;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.zziq
    public void zzc(Runnable runnable) {
        this.zzJA.a(runnable);
    }

    public void zzd(Runnable runnable) {
        this.zzJA.b(runnable);
    }

    public void zzf(T t) {
        synchronized (this.zzpd) {
            if (this.zzzD) {
                return;
            }
            if (this.zzJz) {
                throw new IllegalStateException("Provided CallbackFuture with multiple values.");
            }
            this.zzJz = true;
            this.zzJy = t;
            this.zzpd.notifyAll();
            this.zzJA.a();
        }
    }
}
