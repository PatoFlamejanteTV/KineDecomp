package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.Provider;
import javax.crypto.Cipher;

/* loaded from: classes2.dex */
public final class zzbon implements zzbom<Cipher> {
    @Override // com.google.android.gms.internal.ads.zzbom
    public final /* synthetic */ Cipher zzb(String str, Provider provider) throws GeneralSecurityException {
        if (provider == null) {
            return Cipher.getInstance(str);
        }
        return Cipher.getInstance(str, provider);
    }
}
