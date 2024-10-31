package com.google.android.gms.internal.ads;

@zzark
/* loaded from: classes2.dex */
public final class zzbai {
    private long zzeno;
    private long zzenp = Long.MIN_VALUE;
    private Object mLock = new Object();

    public zzbai(long j) {
        this.zzeno = j;
    }

    public final boolean tryAcquire() {
        synchronized (this.mLock) {
            long c2 = com.google.android.gms.ads.internal.zzbv.l().c();
            if (this.zzenp + this.zzeno > c2) {
                return false;
            }
            this.zzenp = c2;
            return true;
        }
    }
}
