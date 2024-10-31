package com.google.android.gms.internal.firebase_abt;

import java.nio.charset.Charset;

/* loaded from: classes2.dex */
public final class zzh {
    protected static final Charset UTF_8 = Charset.forName("UTF-8");
    private static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    public static final Object zzaa = new Object();

    public static void zza(zzd zzdVar, zzd zzdVar2) {
        zzf zzfVar = zzdVar.zzs;
        if (zzfVar != null) {
            zzdVar2.zzs = (zzf) zzfVar.clone();
        }
    }
}
