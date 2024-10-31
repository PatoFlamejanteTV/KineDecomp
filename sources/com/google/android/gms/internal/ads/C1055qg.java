package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.google.android.gms.internal.ads.qg, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C1055qg {
    public static void a(zzbmd zzbmdVar) throws GeneralSecurityException {
        zzbog.zza(a(zzbmdVar.zzahe().zzahr()));
        a(zzbmdVar.zzahe().zzahs());
        if (zzbmdVar.zzahg() != zzblx.UNKNOWN_FORMAT) {
            zzbkb.zza(zzbmdVar.zzahf().zzagz());
            return;
        }
        throw new GeneralSecurityException("unknown EC point format");
    }

    public static String a(zzbmn zzbmnVar) throws NoSuchAlgorithmException {
        int i = C1068rg.f12493a[zzbmnVar.ordinal()];
        if (i == 1) {
            return "HmacSha1";
        }
        if (i == 2) {
            return "HmacSha256";
        }
        if (i == 3) {
            return "HmacSha512";
        }
        String valueOf = String.valueOf(zzbmnVar);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
        sb.append("hash unsupported for HMAC: ");
        sb.append(valueOf);
        throw new NoSuchAlgorithmException(sb.toString());
    }

    public static zzboi a(zzbml zzbmlVar) throws GeneralSecurityException {
        int i = C1068rg.f12494b[zzbmlVar.ordinal()];
        if (i == 1) {
            return zzboi.NIST_P256;
        }
        if (i == 2) {
            return zzboi.NIST_P384;
        }
        if (i == 3) {
            return zzboi.NIST_P521;
        }
        String valueOf = String.valueOf(zzbmlVar);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 20);
        sb.append("unknown curve type: ");
        sb.append(valueOf);
        throw new GeneralSecurityException(sb.toString());
    }

    public static zzboj a(zzblx zzblxVar) throws GeneralSecurityException {
        int i = C1068rg.f12495c[zzblxVar.ordinal()];
        if (i == 1) {
            return zzboj.UNCOMPRESSED;
        }
        if (i == 2) {
            return zzboj.DO_NOT_USE_CRUNCHY_UNCOMPRESSED;
        }
        if (i == 3) {
            return zzboj.COMPRESSED;
        }
        String valueOf = String.valueOf(zzblxVar);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 22);
        sb.append("unknown point format: ");
        sb.append(valueOf);
        throw new GeneralSecurityException(sb.toString());
    }
}
