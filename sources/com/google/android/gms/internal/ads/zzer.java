package com.google.android.gms.internal.ads;

import android.view.View;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes2.dex */
public final class zzer extends zzeu {
    private final View zzuh;

    public zzer(zzdl zzdlVar, String str, String str2, zzbl zzblVar, int i, int i2, View view) {
        super(zzdlVar, str, str2, zzblVar, i, 57);
        this.zzuh = view;
    }

    @Override // com.google.android.gms.internal.ads.zzeu
    protected final void zzas() throws IllegalAccessException, InvocationTargetException {
        if (this.zzuh != null) {
            zzdt zzdtVar = new zzdt((String) this.zzuw.invoke(null, this.zzuh, this.zzqo.getContext().getResources().getDisplayMetrics()));
            zzbn zzbnVar = new zzbn();
            zzbnVar.zzhe = zzdtVar.zztt;
            zzbnVar.zzhf = zzdtVar.zzhf;
            zzbnVar.zzhg = zzdtVar.zzhg;
            this.zzun.zzfp = zzbnVar;
        }
    }
}
