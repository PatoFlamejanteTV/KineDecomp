package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* loaded from: classes2.dex */
public final class zzbv extends zzbt<Integer, Object> {
    public String zzdq;
    public String zzds;
    public String zzdt;
    public String zzdu;
    public long zzit;

    public zzbv(String str) {
        this();
        zzj(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbt
    protected final void zzj(String str) {
        HashMap zzk = zzbt.zzk(str);
        if (zzk != null) {
            this.zzdq = zzk.get(0) == null ? "E" : (String) zzk.get(0);
            this.zzit = zzk.get(1) == null ? -1L : ((Long) zzk.get(1)).longValue();
            this.zzds = zzk.get(2) == null ? "E" : (String) zzk.get(2);
            this.zzdt = zzk.get(3) == null ? "E" : (String) zzk.get(3);
            this.zzdu = zzk.get(4) != null ? (String) zzk.get(4) : "E";
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbt
    protected final HashMap<Integer, Object> zzv() {
        HashMap<Integer, Object> hashMap = new HashMap<>();
        hashMap.put(0, this.zzdq);
        hashMap.put(4, this.zzdu);
        hashMap.put(3, this.zzdt);
        hashMap.put(2, this.zzds);
        hashMap.put(1, Long.valueOf(this.zzit));
        return hashMap;
    }

    public zzbv() {
        this.zzdq = "E";
        this.zzit = -1L;
        this.zzds = "E";
        this.zzdt = "E";
        this.zzdu = "E";
    }
}
