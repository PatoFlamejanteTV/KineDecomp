package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* loaded from: classes2.dex */
public final class zzcy extends zzbt<Integer, Long> {
    public long zzse;
    public long zzsf;

    public zzcy() {
        this.zzse = -1L;
        this.zzsf = -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzbt
    protected final void zzj(String str) {
        HashMap zzk = zzbt.zzk(str);
        if (zzk != null) {
            this.zzse = ((Long) zzk.get(0)).longValue();
            this.zzsf = ((Long) zzk.get(1)).longValue();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbt
    protected final HashMap<Integer, Long> zzv() {
        HashMap<Integer, Long> hashMap = new HashMap<>();
        hashMap.put(0, Long.valueOf(this.zzse));
        hashMap.put(1, Long.valueOf(this.zzsf));
        return hashMap;
    }

    public zzcy(String str) {
        this();
        zzj(str);
    }
}
