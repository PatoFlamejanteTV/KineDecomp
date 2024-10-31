package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* loaded from: classes2.dex */
public final class zzeb extends zzeu {
    public zzeb(zzdl zzdlVar, String str, String str2, zzbl zzblVar, int i, int i2) {
        super(zzdlVar, str, str2, zzblVar, i, 5);
    }

    @Override // com.google.android.gms.internal.ads.zzeu
    protected final void zzas() throws IllegalAccessException, InvocationTargetException {
        this.zzun.zzdz = -1L;
        this.zzun.zzea = -1L;
        int[] iArr = (int[]) this.zzuw.invoke(null, this.zzqo.getContext());
        synchronized (this.zzun) {
            this.zzun.zzdz = Long.valueOf(iArr[0]);
            this.zzun.zzea = Long.valueOf(iArr[1]);
            if (iArr[2] != Integer.MIN_VALUE) {
                this.zzun.zzfr = Long.valueOf(iArr[2]);
            }
        }
    }
}
