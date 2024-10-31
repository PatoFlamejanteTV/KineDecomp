package com.google.android.gms.internal.ads;

import java.nio.charset.Charset;

/* loaded from: classes2.dex */
public final class zzbux {
    protected static final Charset UTF_8 = Charset.forName("UTF-8");
    private static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    public static final Object zzfws = new Object();

    public static void zza(zzbut zzbutVar, zzbut zzbutVar2) {
        zzbuv zzbuvVar = zzbutVar.zzfwk;
        if (zzbuvVar != null) {
            zzbutVar2.zzfwk = (zzbuv) zzbuvVar.clone();
        }
    }
}
