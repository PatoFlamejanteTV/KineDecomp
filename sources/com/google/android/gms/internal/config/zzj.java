package com.google.android.gms.internal.config;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class zzj {
    private Map<String, String> zzh;
    private int zzi;
    private String zzl;
    private long zzg = 43200;
    private int zzj = -1;
    private int zzk = -1;

    public final zzj zza(long j) {
        this.zzg = j;
        return this;
    }

    public final zzj zzb(int i) {
        this.zzj = i;
        return this;
    }

    public final zzj zzc(int i) {
        this.zzk = i;
        return this;
    }

    public final zzi zzg() {
        return new zzi(this);
    }

    public final zzj zza(String str, String str2) {
        if (this.zzh == null) {
            this.zzh = new HashMap();
        }
        this.zzh.put(str, str2);
        return this;
    }

    public final zzj zza(int i) {
        this.zzi = 10300;
        return this;
    }

    public final zzj zza(String str) {
        this.zzl = str;
        return this;
    }
}
