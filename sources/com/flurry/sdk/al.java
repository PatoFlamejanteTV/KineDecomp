package com.flurry.sdk;

import android.text.TextUtils;

/* loaded from: classes.dex */
public class al {

    /* renamed from: a, reason: collision with root package name */
    private static final String f459a = al.class.getSimpleName();
    private static String b;
    private static String c;

    public static void a(String str) {
        b = str;
    }

    public static String a() {
        if (!TextUtils.isEmpty(b)) {
            return b;
        }
        if (!TextUtils.isEmpty(c)) {
            return c;
        }
        c = b();
        return c;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001b, code lost:            r0 = com.facebook.internal.AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String b() {
        /*
            com.flurry.sdk.ad r0 = com.flurry.sdk.ad.a()     // Catch: java.lang.Throwable -> L27
            android.content.Context r0 = r0.b()     // Catch: java.lang.Throwable -> L27
            android.content.pm.PackageManager r1 = r0.getPackageManager()     // Catch: java.lang.Throwable -> L27
            java.lang.String r0 = r0.getPackageName()     // Catch: java.lang.Throwable -> L27
            r2 = 0
            android.content.pm.PackageInfo r0 = r1.getPackageInfo(r0, r2)     // Catch: java.lang.Throwable -> L27
            java.lang.String r1 = r0.versionName     // Catch: java.lang.Throwable -> L27
            if (r1 == 0) goto L1c
            java.lang.String r0 = r0.versionName     // Catch: java.lang.Throwable -> L27
        L1b:
            return r0
        L1c:
            int r1 = r0.versionCode     // Catch: java.lang.Throwable -> L27
            if (r1 == 0) goto L30
            int r0 = r0.versionCode     // Catch: java.lang.Throwable -> L27
            java.lang.String r0 = java.lang.Integer.toString(r0)     // Catch: java.lang.Throwable -> L27
            goto L1b
        L27:
            r0 = move-exception
            r1 = 6
            java.lang.String r2 = com.flurry.sdk.al.f459a
            java.lang.String r3 = ""
            com.flurry.sdk.as.a(r1, r2, r3, r0)
        L30:
            java.lang.String r0 = "Unknown"
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flurry.sdk.al.b():java.lang.String");
    }
}
