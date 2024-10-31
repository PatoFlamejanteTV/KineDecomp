package com.google.firebase.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.content.ContextCompat;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/* renamed from: com.google.firebase.iid.r */
/* loaded from: classes2.dex */
public final class C1620r {

    /* renamed from: a */
    private final SharedPreferences f17375a;

    /* renamed from: b */
    private final Context f17376b;

    /* renamed from: c */
    private final O f17377c;

    /* renamed from: d */
    private final Map<String, P> f17378d;

    public C1620r(Context context) {
        this(context, new O());
    }

    private static String b(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 4 + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb.append(str);
        sb.append("|T|");
        sb.append(str2);
        sb.append("|");
        sb.append(str3);
        return sb.toString();
    }

    private final synchronized boolean c() {
        return this.f17375a.getAll().isEmpty();
    }

    public final synchronized String a() {
        return this.f17375a.getString("topic_operaion_queue", "");
    }

    private C1620r(Context context, O o) {
        this.f17378d = new ArrayMap();
        this.f17376b = context;
        this.f17375a = context.getSharedPreferences("com.google.android.gms.appid", 0);
        this.f17377c = o;
        File file = new File(ContextCompat.getNoBackupFilesDir(this.f17376b), "com.google.android.gms.appid-no-backup");
        if (file.exists()) {
            return;
        }
        try {
            if (!file.createNewFile() || c()) {
                return;
            }
            Log.i("FirebaseInstanceId", "App restored, clearing state");
            b();
            FirebaseInstanceId.b().i();
        } catch (IOException e2) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf = String.valueOf(e2.getMessage());
                Log.d("FirebaseInstanceId", valueOf.length() != 0 ? "Error creating file in no backup dir: ".concat(valueOf) : new String("Error creating file in no backup dir: "));
            }
        }
    }

    public final synchronized void a(String str) {
        this.f17375a.edit().putString("topic_operaion_queue", str).apply();
    }

    public final synchronized void b() {
        this.f17378d.clear();
        O.a(this.f17376b);
        this.f17375a.edit().clear().commit();
    }

    public final synchronized void c(String str) {
        String concat = String.valueOf(str).concat("|T|");
        SharedPreferences.Editor edit = this.f17375a.edit();
        for (String str2 : this.f17375a.getAll().keySet()) {
            if (str2.startsWith(concat)) {
                edit.remove(str2);
            }
        }
        edit.commit();
    }

    public static String a(String str, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 3 + String.valueOf(str2).length());
        sb.append(str);
        sb.append("|S|");
        sb.append(str2);
        return sb.toString();
    }

    public final synchronized s a(String str, String str2, String str3) {
        return s.a(this.f17375a.getString(b(str, str2, str3), null));
    }

    public final synchronized void a(String str, String str2, String str3, String str4, String str5) {
        String a2 = s.a(str4, str5, System.currentTimeMillis());
        if (a2 == null) {
            return;
        }
        SharedPreferences.Editor edit = this.f17375a.edit();
        edit.putString(b(str, str2, str3), a2);
        edit.commit();
    }

    public final synchronized P b(String str) {
        P b2;
        P p = this.f17378d.get(str);
        if (p != null) {
            return p;
        }
        try {
            b2 = this.f17377c.a(this.f17376b, str);
        } catch (zzaa unused) {
            Log.w("FirebaseInstanceId", "Stored data is corrupt, generating new identity");
            FirebaseInstanceId.b().i();
            b2 = this.f17377c.b(this.f17376b, str);
        }
        this.f17378d.put(str, b2);
        return b2;
    }
}
