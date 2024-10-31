package com.google.android.gms.internal;

import android.text.TextUtils;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class zzjo extends com.google.android.gms.measurement.zze<zzjo> {
    private String zzGY;
    private String zzMi;
    private String zzMj;
    private String zzMk;
    private boolean zzMl;
    private String zzMm;
    private boolean zzMn;
    private double zzMo;

    public String getClientId() {
        return this.zzMj;
    }

    public String getUserId() {
        return this.zzGY;
    }

    public void setClientId(String str) {
        this.zzMj = str;
    }

    public void setSampleRate(double d) {
        com.google.android.gms.common.internal.zzx.b(d >= 0.0d && d <= 100.0d, "Sample rate must be between 0% and 100%");
        this.zzMo = d;
    }

    public void setUserId(String str) {
        this.zzGY = str;
    }

    public String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("hitType", this.zzMi);
        hashMap.put("clientId", this.zzMj);
        hashMap.put("userId", this.zzGY);
        hashMap.put("androidAdId", this.zzMk);
        hashMap.put("AdTargetingEnabled", Boolean.valueOf(this.zzMl));
        hashMap.put("sessionControl", this.zzMm);
        hashMap.put("nonInteraction", Boolean.valueOf(this.zzMn));
        hashMap.put("sampleRate", Double.valueOf(this.zzMo));
        return zzB(hashMap);
    }

    public void zzG(boolean z) {
        this.zzMl = z;
    }

    public void zzH(boolean z) {
        this.zzMn = z;
    }

    @Override // com.google.android.gms.measurement.zze
    public void zza(zzjo zzjoVar) {
        if (!TextUtils.isEmpty(this.zzMi)) {
            zzjoVar.zzaU(this.zzMi);
        }
        if (!TextUtils.isEmpty(this.zzMj)) {
            zzjoVar.setClientId(this.zzMj);
        }
        if (!TextUtils.isEmpty(this.zzGY)) {
            zzjoVar.setUserId(this.zzGY);
        }
        if (!TextUtils.isEmpty(this.zzMk)) {
            zzjoVar.zzaV(this.zzMk);
        }
        if (this.zzMl) {
            zzjoVar.zzG(true);
        }
        if (!TextUtils.isEmpty(this.zzMm)) {
            zzjoVar.zzaW(this.zzMm);
        }
        if (this.zzMn) {
            zzjoVar.zzH(this.zzMn);
        }
        if (this.zzMo != 0.0d) {
            zzjoVar.setSampleRate(this.zzMo);
        }
    }

    public void zzaU(String str) {
        this.zzMi = str;
    }

    public void zzaV(String str) {
        this.zzMk = str;
    }

    public void zzaW(String str) {
        this.zzMm = str;
    }

    public String zzia() {
        return this.zzMi;
    }

    public String zzib() {
        return this.zzMk;
    }

    public boolean zzic() {
        return this.zzMl;
    }

    public String zzid() {
        return this.zzMm;
    }

    public boolean zzie() {
        return this.zzMn;
    }

    public double zzif() {
        return this.zzMo;
    }
}
