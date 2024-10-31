package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* loaded from: classes2.dex */
public final class zzdr extends zzbt<Integer, Long> {
    public Long zzgl;
    public Long zzgn;
    public Long zzgr;
    public Long zzgs;
    public Long zztl;
    public Long zztm;
    public Long zztn;
    public Long zzto;
    public Long zztp;
    public Long zztq;
    public Long zztr;

    public zzdr() {
    }

    @Override // com.google.android.gms.internal.ads.zzbt
    protected final void zzj(String str) {
        HashMap zzk = zzbt.zzk(str);
        if (zzk != null) {
            this.zztl = (Long) zzk.get(0);
            this.zztm = (Long) zzk.get(1);
            this.zztn = (Long) zzk.get(2);
            this.zzgn = (Long) zzk.get(3);
            this.zzgl = (Long) zzk.get(4);
            this.zzto = (Long) zzk.get(5);
            this.zztp = (Long) zzk.get(6);
            this.zztq = (Long) zzk.get(7);
            this.zzgs = (Long) zzk.get(8);
            this.zzgr = (Long) zzk.get(9);
            this.zztr = (Long) zzk.get(10);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbt
    protected final HashMap<Integer, Long> zzv() {
        HashMap<Integer, Long> hashMap = new HashMap<>();
        hashMap.put(0, this.zztl);
        hashMap.put(1, this.zztm);
        hashMap.put(2, this.zztn);
        hashMap.put(3, this.zzgn);
        hashMap.put(4, this.zzgl);
        hashMap.put(5, this.zzto);
        hashMap.put(6, this.zztp);
        hashMap.put(7, this.zztq);
        hashMap.put(8, this.zzgs);
        hashMap.put(9, this.zzgr);
        hashMap.put(10, this.zztr);
        return hashMap;
    }

    public zzdr(String str) {
        zzj(str);
    }
}
