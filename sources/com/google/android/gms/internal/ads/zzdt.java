package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* loaded from: classes2.dex */
public final class zzdt extends zzbt<Integer, Long> {
    public Long zzhf;
    public Long zzhg;
    public Long zztt;

    public zzdt() {
    }

    @Override // com.google.android.gms.internal.ads.zzbt
    protected final void zzj(String str) {
        HashMap zzk = zzbt.zzk(str);
        if (zzk != null) {
            this.zztt = (Long) zzk.get(0);
            this.zzhf = (Long) zzk.get(1);
            this.zzhg = (Long) zzk.get(2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbt
    protected final HashMap<Integer, Long> zzv() {
        HashMap<Integer, Long> hashMap = new HashMap<>();
        hashMap.put(0, this.zztt);
        hashMap.put(1, this.zzhf);
        hashMap.put(2, this.zzhg);
        return hashMap;
    }

    public zzdt(String str) {
        zzj(str);
    }
}
