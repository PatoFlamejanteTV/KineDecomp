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
import org.keyczar.Keyczar;

/* loaded from: classes.dex */
public class ak {

    /* renamed from: a, reason: collision with root package name */
    private Context f4887a;
    private int b = 0;
    private String c;
    private PublicKey d;

    public ak(Context context, String str) {
        this.f4887a = null;
        this.c = null;
        this.f4887a = context;
        this.c = str;
        this.d = a(this.c);
    }

    private String a() {
        String string = this.f4887a.getSharedPreferences("xmgamelicense", 0).getString("license", null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return b(string);
    }

    private static PublicKey a(String str) {
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeySpecException e2) {
            Log.e("LicenseValidator", "Invalid key specification.");
            throw new IllegalArgumentException(e2);
        } catch (Exception e3) {
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
            Cipher.getInstance("RSA/ECB/PKCS1Padding").init(2, this.d);
            return new String(am.a(decode, this.c), Keyczar.DEFAULT_ENCODING);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void b() {
        SharedPreferences.Editor edit = this.f4887a.getSharedPreferences("xmgamelicense", 0).edit();
        edit.remove("license");
        edit.commit();
    }

    private void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        SharedPreferences.Editor edit = this.f4887a.getSharedPreferences("xmgamelicense", 0).edit();
        edit.putString("license", str);
        edit.commit();
    }

    public boolean a(Bundle bundle) {
        if (bundle == null) {
            return false;
        }
        String a2 = a();
        if (TextUtils.isEmpty(a2)) {
            return false;
        }
        try {
            if (a(new af(new JSONObject(a2)), bundle)) {
                return true;
            }
            b();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean a(Bundle bundle, Bundle bundle2) {
        if (bundle == null || bundle2 == null) {
            return false;
        }
        String string = bundle.getString("license");
        if (TextUtils.isEmpty(string)) {
            return false;
        }
        try {
            if (!a(new af(new JSONObject(b(string))), bundle2)) {
                return false;
            }
            c(string);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
