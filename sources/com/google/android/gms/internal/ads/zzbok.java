package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class zzbok implements zzbjm {
    private final zzbov zzfjn;
    private final zzbjx zzfjo;
    private final int zzfjp;

    public zzbok(zzbov zzbovVar, zzbjx zzbjxVar, int i) {
        this.zzfjn = zzbovVar;
        this.zzfjo = zzbjxVar;
        this.zzfjp = i;
    }

    @Override // com.google.android.gms.internal.ads.zzbjm
    public final byte[] zzc(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] zzn = this.zzfjn.zzn(bArr);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        return zzbnx.zza(zzn, this.zzfjo.zzj(zzbnx.zza(bArr2, zzn, Arrays.copyOf(ByteBuffer.allocate(8).putLong(bArr2.length * 8).array(), 8))));
    }
}
