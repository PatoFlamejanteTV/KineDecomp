package com.google.android.gms.internal;

import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class zzpi extends com.google.android.gms.measurement.zze<zzpi> {
    public String zzPp;
    public String zzaLG;
    public String zzaLH;

    public String getAction() {
        return this.zzPp;
    }

    public String getTarget() {
        return this.zzaLH;
    }

    public String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("network", this.zzaLG);
        hashMap.put(NativeProtocol.WEB_DIALOG_ACTION, this.zzPp);
        hashMap.put("target", this.zzaLH);
        return zzB(hashMap);
    }

    @Override // com.google.android.gms.measurement.zze
    public void zza(zzpi zzpiVar) {
        if (!TextUtils.isEmpty(this.zzaLG)) {
            zzpiVar.zzdV(this.zzaLG);
        }
        if (!TextUtils.isEmpty(this.zzPp)) {
            zzpiVar.zzdR(this.zzPp);
        }
        if (TextUtils.isEmpty(this.zzaLH)) {
            return;
        }
        zzpiVar.zzdW(this.zzaLH);
    }

    public void zzdR(String str) {
        this.zzPp = str;
    }

    public void zzdV(String str) {
        this.zzaLG = str;
    }

    public void zzdW(String str) {
        this.zzaLH = str;
    }

    public String zzyQ() {
        return this.zzaLG;
    }
}
