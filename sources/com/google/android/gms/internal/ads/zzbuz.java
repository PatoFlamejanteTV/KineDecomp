package com.google.android.gms.internal.ads;

import java.io.IOException;

/* loaded from: classes2.dex */
public abstract class zzbuz {
    protected volatile int zzfwt = -1;

    public static final <T extends zzbuz> T zza(T t, byte[] bArr) throws zzbuy {
        zza(t, bArr, 0, bArr.length);
        return t;
    }

    public static final byte[] zzb(zzbuz zzbuzVar) {
        byte[] bArr = new byte[zzbuzVar.zzamj()];
        try {
            zzbur zzr = zzbur.zzr(bArr, 0, bArr.length);
            zzbuzVar.zza(zzr);
            zzr.zzalv();
            return bArr;
        } catch (IOException e2) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e2);
        }
    }

    public String toString() {
        return zzbva.zzc(this);
    }

    public abstract zzbuz zza(zzbuq zzbuqVar) throws IOException;

    public void zza(zzbur zzburVar) throws IOException {
    }

    public final int zzamj() {
        int zzt = zzt();
        this.zzfwt = zzt;
        return zzt;
    }

    @Override // 
    /* renamed from: zzapm */
    public zzbuz clone() throws CloneNotSupportedException {
        return (zzbuz) super.clone();
    }

    protected int zzt() {
        return 0;
    }

    private static final <T extends zzbuz> T zza(T t, byte[] bArr, int i, int i2) throws zzbuy {
        try {
            zzbuq zzq = zzbuq.zzq(bArr, 0, i2);
            t.zza(zzq);
            zzq.zzeo(0);
            return t;
        } catch (zzbuy e2) {
            throw e2;
        } catch (IOException e3) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", e3);
        }
    }
}
