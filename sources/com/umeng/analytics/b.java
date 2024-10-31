package com.umeng.analytics;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.pro.g;
import com.umeng.analytics.pro.h;
import com.umeng.analytics.pro.i;
import com.umeng.analytics.pro.j;
import com.umeng.analytics.pro.k;
import com.umeng.analytics.pro.l;
import com.umeng.analytics.pro.o;
import com.umeng.analytics.pro.p;
import com.umeng.analytics.pro.q;
import com.umeng.analytics.pro.r;
import com.umeng.analytics.pro.u;
import com.umeng.analytics.pro.x;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.microedition.khronos.opengles.GL10;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: InternalAgent.java */
/* loaded from: classes3.dex */
public class b implements p {
    private static final String A = "umsp_3";
    private static final String B = "umsp_4";
    private static final String C = "umsp_5";

    /* renamed from: h, reason: collision with root package name */
    private static final String f25781h = "sp_uapp";
    private static final String i = "prepp_uapp";
    private static final int o = 128;
    private static final int p = 256;
    private static String q = "";
    private static String r = "";
    private static final String s = "ekv_bl";
    private static final String t = "ekv_bl_ver";
    private static final String v = "ekv_wl";
    private static final String w = "ekv_wl_ver";
    private static final String y = "umsp_1";
    private static final String z = "umsp_2";

    /* renamed from: a, reason: collision with root package name */
    private Context f25782a;

    /* renamed from: b, reason: collision with root package name */
    private x f25783b;

    /* renamed from: c, reason: collision with root package name */
    private l f25784c;

    /* renamed from: d, reason: collision with root package name */
    private r f25785d;

    /* renamed from: e, reason: collision with root package name */
    private i f25786e;

    /* renamed from: f, reason: collision with root package name */
    private q f25787f;

    /* renamed from: g, reason: collision with root package name */
    private j f25788g;
    private boolean j;
    private volatile JSONObject k;
    private volatile JSONObject l;
    private volatile JSONObject m;
    private boolean n;
    private com.umeng.analytics.filter.a u;
    private com.umeng.analytics.filter.b x;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: InternalAgent.java */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final b f25789a = new b();

        private a() {
        }
    }

    public static b a() {
        return a.f25789a;
    }

    private void i(Context context) {
        try {
            if (context == null) {
                MLog.e("unexpected null context in getNativeSuperProperties");
                return;
            }
            if (this.f25782a == null) {
                this.f25782a = context.getApplicationContext();
            }
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            if (this.k == null) {
                this.k = new JSONObject();
            }
            if (this.l == null) {
                this.l = new JSONObject();
            }
            String string = sharedPreferences.getString(i, null);
            if (!TextUtils.isEmpty(string)) {
                try {
                    this.m = new JSONObject(string);
                } catch (JSONException unused) {
                }
            }
            if (this.m == null) {
                this.m = new JSONObject();
            }
        } catch (Throwable unused2) {
        }
    }

    private void j(Context context) {
        try {
            Class.forName("com.umeng.visual.UMVisualAgent");
        } catch (ClassNotFoundException unused) {
            if (Build.VERSION.SDK_INT > 13) {
                UMWorkDispatch.sendEvent(context, k.a.s, CoreProtocol.getInstance(context), Long.valueOf(System.currentTimeMillis()));
            }
        }
    }

    public JSONObject b() {
        return this.k;
    }

    public JSONObject c() {
        return this.m;
    }

    public JSONObject d() {
        return this.l;
    }

    public void e() {
        this.l = null;
    }

    public String f() {
        if (!UMGlobalContext.getInstance().isMainProcess(this.f25782a)) {
            MLog.e("getOnResumedActivityName can not be called in child process");
            return null;
        }
        return q;
    }

    public String g() {
        if (!UMGlobalContext.getInstance().isMainProcess(this.f25782a)) {
            MLog.e("getOnPausedActivityName can not be called in child process");
            return null;
        }
        return r;
    }

    public void h() {
        try {
            if (this.f25782a != null) {
                if (!UMGlobalContext.getInstance().isMainProcess(this.f25782a)) {
                    MLog.e("onStartSessionInternal can not be called in child process");
                    return;
                } else {
                    long currentTimeMillis = System.currentTimeMillis();
                    UMWorkDispatch.sendEvent(this.f25782a, k.a.k, CoreProtocol.getInstance(this.f25782a), Long.valueOf(currentTimeMillis));
                    UMWorkDispatch.sendEvent(this.f25782a, k.a.f25923g, CoreProtocol.getInstance(this.f25782a), Long.valueOf(currentTimeMillis));
                }
            }
            if (this.f25783b != null) {
                this.f25783b.a();
            }
        } catch (Throwable unused) {
        }
    }

    public synchronized void k() {
        if (!UMGlobalContext.getInstance().isMainProcess(this.f25782a)) {
            MLog.e("unregisterSuperPropertyByCoreProtocol can not be called in child process");
            return;
        }
        if (this.k != null && this.f25782a != null) {
            SharedPreferences.Editor edit = PreferenceWrapper.getDefault(this.f25782a).edit();
            edit.putString(f25781h, this.k.toString());
            edit.commit();
        } else {
            this.k = new JSONObject();
        }
    }

    public synchronized JSONObject l() {
        if (!UMGlobalContext.getInstance().isMainProcess(this.f25782a)) {
            MLog.e("getSuperPropertiesJSONObject can not be called in child process");
            return null;
        }
        if (this.k == null) {
            this.k = new JSONObject();
        }
        return this.k;
    }

    public synchronized void m() {
        try {
            if (this.f25782a != null) {
                if (!UMGlobalContext.getInstance().isMainProcess(this.f25782a)) {
                    MLog.e("clearSuperPropertiesByCoreProtocol can not be called in child process");
                } else {
                    SharedPreferences.Editor edit = PreferenceWrapper.getDefault(this.f25782a).edit();
                    edit.remove(f25781h);
                    edit.commit();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private b() {
        this.f25782a = null;
        this.f25784c = new l();
        this.f25785d = new r();
        this.f25786e = new i();
        this.f25787f = q.a();
        this.f25788g = null;
        this.j = false;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = false;
        this.u = null;
        this.x = null;
        this.f25784c.a(this);
    }

    public void a(Context context) {
        if (context == null) {
            return;
        }
        try {
            if (this.f25782a == null) {
                this.f25782a = context.getApplicationContext();
            }
            if (this.u == null) {
                this.u = new com.umeng.analytics.filter.a("ekv_bl", "ekv_bl_ver");
                this.u.register(this.f25782a);
            }
            if (this.x == null) {
                this.x = new com.umeng.analytics.filter.b("ekv_wl", "ekv_wl_ver");
                this.x.register(this.f25782a);
            }
            if (UMGlobalContext.getInstance().isMainProcess(this.f25782a)) {
                if (!this.j) {
                    this.j = true;
                    i(this.f25782a);
                }
                if (Build.VERSION.SDK_INT > 13) {
                    synchronized (this) {
                        if (!this.n) {
                            this.f25788g = new j(context);
                            if (this.f25788g.a()) {
                                this.n = true;
                            }
                        }
                    }
                } else {
                    this.n = true;
                }
                if (UMConfigure.isDebugLog()) {
                    UMLog.mutlInfo(h.B, 3, "", null, null);
                }
                if (Build.VERSION.SDK_INT > 13) {
                    UMWorkDispatch.sendEvent(this.f25782a, k.a.w, CoreProtocol.getInstance(this.f25782a), Long.valueOf(System.currentTimeMillis()));
                }
                UMWorkDispatch.registerConnStateObserver(CoreProtocol.getInstance(this.f25782a));
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(String str) {
        if (!UMGlobalContext.getInstance().isMainProcess(this.f25782a)) {
            MLog.e("onPageEnd can not be called in child process");
            return;
        }
        try {
            if (AnalyticsConfig.AUTO_ACTIVITY_PAGE_COLLECTION != MobclickAgent.PageMode.LEGACY_AUTO) {
                this.f25785d.b(str);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(Context context) {
        if (context == null) {
            UMLog.aq(h.p, 0, "\\|");
            return;
        }
        if (AnalyticsConfig.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.AUTO) {
            return;
        }
        if (this.f25782a == null) {
            this.f25782a = context.getApplicationContext();
        }
        if (!UMGlobalContext.getInstance().isMainProcess(this.f25782a)) {
            MLog.e("onPause can not be called in child process");
            return;
        }
        if (UMConfigure.isDebugLog() && !(context instanceof Activity)) {
            UMLog.aq(h.q, 2, "\\|");
        }
        try {
            if (!this.j || !this.n) {
                a(context);
            }
            if (AnalyticsConfig.AUTO_ACTIVITY_PAGE_COLLECTION != MobclickAgent.PageMode.LEGACY_MANUAL) {
                this.f25786e.b(context.getClass().getName());
            }
            i();
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e("Exception occurred in Mobclick.onRause(). ", th);
            }
        }
        if (UMConfigure.isDebugLog() && (context instanceof Activity)) {
            r = context.getClass().getName();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(Context context) {
        if (context == null) {
            return;
        }
        try {
            if (this.f25782a == null) {
                this.f25782a = context.getApplicationContext();
            }
            if (!UMGlobalContext.getInstance().isMainProcess(this.f25782a)) {
                MLog.e("onKillProcess can not be called in child process");
                return;
            }
            if (this.f25788g != null) {
                this.f25788g.c();
            }
            if (this.f25786e != null) {
                this.f25786e.b();
            }
            if (this.f25785d != null) {
                this.f25785d.b();
            }
            if (this.f25782a != null) {
                if (this.f25787f != null) {
                    this.f25787f.c(this.f25782a, Long.valueOf(System.currentTimeMillis()));
                }
                k.a(this.f25782a).d();
                r.a(this.f25782a);
                j.a(this.f25782a);
                PreferenceWrapper.getDefault(this.f25782a).edit().commit();
            }
            UMWorkDispatch.Quit();
        } catch (Throwable unused) {
        }
    }

    public synchronized Object e(Context context, String str) {
        try {
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (context == null) {
            UMLog.aq(h.ah, 0, "\\|");
            return null;
        }
        if (this.f25782a == null) {
            this.f25782a = context.getApplicationContext();
        }
        if (!UMGlobalContext.getInstance().isMainProcess(this.f25782a)) {
            MLog.e("getSuperProperty can not be called in child process");
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            UMLog.aq(h.af, 0, "\\|");
            return null;
        }
        if (!str.equals(y) && !str.equals(z) && !str.equals(A) && !str.equals(B) && !str.equals(C)) {
            MLog.e("please check key or value, must be correct!");
            return null;
        }
        if (this.k != null) {
            if (this.k.has(str)) {
                return this.k.opt(str);
            }
        } else {
            this.k = new JSONObject();
        }
        return null;
    }

    public synchronized void f(Context context) {
        if (context == null) {
            UMLog.aq(h.ag, 0, "\\|");
            return;
        }
        if (this.f25782a == null) {
            this.f25782a = context.getApplicationContext();
        }
        if (!UMGlobalContext.getInstance().isMainProcess(this.f25782a)) {
            MLog.e("clearSuperProperties can not be called in child process");
            return;
        }
        if (!this.j || !this.n) {
            a(this.f25782a);
        }
        this.k = new JSONObject();
        UMWorkDispatch.sendEvent(this.f25782a, k.a.q, CoreProtocol.getInstance(this.f25782a), null);
    }

    public synchronized void g(Context context) {
        if (context == null) {
            UMLog.aq(h.ao, 0, "\\|");
            return;
        }
        if (this.f25782a == null) {
            this.f25782a = context.getApplicationContext();
        }
        if (!UMGlobalContext.getInstance().isMainProcess(this.f25782a)) {
            MLog.e("clearPreProperties can not be called in child process");
            return;
        }
        if (!this.j || !this.n) {
            a(this.f25782a);
        }
        if (this.m.length() > 0) {
            UMWorkDispatch.sendEvent(this.f25782a, k.a.v, CoreProtocol.getInstance(this.f25782a), null);
        }
        this.m = new JSONObject();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j() {
        try {
            if (!UMGlobalContext.getInstance().isMainProcess(this.f25782a)) {
                MLog.e("onProfileSignOff can not be called in child process");
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ts", currentTimeMillis);
            k.a(this.f25782a).a((Object) null, true);
            UMWorkDispatch.sendEvent(this.f25782a, k.a.f25922f, CoreProtocol.getInstance(this.f25782a), jSONObject);
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(" Excepthon  in  onProfileSignOff", th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Context context) {
        if (context == null) {
            MLog.e("unexpected null context in onResume");
            return;
        }
        if (AnalyticsConfig.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.AUTO) {
            return;
        }
        if (this.f25782a == null) {
            this.f25782a = context.getApplicationContext();
        }
        if (!UMGlobalContext.getInstance().isMainProcess(this.f25782a)) {
            MLog.e("onResume can not be called in child process");
            return;
        }
        if (UMConfigure.isDebugLog() && !(context instanceof Activity)) {
            UMLog.aq(h.o, 2, "\\|");
        }
        try {
            if (!this.j || !this.n) {
                a(context);
            }
            if (AnalyticsConfig.AUTO_ACTIVITY_PAGE_COLLECTION != MobclickAgent.PageMode.LEGACY_MANUAL) {
                this.f25786e.a(context.getClass().getName());
            }
            h();
            j(this.f25782a);
            if (UMConfigure.isDebugLog() && (context instanceof Activity)) {
                q = context.getClass().getName();
            }
        } catch (Throwable th) {
            MLog.e("Exception occurred in Mobclick.onResume(). ", th);
        }
    }

    public synchronized JSONObject h(Context context) {
        if (context == null) {
            UMLog.aq(h.ap, 0, "\\|");
            return null;
        }
        if (this.f25782a == null) {
            this.f25782a = context.getApplicationContext();
        }
        if (!UMGlobalContext.getInstance().isMainProcess(this.f25782a)) {
            MLog.e("getPreProperties can not be called in child process");
            return null;
        }
        if (!this.j || !this.n) {
            a(this.f25782a);
        }
        if (this.m == null) {
            this.m = new JSONObject();
        }
        JSONObject jSONObject = new JSONObject();
        if (this.m.length() > 0) {
            try {
                jSONObject = new JSONObject(this.m.toString());
            } catch (JSONException unused) {
            }
        }
        return jSONObject;
    }

    public void i() {
        try {
            if (this.f25782a != null) {
                if (!UMGlobalContext.getInstance().isMainProcess(this.f25782a)) {
                    MLog.e("onEndSessionInternal can not be called in child process");
                    return;
                }
                UMWorkDispatch.sendEvent(this.f25782a, k.a.f25924h, CoreProtocol.getInstance(this.f25782a), Long.valueOf(System.currentTimeMillis()));
                UMWorkDispatch.sendEvent(this.f25782a, k.a.f25920d, CoreProtocol.getInstance(this.f25782a), null);
                UMWorkDispatch.sendEvent(this.f25782a, 4099, CoreProtocol.getInstance(this.f25782a), null);
                UMWorkDispatch.sendEvent(this.f25782a, k.a.i, CoreProtocol.getInstance(this.f25782a), null);
            }
        } catch (Throwable unused) {
        }
        x xVar = this.f25783b;
        if (xVar != null) {
            xVar.b();
        }
    }

    public synchronized void f(Context context, String str) {
        if (context == null) {
            UMLog.aq(h.am, 0, "\\|");
            return;
        }
        if (this.f25782a == null) {
            this.f25782a = context.getApplicationContext();
        }
        if (!UMGlobalContext.getInstance().isMainProcess(this.f25782a)) {
            MLog.e("unregisterPreProperty can not be called in child process");
            return;
        }
        if (!this.j || !this.n) {
            a(this.f25782a);
        }
        if (this.m == null) {
            this.m = new JSONObject();
        }
        if (str != null && str.length() > 0) {
            if (this.m.has(str)) {
                this.m.remove(str);
                UMWorkDispatch.sendEvent(this.f25782a, k.a.u, CoreProtocol.getInstance(this.f25782a), this.m.toString());
            } else if (UMConfigure.isDebugLog()) {
                UMLog.aq(h.an, 0, "\\|");
            }
            return;
        }
        MLog.e("please check propertics, property is null!");
    }

    public synchronized void d(Context context, String str) {
        try {
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (context == null) {
            UMLog.aq(h.ag, 0, "\\|");
            return;
        }
        if (this.f25782a == null) {
            this.f25782a = context.getApplicationContext();
        }
        if (!UMGlobalContext.getInstance().isMainProcess(this.f25782a)) {
            MLog.e("unregisterSuperProperty can not be called in child process");
            return;
        }
        if (!this.j || !this.n) {
            a(this.f25782a);
        }
        if (TextUtils.isEmpty(str)) {
            UMLog.aq(h.af, 0, "\\|");
            return;
        }
        if (!str.equals(y) && !str.equals(z) && !str.equals(A) && !str.equals(B) && !str.equals(C)) {
            MLog.e("please check key or value, must be correct!");
            return;
        }
        if (this.k == null) {
            this.k = new JSONObject();
        }
        if (this.k.has(str)) {
            this.k.remove(str);
            UMWorkDispatch.sendEvent(this.f25782a, k.a.r, CoreProtocol.getInstance(this.f25782a), str);
        }
    }

    private boolean c(String str) {
        if (this.u.enabled() && this.u.matchHit(str)) {
            return true;
        }
        if (!this.x.enabled()) {
            return false;
        }
        if (!this.x.matchHit(str)) {
            return true;
        }
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> white list match! id = " + str);
        return false;
    }

    public void b(Context context, String str) {
        try {
            if (context == null) {
                UMLog.aq(h.M, 0, "\\|");
                return;
            }
            if (this.f25782a == null) {
                this.f25782a = context.getApplicationContext();
            }
            if (!UMGlobalContext.getInstance().isMainProcess(this.f25782a)) {
                MLog.e("onDeepLinkReceived can not be called in child process");
                return;
            }
            if (!this.j || !this.n) {
                a(this.f25782a);
            }
            if (!TextUtils.isEmpty(str)) {
                HashMap hashMap = new HashMap();
                hashMap.put(com.umeng.analytics.pro.b.aB, str);
                b(this.f25782a, com.umeng.analytics.pro.b.aA, hashMap, -1L);
                return;
            }
            UMLog.aq(h.N, 0, "\\|");
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(th);
            }
        }
    }

    public synchronized String e(Context context) {
        try {
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (context == null) {
            UMLog.aq(h.ah, 0, "\\|");
            return null;
        }
        if (this.f25782a == null) {
            this.f25782a = context.getApplicationContext();
        }
        if (!UMGlobalContext.getInstance().isMainProcess(this.f25782a)) {
            MLog.e("getSuperProperties can not be called in child process");
            return null;
        }
        if (this.k != null) {
            return this.k.toString();
        }
        this.k = new JSONObject();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(Context context, String str) {
        if (context == null) {
            UMLog.aq(h.z, 0, "\\|");
            return;
        }
        if (this.f25782a == null) {
            this.f25782a = context.getApplicationContext();
        }
        if (!UMGlobalContext.getInstance().isMainProcess(this.f25782a)) {
            MLog.e("setSecret can not be called in child process");
            return;
        }
        if (!this.j || !this.n) {
            a(this.f25782a);
        }
        AnalyticsConfig.a(this.f25782a, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str) {
        if (!UMGlobalContext.getInstance().isMainProcess(this.f25782a)) {
            MLog.e("onPageStart can not be called in child process");
            return;
        }
        try {
            if (AnalyticsConfig.AUTO_ACTIVITY_PAGE_COLLECTION != MobclickAgent.PageMode.LEGACY_AUTO) {
                this.f25785d.a(str);
            }
        } catch (Throwable unused) {
        }
    }

    public void a(x xVar) {
        if (!UMGlobalContext.getInstance().isMainProcess(this.f25782a)) {
            MLog.e("setSysListener can not be called in child process");
        } else {
            this.f25783b = xVar;
        }
    }

    public void a(Context context, int i2) {
        if (context == null) {
            MLog.e("unexpected null context in setVerticalType");
            return;
        }
        if (this.f25782a == null) {
            this.f25782a = context.getApplicationContext();
        }
        if (!UMGlobalContext.getInstance().isMainProcess(this.f25782a)) {
            MLog.e("setVerticalType can not be called in child process");
            return;
        }
        if (!this.j || !this.n) {
            a(this.f25782a);
        }
        AnalyticsConfig.a(this.f25782a, i2);
    }

    private void b(Context context, String str, Map<String, Object> map, long j) {
        try {
            if (context == null) {
                MLog.e("context is null in onEventNoCheck, please check!");
                return;
            }
            if (this.f25782a == null) {
                this.f25782a = context.getApplicationContext();
            }
            if (!this.j || !this.n) {
                a(this.f25782a);
            }
            if (c(str)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> filter ekv [" + str + "].");
                return;
            }
            String str2 = "";
            if (this.k == null) {
                this.k = new JSONObject();
            } else {
                str2 = this.k.toString();
            }
            o.a(this.f25782a).a(str, map, j, str2);
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(th);
            }
        }
    }

    public void a(Context context, String str, HashMap<String, Object> hashMap) {
        if (context == null) {
            return;
        }
        try {
            if (this.f25782a == null) {
                this.f25782a = context.getApplicationContext();
            }
            if (!UMGlobalContext.getInstance().isMainProcess(this.f25782a)) {
                MLog.e("onGKVEvent can not be called in child process");
                return;
            }
            if (!this.j || !this.n) {
                a(this.f25782a);
            }
            String str2 = "";
            if (this.k == null) {
                this.k = new JSONObject();
            } else {
                str2 = this.k.toString();
            }
            o.a(this.f25782a).a(str, hashMap, str2);
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(th);
            }
        }
    }

    public synchronized void b(Object obj) {
        try {
        } catch (Throwable th) {
            throw th;
        }
        if (!UMGlobalContext.getInstance().isMainProcess(this.f25782a)) {
            MLog.e("updateNativePrePropertiesByCoreProtocol can not be called in child process");
            return;
        }
        SharedPreferences.Editor edit = PreferenceWrapper.getDefault(this.f25782a).edit();
        if (obj != null) {
            String str = (String) obj;
            if (edit != null && !TextUtils.isEmpty(str)) {
                edit.putString(i, str).commit();
            }
        } else if (edit != null) {
            edit.remove(i).commit();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Context context, String str) {
        if (context == null) {
            UMLog.aq(h.w, 0, "\\|");
            return;
        }
        if (this.f25782a == null) {
            this.f25782a = context.getApplicationContext();
        }
        if (!UMGlobalContext.getInstance().isMainProcess(this.f25782a)) {
            MLog.e("reportError can not be called in child process");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            if (UMConfigure.isDebugLog()) {
                UMLog.aq(h.x, 0, "\\|");
                return;
            }
            return;
        }
        try {
            if (!this.j || !this.n) {
                a(this.f25782a);
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ts", System.currentTimeMillis());
            jSONObject.put(com.umeng.analytics.pro.b.P, 2);
            jSONObject.put(com.umeng.analytics.pro.b.Q, str);
            jSONObject.put("__ii", this.f25787f.c());
            UMWorkDispatch.sendEvent(this.f25782a, k.a.j, CoreProtocol.getInstance(this.f25782a), jSONObject);
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(th);
            }
        }
    }

    private boolean b(String str, Object obj) {
        int i2;
        if (TextUtils.isEmpty(str)) {
            MLog.e("key is " + str + ", please check key, illegal");
            return false;
        }
        try {
            i2 = str.getBytes("UTF-8").length;
        } catch (UnsupportedEncodingException unused) {
            i2 = 0;
        }
        if (i2 > 128) {
            MLog.e("key length is " + i2 + ", please check key, illegal");
            return false;
        }
        if (obj instanceof String) {
            if (((String) obj).getBytes("UTF-8").length <= 256) {
                return true;
            }
            MLog.e("value length is " + ((String) obj).getBytes("UTF-8").length + ", please check value, illegal");
            return false;
        }
        if ((obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Double) || (obj instanceof Float)) {
            return true;
        }
        MLog.e("value is " + obj + ", please check value, type illegal");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Context context, Throwable th) {
        if (context != null && th != null) {
            if (this.f25782a == null) {
                this.f25782a = context.getApplicationContext();
            }
            if (!UMGlobalContext.getInstance().isMainProcess(this.f25782a)) {
                MLog.e("reportError can not be called in child process");
                return;
            }
            try {
                if (!this.j || !this.n) {
                    a(this.f25782a);
                }
                a(this.f25782a, DataHelper.convertExceptionToString(th));
                return;
            } catch (Exception e2) {
                if (MLog.DEBUG) {
                    MLog.e(e2);
                    return;
                }
                return;
            }
        }
        UMLog.aq(h.y, 0, "\\|");
    }

    public void a(Context context, String str, String str2, long j, int i2) {
        if (context == null) {
            return;
        }
        try {
            if (this.f25782a == null) {
                this.f25782a = context.getApplicationContext();
            }
            if (!this.j || !this.n) {
                a(this.f25782a);
            }
            if (c(str)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> filter ekv [" + str + "].");
                return;
            }
            String str3 = "";
            if (this.k == null) {
                this.k = new JSONObject();
            } else {
                str3 = this.k.toString();
            }
            o.a(this.f25782a).a(str, str2, j, i2, str3);
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Context context, String str, Map<String, Object> map, long j) {
        try {
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(th);
            }
        }
        if (!TextUtils.isEmpty(str)) {
            if (Arrays.asList(com.umeng.analytics.pro.b.aC).contains(str)) {
                UMLog.aq(h.f25893b, 0, "\\|");
                return;
            }
            if (map.isEmpty()) {
                UMLog.aq(h.f25895d, 0, "\\|");
                return;
            }
            Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                if (Arrays.asList(com.umeng.analytics.pro.b.aC).contains(it.next().getKey())) {
                    UMLog.aq(h.f25896e, 0, "\\|");
                    return;
                }
            }
            b(context, str, map, j);
            return;
        }
        UMLog.aq(h.f25894c, 0, "\\|");
    }

    @Override // com.umeng.analytics.pro.p
    public void a(Throwable th) {
        try {
            if (!UMGlobalContext.getInstance().isMainProcess(this.f25782a)) {
                MLog.e("onAppCrash can not be called in child process");
                UMWorkDispatch.Quit();
                return;
            }
            if (this.f25785d != null) {
                this.f25785d.b();
            }
            if (this.f25786e != null) {
                this.f25786e.b();
            }
            if (this.f25788g != null) {
                this.f25788g.c();
            }
            if (this.f25782a != null) {
                if (this.f25787f != null) {
                    this.f25787f.c(this.f25782a, Long.valueOf(System.currentTimeMillis()));
                }
                if (th != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("ts", System.currentTimeMillis());
                    jSONObject.put(com.umeng.analytics.pro.b.P, 1);
                    jSONObject.put(com.umeng.analytics.pro.b.Q, DataHelper.convertExceptionToString(th));
                    g.a(this.f25782a).a(this.f25787f.c(), jSONObject.toString(), 1);
                }
                k.a(this.f25782a).d();
                r.a(this.f25782a);
                j.a(this.f25782a);
                PreferenceWrapper.getDefault(this.f25782a).edit().commit();
            }
            UMWorkDispatch.Quit();
        } catch (Exception e2) {
            if (MLog.DEBUG) {
                MLog.e("Exception in onAppCrash", e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, String str2) {
        try {
            if (!UMGlobalContext.getInstance().isMainProcess(this.f25782a)) {
                MLog.e("onProfileSignIn can not be called in child process");
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(com.umeng.analytics.pro.b.L, str);
            jSONObject.put("uid", str2);
            jSONObject.put("ts", currentTimeMillis);
            k.a(this.f25782a).a((Object) null, true);
            UMWorkDispatch.sendEvent(this.f25782a, k.a.f25921e, CoreProtocol.getInstance(this.f25782a), jSONObject);
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(" Excepthon  in  onProfileSignIn", th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z2) {
        if (!UMGlobalContext.getInstance().isMainProcess(this.f25782a)) {
            MLog.e("setCatchUncaughtExceptions can not be called in child process");
        } else {
            if (AnalyticsConfig.CHANGE_CATCH_EXCEPTION_NOTALLOW) {
                return;
            }
            AnalyticsConfig.CATCH_EXCEPTION = z2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(GL10 gl10) {
        String[] gpu = UMUtils.getGPU(gl10);
        if (gpu.length == 2) {
            AnalyticsConfig.GPU_VENDER = gpu[0];
            AnalyticsConfig.GPU_RENDERER = gpu[1];
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(MobclickAgent.PageMode pageMode) {
        if (!UMGlobalContext.getInstance().isMainProcess(this.f25782a)) {
            MLog.e("setPageCollectionMode can not be called in child process");
        } else {
            AnalyticsConfig.AUTO_ACTIVITY_PAGE_COLLECTION = pageMode;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(double d2, double d3) {
        if (!UMGlobalContext.getInstance().isMainProcess(this.f25782a)) {
            MLog.e("setLocation can not be called in child process");
            return;
        }
        if (AnalyticsConfig.f25761a == null) {
            AnalyticsConfig.f25761a = new double[2];
        }
        double[] dArr = AnalyticsConfig.f25761a;
        dArr[0] = d2;
        dArr[1] = d3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Context context, MobclickAgent.EScenarioType eScenarioType) {
        if (context == null) {
            MLog.e("unexpected null context in setScenarioType");
            return;
        }
        if (this.f25782a == null) {
            this.f25782a = context.getApplicationContext();
        }
        if (!UMGlobalContext.getInstance().isMainProcess(this.f25782a)) {
            MLog.e("setScenarioType can not be called in child process");
            return;
        }
        if (eScenarioType != null) {
            a(this.f25782a, eScenarioType.toValue());
        }
        if (this.j && this.n) {
            return;
        }
        a(this.f25782a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(long j) {
        if (!UMGlobalContext.getInstance().isMainProcess(this.f25782a)) {
            MLog.e("setSessionContinueMillis can not be called in child process");
        } else {
            AnalyticsConfig.kContinueSessionMillis = j;
            u.a().a(AnalyticsConfig.kContinueSessionMillis);
        }
    }

    public synchronized void a(Context context, String str, Object obj) {
        int i2 = 0;
        try {
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (context == null) {
            UMLog.aq(h.ae, 0, "\\|");
            return;
        }
        if (this.f25782a == null) {
            this.f25782a = context.getApplicationContext();
        }
        if (!UMGlobalContext.getInstance().isMainProcess(this.f25782a)) {
            MLog.e("registerSuperProperty can not be called in child process");
            return;
        }
        if (!this.j || !this.n) {
            a(this.f25782a);
        }
        if (!TextUtils.isEmpty(str) && obj != null) {
            if (!str.equals(y) && !str.equals(z) && !str.equals(A) && !str.equals(B) && !str.equals(C)) {
                MLog.e("property name is " + str + ", please check key, must be correct!");
                return;
            }
            if ((obj instanceof String) && !HelperUtils.checkStrLen(obj.toString(), 256)) {
                MLog.e("property value is " + obj + ", please check value, lawless!");
                return;
            }
            try {
                if (this.k == null) {
                    this.k = new JSONObject();
                }
                new JSONObject();
                if (obj.getClass().isArray()) {
                    if (obj instanceof String[]) {
                        String[] strArr = (String[]) obj;
                        if (strArr.length > 10) {
                            MLog.e("please check value, size is " + strArr.length + ", overstep 10!");
                            return;
                        }
                        JSONArray jSONArray = new JSONArray();
                        while (i2 < strArr.length) {
                            if (strArr[i2] != null && HelperUtils.checkStrLen(strArr[i2], 256)) {
                                jSONArray.put(strArr[i2]);
                                i2++;
                            }
                            MLog.e("please check value, length is " + strArr[i2].length() + ", overlength 256!");
                            return;
                        }
                        this.k.put(str, jSONArray);
                    } else if (obj instanceof long[]) {
                        long[] jArr = (long[]) obj;
                        if (jArr.length > 10) {
                            MLog.e("please check value, size is " + jArr.length + ", overstep 10!");
                            return;
                        }
                        JSONArray jSONArray2 = new JSONArray();
                        while (i2 < jArr.length) {
                            jSONArray2.put(jArr[i2]);
                            i2++;
                        }
                        this.k.put(str, jSONArray2);
                    } else if (obj instanceof int[]) {
                        int[] iArr = (int[]) obj;
                        if (iArr.length > 10) {
                            MLog.e("please check value, size is " + iArr.length + ", overstep 10!");
                            return;
                        }
                        JSONArray jSONArray3 = new JSONArray();
                        while (i2 < iArr.length) {
                            jSONArray3.put(iArr[i2]);
                            i2++;
                        }
                        this.k.put(str, jSONArray3);
                    } else if (obj instanceof float[]) {
                        float[] fArr = (float[]) obj;
                        if (fArr.length > 10) {
                            MLog.e("please check value, size is " + fArr.length + ", overstep 10!");
                            return;
                        }
                        JSONArray jSONArray4 = new JSONArray();
                        while (i2 < fArr.length) {
                            jSONArray4.put(fArr[i2]);
                            i2++;
                        }
                        this.k.put(str, jSONArray4);
                    } else if (obj instanceof double[]) {
                        double[] dArr = (double[]) obj;
                        if (dArr.length > 10) {
                            MLog.e("please check value, size is " + dArr.length + ", overstep 10!");
                            return;
                        }
                        JSONArray jSONArray5 = new JSONArray();
                        while (i2 < dArr.length) {
                            jSONArray5.put(dArr[i2]);
                            i2++;
                        }
                        this.k.put(str, jSONArray5);
                    } else if (obj instanceof short[]) {
                        short[] sArr = (short[]) obj;
                        if (sArr.length > 10) {
                            MLog.e("please check value, size is " + sArr.length + ", overstep 10!");
                            return;
                        }
                        JSONArray jSONArray6 = new JSONArray();
                        while (i2 < sArr.length) {
                            jSONArray6.put((int) sArr[i2]);
                            i2++;
                        }
                        this.k.put(str, jSONArray6);
                    } else {
                        MLog.e("please check value, illegal type!");
                        return;
                    }
                } else {
                    if (!(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Integer) && !(obj instanceof Float) && !(obj instanceof Double) && !(obj instanceof Short)) {
                        MLog.e("please check value, illegal type!");
                        return;
                    }
                    this.k.put(str, obj);
                }
            } catch (Throwable unused) {
            }
            UMWorkDispatch.sendEvent(this.f25782a, k.a.p, CoreProtocol.getInstance(this.f25782a), this.k.toString());
            return;
        }
        UMLog.aq(h.af, 0, "\\|");
    }

    private void a(String str, Object obj) {
        try {
            if (this.k == null) {
                this.k = new JSONObject();
            }
            new JSONObject();
            int i2 = 0;
            if (obj.getClass().isArray()) {
                if (obj instanceof String[]) {
                    String[] strArr = (String[]) obj;
                    if (strArr.length > 10) {
                        return;
                    }
                    JSONArray jSONArray = new JSONArray();
                    while (i2 < strArr.length) {
                        if (strArr[i2] != null && !HelperUtils.checkStrLen(strArr[i2], 256)) {
                            jSONArray.put(strArr[i2]);
                        }
                        i2++;
                    }
                    this.k.put(str, jSONArray);
                    return;
                }
                if (obj instanceof long[]) {
                    long[] jArr = (long[]) obj;
                    JSONArray jSONArray2 = new JSONArray();
                    while (i2 < jArr.length) {
                        jSONArray2.put(jArr[i2]);
                        i2++;
                    }
                    this.k.put(str, jSONArray2);
                    return;
                }
                if (obj instanceof int[]) {
                    int[] iArr = (int[]) obj;
                    JSONArray jSONArray3 = new JSONArray();
                    while (i2 < iArr.length) {
                        jSONArray3.put(iArr[i2]);
                        i2++;
                    }
                    this.k.put(str, jSONArray3);
                    return;
                }
                if (obj instanceof float[]) {
                    float[] fArr = (float[]) obj;
                    JSONArray jSONArray4 = new JSONArray();
                    while (i2 < fArr.length) {
                        jSONArray4.put(fArr[i2]);
                        i2++;
                    }
                    this.k.put(str, jSONArray4);
                    return;
                }
                if (obj instanceof double[]) {
                    double[] dArr = (double[]) obj;
                    JSONArray jSONArray5 = new JSONArray();
                    while (i2 < dArr.length) {
                        jSONArray5.put(dArr[i2]);
                        i2++;
                    }
                    this.k.put(str, jSONArray5);
                    return;
                }
                if (obj instanceof short[]) {
                    short[] sArr = (short[]) obj;
                    JSONArray jSONArray6 = new JSONArray();
                    while (i2 < sArr.length) {
                        jSONArray6.put((int) sArr[i2]);
                        i2++;
                    }
                    this.k.put(str, jSONArray6);
                    return;
                }
                return;
            }
            if (obj instanceof List) {
                List list = (List) obj;
                JSONArray jSONArray7 = new JSONArray();
                while (i2 < list.size()) {
                    Object obj2 = list.get(i2);
                    if ((obj2 instanceof String) || (obj2 instanceof Long) || (obj2 instanceof Integer) || (obj2 instanceof Float) || (obj2 instanceof Double) || (obj2 instanceof Short)) {
                        jSONArray7.put(list.get(i2));
                    }
                    i2++;
                }
                this.k.put(str, jSONArray7);
                return;
            }
            if ((obj instanceof String) || (obj instanceof Long) || (obj instanceof Integer) || (obj instanceof Float) || (obj instanceof Double) || (obj instanceof Short)) {
                this.k.put(str, obj);
            }
        } catch (Throwable unused) {
        }
    }

    public synchronized void a(Object obj) {
        if (!UMGlobalContext.getInstance().isMainProcess(this.f25782a)) {
            MLog.e("registerSuperPropertyByCoreProtocol can not be called in child process");
            return;
        }
        if (obj != null && this.f25782a != null) {
            String str = (String) obj;
            SharedPreferences.Editor edit = PreferenceWrapper.getDefault(this.f25782a).edit();
            if (edit != null && !TextUtils.isEmpty(str)) {
                edit.putString(f25781h, this.k.toString()).commit();
            }
        }
    }

    public synchronized void a(Context context, List<String> list) {
        try {
        } catch (Throwable th) {
            MLog.e(th);
        }
        if (context == null) {
            UMLog.aq(h.ai, 0, "\\|");
            return;
        }
        if (this.f25782a == null) {
            this.f25782a = context.getApplicationContext();
        }
        if (!UMGlobalContext.getInstance().isMainProcess(this.f25782a)) {
            MLog.e("setFirstLaunchEvent can not be called in child process");
            return;
        }
        if (!this.j || !this.n) {
            a(this.f25782a);
        }
        o.a(this.f25782a).a(list);
    }

    public synchronized void a(Context context, JSONObject jSONObject) {
        String obj;
        Object obj2;
        if (context == null) {
            UMLog.aq(h.ak, 0, "\\|");
            return;
        }
        if (this.f25782a == null) {
            this.f25782a = context.getApplicationContext();
        }
        if (!UMGlobalContext.getInstance().isMainProcess(this.f25782a)) {
            MLog.e("registerPreProperties can not be called in child process");
            return;
        }
        if (!this.j || !this.n) {
            a(this.f25782a);
        }
        if (this.m == null) {
            this.m = new JSONObject();
        }
        if (jSONObject != null && jSONObject.length() > 0) {
            JSONObject jSONObject2 = null;
            try {
                jSONObject2 = new JSONObject(this.m.toString());
            } catch (Exception unused) {
            }
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            Iterator<String> keys = jSONObject.keys();
            if (keys != null) {
                while (keys.hasNext()) {
                    try {
                        obj = keys.next().toString();
                        obj2 = jSONObject.get(obj);
                    } catch (Exception unused2) {
                    }
                    if (b(obj, obj2)) {
                        jSONObject2.put(obj, obj2);
                        if (jSONObject2.length() > 10) {
                            MLog.e("please check propertics, size overlength!");
                            return;
                        }
                        continue;
                    } else {
                        return;
                    }
                }
            }
            this.m = jSONObject2;
            if (this.m.length() > 0) {
                UMWorkDispatch.sendEvent(this.f25782a, k.a.t, CoreProtocol.getInstance(this.f25782a), this.m.toString());
            }
            return;
        }
        UMLog.aq(h.al, 0, "\\|");
    }
}
