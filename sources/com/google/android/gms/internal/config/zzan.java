package com.google.android.gms.internal.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public final class zzan {
    private Map<String, Map<String, byte[]>> zzav;
    private long zzaw;
    private List<byte[]> zzt;

    public zzan(Map<String, Map<String, byte[]>> map, long j, List<byte[]> list) {
        this.zzav = map;
        this.zzaw = j;
        this.zzt = list;
    }

    public final long getTimestamp() {
        return this.zzaw;
    }

    public final void setTimestamp(long j) {
        this.zzaw = j;
    }

    public final void zza(Map<String, byte[]> map, String str) {
        if (this.zzav == null) {
            this.zzav = new HashMap();
        }
        this.zzav.put(str, map);
    }

    public final boolean zzb(String str) {
        return (str == null || !zzr() || this.zzav.get(str) == null || this.zzav.get(str).isEmpty()) ? false : true;
    }

    public final byte[] zzc(String str, String str2) {
        if (str == null || !zzb(str2)) {
            return null;
        }
        return this.zzav.get(str2).get(str);
    }

    public final Set<String> zzd(String str, String str2) {
        TreeSet treeSet = new TreeSet();
        if (!zzb(str2)) {
            return treeSet;
        }
        if (str != null && !str.isEmpty()) {
            for (String str3 : this.zzav.get(str2).keySet()) {
                if (str3.startsWith(str)) {
                    treeSet.add(str3);
                }
            }
            return treeSet;
        }
        return this.zzav.get(str2).keySet();
    }

    public final List<byte[]> zzh() {
        return this.zzt;
    }

    public final Map<String, Map<String, byte[]>> zzq() {
        return this.zzav;
    }

    public final boolean zzr() {
        Map<String, Map<String, byte[]>> map = this.zzav;
        return (map == null || map.isEmpty()) ? false : true;
    }

    public final boolean zzb(String str, String str2) {
        return zzr() && zzb(str2) && zzc(str, str2) != null;
    }

    @Nullable
    public final Map<String, byte[]> zzc(String str) {
        Map<String, Map<String, byte[]>> map = this.zzav;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }
}
