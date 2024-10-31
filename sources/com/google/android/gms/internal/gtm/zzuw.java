package com.google.android.gms.internal.gtm;

import java.io.IOException;

/* loaded from: classes2.dex */
public abstract class zzuw {
    protected volatile int zzbhl = -1;

    public static final void zza(zzuw zzuwVar, byte[] bArr, int i, int i2) {
        try {
            zzuo zzk = zzuo.zzk(bArr, 0, i2);
            zzuwVar.zza(zzk);
            zzk.zzrx();
        } catch (IOException e2) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e2);
        }
    }

    private static final <T extends zzuw> T zzb(T t, byte[] bArr, int i, int i2) throws zzuv {
        try {
            zzun zzj = zzun.zzj(bArr, 0, i2);
            t.zza(zzj);
            zzj.zzan(0);
            return t;
        } catch (zzuv e2) {
            throw e2;
        } catch (IOException e3) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", e3);
        }
    }

    public String toString() {
        return zzux.zzc(this);
    }

    public abstract zzuw zza(zzun zzunVar) throws IOException;

    public void zza(zzuo zzuoVar) throws IOException {
    }

    public final int zzpe() {
        int zzy = zzy();
        this.zzbhl = zzy;
        return zzy;
    }

    @Override // 
    /* renamed from: zzry */
    public zzuw clone() throws CloneNotSupportedException {
        return (zzuw) super.clone();
    }

    public final int zzse() {
        if (this.zzbhl < 0) {
            zzpe();
        }
        return this.zzbhl;
    }

    protected int zzy() {
        return 0;
    }

    public static final <T extends zzuw> T zza(T t, byte[] bArr) throws zzuv {
        zzb(t, bArr, 0, bArr.length);
        return t;
    }
}
