package com.google.android.gms.internal;

import android.text.TextUtils;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class zzpd extends com.google.android.gms.measurement.zze<zzpd> {
    public int zzAD;
    public int zzAE;
    private String zzVT;
    public int zzaLt;
    public int zzaLu;
    public int zzaLv;

    public String getLanguage() {
        return this.zzVT;
    }

    public void setLanguage(String str) {
        this.zzVT = str;
    }

    public String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("language", this.zzVT);
        hashMap.put("screenColors", Integer.valueOf(this.zzaLt));
        hashMap.put("screenWidth", Integer.valueOf(this.zzAD));
        hashMap.put("screenHeight", Integer.valueOf(this.zzAE));
        hashMap.put("viewportWidth", Integer.valueOf(this.zzaLu));
        hashMap.put("viewportHeight", Integer.valueOf(this.zzaLv));
        return zzB(hashMap);
    }

    @Override // com.google.android.gms.measurement.zze
    public void zza(zzpd zzpdVar) {
        if (this.zzaLt != 0) {
            zzpdVar.zzhW(this.zzaLt);
        }
        if (this.zzAD != 0) {
            zzpdVar.zzhX(this.zzAD);
        }
        if (this.zzAE != 0) {
            zzpdVar.zzhY(this.zzAE);
        }
        if (this.zzaLu != 0) {
            zzpdVar.zzhZ(this.zzaLu);
        }
        if (this.zzaLv != 0) {
            zzpdVar.zzia(this.zzaLv);
        }
        if (TextUtils.isEmpty(this.zzVT)) {
            return;
        }
        zzpdVar.setLanguage(this.zzVT);
    }

    public void zzhW(int i) {
        this.zzaLt = i;
    }

    public void zzhX(int i) {
        this.zzAD = i;
    }

    public void zzhY(int i) {
        this.zzAE = i;
    }

    public void zzhZ(int i) {
        this.zzaLu = i;
    }

    public void zzia(int i) {
        this.zzaLv = i;
    }

    public int zzyA() {
        return this.zzaLt;
    }

    public int zzyB() {
        return this.zzAD;
    }

    public int zzyC() {
        return this.zzAE;
    }

    public int zzyD() {
        return this.zzaLu;
    }

    public int zzyE() {
        return this.zzaLv;
    }
}
