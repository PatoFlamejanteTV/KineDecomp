package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbns;
import java.security.GeneralSecurityException;

/* loaded from: classes2.dex */
public final class zzbla {

    @Deprecated
    public static final zzbns zzfdl = (zzbns) zzbns.zzajw().zzft("TINK_MAC_1_0_0").zzb(zzbjo.zza("TinkMac", "Mac", "HmacKey", 0, true)).zzana();

    @Deprecated
    private static final zzbns zzfdm = (zzbns) zzbns.zzajw().zza((zzbns.zza) zzfdl).zzft("TINK_MAC_1_1_0").zzana();
    public static final zzbns zzfdn = (zzbns) zzbns.zzajw().zza((zzbns.zza) zzfdl).zzft("TINK_MAC").zzana();

    static {
        try {
            zzafu();
        } catch (GeneralSecurityException e2) {
            throw new ExceptionInInitializerError(e2);
        }
    }

    public static void zzafu() throws GeneralSecurityException {
        zzbkb.zza("TinkMac", new C1124vg());
        zzbjo.zza(zzfdn);
    }
}
