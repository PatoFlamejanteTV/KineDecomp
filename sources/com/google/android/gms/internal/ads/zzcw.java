package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes2.dex */
public final class zzcw {
    private static Cipher zzsb;
    private static final Object zzsc = new Object();
    private static final Object zzsd = new Object();
    private final SecureRandom zzsa = null;

    public zzcw(SecureRandom secureRandom) {
    }

    private static Cipher getCipher() throws NoSuchAlgorithmException, NoSuchPaddingException {
        Cipher cipher;
        synchronized (zzsd) {
            if (zzsb == null) {
                zzsb = Cipher.getInstance("AES/CBC/PKCS5Padding");
            }
            cipher = zzsb;
        }
        return cipher;
    }

    public final byte[] zza(byte[] bArr, String str) throws zzcx {
        byte[] doFinal;
        if (bArr.length == 16) {
            try {
                byte[] zza = zzbu.zza(str, false);
                if (zza.length > 16) {
                    ByteBuffer allocate = ByteBuffer.allocate(zza.length);
                    allocate.put(zza);
                    allocate.flip();
                    byte[] bArr2 = new byte[16];
                    byte[] bArr3 = new byte[zza.length - 16];
                    allocate.get(bArr2);
                    allocate.get(bArr3);
                    SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
                    synchronized (zzsc) {
                        getCipher().init(2, secretKeySpec, new IvParameterSpec(bArr2));
                        doFinal = getCipher().doFinal(bArr3);
                    }
                    return doFinal;
                }
                throw new zzcx(this);
            } catch (IllegalArgumentException e2) {
                throw new zzcx(this, e2);
            } catch (InvalidAlgorithmParameterException e3) {
                throw new zzcx(this, e3);
            } catch (InvalidKeyException e4) {
                throw new zzcx(this, e4);
            } catch (NoSuchAlgorithmException e5) {
                throw new zzcx(this, e5);
            } catch (BadPaddingException e6) {
                throw new zzcx(this, e6);
            } catch (IllegalBlockSizeException e7) {
                throw new zzcx(this, e7);
            } catch (NoSuchPaddingException e8) {
                throw new zzcx(this, e8);
            }
        }
        throw new zzcx(this);
    }

    public final String zzb(byte[] bArr, byte[] bArr2) throws zzcx {
        byte[] doFinal;
        byte[] iv;
        if (bArr.length == 16) {
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
                synchronized (zzsc) {
                    getCipher().init(1, secretKeySpec, (SecureRandom) null);
                    doFinal = getCipher().doFinal(bArr2);
                    iv = getCipher().getIV();
                }
                int length = doFinal.length + iv.length;
                ByteBuffer allocate = ByteBuffer.allocate(length);
                allocate.put(iv).put(doFinal);
                allocate.flip();
                byte[] bArr3 = new byte[length];
                allocate.get(bArr3);
                return zzbu.zza(bArr3, false);
            } catch (InvalidKeyException e2) {
                throw new zzcx(this, e2);
            } catch (NoSuchAlgorithmException e3) {
                throw new zzcx(this, e3);
            } catch (BadPaddingException e4) {
                throw new zzcx(this, e4);
            } catch (IllegalBlockSizeException e5) {
                throw new zzcx(this, e5);
            } catch (NoSuchPaddingException e6) {
                throw new zzcx(this, e6);
            }
        }
        throw new zzcx(this);
    }

    public final byte[] zzl(String str) throws zzcx {
        try {
            byte[] zza = zzbu.zza(str, false);
            if (zza.length == 32) {
                byte[] bArr = new byte[16];
                ByteBuffer.wrap(zza, 4, 16).get(bArr);
                for (int i = 0; i < 16; i++) {
                    bArr[i] = (byte) (bArr[i] ^ 68);
                }
                return bArr;
            }
            throw new zzcx(this);
        } catch (IllegalArgumentException e2) {
            throw new zzcx(this, e2);
        }
    }
}
