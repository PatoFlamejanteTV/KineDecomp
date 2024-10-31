package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* loaded from: classes2.dex */
public final class zzbju {
    private zzbne zzfda;

    private zzbju(zzbne zzbneVar) {
        this.zzfda = zzbneVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final zzbju zza(zzbne zzbneVar) throws GeneralSecurityException {
        if (zzbneVar != null && zzbneVar.zzaiw() > 0) {
            return new zzbju(zzbneVar);
        }
        throw new GeneralSecurityException("empty keyset");
    }

    public final String toString() {
        return C0859cg.a(this.zzfda).toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzbne zzafp() {
        return this.zzfda;
    }
}
