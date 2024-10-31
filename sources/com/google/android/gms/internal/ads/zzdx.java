package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.view.View;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes2.dex */
public final class zzdx extends zzeu {
    private final Activity zzug;
    private final View zzuh;

    public zzdx(zzdl zzdlVar, String str, String str2, zzbl zzblVar, int i, int i2, View view, Activity activity) {
        super(zzdlVar, str, str2, zzblVar, i, 62);
        this.zzuh = view;
        this.zzug = activity;
    }

    @Override // com.google.android.gms.internal.ads.zzeu
    protected final void zzas() throws IllegalAccessException, InvocationTargetException {
        if (this.zzuh == null) {
            return;
        }
        boolean booleanValue = ((Boolean) zzwu.zzpz().zzd(zzaan.zzctj)).booleanValue();
        Object[] objArr = (Object[]) this.zzuw.invoke(null, this.zzuh, this.zzug, Boolean.valueOf(booleanValue));
        synchronized (this.zzun) {
            this.zzun.zzfu = Long.valueOf(((Long) objArr[0]).longValue());
            this.zzun.zzfv = Long.valueOf(((Long) objArr[1]).longValue());
            if (booleanValue) {
                this.zzun.zzfw = (String) objArr[2];
            }
        }
    }
}
