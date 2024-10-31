package com.xiaomi.gamecenter.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ak {

    /* renamed from: a */
    private Context f26581a;

    /* renamed from: b */
    private int f26582b = 0;

    /* renamed from: c */
    private String f26583c;

    /* renamed from: d */
    private PublicKey f26584d;

    public ak(Context context, String str) {
        this.f26581a = null;
        this.f26583c = null;
        this.f26581a = context;
        this.f26583c = str;
        this.f26584d = a(this.f26583c);
    }

    private String a() {
        String string = this.f26581a.getSharedPreferences("xmgamelicense", 0).getString("license", null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return b(string);
    }

    private static PublicKey a(String str) {
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException(e2);
        } catch (InvalidKeySpecException e3) {
            Log.e("LicenseValidator", "Invalid key specification.");
            throw new IllegalArgumentException(e3);
        } catch (Exception unused) {
            Log.e("LicenseValidator", "Invalid key specification.");
            return null;
        }
    }

    private boolean a(af afVar, Bundle bundle) {
        if (afVar == null || bundle == null || afVar.a() < System.currentTimeMillis()) {
            return false;
        }
        String string = bundle.getString("mid");
        if (!TextUtils.isEmpty(afVar.b()) && TextUtils.equals(string, afVar.b())) {
            return true;
        }
        String string2 = bundle.getString("imei");
        if (TextUtils.isEmpty(afVar.c()) || !TextUtils.equals(string2, afVar.c())) {
            return !TextUtils.isEmpty(afVar.d()) && TextUtils.equals(bundle.getString("macwifi"), afVar.d());
        }
        return true;
    }

    private String b(String str) {
        try {
            byte[] decode = Base64.decode(str, 0);
            Cipher.getInstance("RSA/ECB/PKCS1Padding").init(2, this.f26584d);
            return new String(am.a(decode, this.f26583c), "UTF-8");
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private void b() {
        SharedPreferences.Editor edit = this.f26581a.getSharedPreferences("xmgamelicense", 0).edit();
        edit.remove("license");
        edit.commit();
    }

    private void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        SharedPreferences.Editor edit = this.f26581a.getSharedPreferences("xmgamelicense", 0).edit();
        edit.putString("license", str);
        edit.commit();
    }

    public boolean a(Bundle bundle) {
        if (bundle == null) {
            return false;
        }
        String a2 = a();
        if (!TextUtils.isEmpty(a2)) {
            try {
                if (a(new af(new JSONObject(a2)), bundle)) {
                    return true;
                }
                b();
                return false;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    public boolean a(Bundle bundle, Bundle bundle2) {
        if (bundle != null && bundle2 != null) {
            String string = bundle.getString("license");
            if (!TextUtils.isEmpty(string)) {
                try {
                    if (a(new af(new JSONObject(b(string))), bundle2)) {
                        c(string);
                        return true;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        return false;
    }
}
