package com.google.android.gms.internal.config;

import com.google.android.gms.common.internal.ShowFirstParty;
import java.util.Collections;
import java.util.Map;

@ShowFirstParty
/* loaded from: classes2.dex */
public final class zzi {
    private final long zzg;
    private final Map<String, String> zzh;
    private final int zzi;
    private final int zzj;
    private final int zzk;
    private final String zzl;

    /* JADX INFO: Access modifiers changed from: private */
    public zzi(zzj zzjVar) {
        long j;
        Map<String, String> map;
        int i;
        int i2;
        int i3;
        String str;
        j = zzjVar.zzg;
        this.zzg = j;
        map = zzjVar.zzh;
        this.zzh = map;
        i = zzjVar.zzi;
        this.zzi = i;
        i2 = zzjVar.zzj;
        this.zzj = i2;
        i3 = zzjVar.zzk;
        this.zzk = i3;
        str = zzjVar.zzl;
        this.zzl = str;
    }

    public final String getGmpAppId() {
        return this.zzl;
    }

    public final long zzb() {
        return this.zzg;
    }

    public final Map<String, String> zzc() {
        Map<String, String> map = this.zzh;
        return map == null ? Collections.emptyMap() : map;
    }

    public final int zzd() {
        return this.zzi;
    }

    public final int zze() {
        return this.zzk;
    }

    public final int zzf() {
        return this.zzj;
    }

    public /* synthetic */ zzi(zzj zzjVar, d dVar) {
        this(zzjVar);
    }
}
