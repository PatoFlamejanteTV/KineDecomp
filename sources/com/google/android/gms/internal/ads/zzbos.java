package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.Provider;

/* loaded from: classes2.dex */
public final class zzbos implements zzbom<MessageDigest> {
    @Override // com.google.android.gms.internal.ads.zzbom
    public final /* synthetic */ MessageDigest zzb(String str, Provider provider) throws GeneralSecurityException {
        if (provider == null) {
            return MessageDigest.getInstance(str);
        }
        return MessageDigest.getInstance(str, provider);
    }
}
