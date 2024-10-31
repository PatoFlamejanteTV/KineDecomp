package com.qq.e.comm.net.rr;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a */
    private static final byte[] f25038a = {91, -62};

    /* renamed from: b */
    private static Cipher f25039b = null;

    /* renamed from: c */
    private static Cipher f25040c = null;

    /* renamed from: d */
    private static String f25041d = String.format("AES/%s/PKCS7Padding", "ECB");

    /* renamed from: e */
    private static byte[] f25042e = Base64.decode("4M3PpUC4Vu1uMp+Y0Mxd+vfc6v4ggJAINfgTlH74pis=", 0);

    /* renamed from: com.qq.e.comm.net.rr.a$a */
    /* loaded from: classes3.dex */
    public static class C0128a extends Exception {
        public C0128a(String str, Throwable th) {
            super(str, th);
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends Exception {
        public b(String str, Throwable th) {
            super(str, th);
        }
    }

    @SuppressLint({"TrulyRandom"})
    private static synchronized Cipher a() throws C0128a {
        synchronized (a.class) {
            if (f25039b != null) {
                return f25039b;
            }
            try {
                Cipher cipher = Cipher.getInstance(f25041d);
                cipher.init(1, new SecretKeySpec(f25042e, "AES"));
                f25039b = cipher;
                return f25039b;
            } catch (Exception e2) {
                throw new C0128a("Fail To Init Cipher", e2);
            }
        }
    }

    public static byte[] a(byte[] bArr) throws b {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.write(f25038a);
            dataOutputStream.writeByte(1);
            dataOutputStream.writeByte(2);
            dataOutputStream.write(c(com.qq.e.comm.a.a(bArr)));
            dataOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e2) {
            throw new b("Exception while packaging byte array", e2);
        }
    }

    private static synchronized Cipher b() throws C0128a {
        synchronized (a.class) {
            if (f25040c != null) {
                return f25040c;
            }
            try {
                Cipher cipher = Cipher.getInstance(f25041d);
                cipher.init(2, new SecretKeySpec(f25042e, "AES"));
                f25040c = cipher;
                return f25040c;
            } catch (Exception e2) {
                throw new C0128a("Fail To Init Cipher", e2);
            }
        }
    }

    @TargetApi(9)
    public static byte[] b(byte[] bArr) throws b {
        if (bArr == null || bArr.length < 4) {
            throw new b("S2SS Package FormatError", null);
        }
        try {
            byte[] bArr2 = new byte[4];
            new DataInputStream(new ByteArrayInputStream(bArr)).read(bArr2);
            if (f25038a[0] == bArr2[0] && f25038a[1] == bArr2[1] && 1 == bArr2[2] && 2 == bArr2[3]) {
                return com.qq.e.comm.a.b(d(Arrays.copyOfRange(bArr, 4, bArr.length)));
            }
            throw new b("S2SS Package Magic/Version FormatError", null);
        } catch (Exception e2) {
            throw new b("Exception while packaging byte array", e2);
        }
    }

    private static byte[] c(byte[] bArr) throws C0128a {
        try {
            return a().doFinal(bArr);
        } catch (Exception e2) {
            throw new C0128a("Exception While encrypt byte array", e2);
        }
    }

    private static byte[] d(byte[] bArr) throws C0128a {
        try {
            return b().doFinal(bArr);
        } catch (Exception e2) {
            throw new C0128a("Exception While dencrypt byte array", e2);
        }
    }
}
