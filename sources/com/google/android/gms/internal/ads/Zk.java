package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class Zk {

    /* renamed from: a */
    public final int f12013a;

    /* renamed from: b */
    public final long[] f12014b;

    /* renamed from: c */
    public final int[] f12015c;

    /* renamed from: d */
    public final int f12016d;

    /* renamed from: e */
    public final long[] f12017e;

    /* renamed from: f */
    public final int[] f12018f;

    public Zk(long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2) {
        zzpo.checkArgument(iArr.length == jArr2.length);
        zzpo.checkArgument(jArr.length == jArr2.length);
        zzpo.checkArgument(iArr2.length == jArr2.length);
        this.f12014b = jArr;
        this.f12015c = iArr;
        this.f12016d = i;
        this.f12017e = jArr2;
        this.f12018f = iArr2;
        this.f12013a = jArr.length;
    }

    public final int a(long j) {
        for (int zza = zzqe.zza(this.f12017e, j, true, false); zza >= 0; zza--) {
            if ((this.f12018f[zza] & 1) != 0) {
                return zza;
            }
        }
        return -1;
    }

    public final int b(long j) {
        for (int zzb = zzqe.zzb(this.f12017e, j, true, false); zzb < this.f12017e.length; zzb++) {
            if ((this.f12018f[zzb] & 1) != 0) {
                return zzb;
            }
        }
        return -1;
    }
}
