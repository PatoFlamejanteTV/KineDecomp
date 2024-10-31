package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* loaded from: classes2.dex */
public final class zzeo extends zzeu {
    private final zzdu zzrt;
    private long zzue;

    public zzeo(zzdl zzdlVar, String str, String str2, zzbl zzblVar, int i, int i2, zzdu zzduVar) {
        super(zzdlVar, str, str2, zzblVar, i, 53);
        this.zzrt = zzduVar;
        if (zzduVar != null) {
            this.zzue = zzduVar.zzaq();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeu
    protected final void zzas() throws IllegalAccessException, InvocationTargetException {
        if (this.zzrt != null) {
            this.zzun.zzfj = (Long) this.zzuw.invoke(null, Long.valueOf(this.zzue));
        }
    }
}
