package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzbof {
    private final zzbou zzfjb;
    private final zzbou zzfjc;

    public zzbof(byte[] bArr, byte[] bArr2) {
        this.zzfjb = zzbou.zzp(bArr);
        this.zzfjc = zzbou.zzp(bArr2);
    }

    public final byte[] zzajz() {
        zzbou zzbouVar = this.zzfjb;
        if (zzbouVar == null) {
            return null;
        }
        return zzbouVar.getBytes();
    }

    public final byte[] zzaka() {
        zzbou zzbouVar = this.zzfjc;
        if (zzbouVar == null) {
            return null;
        }
        return zzbouVar.getBytes();
    }
}
