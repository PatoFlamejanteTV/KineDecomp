package com.google.android.gms.internal.ads;

import java.util.Random;

@zzark
/* loaded from: classes2.dex */
public final class zzwv extends zzya {
    private Object mLock = new Object();
    private final Random zzcls = new Random();
    private long zzclt;

    public zzwv() {
        zzqd();
    }

    @Override // com.google.android.gms.internal.ads.zzxz
    public final long getValue() {
        return this.zzclt;
    }

    public final void zzqd() {
        synchronized (this.mLock) {
            int i = 3;
            long j = 0;
            while (true) {
                i--;
                if (i <= 0) {
                    break;
                }
                j = this.zzcls.nextInt() + 2147483648L;
                if (j != this.zzclt && j != 0) {
                    break;
                }
            }
            this.zzclt = j;
        }
    }
}
