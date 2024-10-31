package com.umeng.commonsdk.statistics.internal;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.proguard.e;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.utils.UMUtils;

/* compiled from: HeaderHelper.java */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a */
    private static Context f26454a;

    /* renamed from: b */
    private String f26455b;

    /* renamed from: c */
    private String f26456c;

    /* compiled from: HeaderHelper.java */
    /* renamed from: com.umeng.commonsdk.statistics.internal.a$a */
    /* loaded from: classes3.dex */
    public static class C0145a {

        /* renamed from: a */
        private static final a f26457a = new a();

        private C0145a() {
        }
    }

    /* synthetic */ a(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static a a(Context context) {
        if (f26454a == null && context != null) {
            f26454a = context.getApplicationContext();
        }
        return C0145a.f26457a;
    }

    private void d(String str) {
        try {
            this.f26455b = str.replaceAll("&=", " ").replaceAll("&&", " ").replaceAll("==", "/") + "/Android/" + Build.DISPLAY + "/" + Build.MODEL + "/" + Build.VERSION.RELEASE + " " + HelperUtils.getUmengMD5(UMUtils.getAppkey(f26454a));
        } catch (Throwable th) {
            UMCrashManager.reportCrash(f26454a, th);
        }
    }

    private void e(String str) {
        try {
            String str2 = str.split("&&")[0];
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            String[] split = str2.split("&=");
            StringBuilder sb = new StringBuilder();
            sb.append(e.ax);
            for (String str3 : split) {
                if (!TextUtils.isEmpty(str3)) {
                    String substring = str3.substring(0, 2);
                    if (substring.endsWith("=")) {
                        substring = substring.replace("=", "");
                    }
                    sb.append(substring);
                }
            }
            this.f26456c = sb.toString();
        } catch (Throwable th) {
            UMCrashManager.reportCrash(f26454a, th);
        }
    }

    public boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(e.ar);
    }

    public void c(String str) {
        String substring = str.substring(0, str.indexOf(95));
        e(substring);
        d(substring);
    }

    private a() {
        this.f26455b = null;
        this.f26456c = null;
    }

    public String b() {
        return this.f26455b;
    }

    public boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(e.al);
    }

    public String a() {
        return this.f26456c;
    }
}
