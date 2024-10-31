package com.google.android.gms.internal.ads;

import android.provider.Settings;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes2.dex */
public final class zzdy extends zzeu {
    public zzdy(zzdl zzdlVar, String str, String str2, zzbl zzblVar, int i, int i2) {
        super(zzdlVar, str, str2, zzblVar, i, 49);
    }

    @Override // com.google.android.gms.internal.ads.zzeu
    protected final void zzas() throws IllegalAccessException, InvocationTargetException {
        this.zzun.zzfg = 2;
        try {
            int i = 1;
            boolean booleanValue = ((Boolean) this.zzuw.invoke(null, this.zzqo.getContext())).booleanValue();
            zzbl zzblVar = this.zzun;
            if (!booleanValue) {
                i = 0;
            }
            zzblVar.zzfg = Integer.valueOf(i);
        } catch (InvocationTargetException e2) {
            if (!(e2.getTargetException() instanceof Settings.SettingNotFoundException)) {
                throw e2;
            }
        }
    }
}
