package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;

/* compiled from: SPHelper.java */
/* loaded from: classes3.dex */
public final class z {

    /* renamed from: a */
    private static z f25979a = null;

    /* renamed from: b */
    private static Context f25980b = null;

    /* renamed from: c */
    private static String f25981c = null;

    /* renamed from: d */
    private static final String f25982d = "mobclick_agent_user_";

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SPHelper.java */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a */
        private static final z f25983a = new z();

        private a() {
        }
    }

    public static synchronized z a(Context context) {
        z zVar;
        synchronized (z.class) {
            if (f25980b == null && context != null) {
                f25980b = context.getApplicationContext();
            }
            if (f25980b != null) {
                f25981c = context.getPackageName();
            }
            zVar = a.f25983a;
        }
        return zVar;
    }

    private SharedPreferences e() {
        Context context = f25980b;
        if (context == null) {
            return null;
        }
        return context.getSharedPreferences(f25982d + f25981c, 0);
    }

    public void b() {
        SharedPreferences e2 = e();
        if (e2 != null) {
            e2.edit().remove("au_p").remove("au_u").commit();
        }
    }

    public String c() {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f25980b);
        if (sharedPreferences != null) {
            return sharedPreferences.getString("st", null);
        }
        return null;
    }

    public int d() {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f25980b);
        if (sharedPreferences != null) {
            return sharedPreferences.getInt("vt", 0);
        }
        return 0;
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        SharedPreferences.Editor edit = e().edit();
        edit.putString("au_p", str);
        edit.putString("au_u", str2);
        edit.commit();
    }

    public String[] a() {
        SharedPreferences e2 = e();
        if (e2 == null) {
            return null;
        }
        String string = e2.getString("au_p", null);
        String string2 = e2.getString("au_u", null);
        if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
            return null;
        }
        return new String[]{string, string2};
    }

    public void a(String str) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f25980b);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("st", str).commit();
        }
    }

    public void a(int i) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f25980b);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt("vt", i).commit();
        }
    }
}
