package com.google.android.gms.internal.ads;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import javax.annotation.ParametersAreNonnullByDefault;

@zzark
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zztm extends zztd {
    private MessageDigest zzbze;
    private final int zzbzh;
    private final int zzbzi;

    public zztm(int i) {
        int i2 = i / 8;
        this.zzbzh = i % 8 > 0 ? i2 + 1 : i2;
        this.zzbzi = i;
    }

    @Override // com.google.android.gms.internal.ads.zztd
    public final byte[] zzay(String str) {
        synchronized (this.mLock) {
            this.zzbze = zzoc();
            if (this.zzbze == null) {
                return new byte[0];
            }
            this.zzbze.reset();
            this.zzbze.update(str.getBytes(Charset.forName("UTF-8")));
            byte[] digest = this.zzbze.digest();
            byte[] bArr = new byte[digest.length > this.zzbzh ? this.zzbzh : digest.length];
            System.arraycopy(digest, 0, bArr, 0, bArr.length);
            if (this.zzbzi % 8 > 0) {
                long j = 0;
                for (int i = 0; i < bArr.length; i++) {
                    if (i > 0) {
                        j <<= 8;
                    }
                    j += bArr[i] & 255;
                }
                long j2 = j >>> (8 - (this.zzbzi % 8));
                for (int i2 = this.zzbzh - 1; i2 >= 0; i2--) {
                    bArr[i2] = (byte) (255 & j2);
                    j2 >>>= 8;
                }
            }
            return bArr;
        }
    }
}
