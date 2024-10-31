package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* loaded from: classes2.dex */
public final class zzen extends zzeu {
    public zzen(zzdl zzdlVar, String str, String str2, zzbl zzblVar, int i, int i2) {
        super(zzdlVar, str, str2, zzblVar, i, 51);
    }

    @Override // com.google.android.gms.internal.ads.zzeu
    protected final void zzas() throws IllegalAccessException, InvocationTargetException {
        synchronized (this.zzun) {
            zzdk zzdkVar = new zzdk((String) this.zzuw.invoke(null, new Object[0]));
            this.zzun.zzfh = zzdkVar.zzsn;
            this.zzun.zzfi = zzdkVar.zzso;
        }
    }
}
