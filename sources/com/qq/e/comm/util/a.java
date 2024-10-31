package com.qq.e.comm.util;

import android.util.Base64;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* loaded from: classes3.dex */
public class a {

    /* renamed from: a */
    private PublicKey f25067a;

    /* renamed from: b */
    private final boolean f25068b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.qq.e.comm.util.a$a */
    /* loaded from: classes3.dex */
    public static final class C0129a {

        /* renamed from: a */
        public static final a f25069a = new a((byte) 0);
    }

    private a() {
        boolean z;
        try {
            this.f25067a = b("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDKta2b5Vw5YkWHCAj4rJCwS227\r/35FZ29e4I6pS2B8zSq2RgBpXUuMg7oZF1Qt3x0iyg8PeyblyNeCRB6gIMehFThe\r1Y7m1FaQyaZp+CJYOTLM4/THKp9UndrEgJ/5a83vP1375YCV2lMvWARrNlBep4RN\rnESUJhQz58Gr/F39TwIDAQAB");
            z = true;
        } catch (Throwable unused) {
            z = false;
        }
        this.f25068b = z;
    }

    /* synthetic */ a(byte b2) {
        this();
    }

    public static a a() {
        return C0129a.f25069a;
    }

    private String a(String str) {
        if (this.f25067a == null) {
            return null;
        }
        byte[] decode = Base64.decode(str, 0);
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(2, this.f25067a);
            return new String(cipher.doFinal(decode), "UTF-8").trim();
        } catch (Throwable th) {
            GDTLogger.e("ErrorWhileVerifySigNature", th);
            return null;
        }
    }

    private static PublicKey b(String str) throws Exception {
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
        } catch (NullPointerException unused) {
            throw new Exception("公钥数据为空");
        } catch (NoSuchAlgorithmException unused2) {
            throw new Exception("无此算法");
        } catch (InvalidKeySpecException unused3) {
            throw new Exception("公钥非法");
        }
    }

    public final boolean a(String str, String str2) {
        return b(str, Md5Util.encode(str2));
    }

    public final boolean b(String str, String str2) {
        if (StringUtil.isEmpty(str2)) {
            return false;
        }
        if (!this.f25068b) {
            return true;
        }
        String a2 = a(str);
        boolean equals = str2.equals(a2);
        GDTLogger.d("Verify Result" + equals + "src=" + str2 + " & target=" + a2);
        return equals;
    }
}
