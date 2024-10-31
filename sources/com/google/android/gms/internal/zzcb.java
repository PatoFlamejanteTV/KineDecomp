package com.google.android.gms.internal;

import android.text.TextUtils;

/* loaded from: classes.dex */
public class zzcb {
    public zzca zza(zzbz zzbzVar) {
        if (zzbzVar == null) {
            throw new IllegalArgumentException("CSI configuration can't be null. ");
        }
        if (!zzbzVar.zzdg()) {
            com.google.android.gms.ads.internal.util.client.zzb.d("CsiReporterFactory: CSI is not enabled. No CSI reporter created.");
            return null;
        }
        if (zzbzVar.getContext() == null) {
            throw new IllegalArgumentException("Context can't be null. Please set up context in CsiConfiguration.");
        }
        if (TextUtils.isEmpty(zzbzVar.zzbV())) {
            throw new IllegalArgumentException("AfmaVersion can't be null or empty. Please set up afmaVersion in CsiConfiguration.");
        }
        return new zzca(zzbzVar.getContext(), zzbzVar.zzbV(), zzbzVar.zzdh(), zzbzVar.zzdi());
    }
}
