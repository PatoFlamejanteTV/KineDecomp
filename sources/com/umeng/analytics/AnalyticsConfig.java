package com.umeng.analytics;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.pro.h;
import com.umeng.analytics.pro.z;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.utils.UMUtils;

/* loaded from: classes3.dex */
public class AnalyticsConfig {
    public static String GPU_RENDERER = "";
    public static String GPU_VENDER = "";

    /* renamed from: b */
    private static String f25762b;

    /* renamed from: c */
    private static String f25763c;

    /* renamed from: d */
    private static String f25764d;

    /* renamed from: e */
    private static int f25765e;
    public static String mWrapperType;
    public static String mWrapperVersion;
    public static MobclickAgent.PageMode AUTO_ACTIVITY_PAGE_COLLECTION = MobclickAgent.PageMode.LEGACY_AUTO;
    public static boolean CHANGE_CATCH_EXCEPTION_NOTALLOW = false;
    public static boolean CATCH_EXCEPTION = true;
    public static long kContinueSessionMillis = com.umeng.commonsdk.proguard.c.f26227d;
    public static boolean CLEAR_EKV_BL = false;
    public static boolean CLEAR_EKV_WL = false;

    /* renamed from: a */
    static double[] f25761a = null;

    static void a(String str) {
        f25763c = str;
    }

    public static String getAppkey(Context context) {
        return UMUtils.getAppkey(context);
    }

    public static String getChannel(Context context) {
        return UMUtils.getChannel(context);
    }

    public static double[] getLocation() {
        return f25761a;
    }

    public static String getSecretKey(Context context) {
        if (TextUtils.isEmpty(f25764d)) {
            f25764d = z.a(context).c();
        }
        return f25764d;
    }

    public static int getVerticalType(Context context) {
        if (f25765e == 0) {
            f25765e = z.a(context).d();
        }
        return f25765e;
    }

    public static void a(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            f25764d = str;
            z.a(context).a(f25764d);
        } else {
            UMLog.aq(h.A, 0, "\\|");
        }
    }

    public static void a(Context context, int i) {
        f25765e = i;
        z.a(context).a(f25765e);
    }
}
