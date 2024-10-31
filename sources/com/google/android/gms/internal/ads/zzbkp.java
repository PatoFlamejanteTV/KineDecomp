package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbns;
import java.security.GeneralSecurityException;

/* loaded from: classes2.dex */
public final class zzbkp {

    @Deprecated
    public static final zzbns zzfdl = (zzbns) zzbns.zzajw().zza((zzbns.zza) zzbke.zzfdl).zzb(zzbjo.zza("TinkHybridDecrypt", "HybridDecrypt", "EciesAeadHkdfPrivateKey", 0, true)).zzb(zzbjo.zza("TinkHybridEncrypt", "HybridEncrypt", "EciesAeadHkdfPublicKey", 0, true)).zzft("TINK_HYBRID_1_0_0").zzana();

    @Deprecated
    private static final zzbns zzfdm = (zzbns) zzbns.zzajw().zza((zzbns.zza) zzfdl).zzft("TINK_HYBRID_1_1_0").zzana();
    private static final zzbns zzfdn = (zzbns) zzbns.zzajw().zza((zzbns.zza) zzbke.zzfdn).zzb(zzbjo.zza("TinkHybridDecrypt", "HybridDecrypt", "EciesAeadHkdfPrivateKey", 0, true)).zzb(zzbjo.zza("TinkHybridEncrypt", "HybridEncrypt", "EciesAeadHkdfPublicKey", 0, true)).zzft("TINK_HYBRID").zzana();

    static {
        try {
            zzbke.zzafu();
            zzbkb.zza("TinkHybridEncrypt", new C1027og());
            zzbkb.zza("TinkHybridDecrypt", new C1013ng());
            zzbjo.zza(zzfdn);
        } catch (GeneralSecurityException e2) {
            throw new ExceptionInInitializerError(e2);
        }
    }
}
