package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import java.util.Arrays;

/* loaded from: classes2.dex */
public abstract class zzod implements zzom {
    private final int length;
    private int zzaac;
    private final zzfs[] zzayc;
    private final zzlz zzbej;
    private final int[] zzbek;
    private final long[] zzbel;

    public zzod(zzlz zzlzVar, int... iArr) {
        int i = 0;
        zzpo.checkState(iArr.length > 0);
        zzpo.checkNotNull(zzlzVar);
        this.zzbej = zzlzVar;
        this.length = iArr.length;
        this.zzayc = new zzfs[this.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            this.zzayc[i2] = zzlzVar.zzat(iArr[i2]);
        }
        Arrays.sort(this.zzayc, new Ol());
        this.zzbek = new int[this.length];
        while (true) {
            int i3 = this.length;
            if (i < i3) {
                this.zzbek[i] = zzlzVar.zzi(this.zzayc[i]);
                i++;
            } else {
                this.zzbel = new long[i3];
                return;
            }
        }
    }

    private final boolean zzg(int i, long j) {
        return this.zzbel[i] > j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzod zzodVar = (zzod) obj;
            if (this.zzbej == zzodVar.zzbej && Arrays.equals(this.zzbek, zzodVar.zzbek)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        if (this.zzaac == 0) {
            this.zzaac = (System.identityHashCode(this.zzbej) * 31) + Arrays.hashCode(this.zzbek);
        }
        return this.zzaac;
    }

    @Override // com.google.android.gms.internal.ads.zzom
    public final int length() {
        return this.zzbek.length;
    }

    @Override // com.google.android.gms.internal.ads.zzom
    public final zzfs zzat(int i) {
        return this.zzayc[i];
    }

    @Override // com.google.android.gms.internal.ads.zzom
    public final int zzbd(int i) {
        return this.zzbek[i];
    }

    @Override // com.google.android.gms.internal.ads.zzom
    public final boolean zzf(int i, long j) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean zzg = zzg(i, elapsedRealtime);
        int i2 = 0;
        while (i2 < this.length && !zzg) {
            zzg = (i2 == i || zzg(i2, elapsedRealtime)) ? false : true;
            i2++;
        }
        if (!zzg) {
            return false;
        }
        long[] jArr = this.zzbel;
        jArr[i] = Math.max(jArr[i], elapsedRealtime + 60000);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzom
    public final zzlz zzgk() {
        return this.zzbej;
    }

    @Override // com.google.android.gms.internal.ads.zzom
    public final zzfs zzgl() {
        return this.zzayc[zzgm()];
    }

    @Override // com.google.android.gms.internal.ads.zzom
    public final int zzi(zzfs zzfsVar) {
        for (int i = 0; i < this.length; i++) {
            if (this.zzayc[i] == zzfsVar) {
                return i;
            }
        }
        return -1;
    }
}
