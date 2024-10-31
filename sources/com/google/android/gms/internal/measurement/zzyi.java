package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* loaded from: classes2.dex */
public abstract class zzyi {
    protected volatile int zzcfd = -1;

    public static final void zza(zzyi zzyiVar, byte[] bArr, int i, int i2) {
        try {
            zzya zzk = zzya.zzk(bArr, 0, i2);
            zzyiVar.zza(zzk);
            zzk.zzza();
        } catch (IOException e2) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e2);
        }
    }

    private static final <T extends zzyi> T zzb(T t, byte[] bArr, int i, int i2) throws zzyh {
        try {
            zzxz zzj = zzxz.zzj(bArr, 0, i2);
            t.zza(zzj);
            zzj.zzap(0);
            return t;
        } catch (zzyh e2) {
            throw e2;
        } catch (IOException e3) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", e3);
        }
    }

    public String toString() {
        return zzyj.zzc(this);
    }

    public abstract zzyi zza(zzxz zzxzVar) throws IOException;

    public void zza(zzya zzyaVar) throws IOException {
    }

    protected int zzf() {
        return 0;
    }

    public final int zzvx() {
        int zzf = zzf();
        this.zzcfd = zzf;
        return zzf;
    }

    @Override // 
    /* renamed from: zzzb */
    public zzyi clone() throws CloneNotSupportedException {
        return (zzyi) super.clone();
    }

    public final int zzzh() {
        if (this.zzcfd < 0) {
            zzvx();
        }
        return this.zzcfd;
    }

    public static final <T extends zzyi> T zza(T t, byte[] bArr) throws zzyh {
        zzb(t, bArr, 0, bArr.length);
        return t;
    }
}
