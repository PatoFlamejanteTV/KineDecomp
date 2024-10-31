package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* loaded from: classes2.dex */
public final class zzed extends zzeu {
    private long startTime;

    public zzed(zzdl zzdlVar, String str, String str2, zzbl zzblVar, long j, int i, int i2) {
        super(zzdlVar, str, str2, zzblVar, i, 25);
        this.startTime = j;
    }

    @Override // com.google.android.gms.internal.ads.zzeu
    protected final void zzas() throws IllegalAccessException, InvocationTargetException {
        long longValue = ((Long) this.zzuw.invoke(null, new Object[0])).longValue();
        synchronized (this.zzun) {
            this.zzun.zzgi = Long.valueOf(longValue);
            if (this.startTime != 0) {
                this.zzun.zzel = Long.valueOf(longValue - this.startTime);
                this.zzun.zzeq = Long.valueOf(this.startTime);
            }
        }
    }
}
