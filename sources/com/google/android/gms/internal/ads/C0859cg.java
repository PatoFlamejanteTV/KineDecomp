package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbmv;
import com.google.android.gms.internal.ads.zzbne;
import com.google.android.gms.internal.ads.zzbng;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.ads.cg, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0859cg {

    /* renamed from: a, reason: collision with root package name */
    private static final Charset f12103a = Charset.forName("UTF-8");

    public static zzbng a(zzbne zzbneVar) {
        zzbng.zza zzea = zzbng.zzaje().zzea(zzbneVar.zzaiu());
        for (zzbne.zzb zzbVar : zzbneVar.zzaiv()) {
            zzea.zzb((zzbng.zzb) zzbng.zzb.zzajg().zzfr(zzbVar.zzaiz().zzaig()).zzb(zzbVar.zzaja()).zzb(zzbVar.zzajc()).zzec(zzbVar.zzajb()).zzana());
        }
        return (zzbng) zzea.zzana();
    }

    public static void b(zzbne zzbneVar) throws GeneralSecurityException {
        if (zzbneVar.zzaiw() != 0) {
            int zzaiu = zzbneVar.zzaiu();
            boolean z = false;
            boolean z2 = true;
            for (zzbne.zzb zzbVar : zzbneVar.zzaiv()) {
                if (zzbVar.zzaiy()) {
                    if (zzbVar.zzajc() != zzbnq.UNKNOWN_PREFIX) {
                        if (zzbVar.zzaja() != zzbmy.UNKNOWN_STATUS) {
                            if (zzbVar.zzaja() == zzbmy.ENABLED && zzbVar.zzajb() == zzaiu) {
                                if (z) {
                                    throw new GeneralSecurityException("keyset contains multiple primary keys");
                                }
                                z = true;
                            }
                            if (zzbVar.zzaiz().zzaii() != zzbmv.zzb.ASYMMETRIC_PUBLIC) {
                                z2 = false;
                            }
                        } else {
                            throw new GeneralSecurityException(String.format("key %d has unknown status", Integer.valueOf(zzbVar.zzajb())));
                        }
                    } else {
                        throw new GeneralSecurityException(String.format("key %d has unknown prefix", Integer.valueOf(zzbVar.zzajb())));
                    }
                } else {
                    throw new GeneralSecurityException(String.format("key %d has no key data", Integer.valueOf(zzbVar.zzajb())));
                }
            }
            if (!z && !z2) {
                throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
            }
            return;
        }
        throw new GeneralSecurityException("empty keyset");
    }
}
