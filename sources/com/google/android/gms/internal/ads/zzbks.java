package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collection;
import java.util.Iterator;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
public final class zzbks {
    private static final Logger logger = Logger.getLogger(zzbks.class.getName());

    public static zzbjs zza(zzbju zzbjuVar) throws GeneralSecurityException {
        zzbjz zza = zzbkb.zza(zzbjuVar, (zzbjt) null);
        Iterator it = zza.zzafr().iterator();
        while (it.hasNext()) {
            Iterator it2 = ((Collection) it.next()).iterator();
            while (it2.hasNext()) {
                if (!(((zzbka) it2.next()).zzafs() instanceof zzbjs)) {
                    throw new GeneralSecurityException("invalid HybridEncrypt key material");
                }
            }
        }
        return new C1041pg(zza);
    }
}
