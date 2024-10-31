package com.google.android.gms.internal;

import android.text.TextUtils;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class zzpb extends com.google.android.gms.measurement.zze<zzpb> {
    private String zzOZ;
    private String zzPa;
    private String zzaLl;
    private String zzaLm;

    public void setAppId(String str) {
        this.zzaLl = str;
    }

    public void setAppInstallerId(String str) {
        this.zzaLm = str;
    }

    public void setAppName(String str) {
        this.zzOZ = str;
    }

    public void setAppVersion(String str) {
        this.zzPa = str;
    }

    public String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("appName", this.zzOZ);
        hashMap.put("appVersion", this.zzPa);
        hashMap.put("appId", this.zzaLl);
        hashMap.put("appInstallerId", this.zzaLm);
        return zzB(hashMap);
    }

    @Override // com.google.android.gms.measurement.zze
    public void zza(zzpb zzpbVar) {
        if (!TextUtils.isEmpty(this.zzOZ)) {
            zzpbVar.setAppName(this.zzOZ);
        }
        if (!TextUtils.isEmpty(this.zzPa)) {
            zzpbVar.setAppVersion(this.zzPa);
        }
        if (!TextUtils.isEmpty(this.zzaLl)) {
            zzpbVar.setAppId(this.zzaLl);
        }
        if (TextUtils.isEmpty(this.zzaLm)) {
            return;
        }
        zzpbVar.setAppInstallerId(this.zzaLm);
    }

    public String zzkp() {
        return this.zzOZ;
    }

    public String zzkr() {
        return this.zzPa;
    }

    public String zzuM() {
        return this.zzaLl;
    }

    public String zzyt() {
        return this.zzaLm;
    }
}
