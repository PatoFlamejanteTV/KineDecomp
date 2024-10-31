package com.google.android.gms.internal;

/* loaded from: classes.dex */
public class zzik {
    private long zzJk;
    private long zzJl = Long.MIN_VALUE;
    private Object zzpd = new Object();

    public zzik(long j) {
        this.zzJk = j;
    }

    public boolean tryAcquire() {
        boolean z;
        synchronized (this.zzpd) {
            long elapsedRealtime = com.google.android.gms.ads.internal.zzp.i().elapsedRealtime();
            if (this.zzJl + this.zzJk > elapsedRealtime) {
                z = false;
            } else {
                this.zzJl = elapsedRealtime;
                z = true;
            }
        }
        return z;
    }
}
