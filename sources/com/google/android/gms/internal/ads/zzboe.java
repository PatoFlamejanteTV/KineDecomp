package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes2.dex */
public final class zzboe {
    private ECPublicKey zzfja;

    public zzboe(ECPublicKey eCPublicKey) {
        this.zzfja = eCPublicKey;
    }

    public final zzbof zza(String str, byte[] bArr, byte[] bArr2, int i, zzboj zzbojVar) throws GeneralSecurityException {
        byte[] bArr3;
        KeyPair zza = zzbog.zza(this.zzfja.getParams());
        ECPublicKey eCPublicKey = (ECPublicKey) zza.getPublic();
        ECPrivateKey eCPrivateKey = (ECPrivateKey) zza.getPrivate();
        ECPublicKey eCPublicKey2 = this.zzfja;
        try {
            ECParameterSpec params = eCPublicKey2.getParams();
            ECParameterSpec params2 = eCPrivateKey.getParams();
            if (params.getCurve().equals(params2.getCurve()) && params.getGenerator().equals(params2.getGenerator()) && params.getOrder().equals(params2.getOrder()) && params.getCofactor() == params2.getCofactor()) {
                byte[] zza2 = zzbog.zza(eCPrivateKey, eCPublicKey2.getW());
                EllipticCurve curve = eCPublicKey.getParams().getCurve();
                ECPoint w = eCPublicKey.getW();
                zzbog.zza(w, curve);
                int zzb = zzbog.zzb(curve);
                int i2 = C0917gh.f12179a[zzbojVar.ordinal()];
                int i3 = 1;
                if (i2 == 1) {
                    int i4 = (zzb * 2) + 1;
                    bArr3 = new byte[i4];
                    byte[] byteArray = w.getAffineX().toByteArray();
                    byte[] byteArray2 = w.getAffineY().toByteArray();
                    System.arraycopy(byteArray2, 0, bArr3, i4 - byteArray2.length, byteArray2.length);
                    System.arraycopy(byteArray, 0, bArr3, (zzb + 1) - byteArray.length, byteArray.length);
                    bArr3[0] = 4;
                } else if (i2 != 2) {
                    if (i2 == 3) {
                        int i5 = zzb + 1;
                        byte[] bArr4 = new byte[i5];
                        byte[] byteArray3 = w.getAffineX().toByteArray();
                        System.arraycopy(byteArray3, 0, bArr4, i5 - byteArray3.length, byteArray3.length);
                        bArr4[0] = (byte) (w.getAffineY().testBit(0) ? 3 : 2);
                        bArr3 = bArr4;
                    } else {
                        String valueOf = String.valueOf(zzbojVar);
                        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 15);
                        sb.append("invalid format:");
                        sb.append(valueOf);
                        throw new GeneralSecurityException(sb.toString());
                    }
                } else {
                    int i6 = zzb * 2;
                    bArr3 = new byte[i6];
                    byte[] byteArray4 = w.getAffineX().toByteArray();
                    if (byteArray4.length > zzb) {
                        byteArray4 = Arrays.copyOfRange(byteArray4, byteArray4.length - zzb, byteArray4.length);
                    }
                    byte[] byteArray5 = w.getAffineY().toByteArray();
                    if (byteArray5.length > zzb) {
                        byteArray5 = Arrays.copyOfRange(byteArray5, byteArray5.length - zzb, byteArray5.length);
                    }
                    System.arraycopy(byteArray5, 0, bArr3, i6 - byteArray5.length, byteArray5.length);
                    System.arraycopy(byteArray4, 0, bArr3, zzb - byteArray4.length, byteArray4.length);
                }
                byte[] zza3 = zzbnx.zza(bArr3, zza2);
                Mac zzfu = zzbol.zzfjs.zzfu(str);
                if (i <= zzfu.getMacLength() * 255) {
                    if (bArr != null && bArr.length != 0) {
                        zzfu.init(new SecretKeySpec(bArr, str));
                    } else {
                        zzfu.init(new SecretKeySpec(new byte[zzfu.getMacLength()], str));
                    }
                    byte[] doFinal = zzfu.doFinal(zza3);
                    byte[] bArr5 = new byte[i];
                    zzfu.init(new SecretKeySpec(doFinal, str));
                    byte[] bArr6 = new byte[0];
                    int i7 = 0;
                    while (true) {
                        zzfu.update(bArr6);
                        zzfu.update(bArr2);
                        zzfu.update((byte) i3);
                        bArr6 = zzfu.doFinal();
                        if (bArr6.length + i7 < i) {
                            System.arraycopy(bArr6, 0, bArr5, i7, bArr6.length);
                            i7 += bArr6.length;
                            i3++;
                        } else {
                            System.arraycopy(bArr6, 0, bArr5, i7, i - i7);
                            return new zzbof(bArr3, bArr5);
                        }
                    }
                } else {
                    throw new GeneralSecurityException("size too large");
                }
            } else {
                throw new GeneralSecurityException("invalid public key spec");
            }
        } catch (IllegalArgumentException | NullPointerException e2) {
            throw new GeneralSecurityException(e2.toString());
        }
    }
}
