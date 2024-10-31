package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class zzax {

    /* renamed from: a, reason: collision with root package name */
    static Map<String, String> f2231a = new HashMap();
    private static String b;

    public static String a(String str, String str2) {
        if (str2 != null) {
            return Uri.parse("http://hostname/?" + str).getQueryParameter(str2);
        }
        if (str.length() > 0) {
            return str;
        }
        return null;
    }

    public static void a(Context context, String str) {
        String a2 = a(str, "conv");
        if (a2 == null || a2.length() <= 0) {
            return;
        }
        f2231a.put(a2, str);
        ah.a(context, "gtm_click_referrers", a2, str);
    }

    public static void a(String str) {
        synchronized (zzax.class) {
            b = str;
        }
    }
}
