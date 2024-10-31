package com.google.android.gms.internal.config;

import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class zzaq {
    private boolean zzap;
    private int zzay;
    private long zzbc;
    private Map<String, zzal> zzbd;

    public zzaq() {
        this(-1L);
    }

    public final int getLastFetchStatus() {
        return this.zzay;
    }

    public final boolean isDeveloperModeEnabled() {
        return this.zzap;
    }

    public final void zza(boolean z) {
        this.zzap = z;
    }

    public final void zzc(long j) {
        this.zzbc = j;
    }

    public final void zzd(String str) {
        if (this.zzbd.get(str) == null) {
            return;
        }
        this.zzbd.remove(str);
    }

    public final void zzf(int i) {
        this.zzay = i;
    }

    public final Map<String, zzal> zzs() {
        return this.zzbd;
    }

    public final long zzt() {
        return this.zzbc;
    }

    @VisibleForTesting
    private zzaq(long j) {
        this(0, -1L, null, false);
    }

    public final void zza(Map<String, zzal> map) {
        this.zzbd = map;
    }

    private zzaq(int i, long j, Map<String, zzal> map, boolean z) {
        this.zzay = 0;
        this.zzbc = -1L;
        this.zzbd = new HashMap();
        this.zzap = false;
    }

    public final void zza(String str, zzal zzalVar) {
        this.zzbd.put(str, zzalVar);
    }
}
