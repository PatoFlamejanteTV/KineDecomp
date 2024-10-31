package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.Signature;

/* loaded from: classes2.dex */
public final class zzbot implements zzbom<Signature> {
    @Override // com.google.android.gms.internal.ads.zzbom
    public final /* synthetic */ Signature zzb(String str, Provider provider) throws GeneralSecurityException {
        if (provider == null) {
            return Signature.getInstance(str);
        }
        return Signature.getInstance(str, provider);
    }
}
