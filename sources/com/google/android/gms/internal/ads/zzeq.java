package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* loaded from: classes2.dex */
public final class zzeq extends zzeu {
    public zzeq(zzdl zzdlVar, String str, String str2, zzbl zzblVar, int i, int i2) {
        super(zzdlVar, str, str2, zzblVar, i, 48);
    }

    @Override // com.google.android.gms.internal.ads.zzeu
    protected final void zzas() throws IllegalAccessException, InvocationTargetException {
        this.zzun.zzff = 2;
        boolean booleanValue = ((Boolean) this.zzuw.invoke(null, this.zzqo.getContext())).booleanValue();
        synchronized (this.zzun) {
            if (booleanValue) {
                this.zzun.zzff = 1;
            } else {
                this.zzun.zzff = 0;
            }
        }
    }
}
