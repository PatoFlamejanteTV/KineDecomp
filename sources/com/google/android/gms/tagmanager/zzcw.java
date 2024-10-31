package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashMap;
import java.util.Map;

@ShowFirstParty
@VisibleForTesting
/* loaded from: classes2.dex */
public class zzcw {

    /* renamed from: a */
    private static String f14233a;

    /* renamed from: b */
    @VisibleForTesting
    static Map<String, String> f14234b = new HashMap();

    public static void a(String str) {
        synchronized (zzcw.class) {
            f14233a = str;
        }
    }

    public static void b(Context context, String str) {
        String a2 = a(str, "conv");
        if (a2 == null || a2.length() <= 0) {
            return;
        }
        f14234b.put(a2, str);
        x.a(context, "gtm_click_referrers", a2, str);
    }

    public static void a(Context context, String str) {
        x.a(context, "gtm_install_referrer", "referrer", str);
        b(context, str);
    }

    public static String a(String str, String str2) {
        if (str2 == null) {
            if (str.length() > 0) {
                return str;
            }
            return null;
        }
        String valueOf = String.valueOf(str);
        return Uri.parse(valueOf.length() != 0 ? "http://hostname/?".concat(valueOf) : new String("http://hostname/?")).getQueryParameter(str2);
    }
}
