package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* loaded from: classes2.dex */
public final class zzeh extends zzeu {
    private long zzup;

    public zzeh(zzdl zzdlVar, String str, String str2, zzbl zzblVar, int i, int i2) {
        super(zzdlVar, str, str2, zzblVar, i, 12);
        this.zzup = -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzeu
    protected final void zzas() throws IllegalAccessException, InvocationTargetException {
        this.zzun.zzeg = -1L;
        this.zzun.zzeg = (Long) this.zzuw.invoke(null, this.zzqo.getContext());
    }
}
