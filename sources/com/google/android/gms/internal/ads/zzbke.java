package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbns;
import java.security.GeneralSecurityException;

/* loaded from: classes2.dex */
public final class zzbke {

    @Deprecated
    public static final zzbns zzfdl = (zzbns) zzbns.zzajw().zza((zzbns.zza) zzbla.zzfdl).zzb(zzbjo.zza("TinkAead", "Aead", "AesCtrHmacAeadKey", 0, true)).zzb(zzbjo.zza("TinkAead", "Aead", "AesEaxKey", 0, true)).zzb(zzbjo.zza("TinkAead", "Aead", "AesGcmKey", 0, true)).zzb(zzbjo.zza("TinkAead", "Aead", "ChaCha20Poly1305Key", 0, true)).zzb(zzbjo.zza("TinkAead", "Aead", "KmsAeadKey", 0, true)).zzb(zzbjo.zza("TinkAead", "Aead", "KmsEnvelopeAeadKey", 0, true)).zzft("TINK_AEAD_1_0_0").zzana();

    @Deprecated
    private static final zzbns zzfdm = (zzbns) zzbns.zzajw().zza((zzbns.zza) zzfdl).zzft("TINK_AEAD_1_1_0").zzana();
    public static final zzbns zzfdn = (zzbns) zzbns.zzajw().zza((zzbns.zza) zzbla.zzfdn).zzb(zzbjo.zza("TinkAead", "Aead", "AesCtrHmacAeadKey", 0, true)).zzb(zzbjo.zza("TinkAead", "Aead", "AesEaxKey", 0, true)).zzb(zzbjo.zza("TinkAead", "Aead", "AesGcmKey", 0, true)).zzb(zzbjo.zza("TinkAead", "Aead", "ChaCha20Poly1305Key", 0, true)).zzb(zzbjo.zza("TinkAead", "Aead", "KmsAeadKey", 0, true)).zzb(zzbjo.zza("TinkAead", "Aead", "KmsEnvelopeAeadKey", 0, true)).zzft("TINK_AEAD").zzana();

    static {
        try {
            zzafu();
        } catch (GeneralSecurityException e2) {
            throw new ExceptionInInitializerError(e2);
        }
    }

    public static void zzafu() throws GeneralSecurityException {
        zzbla.zzafu();
        zzbkb.zza("TinkAead", new C0874dg());
        zzbjo.zza(zzfdn);
    }
}
