package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzhy implements zzii {
    @Override // com.google.android.gms.internal.ads.zzii
    public final int zza(zzia zziaVar, int i, boolean z) throws IOException, InterruptedException {
        int zzv = zziaVar.zzv(i);
        if (zzv != -1) {
            return zzv;
        }
        if (z) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // com.google.android.gms.internal.ads.zzii
    public final void zza(long j, int i, int i2, int i3, zzij zzijVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzii
    public final void zzf(zzfs zzfsVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzii
    public final void zza(zzpx zzpxVar, int i) {
        zzpxVar.zzbl(i);
    }
}
