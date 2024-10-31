package com.umeng.commonsdk.statistics;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.commonsdk.statistics.common.d;

/* compiled from: AnalyticsConfig.java */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a */
    public static String f26350a = "native";

    /* renamed from: b */
    public static String f26351b = "";

    /* renamed from: c */
    public static int f26352c;

    /* renamed from: d */
    private static String f26353d;

    public static String a(Context context) {
        if (TextUtils.isEmpty(f26353d)) {
            f26353d = d.a(context).b();
        }
        return f26353d;
    }
}
