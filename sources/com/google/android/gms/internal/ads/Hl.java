package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class Hl {

    /* renamed from: a */
    public final boolean f11583a;

    /* renamed from: b */
    public final long f11584b;

    /* renamed from: c */
    public final long f11585c;

    private Hl(boolean z, long j, long j2) {
        this.f11583a = z;
        this.f11584b = j;
        this.f11585c = j2;
    }

    public static Hl a(zznn zznnVar, long j) {
        int i;
        int size = zznnVar.zzbbe.size();
        int i2 = 0;
        long j2 = Long.MAX_VALUE;
        int i3 = 0;
        boolean z = false;
        boolean z2 = false;
        long j3 = 0;
        while (i3 < size) {
            zznd zzgj = zznnVar.zzbbe.get(i3).zzbcn.get(i2).zzgj();
            if (zzgj == null) {
                return new Hl(true, 0L, j);
            }
            z2 |= zzgj.zzge();
            int zzai = zzgj.zzai(j);
            if (zzai == 0) {
                i = i3;
                z = true;
                j3 = 0;
                j2 = 0;
            } else if (z) {
                i = i3;
            } else {
                int zzgd = zzgj.zzgd();
                i = i3;
                long max = Math.max(j3, zzgj.zzaw(zzgd));
                if (zzai != -1) {
                    int i4 = (zzgd + zzai) - 1;
                    j2 = Math.min(j2, zzgj.zzaw(i4) + zzgj.zze(i4, j));
                }
                j3 = max;
            }
            i3 = i + 1;
            i2 = 0;
        }
        return new Hl(z2, j3, j2);
    }
}
