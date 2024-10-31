package com.adobe.creativesdk.foundation.internal.auth;

import android.util.Base64;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeCommonCipher.java */
/* loaded from: classes.dex */
public final class L {

    /* renamed from: a */
    private static L f4840a;

    /* renamed from: b */
    private Cipher f4841b;

    /* renamed from: c */
    private Cipher f4842c;

    public L(byte[] bArr) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        this.f4842c = Cipher.getInstance("AES");
        this.f4842c.init(1, secretKeySpec);
        this.f4841b = Cipher.getInstance("AES");
        this.f4841b.init(2, secretKeySpec);
    }

    public static L a(byte[] bArr) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        if (f4840a == null) {
            f4840a = new L(bArr);
        }
        return f4840a;
    }

    public String b(String str) {
        if (str != null) {
            try {
                return new String(Base64.encode(this.f4842c.doFinal(str.getBytes("UTF-8")), 2), "UTF-8");
            } catch (Exception e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, e2.getClass().getSimpleName(), "Encryption error", e2);
            }
        }
        return null;
    }

    public String a(String str) {
        if (str != null) {
            try {
                return new String(this.f4841b.doFinal(Base64.decode(str.getBytes("UTF-8"), 2)), "UTF-8");
            } catch (Exception e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, e2.getClass().getSimpleName(), "Decryption error", e2);
            }
        }
        return null;
    }
}
