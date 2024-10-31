package com.adobe.creativesdk.foundation.internal.auth;

import android.content.SharedPreferences;
import android.util.Base64;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

/* compiled from: AdobeCSDKAuthAESKeyMgr.java */
/* loaded from: classes.dex */
public class J {

    /* renamed from: a */
    private static J f4825a = null;

    /* renamed from: b */
    private static final String f4826b = "J";

    /* renamed from: c */
    private byte[] f4827c;

    /* renamed from: d */
    private final String f4828d = "adb_foundation_auth_aes_preference";

    /* renamed from: e */
    private final String f4829e = "adb_foundation_auth_aes_secret_key";

    /* renamed from: f */
    private final String f4830f = "adb_shareddevicetoken_auth_aes_secret_key";

    /* renamed from: g */
    private a f4831g = new a();

    J() {
    }

    public static byte[] c() {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(128);
            return keyGenerator.generateKey().getEncoded();
        } catch (Exception e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, f4826b, e2.getMessage(), e2);
            throw new IllegalArgumentException("Auth Foundation : Auth AESKeyMgr : Failed to generate an AES key");
        }
    }

    public static J e() {
        if (f4825a == null) {
            f4825a = new J();
        }
        return f4825a;
    }

    private byte[] f() {
        return a("adb_foundation_auth_aes_secret_key");
    }

    public void b() {
        SharedPreferences.Editor edit = c.a.a.a.c.a.a.b().a().getSharedPreferences("adb_foundation_auth_aes_preference", 0).edit();
        edit.remove("adb_foundation_auth_aes_secret_key");
        edit.commit();
    }

    public byte[] d() {
        byte[] bArr = this.f4827c;
        if (bArr != null) {
            return (byte[]) bArr.clone();
        }
        this.f4827c = f();
        if (this.f4827c == null) {
            this.f4827c = c();
            byte[] bArr2 = this.f4827c;
            if (bArr2 != null) {
                a(bArr2);
            } else {
                throw new IllegalArgumentException("CSDK Foundation Auth AES Key is null.");
            }
        }
        return (byte[]) this.f4827c.clone();
    }

    /* compiled from: AdobeCSDKAuthAESKeyMgr.java */
    /* loaded from: classes.dex */
    public class a {

        /* renamed from: a */
        private PrivateKey f4832a;

        /* renamed from: b */
        private PublicKey f4833b;

        /* renamed from: c */
        private boolean f4834c = false;

        public a() {
            if (!this.f4834c) {
            }
        }

        private Cipher a() {
            try {
                return Cipher.getInstance("RSA/ECB/PKCS1Padding", "AndroidOpenSSL");
            } catch (Exception e2) {
                throw new IllegalArgumentException("Auth Foundation : Auth AESKeyMgr : Failed to create Cipher", e2);
            }
        }

        private byte[] c(byte[] bArr) {
            Cipher a2 = a();
            try {
                a2.init(2, this.f4832a);
                return a2.doFinal(bArr);
            } catch (Exception e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, J.f4826b, e2.getMessage(), e2);
                throw new IllegalArgumentException("Auth Foundation : Auth AESKeyMgr : Failed to decyrpt using private key", e2);
            }
        }

        private byte[] d(byte[] bArr) {
            Cipher a2 = a();
            try {
                a2.init(1, this.f4833b);
                return a2.doFinal(bArr);
            } catch (Exception e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, J.f4826b, e2.getMessage(), e2);
                throw new IllegalArgumentException("Auth Foundation : Auth AESKeyMgr : Failed to encrypt using public key", e2);
            }
        }

        public byte[] b(byte[] bArr) {
            return !this.f4834c ? bArr : d(bArr);
        }

        public byte[] a(byte[] bArr) {
            return !this.f4834c ? bArr : c(bArr);
        }
    }

    private void a(byte[] bArr, String str) {
        String encodeToString = Base64.encodeToString(this.f4831g.b(bArr), 2);
        SharedPreferences.Editor edit = c.a.a.a.c.a.a.b().a().getSharedPreferences("adb_foundation_auth_aes_preference", 0).edit();
        edit.putString(str, encodeToString);
        edit.commit();
    }

    private String b(String str) {
        return c.a.a.a.c.a.a.b().a().getSharedPreferences("adb_foundation_auth_aes_preference", 0).getString(str, null);
    }

    private void a(byte[] bArr) {
        a(bArr, "adb_foundation_auth_aes_secret_key");
    }

    private byte[] a(String str) {
        String b2 = b(str);
        if (b2 == null) {
            return null;
        }
        try {
            return this.f4831g.a(Base64.decode(b2.getBytes("UTF-8"), 2));
        } catch (Exception e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, e2.getClass().getSimpleName(), "Decryption error", e2);
            return null;
        }
    }
}
