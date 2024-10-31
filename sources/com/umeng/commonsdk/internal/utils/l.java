package com.umeng.commonsdk.internal.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.ULog;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.json.JSONObject;

/* compiled from: UMProbe.java */
/* loaded from: classes3.dex */
public class l {

    /* renamed from: a */
    public static final String f26135a = "UM_PROBE_DATA";

    /* renamed from: b */
    public static final String f26136b = "_dsk_s";

    /* renamed from: c */
    public static final String f26137c = "_thm_z";

    /* renamed from: d */
    public static final String f26138d = "_gdf_r";

    /* renamed from: e */
    private static Object f26139e = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UMProbe.java */
    /* renamed from: com.umeng.commonsdk.internal.utils.l$1 */
    /* loaded from: classes3.dex */
    public static class AnonymousClass1 extends Thread {

        /* renamed from: a */
        final /* synthetic */ String[] f26140a;

        /* renamed from: b */
        final /* synthetic */ Context f26141b;

        AnonymousClass1(String[] strArr, Context context) {
            strArr = strArr;
            context = context;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            try {
                strArr[0] = l.c();
                strArr[1] = l.a();
                strArr[2] = l.b();
                ULog.i("diskType = " + strArr[0] + "; ThremalZone = " + strArr[1] + "; GoldFishRc = " + strArr[2]);
                l.b(context, strArr);
            } catch (Throwable th) {
                UMCrashManager.reportCrash(context, th);
            }
        }
    }

    public static void b(Context context) {
        if (c(context)) {
            return;
        }
        new Thread() { // from class: com.umeng.commonsdk.internal.utils.l.1

            /* renamed from: a */
            final /* synthetic */ String[] f26140a;

            /* renamed from: b */
            final /* synthetic */ Context f26141b;

            AnonymousClass1(String[] strArr, Context context2) {
                strArr = strArr;
                context = context2;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                super.run();
                try {
                    strArr[0] = l.c();
                    strArr[1] = l.a();
                    strArr[2] = l.b();
                    ULog.i("diskType = " + strArr[0] + "; ThremalZone = " + strArr[1] + "; GoldFishRc = " + strArr[2]);
                    l.b(context, strArr);
                } catch (Throwable th) {
                    UMCrashManager.reportCrash(context, th);
                }
            }
        }.start();
    }

    public static boolean c(Context context) {
        SharedPreferences sharedPreferences;
        return (context == null || (sharedPreferences = context.getApplicationContext().getSharedPreferences(f26135a, 0)) == null || TextUtils.isEmpty(sharedPreferences.getString(f26136b, ""))) ? false : true;
    }

    public static String a(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(f26135a, 0);
            if (sharedPreferences == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            synchronized (f26139e) {
                jSONObject.put(f26136b, sharedPreferences.getString(f26136b, ""));
                jSONObject.put(f26137c, sharedPreferences.getString(f26137c, ""));
                jSONObject.put(f26138d, sharedPreferences.getString(f26138d, ""));
            }
            return jSONObject.toString();
        } catch (Exception e2) {
            UMCrashManager.reportCrash(context, e2);
            return null;
        }
    }

    public static void b(Context context, String[] strArr) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getApplicationContext().getSharedPreferences(f26135a, 0)) == null) {
            return;
        }
        synchronized (f26139e) {
            sharedPreferences.edit().putString(f26136b, strArr[0]).putString(f26137c, strArr[1]).putString(f26138d, strArr[2]).commit();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0038 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String c() {
        /*
            r0 = 0
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L33
            java.io.FileReader r2 = new java.io.FileReader     // Catch: java.lang.Throwable -> L33
            java.lang.String r3 = "/proc/diskstats"
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L33
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L33
        Ld:
            java.lang.String r0 = r1.readLine()     // Catch: java.lang.Throwable -> L34
            java.lang.String r2 = "mtd"
            java.lang.String r3 = "sda"
            java.lang.String r4 = "mmcblk"
            if (r0 == 0) goto L30
            boolean r5 = r0.contains(r4)     // Catch: java.lang.Throwable -> L34
            if (r5 == 0) goto L21
            r2 = r4
            goto L36
        L21:
            boolean r4 = r0.contains(r3)     // Catch: java.lang.Throwable -> L34
            if (r4 == 0) goto L29
            r2 = r3
            goto L36
        L29:
            boolean r0 = r0.contains(r2)     // Catch: java.lang.Throwable -> L34
            if (r0 == 0) goto Ld
            goto L36
        L30:
            java.lang.String r2 = "unknown"
            goto L36
        L33:
            r1 = r0
        L34:
            java.lang.String r2 = "noper"
        L36:
            if (r1 == 0) goto L3b
            r1.close()     // Catch: java.lang.Throwable -> L3b
        L3b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.internal.utils.l.c():java.lang.String");
    }

    public static String b() {
        int i;
        try {
            i = a("ls /", "goldfish");
        } catch (Throwable unused) {
            i = -1;
        }
        return i > 0 ? "goldfish" : i < 0 ? "noper" : "unknown";
    }

    public static int a(String str, String str2) throws IOException {
        int i;
        Process exec = Runtime.getRuntime().exec(str);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                i = -1;
                break;
            }
            if (readLine.contains(str2)) {
                i = 1;
                break;
            }
        }
        try {
            if (exec.waitFor() != 0) {
                return -1;
            }
            return i;
        } catch (InterruptedException unused) {
            return -1;
        }
    }

    public static String a() {
        int i;
        try {
            i = a("ls /sys/class/thermal", "thermal_zone");
        } catch (Throwable unused) {
            i = -1;
        }
        return i > 0 ? "thermal_zone" : i < 0 ? "noper" : "unknown";
    }
}
