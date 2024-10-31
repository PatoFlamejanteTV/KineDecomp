package com.google.android.gms.internal.ads;

import android.support.v7.widget.ActivityChooserView;
import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes2.dex */
public final class zzbnu implements zzbov {
    private final SecretKeySpec zzfil;
    private final int zzfim;
    private final int zzfin;

    public zzbnu(byte[] bArr, int i) throws GeneralSecurityException {
        zzbpd.zzeh(bArr.length);
        this.zzfil = new SecretKeySpec(bArr, "AES");
        this.zzfin = zzbol.zzfjr.zzfu("AES/CTR/NoPadding").getBlockSize();
        if (i >= 12 && i <= this.zzfin) {
            this.zzfim = i;
            return;
        }
        throw new GeneralSecurityException("invalid IV size");
    }

    @Override // com.google.android.gms.internal.ads.zzbov
    public final byte[] zzn(byte[] bArr) throws GeneralSecurityException {
        int length = bArr.length;
        int i = this.zzfim;
        if (length <= ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED - i) {
            byte[] bArr2 = new byte[bArr.length + i];
            byte[] zzeg = zzboy.zzeg(i);
            System.arraycopy(zzeg, 0, bArr2, 0, this.zzfim);
            int length2 = bArr.length;
            int i2 = this.zzfim;
            Cipher zzfu = zzbol.zzfjr.zzfu("AES/CTR/NoPadding");
            byte[] bArr3 = new byte[this.zzfin];
            System.arraycopy(zzeg, 0, bArr3, 0, this.zzfim);
            zzfu.init(1, this.zzfil, new IvParameterSpec(bArr3));
            if (zzfu.doFinal(bArr, 0, length2, bArr2, i2) == length2) {
                return bArr2;
            }
            throw new GeneralSecurityException("stored output's length does not match input's length");
        }
        int i3 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED - i;
        StringBuilder sb = new StringBuilder(43);
        sb.append("plaintext length can not exceed ");
        sb.append(i3);
        throw new GeneralSecurityException(sb.toString());
    }
}
