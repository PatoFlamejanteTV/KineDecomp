package com.google.android.gms.internal.firebase_abt;

import java.io.IOException;

/* loaded from: classes2.dex */
public abstract class zzj {
    protected volatile int zzab = -1;

    public static final <T extends zzj> T zza(T t, byte[] bArr, int i, int i2) throws zzi {
        try {
            zza zza = zza.zza(bArr, 0, i2);
            t.zza(zza);
            zza.zza(0);
            return t;
        } catch (zzi e2) {
            throw e2;
        } catch (IOException e3) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", e3);
        }
    }

    public String toString() {
        return zzk.zzb(this);
    }

    public abstract zzj zza(zza zzaVar) throws IOException;

    @Override // 
    /* renamed from: zzj */
    public zzj clone() throws CloneNotSupportedException {
        return (zzj) super.clone();
    }
}
