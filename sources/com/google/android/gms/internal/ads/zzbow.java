package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;

/* loaded from: classes2.dex */
public final class zzbow implements zzbjx {
    private Mac zzfkb;
    private final int zzfkc;
    private final String zzfkd;
    private final Key zzfke;

    public zzbow(String str, Key key, int i) throws GeneralSecurityException {
        if (i >= 10) {
            char c2 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -1823053428) {
                if (hashCode != 392315118) {
                    if (hashCode == 392317873 && str.equals("HMACSHA512")) {
                        c2 = 2;
                    }
                } else if (str.equals("HMACSHA256")) {
                    c2 = 1;
                }
            } else if (str.equals("HMACSHA1")) {
                c2 = 0;
            }
            if (c2 != 0) {
                if (c2 != 1) {
                    if (c2 != 2) {
                        String valueOf = String.valueOf(str);
                        throw new NoSuchAlgorithmException(valueOf.length() != 0 ? "unknown Hmac algorithm: ".concat(valueOf) : new String("unknown Hmac algorithm: "));
                    }
                    if (i > 64) {
                        throw new InvalidAlgorithmParameterException("tag size too big");
                    }
                } else if (i > 32) {
                    throw new InvalidAlgorithmParameterException("tag size too big");
                }
            } else if (i > 20) {
                throw new InvalidAlgorithmParameterException("tag size too big");
            }
            this.zzfkd = str;
            this.zzfkc = i;
            this.zzfke = key;
            this.zzfkb = zzbol.zzfjs.zzfu(str);
            this.zzfkb.init(key);
            return;
        }
        throw new InvalidAlgorithmParameterException("tag size too small, need at least 10 bytes");
    }

    @Override // com.google.android.gms.internal.ads.zzbjx
    public final byte[] zzj(byte[] bArr) throws GeneralSecurityException {
        Mac zzfu;
        try {
            zzfu = (Mac) this.zzfkb.clone();
        } catch (CloneNotSupportedException unused) {
            zzfu = zzbol.zzfjs.zzfu(this.zzfkd);
            zzfu.init(this.zzfke);
        }
        zzfu.update(bArr);
        byte[] bArr2 = new byte[this.zzfkc];
        System.arraycopy(zzfu.doFinal(), 0, bArr2, 0, this.zzfkc);
        return bArr2;
    }
}
