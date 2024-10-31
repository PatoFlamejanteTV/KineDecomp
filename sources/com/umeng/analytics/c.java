package com.umeng.analytics;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.z;

/* compiled from: InternalConfig.java */
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a */
    private static String[] f25790a = new String[2];

    public static void a(Context context, String str, String str2) {
        String[] strArr = f25790a;
        strArr[0] = str;
        strArr[1] = str2;
        if (context != null) {
            z.a(context).a(str, str2);
        }
    }

    public static void b(Context context) {
        String[] strArr = f25790a;
        strArr[0] = null;
        strArr[1] = null;
        if (context != null) {
            z.a(context).b();
        }
    }

    public static String[] a(Context context) {
        String[] a2;
        if (!TextUtils.isEmpty(f25790a[0]) && !TextUtils.isEmpty(f25790a[1])) {
            return f25790a;
        }
        if (context == null || (a2 = z.a(context).a()) == null) {
            return null;
        }
        String[] strArr = f25790a;
        strArr[0] = a2[0];
        strArr[1] = a2[1];
        return strArr;
    }
}
