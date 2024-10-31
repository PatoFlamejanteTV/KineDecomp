package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzhw implements zzig {
    public final int length;
    private final long zzaan;
    public final int[] zzagt;
    public final long[] zzagu;
    public final long[] zzagv;
    public final long[] zzagw;

    public zzhw(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.zzagt = iArr;
        this.zzagu = jArr;
        this.zzagv = jArr2;
        this.zzagw = jArr3;
        this.length = iArr.length;
        int i = this.length;
        if (i > 0) {
            this.zzaan = jArr2[i - 1] + jArr3[i - 1];
        } else {
            this.zzaan = 0L;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzig
    public final long getDurationUs() {
        return this.zzaan;
    }

    @Override // com.google.android.gms.internal.ads.zzig
    public final boolean zzdw() {
        return true;
    }

    public final int zzq(long j) {
        return zzqe.zza(this.zzagw, j, true, true);
    }

    @Override // com.google.android.gms.internal.ads.zzig
    public final long zzr(long j) {
        return this.zzagu[zzq(j)];
    }
}
