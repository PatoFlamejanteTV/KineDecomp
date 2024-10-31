package com.google.android.gms.internal;

/* loaded from: classes.dex */
public class zzcc {
    public static zzce zza(zzcg zzcgVar, long j) {
        if (zzcgVar == null) {
            return null;
        }
        return zzcgVar.zzb(j);
    }

    public static boolean zza(zzcg zzcgVar, zzce zzceVar, long j, String... strArr) {
        if (zzcgVar == null || zzceVar == null) {
            return false;
        }
        return zzcgVar.zza(zzceVar, j, strArr);
    }

    public static boolean zza(zzcg zzcgVar, zzce zzceVar, String... strArr) {
        if (zzcgVar == null || zzceVar == null) {
            return false;
        }
        return zzcgVar.zza(zzceVar, strArr);
    }

    public static zzce zzb(zzcg zzcgVar) {
        if (zzcgVar == null) {
            return null;
        }
        return zzcgVar.zzdn();
    }
}
