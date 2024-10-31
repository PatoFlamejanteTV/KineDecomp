package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.common.GooglePlayServicesUtil;

@zzgr
/* loaded from: classes.dex */
public class zzbx {
    private final Object zzpd = new Object();
    private boolean zzpA = false;
    private SharedPreferences zzuj = null;

    public void initialize(Context context) {
        synchronized (this.zzpd) {
            if (this.zzpA) {
                return;
            }
            Context e = GooglePlayServicesUtil.e(context);
            if (e == null) {
                return;
            }
            this.zzuj = com.google.android.gms.ads.internal.zzp.l().zzv(e);
            this.zzpA = true;
        }
    }

    public <T> T zzd(zzbu<T> zzbuVar) {
        synchronized (this.zzpd) {
            if (this.zzpA) {
                return zzbuVar.zza(this.zzuj);
            }
            return zzbuVar.zzde();
        }
    }
}
