package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* loaded from: classes2.dex */
public final class zzdk extends zzbt<Integer, Long> {
    public Long zzsn;
    public Long zzso;

    public zzdk() {
    }

    @Override // com.google.android.gms.internal.ads.zzbt
    protected final void zzj(String str) {
        HashMap zzk = zzbt.zzk(str);
        if (zzk != null) {
            this.zzsn = (Long) zzk.get(0);
            this.zzso = (Long) zzk.get(1);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbt
    protected final HashMap<Integer, Long> zzv() {
        HashMap<Integer, Long> hashMap = new HashMap<>();
        hashMap.put(0, this.zzsn);
        hashMap.put(1, this.zzso);
        return hashMap;
    }

    public zzdk(String str) {
        zzj(str);
    }
}
