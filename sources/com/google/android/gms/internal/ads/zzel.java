package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* loaded from: classes2.dex */
public final class zzel extends zzeu {
    private final boolean zzur;

    public zzel(zzdl zzdlVar, String str, String str2, zzbl zzblVar, int i, int i2) {
        super(zzdlVar, str, str2, zzblVar, i, 61);
        this.zzur = zzdlVar.zzaj();
    }

    @Override // com.google.android.gms.internal.ads.zzeu
    protected final void zzas() throws IllegalAccessException, InvocationTargetException {
        long longValue = ((Long) this.zzuw.invoke(null, this.zzqo.getContext(), Boolean.valueOf(this.zzur))).longValue();
        synchronized (this.zzun) {
            this.zzun.zzft = Long.valueOf(longValue);
        }
    }
}
