package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbnc;
import java.security.GeneralSecurityException;

/* loaded from: classes2.dex */
public final class zzbjo {
    public static zzbnc zza(String str, String str2, String str3, int i, boolean z) {
        zzbnc.zza zzfo = zzbnc.zzais().zzfo(str2);
        String valueOf = String.valueOf(str3);
        return (zzbnc) zzfo.zzfp(valueOf.length() != 0 ? "type.googleapis.com/google.crypto.tink.".concat(valueOf) : new String("type.googleapis.com/google.crypto.tink.")).zzdy(0).zzbc(true).zzfq(str).zzana();
    }

    public static void zza(zzbns zzbnsVar) throws GeneralSecurityException {
        for (zzbnc zzbncVar : zzbnsVar.zzajv()) {
            if (!zzbncVar.zzaig().isEmpty()) {
                if (!zzbncVar.zzaio().isEmpty()) {
                    if (!zzbncVar.zzair().isEmpty()) {
                        zzbkb.zza(zzbkb.zzfi(zzbncVar.zzair()).zzb(zzbncVar.zzaig(), zzbncVar.zzaio(), zzbncVar.zzaip()), zzbncVar.zzaiq());
                    } else {
                        throw new GeneralSecurityException("Missing catalogue_name.");
                    }
                } else {
                    throw new GeneralSecurityException("Missing primitive_name.");
                }
            } else {
                throw new GeneralSecurityException("Missing type_url.");
            }
        }
    }
}
