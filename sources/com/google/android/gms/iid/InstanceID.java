package com.google.android.gms.iid;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Looper;
import android.util.Base64;
import android.util.Log;
import java.io.IOException;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class InstanceID {

    /* renamed from: a, reason: collision with root package name */
    static Map<String, InstanceID> f1422a = new HashMap();
    static String f;
    private static zzd g;
    private static zzc h;
    Context b;
    KeyPair c;
    String d;
    long e;

    protected InstanceID(Context context, String str, Bundle bundle) {
        this.d = "";
        this.b = context.getApplicationContext();
        this.d = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            Log.w("InstanceID", "Never happens: can't find own package " + e);
            return 0;
        }
    }

    public static synchronized InstanceID a(Context context, Bundle bundle) {
        InstanceID instanceID;
        synchronized (InstanceID.class) {
            String string = bundle == null ? "" : bundle.getString("subtype");
            String str = string == null ? "" : string;
            Context applicationContext = context.getApplicationContext();
            if (g == null) {
                g = new zzd(applicationContext);
                h = new zzc(applicationContext);
            }
            f = Integer.toString(a(applicationContext));
            instanceID = f1422a.get(str);
            if (instanceID == null) {
                instanceID = new InstanceID(applicationContext, str, bundle);
                f1422a.put(str, instanceID);
            }
        }
        return instanceID;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(KeyPair keyPair) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(keyPair.getPublic().getEncoded());
            digest[0] = (byte) (((digest[0] & 15) + 112) & 255);
            return Base64.encodeToString(digest, 0, 8, 11);
        } catch (NoSuchAlgorithmException e) {
            Log.w("InstanceID", "Unexpected error, device missing required alghorithms");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(byte[] bArr) {
        return Base64.encodeToString(bArr, 11);
    }

    public static InstanceID b(Context context) {
        return a(context, null);
    }

    public String a(String str, String str2, Bundle bundle) throws IOException {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        String a2 = f() ? null : g.a(this.d, str, str2);
        if (a2 == null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            boolean z = "jwt".equals(bundle.getString("type")) ? false : bundle.getString("ttl") == null;
            a2 = b(str, str2, bundle);
            Log.w("InstanceID", "token: " + a2);
            if (a2 != null && z) {
                g.a(this.d, str, str2, a2, f);
            }
        }
        return a2;
    }

    KeyPair a() {
        if (this.c == null) {
            this.c = g.c(this.d);
        }
        if (this.c == null) {
            this.e = System.currentTimeMillis();
            this.c = g.a(this.d, this.e);
        }
        return this.c;
    }

    public String b() {
        return a(a());
    }

    public String b(String str, String str2, Bundle bundle) throws IOException {
        if (str2 != null) {
            bundle.putString("scope", str2);
        }
        bundle.putString("sender", str);
        String str3 = "".equals(this.d) ? str : this.d;
        if (!bundle.containsKey("legacy.register")) {
            bundle.putString("subscription", str);
            bundle.putString("subtype", str3);
            bundle.putString("X-subscription", str);
            bundle.putString("X-subtype", str3);
        }
        return h.b(h.a(bundle, a()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        this.e = 0L;
        g.d(this.d);
        this.c = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzd d() {
        return g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzc e() {
        return h;
    }

    boolean f() {
        String a2;
        String a3 = g.a("appVersion");
        if (a3 == null || !a3.equals(f) || (a2 = g.a("lastToken")) == null) {
            return true;
        }
        return (System.currentTimeMillis() / 1000) - Long.valueOf(Long.parseLong(a2)).longValue() > 604800;
    }
}
