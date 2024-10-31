package com.google.android.gms.internal.config;

import com.google.android.gms.common.api.Status;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* loaded from: classes2.dex */
public final class zzu implements zzk {
    private final Status mStatus;
    private final Map<String, TreeMap<String, byte[]>> zzr;
    private final long zzs;
    private final List<byte[]> zzt;

    public zzu(Status status, Map<String, TreeMap<String, byte[]>> map) {
        this(status, map, -1L);
    }

    @Override // com.google.android.gms.internal.config.zzk, com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.mStatus;
    }

    @Override // com.google.android.gms.internal.config.zzk
    public final long getThrottleEndTimeMillis() {
        return this.zzs;
    }

    @Override // com.google.android.gms.internal.config.zzk
    public final byte[] zza(String str, byte[] bArr, String str2) {
        Map<String, TreeMap<String, byte[]>> map = this.zzr;
        boolean z = false;
        if (map != null && map.get(str2) != null && this.zzr.get(str2).get(str) != null) {
            z = true;
        }
        if (z) {
            return this.zzr.get(str2).get(str);
        }
        return null;
    }

    @Override // com.google.android.gms.internal.config.zzk
    public final List<byte[]> zzh() {
        return this.zzt;
    }

    @Override // com.google.android.gms.internal.config.zzk
    public final Map<String, Set<String>> zzi() {
        HashMap hashMap = new HashMap();
        Map<String, TreeMap<String, byte[]>> map = this.zzr;
        if (map != null) {
            for (String str : map.keySet()) {
                TreeMap<String, byte[]> treeMap = this.zzr.get(str);
                if (treeMap != null) {
                    hashMap.put(str, treeMap.keySet());
                }
            }
        }
        return hashMap;
    }

    private zzu(Status status, Map<String, TreeMap<String, byte[]>> map, long j) {
        this(status, map, -1L, null);
    }

    public zzu(Status status, Map<String, TreeMap<String, byte[]>> map, List<byte[]> list) {
        this(status, map, -1L, list);
    }

    public zzu(Status status, Map<String, TreeMap<String, byte[]>> map, long j, List<byte[]> list) {
        this.mStatus = status;
        this.zzr = map;
        this.zzs = j;
        this.zzt = list;
    }
}
