package com.xiaomi.gamecenter.sdk;

import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* loaded from: classes.dex */
public class am {
    public static byte[] a(byte[] bArr, String str) {
        PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(2, generatePublic);
        int length = bArr.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        int i2 = 0;
        while (length - i2 > 0) {
            byte[] doFinal = length - i2 > 128 ? cipher.doFinal(bArr, i2, 128) : cipher.doFinal(bArr, i2, length - i2);
            byteArrayOutputStream.write(doFinal, 0, doFinal.length);
            int i3 = i + 1;
            i2 = i3 * 128;
            i = i3;
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        return byteArray;
    }
}
