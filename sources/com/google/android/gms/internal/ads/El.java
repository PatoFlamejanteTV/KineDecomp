package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class El extends zzgc {

    /* renamed from: a, reason: collision with root package name */
    private final long f11508a;

    /* renamed from: b, reason: collision with root package name */
    private final long f11509b;

    /* renamed from: c, reason: collision with root package name */
    private final int f11510c;

    /* renamed from: d, reason: collision with root package name */
    private final long f11511d;

    /* renamed from: e, reason: collision with root package name */
    private final long f11512e;

    /* renamed from: f, reason: collision with root package name */
    private final long f11513f;

    /* renamed from: g, reason: collision with root package name */
    private final zznj f11514g;

    public El(long j, long j2, int i, long j3, long j4, long j5, zznj zznjVar) {
        this.f11508a = j;
        this.f11509b = j2;
        this.f11510c = i;
        this.f11511d = j3;
        this.f11512e = j4;
        this.f11513f = j5;
        this.f11514g = zznjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgc
    public final zzge zza(int i, zzge zzgeVar, boolean z) {
        zzpo.zzc(i, 0, this.f11514g.zzcl());
        Integer num = null;
        String str = z ? this.f11514g.zzba(i).zzze : null;
        if (z) {
            int i2 = this.f11510c;
            zzpo.zzc(i, 0, this.f11514g.zzcl());
            num = Integer.valueOf(i2 + i);
        }
        return zzgeVar.zza(str, num, 0, this.f11514g.zzbb(i), zzfe.zzg(this.f11514g.zzba(i).zzbdj - this.f11514g.zzba(0).zzbdj) - this.f11511d, false);
    }

    @Override // com.google.android.gms.internal.ads.zzgc
    public final int zzc(Object obj) {
        int intValue;
        int i;
        if ((obj instanceof Integer) && (intValue = ((Integer) obj).intValue()) >= (i = this.f11510c) && intValue < i + zzcl()) {
            return intValue - this.f11510c;
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzgc
    public final int zzck() {
        return 1;
    }

    @Override // com.google.android.gms.internal.ads.zzgc
    public final int zzcl() {
        return this.f11514g.zzcl();
    }

    @Override // com.google.android.gms.internal.ads.zzgc
    public final zzgf zza(int i, zzgf zzgfVar, boolean z, long j) {
        zznd zzgj;
        zzpo.zzc(i, 0, 1);
        long j2 = this.f11513f;
        if (this.f11514g.zzbcs) {
            if (j > 0) {
                j2 += j;
                if (j2 > this.f11512e) {
                    j2 = -9223372036854775807L;
                }
            }
            long j3 = this.f11511d + j2;
            long zzbb = this.f11514g.zzbb(0);
            long j4 = j3;
            int i2 = 0;
            while (i2 < this.f11514g.zzcl() - 1 && j4 >= zzbb) {
                j4 -= zzbb;
                i2++;
                zzbb = this.f11514g.zzbb(i2);
            }
            zznn zzba = this.f11514g.zzba(i2);
            int size = zzba.zzbbe.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    i3 = -1;
                    break;
                }
                if (zzba.zzbbe.get(i3).type == 2) {
                    break;
                }
                i3++;
            }
            if (i3 != -1 && (zzgj = zzba.zzbbe.get(i3).zzbcn.get(0).zzgj()) != null && zzgj.zzai(zzbb) != 0) {
                j2 = (j2 + zzgj.zzaw(zzgj.zzf(j4, zzbb))) - j4;
            }
        }
        long j5 = j2;
        return zzgfVar.zza(null, this.f11508a, this.f11509b, true, this.f11514g.zzbcs, j5, this.f11512e, 0, r2.zzcl() - 1, this.f11511d);
    }
}
