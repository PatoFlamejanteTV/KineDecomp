package com.google.android.gms.internal;

import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class zzpf extends com.google.android.gms.measurement.zze<zzpf> {
    private String mCategory;
    private String zzPp;
    private String zzaLw;
    private long zzavc;

    public String getAction() {
        return this.zzPp;
    }

    public String getLabel() {
        return this.zzaLw;
    }

    public long getValue() {
        return this.zzavc;
    }

    public String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("category", this.mCategory);
        hashMap.put(NativeProtocol.WEB_DIALOG_ACTION, this.zzPp);
        hashMap.put("label", this.zzaLw);
        hashMap.put("value", Long.valueOf(this.zzavc));
        return zzB(hashMap);
    }

    public void zzM(long j) {
        this.zzavc = j;
    }

    @Override // com.google.android.gms.measurement.zze
    public void zza(zzpf zzpfVar) {
        if (!TextUtils.isEmpty(this.mCategory)) {
            zzpfVar.zzdQ(this.mCategory);
        }
        if (!TextUtils.isEmpty(this.zzPp)) {
            zzpfVar.zzdR(this.zzPp);
        }
        if (!TextUtils.isEmpty(this.zzaLw)) {
            zzpfVar.zzdS(this.zzaLw);
        }
        if (this.zzavc != 0) {
            zzpfVar.zzM(this.zzavc);
        }
    }

    public void zzdQ(String str) {
        this.mCategory = str;
    }

    public void zzdR(String str) {
        this.zzPp = str;
    }

    public void zzdS(String str) {
        this.zzaLw = str;
    }

    public String zzyJ() {
        return this.mCategory;
    }
}
