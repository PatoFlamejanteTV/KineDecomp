package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* loaded from: classes2.dex */
public final class zzei extends zzeu {
    private static volatile String zzdw;
    private static final Object zzum = new Object();

    public zzei(zzdl zzdlVar, String str, String str2, zzbl zzblVar, int i, int i2) {
        super(zzdlVar, str, str2, zzblVar, i, 1);
    }

    @Override // com.google.android.gms.internal.ads.zzeu
    protected final void zzas() throws IllegalAccessException, InvocationTargetException {
        this.zzun.zzdw = "E";
        if (zzdw == null) {
            synchronized (zzum) {
                if (zzdw == null) {
                    zzdw = (String) this.zzuw.invoke(null, new Object[0]);
                }
            }
        }
        synchronized (this.zzun) {
            this.zzun.zzdw = zzdw;
        }
    }
}
