package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* loaded from: classes2.dex */
public final class zzej extends zzeu {
    public zzej(zzdl zzdlVar, String str, String str2, zzbl zzblVar, int i, int i2) {
        super(zzdlVar, str, str2, zzblVar, i, 3);
    }

    @Override // com.google.android.gms.internal.ads.zzeu
    protected final void zzas() throws IllegalAccessException, InvocationTargetException {
        synchronized (this.zzun) {
            zzcy zzcyVar = new zzcy((String) this.zzuw.invoke(null, this.zzqo.getContext()));
            synchronized (this.zzun) {
                this.zzun.zzdx = Long.valueOf(zzcyVar.zzse);
                this.zzun.zzfs = Long.valueOf(zzcyVar.zzsf);
            }
        }
    }
}
