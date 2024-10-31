package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.interfaces.ECPrivateKey;

/* loaded from: classes2.dex */
public final class zzbob implements zzbjr {
    private static final byte[] zzfdo = new byte[0];
    private final ECPrivateKey zzfit;
    private final zzbod zzfiu;
    private final String zzfiv;
    private final byte[] zzfiw;
    private final zzboj zzfix;
    private final zzboa zzfiy;

    public zzbob(ECPrivateKey eCPrivateKey, byte[] bArr, String str, zzboj zzbojVar, zzboa zzboaVar) throws GeneralSecurityException {
        this.zzfit = eCPrivateKey;
        this.zzfiu = new zzbod(eCPrivateKey);
        this.zzfiw = bArr;
        this.zzfiv = str;
        this.zzfix = zzbojVar;
        this.zzfiy = zzboaVar;
    }
}
