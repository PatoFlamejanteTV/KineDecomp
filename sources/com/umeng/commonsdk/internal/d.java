package com.umeng.commonsdk.internal;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.wifi.ScanResult;
import android.os.Build;
import android.support.v7.widget.ActivityChooserView;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.inputmethod.InputMethodInfo;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.framework.UMModuleRegister;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.internal.utils.a;
import com.umeng.commonsdk.internal.utils.d;
import com.umeng.commonsdk.internal.utils.j;
import com.umeng.commonsdk.internal.utils.k;
import com.umeng.commonsdk.internal.utils.l;
import com.umeng.commonsdk.proguard.e;
import com.umeng.commonsdk.proguard.s;
import com.umeng.commonsdk.stateless.UMSLEnvelopeBuild;
import com.umeng.commonsdk.stateless.f;
import com.umeng.commonsdk.statistics.common.ULog;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: UMInternalManager.java */
/* loaded from: classes3.dex */
public class d {
    public static void a(Context context) {
        try {
            ULog.i("walle", "[internal] workEvent send envelope");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(e.aw, a.f26053d);
            JSONObject buildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(context, jSONObject, e(context));
            if (buildEnvelopeWithExtHeader == null || buildEnvelopeWithExtHeader.has("exception")) {
                return;
            }
            ULog.i("walle", "[internal] workEvent send envelope back, result is ok");
            com.umeng.commonsdk.internal.utils.a.f(context);
            j.d(context);
            com.umeng.commonsdk.proguard.c.c(context);
        } catch (Exception e2) {
            UMCrashManager.reportCrash(context, e2);
        }
    }

    public static void b(Context context) {
        ULog.i("walle", "[internal] begin by stateful--->>>");
        if (context != null) {
            try {
                if (UMEnvelopeBuild.isReadyBuild(context, UMLogDataProtocol.UMBusinessType.U_INTERNAL)) {
                    UMWorkDispatch.sendEvent(context, a.f26054e, b.a(context).a(), null);
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(context, th);
            }
        }
    }

    public static void c(Context context) {
        if (context != null) {
            try {
                ULog.i("walle", "[internal] begin by not stateful--->>>");
                context = context.getApplicationContext();
                f.a(context, context.getFilesDir() + "/" + com.umeng.commonsdk.stateless.a.f26307e + "/" + Base64.encodeToString(a.f26050a.getBytes(), 0), 10);
                UMSLEnvelopeBuild uMSLEnvelopeBuild = new UMSLEnvelopeBuild();
                JSONObject buildSLBaseHeader = uMSLEnvelopeBuild.buildSLBaseHeader(context);
                if (buildSLBaseHeader != null && buildSLBaseHeader.has("header")) {
                    try {
                        JSONObject jSONObject = (JSONObject) buildSLBaseHeader.opt("header");
                        if (jSONObject != null) {
                            jSONObject.put(e.aw, a.f26053d);
                        }
                    } catch (Exception unused) {
                    }
                }
                ULog.i("walle", "[internal] header is " + buildSLBaseHeader.toString());
                JSONObject d2 = d(context);
                ULog.i("walle", "[internal] body is " + d2.toString());
                ULog.i("walle", uMSLEnvelopeBuild.buildSLEnvelope(context, buildSLBaseHeader, d2, a.f26050a).toString());
            } catch (Throwable th) {
                UMCrashManager.reportCrash(context, th);
            }
        }
    }

    public static JSONObject d(Context context) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            try {
                try {
                    JSONArray p = p(applicationContext);
                    if (p != null && p.length() > 0) {
                        jSONObject2.put("run_server", p);
                    }
                } catch (Exception e2) {
                    UMCrashManager.reportCrash(applicationContext, e2);
                }
                try {
                    String k = com.umeng.commonsdk.internal.utils.a.k(applicationContext);
                    if (!TextUtils.isEmpty(k)) {
                        jSONObject2.put("imsi", k);
                    }
                } catch (Exception e3) {
                    UMCrashManager.reportCrash(applicationContext, e3);
                }
                try {
                    String l = com.umeng.commonsdk.internal.utils.a.l(applicationContext);
                    if (!TextUtils.isEmpty(l)) {
                        jSONObject2.put("meid", l);
                    }
                } catch (Exception e4) {
                    UMCrashManager.reportCrash(applicationContext, e4);
                }
                try {
                    jSONObject.put(UMModuleRegister.INNER, jSONObject2);
                } catch (JSONException e5) {
                    UMCrashManager.reportCrash(applicationContext, e5);
                }
            } catch (Exception unused) {
            }
        }
        return jSONObject;
    }

    public static JSONObject e(Context context) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            try {
                JSONArray p = p(applicationContext);
                if (p != null && p.length() > 0) {
                    jSONObject2.put("rs", p);
                }
            } catch (Exception e2) {
                UMCrashManager.reportCrash(applicationContext, e2);
            }
            try {
                JSONArray q = q(applicationContext);
                if (q != null && q.length() > 0) {
                    jSONObject2.put("bstn", q);
                }
            } catch (Exception e3) {
                UMCrashManager.reportCrash(applicationContext, e3);
            }
            try {
                JSONArray r = r(applicationContext);
                if (r != null && r.length() > 0) {
                    jSONObject2.put("by", r);
                }
            } catch (Exception e4) {
                UMCrashManager.reportCrash(applicationContext, e4);
            }
            try {
                a(applicationContext, jSONObject2);
            } catch (Exception e5) {
                UMCrashManager.reportCrash(applicationContext, e5);
            }
            try {
                b(applicationContext, jSONObject2);
            } catch (Exception e6) {
                UMCrashManager.reportCrash(applicationContext, e6);
            }
            try {
                JSONObject a2 = a();
                if (a2 != null && a2.length() > 0) {
                    jSONObject2.put("sd", a2);
                }
            } catch (Exception e7) {
                UMCrashManager.reportCrash(applicationContext, e7);
            }
            try {
                JSONObject b2 = b();
                if (b2 != null && b2.length() > 0) {
                    jSONObject2.put("build", b2);
                }
            } catch (Exception e8) {
                UMCrashManager.reportCrash(applicationContext, e8);
            }
            try {
                JSONObject jSONObject3 = new JSONObject();
                JSONArray g2 = g(applicationContext);
                if (g2 != null && g2.length() > 0) {
                    try {
                        jSONObject3.put("a_sr", g2);
                    } catch (JSONException unused) {
                    }
                }
                JSONArray c2 = j.c(applicationContext);
                if (c2 != null && c2.length() > 0) {
                    try {
                        jSONObject3.put("stat", c2);
                    } catch (JSONException unused2) {
                    }
                }
                jSONObject2.put("sr", jSONObject3);
            } catch (Exception e9) {
                UMCrashManager.reportCrash(applicationContext, e9);
            }
            try {
                JSONObject h2 = h(applicationContext);
                if (h2 != null && h2.length() > 0) {
                    jSONObject2.put("scr", h2);
                }
            } catch (Exception e10) {
                UMCrashManager.reportCrash(applicationContext, e10);
            }
            try {
                JSONObject i = i(applicationContext);
                if (i != null && i.length() > 0) {
                    jSONObject2.put("sinfo", i);
                }
            } catch (Exception e11) {
                UMCrashManager.reportCrash(applicationContext, e11);
            }
            try {
                JSONObject jSONObject4 = new JSONObject();
                JSONArray e12 = com.umeng.commonsdk.internal.utils.a.e(applicationContext);
                if (e12 != null && e12.length() > 0) {
                    try {
                        jSONObject4.put("wl", e12);
                    } catch (JSONException unused3) {
                    }
                }
                JSONArray j = j(applicationContext);
                if (j != null && j.length() > 0) {
                    try {
                        jSONObject4.put("a_wls", j);
                    } catch (JSONException unused4) {
                    }
                }
                jSONObject2.put("winfo", jSONObject4);
            } catch (Exception e13) {
                UMCrashManager.reportCrash(applicationContext, e13);
            }
            try {
                JSONArray k = k(applicationContext);
                if (k != null && k.length() > 0) {
                    jSONObject2.put("input", k);
                }
            } catch (Exception e14) {
                UMCrashManager.reportCrash(applicationContext, e14);
            }
            try {
                JSONObject o = com.umeng.commonsdk.internal.utils.a.o(applicationContext);
                if (o != null && o.length() > 0) {
                    jSONObject2.put("bt", o);
                }
            } catch (Exception e15) {
                UMCrashManager.reportCrash(applicationContext, e15);
            }
            try {
                JSONArray l = l(applicationContext);
                if (l != null && l.length() > 0) {
                    jSONObject2.put("cam", l);
                }
            } catch (Exception e16) {
                UMCrashManager.reportCrash(applicationContext, e16);
            }
            try {
                JSONArray m = m(applicationContext);
                if (m != null && m.length() > 0) {
                    jSONObject2.put("appls", m);
                }
            } catch (Exception e17) {
                UMCrashManager.reportCrash(applicationContext, e17);
            }
            try {
                JSONObject n = n(applicationContext);
                if (n != null && n.length() > 0) {
                    jSONObject2.put("mem", n);
                }
            } catch (Exception e18) {
                UMCrashManager.reportCrash(applicationContext, e18);
            }
            try {
                JSONArray o2 = o(applicationContext);
                if (o2 != null && o2.length() > 0) {
                    jSONObject2.put("lbs", o2);
                }
            } catch (Exception e19) {
                UMCrashManager.reportCrash(applicationContext, e19);
            }
            try {
                JSONObject d2 = d();
                if (d2 != null && d2.length() > 0) {
                    jSONObject2.put(e.v, d2);
                }
            } catch (Exception unused5) {
            }
            try {
                JSONObject c3 = c();
                if (c3 != null && c3.length() > 0) {
                    jSONObject2.put("rom", c3);
                }
            } catch (Exception unused6) {
            }
            try {
                jSONObject.put(e.ak, jSONObject2);
            } catch (JSONException e20) {
                UMCrashManager.reportCrash(applicationContext, e20);
            }
        }
        return jSONObject;
    }

    public static String f(Context context) {
        try {
            com.umeng.commonsdk.statistics.idtracking.e a2 = com.umeng.commonsdk.statistics.idtracking.e.a(context);
            if (a2 == null) {
                return null;
            }
            a2.a();
            String encodeToString = Base64.encodeToString(new s().a(a2.b()), 0);
            if (TextUtils.isEmpty(encodeToString)) {
                return null;
            }
            return encodeToString;
        } catch (Exception e2) {
            UMCrashManager.reportCrash(context, e2);
            return null;
        }
    }

    public static JSONArray g(Context context) {
        if (context != null) {
            return k.g(context.getApplicationContext());
        }
        return null;
    }

    public static JSONObject h(Context context) {
        DisplayMetrics displayMetrics;
        JSONObject jSONObject = new JSONObject();
        if (context != null) {
            try {
                jSONObject.put("a_st_h", com.umeng.commonsdk.internal.utils.a.h(context));
                jSONObject.put("a_nav_h", com.umeng.commonsdk.internal.utils.a.i(context));
                if (context.getResources() != null && (displayMetrics = context.getResources().getDisplayMetrics()) != null) {
                    jSONObject.put("a_den", displayMetrics.density);
                    jSONObject.put("a_dpi", displayMetrics.densityDpi);
                }
            } catch (Exception e2) {
                UMCrashManager.reportCrash(context, e2);
            }
        }
        return jSONObject;
    }

    public static JSONObject i(Context context) {
        JSONObject jSONObject = new JSONObject();
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            String packageName = applicationContext.getPackageName();
            try {
                jSONObject.put("a_fit", com.umeng.commonsdk.internal.utils.a.a(applicationContext, packageName));
                jSONObject.put("a_alut", com.umeng.commonsdk.internal.utils.a.b(applicationContext, packageName));
                jSONObject.put("a_c", com.umeng.commonsdk.internal.utils.a.c(applicationContext, packageName));
                jSONObject.put("a_uid", com.umeng.commonsdk.internal.utils.a.d(applicationContext, packageName));
                if (com.umeng.commonsdk.internal.utils.a.a()) {
                    jSONObject.put("a_root", 1);
                } else {
                    jSONObject.put("a_root", 0);
                }
                jSONObject.put("tf", com.umeng.commonsdk.internal.utils.a.b());
                jSONObject.put("s_fs", com.umeng.commonsdk.internal.utils.a.a(applicationContext));
                jSONObject.put("a_meid", com.umeng.commonsdk.internal.utils.a.l(applicationContext));
                jSONObject.put("a_imsi", com.umeng.commonsdk.internal.utils.a.k(applicationContext));
                jSONObject.put("st", com.umeng.commonsdk.internal.utils.a.f());
                String b2 = k.b(applicationContext);
                if (!TextUtils.isEmpty(b2)) {
                    try {
                        jSONObject.put("a_iccid", b2);
                    } catch (Exception unused) {
                    }
                }
                String c2 = k.c(applicationContext);
                if (!TextUtils.isEmpty(c2)) {
                    try {
                        jSONObject.put("a_simei", c2);
                    } catch (Exception unused2) {
                    }
                }
                jSONObject.put("hn", com.umeng.commonsdk.internal.utils.a.g());
                jSONObject.put("ts", System.currentTimeMillis());
            } catch (Exception e2) {
                UMCrashManager.reportCrash(applicationContext, e2);
            }
        }
        return jSONObject;
    }

    public static JSONArray j(Context context) {
        Context applicationContext;
        List<ScanResult> b2;
        JSONArray jSONArray = new JSONArray();
        if (context != null && (b2 = com.umeng.commonsdk.internal.utils.a.b((applicationContext = context.getApplicationContext()))) != null && b2.size() > 0) {
            for (ScanResult scanResult : b2) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("a_bssid", scanResult.BSSID);
                    jSONObject.put("a_ssid", scanResult.SSID);
                    jSONObject.put("a_cap", scanResult.capabilities);
                    jSONObject.put("a_fcy", scanResult.frequency);
                    jSONObject.put("ts", System.currentTimeMillis());
                    if (Build.VERSION.SDK_INT >= 23) {
                        jSONObject.put("a_c0", scanResult.centerFreq0);
                        jSONObject.put("a_c1", scanResult.centerFreq1);
                        jSONObject.put("a_cw", scanResult.channelWidth);
                        if (scanResult.is80211mcResponder()) {
                            jSONObject.put("a_is80211", 1);
                        } else {
                            jSONObject.put("a_is80211", 0);
                        }
                        if (scanResult.isPasspointNetwork()) {
                            jSONObject.put("a_isppn", 1);
                        } else {
                            jSONObject.put("a_isppn", 0);
                        }
                        jSONObject.put("a_ofn", scanResult.operatorFriendlyName);
                        jSONObject.put("a_vn", scanResult.venueName);
                    }
                    jSONObject.put("a_dc", scanResult.describeContents());
                    jSONArray.put(jSONObject);
                } catch (Exception e2) {
                    UMCrashManager.reportCrash(applicationContext, e2);
                }
            }
        }
        return jSONArray;
    }

    public static JSONArray k(Context context) {
        Context applicationContext;
        List<InputMethodInfo> m;
        JSONArray jSONArray = new JSONArray();
        if (context != null && (m = com.umeng.commonsdk.internal.utils.a.m((applicationContext = context.getApplicationContext()))) != null) {
            for (InputMethodInfo inputMethodInfo : m) {
                try {
                    CharSequence loadLabel = inputMethodInfo.loadLabel(applicationContext.getPackageManager());
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("a_la", loadLabel);
                    jSONObject.put("a_pn", inputMethodInfo.getPackageName());
                    jSONObject.put("ts", System.currentTimeMillis());
                    jSONArray.put(jSONObject);
                } catch (Exception e2) {
                    UMCrashManager.reportCrash(applicationContext, e2);
                }
            }
        }
        return jSONArray;
    }

    public static JSONArray l(Context context) {
        Context applicationContext;
        List<j.a> e2;
        JSONArray jSONArray = new JSONArray();
        if (context != null && (e2 = j.e((applicationContext = context.getApplicationContext()))) != null && !e2.isEmpty()) {
            for (j.a aVar : e2) {
                if (aVar != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("a_w", aVar.f26129a);
                        jSONObject.put("a_h", aVar.f26130b);
                        jSONObject.put("ts", System.currentTimeMillis());
                        jSONArray.put(jSONObject);
                    } catch (Exception e3) {
                        UMCrashManager.reportCrash(applicationContext, e3);
                    }
                }
            }
        }
        return jSONArray;
    }

    public static JSONArray m(Context context) {
        Context applicationContext;
        List<a.C0141a> p;
        JSONArray jSONArray = new JSONArray();
        if (context != null && (p = com.umeng.commonsdk.internal.utils.a.p((applicationContext = context.getApplicationContext()))) != null && !p.isEmpty()) {
            for (a.C0141a c0141a : p) {
                if (c0141a != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("a_pn", c0141a.f26066a);
                        jSONObject.put("a_la", c0141a.f26067b);
                        jSONObject.put("ts", System.currentTimeMillis());
                        jSONArray.put(jSONObject);
                    } catch (Exception e2) {
                        UMCrashManager.reportCrash(applicationContext, e2);
                    }
                }
            }
        }
        return jSONArray;
    }

    public static JSONObject n(Context context) {
        Context applicationContext;
        ActivityManager.MemoryInfo q;
        JSONObject jSONObject = new JSONObject();
        if (context != null && (q = com.umeng.commonsdk.internal.utils.a.q((applicationContext = context.getApplicationContext()))) != null) {
            try {
                if (Build.VERSION.SDK_INT >= 16) {
                    jSONObject.put(e.ar, q.totalMem);
                }
                jSONObject.put("f", q.availMem);
                jSONObject.put("ts", System.currentTimeMillis());
            } catch (Exception e2) {
                UMCrashManager.reportCrash(applicationContext, e2);
            }
        }
        return jSONObject;
    }

    private static JSONArray o(Context context) {
        if (context != null) {
            return com.umeng.commonsdk.proguard.c.b(context.getApplicationContext());
        }
        return null;
    }

    private static JSONArray p(Context context) {
        List<ActivityManager.RunningServiceInfo> runningServices;
        JSONArray jSONArray = null;
        if (context == null) {
            return null;
        }
        try {
            ActivityManager activityManager = (ActivityManager) context.getApplicationContext().getSystemService("activity");
            if (activityManager == null || (runningServices = activityManager.getRunningServices(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED)) == null || runningServices.isEmpty()) {
                return null;
            }
            for (int i = 0; i < runningServices.size(); i++) {
                if (runningServices.get(i) != null && runningServices.get(i).service != null && runningServices.get(i).service.getClassName() != null && runningServices.get(i).service.getPackageName() != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("sn", runningServices.get(i).service.getClassName().toString());
                        jSONObject.put(com.umeng.analytics.pro.b.ad, runningServices.get(i).service.getPackageName().toString());
                        if (jSONArray == null) {
                            jSONArray = new JSONArray();
                        }
                        jSONArray.put(jSONObject);
                    } catch (JSONException unused) {
                    }
                }
            }
            if (jSONArray == null) {
                return jSONArray;
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("ts", System.currentTimeMillis());
                jSONObject2.put("ls", jSONArray);
            } catch (JSONException unused2) {
            }
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("sers", jSONObject2);
            } catch (JSONException unused3) {
            }
            JSONArray jSONArray2 = new JSONArray();
            try {
                jSONArray2.put(jSONObject3);
                return jSONArray2;
            } catch (Throwable th) {
                th = th;
                jSONArray = jSONArray2;
                UMCrashManager.reportCrash(context, th);
                return jSONArray;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static JSONArray q(Context context) {
        JSONArray jSONArray = new JSONArray();
        JSONObject d2 = k.d(context);
        if (d2 != null) {
            try {
                String e2 = k.e(context);
                if (!TextUtils.isEmpty(e2)) {
                    d2.put("sig", e2);
                }
                jSONArray.put(d2);
            } catch (Exception unused) {
            }
        }
        return jSONArray;
    }

    private static JSONArray r(Context context) {
        JSONArray jSONArray = new JSONArray();
        String f2 = k.f(context);
        if (!TextUtils.isEmpty(f2)) {
            try {
                jSONArray.put(new JSONObject(f2));
            } catch (Exception unused) {
            }
        }
        return jSONArray;
    }

    private static JSONArray s(Context context) {
        JSONArray jSONArray = new JSONArray();
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            String a2 = k.a(applicationContext);
            JSONObject jSONObject = null;
            if (!TextUtils.isEmpty(a2)) {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put(e.X, a2);
                    } catch (Exception unused) {
                    }
                    jSONObject = jSONObject2;
                } catch (Exception unused2) {
                }
            }
            String b2 = k.b(applicationContext);
            if (!TextUtils.isEmpty(b2)) {
                if (jSONObject == null) {
                    try {
                        jSONObject = new JSONObject();
                    } catch (Exception unused3) {
                    }
                }
                jSONObject.put(e.Y, b2);
            }
            String c2 = k.c(applicationContext);
            if (!TextUtils.isEmpty(c2)) {
                if (jSONObject == null) {
                    try {
                        jSONObject = new JSONObject();
                    } catch (Exception unused4) {
                    }
                }
                jSONObject.put(e.Z, c2);
            }
            JSONObject d2 = k.d(applicationContext);
            if (d2 != null) {
                try {
                    String e2 = k.e(applicationContext);
                    if (!TextUtils.isEmpty(e2)) {
                        d2.put("signalscale", e2);
                    }
                    if (jSONObject == null) {
                        jSONObject = new JSONObject();
                    }
                    jSONObject.put(e.ab, d2);
                } catch (Exception unused5) {
                }
            }
            String f2 = k.f(applicationContext);
            if (!TextUtils.isEmpty(f2)) {
                if (jSONObject == null) {
                    try {
                        jSONObject = new JSONObject();
                    } catch (Exception unused6) {
                    }
                }
                jSONObject.put(e.W, new JSONObject(f2));
            }
            if (jSONObject != null) {
                jSONArray.put(jSONObject);
            }
        }
        return jSONArray;
    }

    private static void b(Context context, JSONObject jSONObject) {
        if (context != null) {
            String a2 = l.a(context);
            if (TextUtils.isEmpty(a2)) {
                return;
            }
            try {
                JSONObject jSONObject2 = new JSONObject(a2);
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                if (jSONObject2.has(l.f26138d)) {
                    jSONObject.put(l.f26138d, jSONObject2.opt(l.f26138d));
                }
                if (jSONObject2.has(l.f26137c)) {
                    jSONObject.put(l.f26137c, jSONObject2.opt(l.f26137c));
                }
                if (jSONObject2.has(l.f26136b)) {
                    jSONObject.put(l.f26136b, jSONObject2.opt(l.f26136b));
                }
            } catch (Exception unused) {
            }
        }
    }

    private static void a(Context context, JSONObject jSONObject) {
        PackageManager packageManager;
        if (context == null || (packageManager = context.getApplicationContext().getPackageManager()) == null) {
            return;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        a(jSONObject, "gp", packageManager.hasSystemFeature("android.hardware.location.gps"));
        a(jSONObject, "to", packageManager.hasSystemFeature("android.hardware.touchscreen"));
        a(jSONObject, "mo", packageManager.hasSystemFeature("android.hardware.telephony"));
        a(jSONObject, "ca", packageManager.hasSystemFeature("android.hardware.camera"));
        a(jSONObject, "fl", packageManager.hasSystemFeature("android.hardware.camera.flash"));
    }

    public static JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("a_pr", Build.PRODUCT);
            jSONObject.put("a_bl", Build.BOOTLOADER);
            if (Build.VERSION.SDK_INT >= 14) {
                jSONObject.put("a_rv", Build.getRadioVersion());
            }
            jSONObject.put("a_fp", Build.FINGERPRINT);
            jSONObject.put("a_hw", Build.HARDWARE);
            jSONObject.put("a_host", Build.HOST);
            if (Build.VERSION.SDK_INT >= 21) {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < Build.SUPPORTED_32_BIT_ABIS.length; i++) {
                    jSONArray.put(Build.SUPPORTED_32_BIT_ABIS[i]);
                }
                if (jSONArray.length() > 0) {
                    jSONObject.put("a_s32", jSONArray);
                }
            }
            if (Build.VERSION.SDK_INT >= 21) {
                JSONArray jSONArray2 = new JSONArray();
                for (int i2 = 0; i2 < Build.SUPPORTED_64_BIT_ABIS.length; i2++) {
                    jSONArray2.put(Build.SUPPORTED_64_BIT_ABIS[i2]);
                }
                if (jSONArray2.length() > 0) {
                    jSONObject.put("a_s64", jSONArray2);
                }
            }
            if (Build.VERSION.SDK_INT >= 21) {
                JSONArray jSONArray3 = new JSONArray();
                for (int i3 = 0; i3 < Build.SUPPORTED_ABIS.length; i3++) {
                    jSONArray3.put(Build.SUPPORTED_ABIS[i3]);
                }
                if (jSONArray3.length() > 0) {
                    jSONObject.put("a_sa", jSONArray3);
                }
            }
            jSONObject.put("a_ta", Build.TAGS);
            jSONObject.put("a_uk", "unknown");
            jSONObject.put("a_user", Build.USER);
            jSONObject.put("a_cpu1", Build.CPU_ABI);
            jSONObject.put("a_cpu2", Build.CPU_ABI2);
            jSONObject.put("a_ra", Build.RADIO);
            if (Build.VERSION.SDK_INT >= 23) {
                jSONObject.put("a_bos", Build.VERSION.BASE_OS);
                jSONObject.put("a_pre", Build.VERSION.PREVIEW_SDK_INT);
                jSONObject.put("a_sp", Build.VERSION.SECURITY_PATCH);
            }
            jSONObject.put("a_cn", Build.VERSION.CODENAME);
            jSONObject.put("a_intl", Build.VERSION.INCREMENTAL);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private static JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tot_s", com.umeng.commonsdk.internal.utils.a.h());
            jSONObject.put("ava_s", com.umeng.commonsdk.internal.utils.a.i());
            jSONObject.put("ts", System.currentTimeMillis());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private static JSONObject d() {
        try {
            d.a a2 = com.umeng.commonsdk.internal.utils.d.a();
            if (a2 == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("pro", a2.f26092a);
                jSONObject.put("pla", a2.f26093b);
                jSONObject.put("cpus", a2.f26094c);
                jSONObject.put("fea", a2.f26095d);
                jSONObject.put("imp", a2.f26096e);
                jSONObject.put("arc", a2.f26097f);
                jSONObject.put("var", a2.f26098g);
                jSONObject.put("par", a2.f26099h);
                jSONObject.put("rev", a2.i);
                jSONObject.put("har", a2.j);
                jSONObject.put("rev", a2.k);
                jSONObject.put("ser", a2.l);
                jSONObject.put("cur_cpu", com.umeng.commonsdk.internal.utils.d.d());
                jSONObject.put("max_cpu", com.umeng.commonsdk.internal.utils.d.b());
                jSONObject.put("min_cpu", com.umeng.commonsdk.internal.utils.d.c());
                jSONObject.put("ts", System.currentTimeMillis());
            } catch (Exception unused) {
            }
            return jSONObject;
        } catch (Exception unused2) {
            return null;
        }
    }

    private static void a(JSONObject jSONObject, String str, boolean z) {
        if (jSONObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (z) {
                jSONObject.put(str, 1);
            } else {
                jSONObject.put(str, 0);
            }
        } catch (Exception unused) {
        }
    }

    public static JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("f", com.umeng.commonsdk.internal.utils.a.c());
            jSONObject.put(e.ar, com.umeng.commonsdk.internal.utils.a.d());
            jSONObject.put("ts", System.currentTimeMillis());
        } catch (Exception unused) {
        }
        return jSONObject;
    }
}
