package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* loaded from: classes2.dex */
public final class zzeg extends zzeu {
    private static final Object zzum = new Object();
    private static volatile Long zzuo;

    public zzeg(zzdl zzdlVar, String str, String str2, zzbl zzblVar, int i, int i2) {
        super(zzdlVar, str, str2, zzblVar, i, 22);
    }

    @Override // com.google.android.gms.internal.ads.zzeu
    protected final void zzas() throws IllegalAccessException, InvocationTargetException {
        if (zzuo == null) {
            synchronized (zzum) {
                if (zzuo == null) {
                    zzuo = (Long) this.zzuw.invoke(null, new Object[0]);
                }
            }
        }
        synchronized (this.zzun) {
            this.zzun.zzep = zzuo;
        }
    }
}
