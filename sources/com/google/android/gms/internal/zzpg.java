package com.google.android.gms.internal;

import android.text.TextUtils;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class zzpg extends com.google.android.gms.measurement.zze<zzpg> {
    public boolean zzaLx;
    public String zzaqZ;

    public String getDescription() {
        return this.zzaqZ;
    }

    public void setDescription(String str) {
        this.zzaqZ = str;
    }

    public String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("description", this.zzaqZ);
        hashMap.put("fatal", Boolean.valueOf(this.zzaLx));
        return zzB(hashMap);
    }

    @Override // com.google.android.gms.measurement.zze
    public void zza(zzpg zzpgVar) {
        if (!TextUtils.isEmpty(this.zzaqZ)) {
            zzpgVar.setDescription(this.zzaqZ);
        }
        if (this.zzaLx) {
            zzpgVar.zzak(this.zzaLx);
        }
    }

    public void zzak(boolean z) {
        this.zzaLx = z;
    }

    public boolean zzyK() {
        return this.zzaLx;
    }
}
