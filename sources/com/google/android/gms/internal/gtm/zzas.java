package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class zzas {
    private final Map<String, String> zztc;
    private final String zzut;
    private final long zzww;
    private final String zzwx;
    private final boolean zzwy;
    private long zzwz;

    public zzas(long j, String str, String str2, boolean z, long j2, Map<String, String> map) {
        Preconditions.b(str);
        Preconditions.b(str2);
        this.zzww = 0L;
        this.zzut = str;
        this.zzwx = str2;
        this.zzwy = z;
        this.zzwz = j2;
        if (map != null) {
            this.zztc = new HashMap(map);
        } else {
            this.zztc = Collections.emptyMap();
        }
    }

    public final void zzb(long j) {
        this.zzwz = j;
    }

    public final String zzbt() {
        return this.zzut;
    }

    public final long zzdi() {
        return this.zzww;
    }

    public final String zzdj() {
        return this.zzwx;
    }

    public final boolean zzdk() {
        return this.zzwy;
    }

    public final long zzdl() {
        return this.zzwz;
    }

    public final Map<String, String> zzdm() {
        return this.zztc;
    }
}
