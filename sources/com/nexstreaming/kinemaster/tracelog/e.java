package com.nexstreaming.kinemaster.tracelog;

import android.content.Context;
import android.preference.PreferenceManager;
import android.util.Log;
import com.mixpanel.android.mpmetrics.ae;
import com.mixpanel.android.mpmetrics.n;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* compiled from: MixPanelABTest.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static ae<Boolean> f3645a;
    private static ae<Boolean> b;
    private static ae<Boolean> c;
    private static ae<Integer> d;

    public static void a(Context context) {
        f3645a = n.a("Show First Product", true);
        b = n.a("Show Second Product", true);
        c = n.a("Show Third Product", true);
        d = n.a("Export duration Limit", 0);
        b(context);
    }

    public static boolean a() {
        return f3645a.a().booleanValue();
    }

    public static boolean b() {
        return b.a().booleanValue();
    }

    public static boolean c() {
        return c.a().booleanValue();
    }

    public static int d() {
        return d.a().intValue();
    }

    public static int e() {
        return d.a().intValue() * LicenseErrCode.LICENSE_STATUS_NOT_LICENSED;
    }

    public static boolean b(Context context) {
        boolean z;
        boolean z2 = PreferenceManager.getDefaultSharedPreferences(context).getBoolean("new_user", false);
        boolean exists = EditorGlobal.d(context).exists();
        Log.i("MixPanelABTest", "export exists : " + exists);
        if (z2 || exists) {
            z = z2;
        } else {
            z = exists ? false : true;
            PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("new_user", true).apply();
        }
        Log.i("MixPanelABTest", "isNewUser() returned: " + z);
        return z;
    }

    public static boolean c(Context context) {
        boolean z = b(context) && d() > 0;
        Log.i("MixPanelABTest", "isEnableLimitNewUser() returned: " + z);
        return z;
    }
}
