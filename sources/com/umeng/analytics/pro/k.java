package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.process.UMProcessDBHelper;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.common.ReportPolicy;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.statistics.internal.StatTracer;
import com.umeng.commonsdk.statistics.noise.ABTest;
import com.umeng.commonsdk.statistics.noise.Defcon;
import com.umeng.commonsdk.utils.JSONArraySortUtil;
import com.umeng.commonsdk.utils.UMUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: CoreProtocolImpl.java */
/* loaded from: classes3.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    private static Context f25909a = null;
    private static final String l = "first_activate_time";
    private static final String m = "ana_is_f";
    private static final String n = "thtstart";
    private static final String o = "dstk_last_time";
    private static final String p = "dstk_cnt";
    private static final String q = "gkvc";
    private static final String r = "ekvc";
    private static final String t = "-1";

    /* renamed from: b, reason: collision with root package name */
    private c f25910b;

    /* renamed from: c, reason: collision with root package name */
    private SharedPreferences f25911c;

    /* renamed from: d, reason: collision with root package name */
    private String f25912d;

    /* renamed from: e, reason: collision with root package name */
    private String f25913e;

    /* renamed from: f, reason: collision with root package name */
    private int f25914f;

    /* renamed from: g, reason: collision with root package name */
    private JSONArray f25915g;

    /* renamed from: h, reason: collision with root package name */
    private final int f25916h;
    private int i;
    private int j;
    private long k;
    private final long s;
    private boolean u;
    private boolean v;
    private Object w;

    /* compiled from: CoreProtocolImpl.java */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static final int f25917a = 4097;

        /* renamed from: b, reason: collision with root package name */
        public static final int f25918b = 4098;

        /* renamed from: c, reason: collision with root package name */
        public static final int f25919c = 4099;

        /* renamed from: d, reason: collision with root package name */
        public static final int f25920d = 4100;

        /* renamed from: e, reason: collision with root package name */
        public static final int f25921e = 4101;

        /* renamed from: f, reason: collision with root package name */
        public static final int f25922f = 4102;

        /* renamed from: g, reason: collision with root package name */
        public static final int f25923g = 4103;

        /* renamed from: h, reason: collision with root package name */
        public static final int f25924h = 4104;
        public static final int i = 4105;
        public static final int j = 4106;
        public static final int k = 4352;
        public static final int l = 4353;
        public static final int m = 4354;
        public static final int n = 8193;
        public static final int o = 8194;
        public static final int p = 8195;
        public static final int q = 8196;
        public static final int r = 8197;
        public static final int s = 8198;
        public static final int t = 8199;
        public static final int u = 8200;
        public static final int v = 8201;
        public static final int w = 8202;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: CoreProtocolImpl.java */
    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final k f25925a = new k();

        private b() {
        }
    }

    public static k a(Context context) {
        if (f25909a == null && context != null) {
            f25909a = context.getApplicationContext();
        }
        return b.f25925a;
    }

    private void e(Object obj) {
        try {
            JSONObject jSONObject = (JSONObject) obj;
            if (2050 == jSONObject.getInt("__t")) {
                if (!a(this.k, this.i)) {
                    return;
                } else {
                    this.i++;
                }
            } else if (2049 == jSONObject.getInt("__t")) {
                if (!a(this.k, this.j)) {
                    return;
                } else {
                    this.j++;
                }
            }
            if (this.f25915g.length() >= this.f25914f) {
                g.a(f25909a).a(this.f25915g);
                this.f25915g = new JSONArray();
            }
            if (this.k == 0) {
                this.k = System.currentTimeMillis();
            }
            this.f25915g.put(jSONObject);
        } catch (Throwable th) {
            MLog.e(th);
        }
    }

    private void h() {
        try {
            Class.forName("com.umeng.analytics.vismode.event.VisualHelper").getMethod("loadNativeData", Context.class).invoke(null, f25909a);
        } catch (Exception unused) {
        }
    }

    private void i() {
        try {
            Class.forName("com.umeng.analytics.vismode.event.VisualHelper").getMethod("processCommond", Context.class, String.class).invoke(null, f25909a, AnalyticsConfig.getAppkey(f25909a));
        } catch (Exception unused) {
        }
    }

    private void j() {
        JSONObject b2 = b(UMEnvelopeBuild.maxDataSpace(f25909a));
        if (b2 == null || b2.length() < 1) {
            return;
        }
        JSONObject jSONObject = (JSONObject) b2.opt("header");
        JSONObject jSONObject2 = (JSONObject) b2.opt("content");
        if (f25909a == null || jSONObject == null || jSONObject2 == null) {
            return;
        }
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> constructInstantMessage: request build envelope.");
        JSONObject buildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(f25909a, jSONObject, jSONObject2);
        if (buildEnvelopeWithExtHeader != null) {
            try {
                if (buildEnvelopeWithExtHeader.has("exception")) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "Build envelope error code: " + buildEnvelopeWithExtHeader.getInt("exception"));
                }
            } catch (Throwable unused) {
            }
            b((Object) buildEnvelopeWithExtHeader);
        }
    }

    private void k() {
        JSONObject buildEnvelopeWithExtHeader;
        JSONObject a2 = a(UMEnvelopeBuild.maxDataSpace(f25909a));
        if (a2 == null || a2.length() < 1) {
            return;
        }
        JSONObject jSONObject = (JSONObject) a2.opt("header");
        JSONObject jSONObject2 = (JSONObject) a2.opt("content");
        Context context = f25909a;
        if (context == null || jSONObject == null || jSONObject2 == null || (buildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(context, jSONObject, jSONObject2)) == null) {
            return;
        }
        try {
            if (buildEnvelopeWithExtHeader.has("exception")) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "Build envelope error code: " + buildEnvelopeWithExtHeader.getInt("exception"));
            }
        } catch (Throwable unused) {
        }
        c(buildEnvelopeWithExtHeader);
        a((Object) buildEnvelopeWithExtHeader);
    }

    private JSONObject l() {
        JSONObject m2 = m();
        if (m2 != null) {
            try {
                m2.put("st", "1");
            } catch (Throwable unused) {
            }
        }
        return m2;
    }

    private JSONObject m() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (AnalyticsConfig.mWrapperType != null && AnalyticsConfig.mWrapperVersion != null) {
                jSONObject.put("wrapper_version", AnalyticsConfig.mWrapperVersion);
                jSONObject.put("wrapper_type", AnalyticsConfig.mWrapperType);
            }
            jSONObject.put(com.umeng.analytics.pro.b.i, AnalyticsConfig.getVerticalType(f25909a));
            jSONObject.put("sdk_version", v.f25973a);
            String MD5 = HelperUtils.MD5(AnalyticsConfig.getSecretKey(f25909a));
            if (!TextUtils.isEmpty(MD5)) {
                jSONObject.put("secret", MD5);
            }
            String imprintProperty = UMEnvelopeBuild.imprintProperty(f25909a, "pr_ve", null);
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f25909a);
            String imprintProperty2 = UMEnvelopeBuild.imprintProperty(f25909a, com.umeng.analytics.pro.b.ak, "");
            if (!TextUtils.isEmpty(imprintProperty2)) {
                if (AnalyticsConfig.CLEAR_EKV_BL) {
                    jSONObject.put(com.umeng.analytics.pro.b.am, "");
                } else {
                    jSONObject.put(com.umeng.analytics.pro.b.am, imprintProperty2);
                }
            }
            String imprintProperty3 = UMEnvelopeBuild.imprintProperty(f25909a, com.umeng.analytics.pro.b.al, "");
            if (!TextUtils.isEmpty(imprintProperty3)) {
                if (AnalyticsConfig.CLEAR_EKV_WL) {
                    jSONObject.put(com.umeng.analytics.pro.b.an, "");
                } else {
                    jSONObject.put(com.umeng.analytics.pro.b.an, imprintProperty3);
                }
            }
            jSONObject.put(com.umeng.analytics.pro.b.ae, "1.0.0");
            if (t()) {
                jSONObject.put(com.umeng.analytics.pro.b.ag, "1");
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putLong(m, 0L).commit();
                }
            }
            jSONObject.put(com.umeng.analytics.pro.b.l, n());
            jSONObject.put(com.umeng.analytics.pro.b.m, o());
            if (sharedPreferences != null) {
                String string = sharedPreferences.getString("vers_name", "");
                if (!TextUtils.isEmpty(string)) {
                    String format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
                    if (TextUtils.isEmpty(imprintProperty)) {
                        jSONObject.put(com.umeng.analytics.pro.b.l, sharedPreferences.getString("vers_pre_version", AppEventsConstants.EVENT_PARAM_VALUE_NO));
                        jSONObject.put(com.umeng.analytics.pro.b.m, sharedPreferences.getString("vers_date", format));
                    }
                    sharedPreferences.edit().putString("pre_version", string).putString("cur_version", DeviceConfig.getAppVersionName(f25909a)).putString("pre_date", format).remove("vers_name").remove("vers_code").remove("vers_date").remove("vers_pre_version").commit();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    private String n() {
        String str;
        String str2 = null;
        try {
            str2 = UMEnvelopeBuild.imprintProperty(f25909a, "pr_ve", null);
        } catch (Throwable unused) {
        }
        if (TextUtils.isEmpty(str2)) {
            if (!TextUtils.isEmpty(this.f25912d)) {
                return this.f25912d;
            }
            if (this.f25911c == null) {
                this.f25911c = PreferenceWrapper.getDefault(f25909a);
            }
            String string = this.f25911c.getString("pre_version", "");
            String appVersionName = DeviceConfig.getAppVersionName(f25909a);
            if (TextUtils.isEmpty(string)) {
                this.f25911c.edit().putString("pre_version", AppEventsConstants.EVENT_PARAM_VALUE_NO).putString("cur_version", appVersionName).commit();
                str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            } else {
                str = this.f25911c.getString("cur_version", "");
                if (appVersionName.equals(str)) {
                    str = string;
                } else {
                    this.f25911c.edit().putString("pre_version", str).putString("cur_version", appVersionName).commit();
                }
            }
            this.f25912d = str;
            return str;
        }
        str = str2;
        this.f25912d = str;
        return str;
    }

    private String o() {
        String str;
        String str2 = null;
        try {
            str2 = UMEnvelopeBuild.imprintProperty(f25909a, "ud_da", null);
        } catch (Throwable unused) {
        }
        if (TextUtils.isEmpty(str2)) {
            if (!TextUtils.isEmpty(this.f25913e)) {
                return this.f25913e;
            }
            if (this.f25911c == null) {
                this.f25911c = PreferenceWrapper.getDefault(f25909a);
            }
            str = this.f25911c.getString("pre_date", "");
            if (TextUtils.isEmpty(str)) {
                str = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
                this.f25911c.edit().putString("pre_date", str).commit();
            } else {
                String format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
                if (!str.equals(format)) {
                    this.f25911c.edit().putString("pre_date", format).commit();
                    str = format;
                }
            }
            this.f25913e = str;
            return str;
        }
        str = str2;
        this.f25913e = str;
        return str;
    }

    private void p() {
        try {
            this.i = 0;
            this.j = 0;
            this.k = System.currentTimeMillis();
            PreferenceWrapper.getDefault(f25909a).edit().putLong(o, System.currentTimeMillis()).putInt(p, 0).commit();
        } catch (Throwable unused) {
        }
    }

    private boolean q() {
        try {
            if (!TextUtils.isEmpty(q.a().b())) {
                b(f25909a);
            }
            if (this.f25915g.length() <= 0) {
                return false;
            }
            for (int i = 0; i < this.f25915g.length(); i++) {
                JSONObject optJSONObject = this.f25915g.optJSONObject(i);
                if (optJSONObject != null && optJSONObject.length() > 0) {
                    String optString = optJSONObject.optString("__i");
                    if (TextUtils.isEmpty(optString) || t.equals(optString)) {
                        return false;
                    }
                }
            }
            return true;
        } catch (Throwable unused) {
            return true;
        }
    }

    private void r() {
        if (this.f25915g.length() > 0) {
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < this.f25915g.length(); i++) {
                try {
                    JSONObject jSONObject = this.f25915g.getJSONObject(i);
                    if (jSONObject != null && jSONObject.length() > 0) {
                        String optString = jSONObject.optString("__i");
                        if (TextUtils.isEmpty(optString) || t.equals(optString)) {
                            String b2 = q.a().b();
                            if (TextUtils.isEmpty(b2)) {
                                b2 = t;
                            }
                            jSONObject.put("__i", b2);
                        }
                        jSONArray.put(jSONObject);
                    } else {
                        jSONArray.put(jSONObject);
                    }
                } catch (Throwable unused) {
                }
            }
            this.f25915g = jSONArray;
        }
    }

    private void s() {
        SharedPreferences sharedPreferences;
        try {
            if (!t() || f25909a == null || (sharedPreferences = PreferenceWrapper.getDefault(f25909a)) == null || sharedPreferences.getLong(l, 0L) != 0) {
                return;
            }
            sharedPreferences.edit().putLong(l, System.currentTimeMillis()).commit();
        } catch (Throwable unused) {
        }
    }

    private boolean t() {
        SharedPreferences sharedPreferences;
        try {
            if (f25909a == null || (sharedPreferences = PreferenceWrapper.getDefault(f25909a)) == null) {
                return false;
            }
            return sharedPreferences.getLong(m, -1L) != 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    public JSONObject b(long j) {
        if (TextUtils.isEmpty(u.a().d(UMGlobalContext.getAppContext(f25909a)))) {
            return null;
        }
        JSONObject b2 = g.a(UMGlobalContext.getAppContext(f25909a)).b(false);
        String[] a2 = com.umeng.analytics.c.a(f25909a);
        if (a2 != null && !TextUtils.isEmpty(a2[0]) && !TextUtils.isEmpty(a2[1])) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(com.umeng.analytics.pro.b.L, a2[0]);
                jSONObject.put(com.umeng.analytics.pro.b.M, a2[1]);
                if (jSONObject.length() > 0) {
                    b2.put(com.umeng.analytics.pro.b.K, jSONObject);
                }
            } catch (Throwable unused) {
            }
        }
        int a3 = n.a().a(f25909a);
        if (b2.length() == 1 && b2.optJSONObject(com.umeng.analytics.pro.b.K) != null && a3 != 3) {
            return null;
        }
        n.a().b(b2, f25909a);
        if (b2.length() <= 0 && a3 != 3) {
            return null;
        }
        JSONObject l2 = l();
        if (l2 != null) {
            a(l2);
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            if (a3 == 3) {
                jSONObject3.put("analytics", new JSONObject());
            } else if (b2 != null && b2.length() > 0) {
                jSONObject3.put("analytics", b2);
            }
            if (l2 != null && l2.length() > 0) {
                jSONObject2.put("header", l2);
            }
            if (jSONObject3.length() > 0) {
                jSONObject2.put("content", jSONObject3);
            }
            return b(jSONObject2, j);
        } catch (Throwable unused2) {
            return jSONObject2;
        }
    }

    public void b() {
    }

    public void c() {
        b(f25909a);
        d();
        a(true);
    }

    public void d() {
        try {
            if (this.f25915g.length() > 0) {
                g.a(f25909a).a(this.f25915g);
                this.f25915g = new JSONArray();
            }
            PreferenceWrapper.getDefault(f25909a).edit().putLong(n, this.k).putInt(q, this.i).putInt(r, this.j).commit();
        } catch (Throwable unused) {
        }
    }

    public long f() {
        SharedPreferences sharedPreferences;
        long j = 0;
        try {
            if (f25909a == null || (sharedPreferences = PreferenceWrapper.getDefault(f25909a)) == null) {
                return 0L;
            }
            long j2 = sharedPreferences.getLong(l, 0L);
            if (j2 == 0) {
                try {
                    j = System.currentTimeMillis();
                    sharedPreferences.edit().putLong(l, j).commit();
                    return j;
                } catch (Throwable unused) {
                }
            }
            return j2;
        } catch (Throwable unused2) {
            return j;
        }
    }

    private k() {
        this.f25910b = null;
        this.f25911c = null;
        this.f25912d = null;
        this.f25913e = null;
        this.f25914f = 10;
        this.f25915g = new JSONArray();
        this.f25916h = 5000;
        this.i = 0;
        this.j = 0;
        this.k = 0L;
        this.s = 28800000L;
        this.u = false;
        this.v = false;
        this.w = new Object();
        try {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f25909a);
            this.k = sharedPreferences.getLong(n, 0L);
            this.i = sharedPreferences.getInt(q, 0);
            this.j = sharedPreferences.getInt(r, 0);
            this.f25910b = new c();
        } catch (Throwable unused) {
        }
    }

    private void g(Object obj) {
        try {
            b(f25909a);
            d();
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject != null && jSONObject.length() > 0) {
                String string = jSONObject.getString(com.umeng.analytics.pro.b.L);
                String string2 = jSONObject.getString("uid");
                long j = jSONObject.getLong("ts");
                String[] a2 = com.umeng.analytics.c.a(f25909a);
                if (a2 != null && string.equals(a2[0]) && string2.equals(a2[1])) {
                    return;
                }
                q.a().a(f25909a, j);
                String c2 = u.a().c(f25909a);
                boolean b2 = q.a().b(f25909a, j);
                com.umeng.analytics.c.a(f25909a, string, string2);
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onProfileSignIn: force generate new session: session id = " + c2);
                q.a().a(f25909a, j, true);
                if (b2) {
                    q.a().c(f25909a, j);
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* compiled from: CoreProtocolImpl.java */
    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private ReportPolicy.ReportStrategy f25926a = null;

        /* renamed from: b, reason: collision with root package name */
        private int f25927b = -1;

        /* renamed from: c, reason: collision with root package name */
        private int f25928c = -1;

        /* renamed from: d, reason: collision with root package name */
        private int f25929d = -1;

        /* renamed from: e, reason: collision with root package name */
        private int f25930e = -1;

        /* renamed from: f, reason: collision with root package name */
        private ABTest f25931f;

        public c() {
            this.f25931f = null;
            this.f25931f = ABTest.getService(k.f25909a);
        }

        public void a() {
            try {
                int[] a2 = a(-1, -1);
                this.f25927b = a2[0];
                this.f25928c = a2[1];
            } catch (Throwable unused) {
            }
        }

        protected void b() {
            int i;
            ReportPolicy.ReportStrategy defconPolicy;
            Defcon service = Defcon.getService(k.f25909a);
            if (!service.isOpen()) {
                boolean z = Integer.valueOf(UMEnvelopeBuild.imprintProperty(k.f25909a, "integrated_test", k.t)).intValue() == 1;
                if (UMConfigure.isDebugLog() && z && !MLog.DEBUG) {
                    UMLog.mutlInfo(h.J, 3, "\\|", null, null);
                }
                if (MLog.DEBUG && z) {
                    this.f25926a = new ReportPolicy.DebugPolicy(StatTracer.getInstance(k.f25909a));
                } else if (this.f25931f.isInTest() && "RPT".equals(this.f25931f.getTestName())) {
                    if (this.f25931f.getTestPolicy() == 6) {
                        if (Integer.valueOf(UMEnvelopeBuild.imprintProperty(k.f25909a, "test_report_interval", k.t)).intValue() != -1) {
                            i = a(90000);
                        } else {
                            i = this.f25928c;
                            if (i <= 0) {
                                i = this.f25930e;
                            }
                        }
                    } else {
                        i = 0;
                    }
                    this.f25926a = b(this.f25931f.getTestPolicy(), i);
                } else {
                    int i2 = this.f25929d;
                    int i3 = this.f25930e;
                    int i4 = this.f25927b;
                    if (i4 != -1) {
                        i3 = this.f25928c;
                        i2 = i4;
                    }
                    this.f25926a = b(i2, i3);
                }
            } else {
                ReportPolicy.ReportStrategy reportStrategy = this.f25926a;
                if (!((reportStrategy instanceof ReportPolicy.DefconPolicy) && reportStrategy.isValid())) {
                    defconPolicy = new ReportPolicy.DefconPolicy(StatTracer.getInstance(k.f25909a), service);
                } else {
                    defconPolicy = this.f25926a;
                }
                this.f25926a = defconPolicy;
            }
            if (UMConfigure.isDebugLog()) {
                try {
                    if (this.f25926a instanceof ReportPolicy.ReportAtLaunch) {
                        UMLog.mutlInfo(h.H, 3, "", null, null);
                    } else if (this.f25926a instanceof ReportPolicy.ReportByInterval) {
                        UMLog.mutlInfo(h.I, 3, "", new String[]{"@"}, new String[]{String.valueOf(((ReportPolicy.ReportByInterval) this.f25926a).getReportInterval() / 1000)});
                    } else if (this.f25926a instanceof ReportPolicy.DebugPolicy) {
                        UMLog.mutlInfo(h.K, 3, "", null, null);
                    } else if (this.f25926a instanceof ReportPolicy.ReportQuasiRealtime) {
                        String[] strArr = {String.valueOf(((ReportPolicy.ReportQuasiRealtime) this.f25926a).getReportInterval() / 1000)};
                        UMLog uMLog = UMConfigure.umDebugLog;
                        UMLog.mutlInfo(h.L, 3, "", new String[]{"@"}, strArr);
                    } else {
                        boolean z2 = this.f25926a instanceof ReportPolicy.DefconPolicy;
                    }
                } catch (Throwable unused) {
                }
            }
        }

        public ReportPolicy.ReportStrategy c() {
            b();
            return this.f25926a;
        }

        public int[] a(int i, int i2) {
            int intValue = Integer.valueOf(UMEnvelopeBuild.imprintProperty(k.f25909a, "report_policy", k.t)).intValue();
            int intValue2 = Integer.valueOf(UMEnvelopeBuild.imprintProperty(k.f25909a, "report_interval", k.t)).intValue();
            if (intValue == -1 || !ReportPolicy.isValid(intValue)) {
                return new int[]{i, i2};
            }
            if (6 == intValue) {
                int i3 = 90;
                if (intValue2 != -1 && intValue2 >= 90 && intValue2 <= 86400) {
                    i3 = intValue2;
                }
                return new int[]{intValue, i3 * 1000};
            }
            if (11 == intValue) {
                int i4 = 15;
                if (intValue2 != -1 && intValue2 >= 15 && intValue2 <= 3600) {
                    i4 = intValue2;
                }
                return new int[]{intValue, i4 * 1000};
            }
            return new int[]{i, i2};
        }

        public int a(int i) {
            int intValue = Integer.valueOf(UMEnvelopeBuild.imprintProperty(k.f25909a, "test_report_interval", k.t)).intValue();
            return (intValue == -1 || intValue < 90 || intValue > 86400) ? i : intValue * 1000;
        }

        private ReportPolicy.ReportStrategy b(int i, int i2) {
            if (i == 0) {
                ReportPolicy.ReportStrategy reportStrategy = this.f25926a;
                return reportStrategy instanceof ReportPolicy.ReportRealtime ? reportStrategy : new ReportPolicy.ReportRealtime();
            }
            if (i == 1) {
                ReportPolicy.ReportStrategy reportStrategy2 = this.f25926a;
                return reportStrategy2 instanceof ReportPolicy.ReportAtLaunch ? reportStrategy2 : new ReportPolicy.ReportAtLaunch();
            }
            if (i == 4) {
                ReportPolicy.ReportStrategy reportStrategy3 = this.f25926a;
                return reportStrategy3 instanceof ReportPolicy.ReportDaily ? reportStrategy3 : new ReportPolicy.ReportDaily(StatTracer.getInstance(k.f25909a));
            }
            if (i == 5) {
                ReportPolicy.ReportStrategy reportStrategy4 = this.f25926a;
                return reportStrategy4 instanceof ReportPolicy.ReportWifiOnly ? reportStrategy4 : new ReportPolicy.ReportWifiOnly(k.f25909a);
            }
            if (i == 6) {
                ReportPolicy.ReportStrategy reportStrategy5 = this.f25926a;
                if (reportStrategy5 instanceof ReportPolicy.ReportByInterval) {
                    ((ReportPolicy.ReportByInterval) reportStrategy5).setReportInterval(i2);
                    return reportStrategy5;
                }
                return new ReportPolicy.ReportByInterval(StatTracer.getInstance(k.f25909a), i2);
            }
            if (i == 8) {
                ReportPolicy.ReportStrategy reportStrategy6 = this.f25926a;
                return reportStrategy6 instanceof ReportPolicy.SmartPolicy ? reportStrategy6 : new ReportPolicy.SmartPolicy(StatTracer.getInstance(k.f25909a));
            }
            if (i != 11) {
                ReportPolicy.ReportStrategy reportStrategy7 = this.f25926a;
                return reportStrategy7 instanceof ReportPolicy.ReportAtLaunch ? reportStrategy7 : new ReportPolicy.ReportAtLaunch();
            }
            ReportPolicy.ReportStrategy reportStrategy8 = this.f25926a;
            if (reportStrategy8 instanceof ReportPolicy.ReportQuasiRealtime) {
                ((ReportPolicy.ReportQuasiRealtime) reportStrategy8).setReportInterval(i2);
                return reportStrategy8;
            }
            ReportPolicy.ReportQuasiRealtime reportQuasiRealtime = new ReportPolicy.ReportQuasiRealtime();
            reportQuasiRealtime.setReportInterval(i2);
            return reportQuasiRealtime;
        }
    }

    private boolean c(boolean z) {
        if (t()) {
            return true;
        }
        if (this.f25910b == null) {
            this.f25910b = new c();
        }
        this.f25910b.a();
        ReportPolicy.ReportStrategy c2 = this.f25910b.c();
        MLog.d("Report policy : " + c2.getClass().getSimpleName());
        boolean shouldSendMessage = c2.shouldSendMessage(z);
        if (shouldSendMessage) {
            if (((c2 instanceof ReportPolicy.ReportByInterval) || (c2 instanceof ReportPolicy.DebugPolicy) || (c2 instanceof ReportPolicy.ReportQuasiRealtime)) && q()) {
                d();
            }
            if ((c2 instanceof ReportPolicy.DefconPolicy) && q()) {
                d();
            }
        }
        return shouldSendMessage;
    }

    private void h(Object obj) {
        try {
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject == null || jSONObject.length() <= 0 || !jSONObject.has("__ii")) {
                return;
            }
            String optString = jSONObject.optString("__ii");
            jSONObject.remove("__ii");
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            g.a(f25909a).a(optString, obj.toString(), 2);
        } catch (Throwable unused) {
        }
    }

    public void a() {
        if (f25909a != null) {
            synchronized (this.w) {
                if (this.u) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> network is now available, rebuild instant session data packet.");
                    UMWorkDispatch.sendEvent(f25909a, a.l, CoreProtocol.getInstance(f25909a), null);
                }
            }
            synchronized (this.w) {
                if (this.v) {
                    UMWorkDispatch.sendEvent(f25909a, a.m, CoreProtocol.getInstance(f25909a), null);
                }
            }
        }
    }

    /* compiled from: CoreProtocolImpl.java */
    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        private Map<String, Object> f25932a;

        /* renamed from: b, reason: collision with root package name */
        private String f25933b;

        /* renamed from: c, reason: collision with root package name */
        private String f25934c;

        /* renamed from: d, reason: collision with root package name */
        private long f25935d;

        private d() {
            this.f25932a = null;
            this.f25933b = null;
            this.f25934c = null;
            this.f25935d = 0L;
        }

        public Map<String, Object> a() {
            return this.f25932a;
        }

        public String b() {
            return this.f25934c;
        }

        public String c() {
            return this.f25933b;
        }

        public long d() {
            return this.f25935d;
        }

        public d(String str, Map<String, Object> map, String str2, long j) {
            this.f25932a = null;
            this.f25933b = null;
            this.f25934c = null;
            this.f25935d = 0L;
            this.f25932a = map;
            this.f25933b = str;
            this.f25935d = j;
            this.f25934c = str2;
        }
    }

    private void f(Object obj) {
        try {
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject != null && jSONObject.length() > 0) {
                long j = jSONObject.getLong("ts");
                b(f25909a);
                d();
                String[] a2 = com.umeng.analytics.c.a(f25909a);
                if (a2 == null || TextUtils.isEmpty(a2[0]) || TextUtils.isEmpty(a2[1])) {
                    return;
                }
                q.a().a(f25909a, j);
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onProfileSignIn: force generate new session: session id = " + u.a().c(f25909a));
                boolean b2 = q.a().b(f25909a, j);
                com.umeng.analytics.c.b(f25909a);
                q.a().a(f25909a, j, true);
                if (b2) {
                    q.a().c(f25909a, j);
                }
            }
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(" Excepthon  in  onProfileSignOff", th);
            }
        }
    }

    private void d(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        try {
            if (jSONObject.getJSONObject("header").has(com.umeng.analytics.pro.b.ay)) {
                if (jSONObject.has("content")) {
                    jSONObject = jSONObject.getJSONObject("content");
                }
                if (jSONObject.has("analytics")) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("analytics");
                    if (jSONObject2.has(com.umeng.analytics.pro.b.n) && (optJSONObject2 = jSONObject2.getJSONArray(com.umeng.analytics.pro.b.n).optJSONObject(0)) != null) {
                        String optString = optJSONObject2.optString("id");
                        if (!TextUtils.isEmpty(optString)) {
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> removeAllInstantData: really delete instant session data");
                            g.a(f25909a).b(optString);
                        }
                    }
                }
                g.a(f25909a).b();
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> removeAllInstantData: send INSTANT_SESSION_START_CONTINUE event because OVERSIZE.");
                UMWorkDispatch.sendEvent(f25909a, a.l, CoreProtocol.getInstance(f25909a), null);
                return;
            }
            if (jSONObject.has("content")) {
                jSONObject = jSONObject.getJSONObject("content");
            }
            if (jSONObject.has("analytics") && (optJSONObject = jSONObject.optJSONObject("analytics")) != null && optJSONObject.length() > 0 && optJSONObject.has(com.umeng.analytics.pro.b.n)) {
                g.a(f25909a).a(true, false);
            }
            g.a(f25909a).b();
        } catch (Exception unused) {
        }
    }

    private void e(JSONObject jSONObject) {
        JSONObject optJSONObject;
        try {
            if (jSONObject.getJSONObject("header").has(com.umeng.analytics.pro.b.ay)) {
                if (jSONObject.has("content")) {
                    jSONObject = jSONObject.getJSONObject("content");
                }
                if (jSONObject.has("analytics")) {
                    if (jSONObject.getJSONObject("analytics").has(com.umeng.analytics.pro.b.n)) {
                        g.a(f25909a).i();
                        g.a(f25909a).h();
                        g.a(f25909a).b(true, false);
                        g.a(f25909a).a();
                        return;
                    }
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> Error, Should not go to this branch.");
                    return;
                }
                return;
            }
            if (jSONObject.has("content")) {
                jSONObject = jSONObject.getJSONObject("content");
            }
            if (jSONObject.has("analytics") && (optJSONObject = jSONObject.optJSONObject("analytics")) != null && optJSONObject.length() > 0) {
                if (optJSONObject.has(com.umeng.analytics.pro.b.n)) {
                    g.a(f25909a).b(true, false);
                }
                if (optJSONObject.has(com.umeng.analytics.pro.b.R) || optJSONObject.has(com.umeng.analytics.pro.b.S)) {
                    g.a(f25909a).h();
                }
                if (optJSONObject.has("error")) {
                    g.a(f25909a).i();
                }
            }
            g.a(f25909a).a();
        } catch (Exception unused) {
        }
    }

    private void c(JSONObject jSONObject) {
        String str;
        JSONObject jSONObject2;
        JSONArray jSONArray;
        if (jSONObject == null) {
            return;
        }
        try {
            if (jSONObject.length() <= 0) {
                return;
            }
            JSONObject jSONObject3 = new JSONObject();
            if (jSONObject.has("analytics")) {
                JSONObject jSONObject4 = jSONObject.getJSONObject("analytics");
                if (jSONObject4.has(com.umeng.analytics.pro.b.R)) {
                    str = "appkey";
                    jSONObject3.put(com.umeng.analytics.pro.b.R, jSONObject4.getJSONArray(com.umeng.analytics.pro.b.R));
                } else {
                    str = "appkey";
                }
                if (jSONObject4.has(com.umeng.analytics.pro.b.S)) {
                    jSONObject3.put(com.umeng.analytics.pro.b.S, jSONObject4.getJSONArray(com.umeng.analytics.pro.b.S));
                }
                if (jSONObject4.has("error")) {
                    jSONObject3.put("error", jSONObject4.getJSONArray("error"));
                }
                if (jSONObject4.has(com.umeng.analytics.pro.b.n)) {
                    JSONArray jSONArray2 = jSONObject4.getJSONArray(com.umeng.analytics.pro.b.n);
                    JSONArray jSONArray3 = new JSONArray();
                    int i = 0;
                    while (i < jSONArray2.length()) {
                        JSONObject jSONObject5 = jSONArray2.getJSONObject(i);
                        if (jSONObject5 == null || jSONObject5.length() <= 0) {
                            jSONArray = jSONArray2;
                        } else {
                            jSONArray = jSONArray2;
                            if (jSONObject5.has(com.umeng.analytics.pro.b.t)) {
                                jSONObject5.remove(com.umeng.analytics.pro.b.t);
                            }
                            jSONArray3.put(jSONObject5);
                        }
                        i++;
                        jSONArray2 = jSONArray;
                    }
                    jSONObject3.put(com.umeng.analytics.pro.b.n, jSONArray3);
                }
                if (jSONObject4.has(com.umeng.analytics.pro.b.H)) {
                    jSONObject3.put(com.umeng.analytics.pro.b.H, jSONObject4.getJSONObject(com.umeng.analytics.pro.b.H));
                }
                if (jSONObject4.has(com.umeng.analytics.pro.b.K)) {
                    jSONObject3.put(com.umeng.analytics.pro.b.K, jSONObject4.getJSONObject(com.umeng.analytics.pro.b.K));
                }
            } else {
                str = "appkey";
            }
            if (jSONObject.has("dplus")) {
                jSONObject3.put("dplus", jSONObject.getJSONObject("dplus"));
            }
            if (jSONObject.has("header") && jSONObject.has("header") && (jSONObject2 = jSONObject.getJSONObject("header")) != null && jSONObject2.length() > 0) {
                if (jSONObject2.has("sdk_version")) {
                    jSONObject3.put("sdk_version", jSONObject2.getString("sdk_version"));
                }
                if (jSONObject2.has("device_id")) {
                    jSONObject3.put("device_id", jSONObject2.getString("device_id"));
                }
                if (jSONObject2.has("device_model")) {
                    jSONObject3.put("device_model", jSONObject2.getString("device_model"));
                }
                if (jSONObject2.has("version_code")) {
                    jSONObject3.put(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, jSONObject2.getInt("version_code"));
                }
                String str2 = str;
                if (jSONObject2.has(str2)) {
                    jSONObject3.put(str2, jSONObject2.getString(str2));
                }
                if (jSONObject2.has("channel")) {
                    jSONObject3.put("channel", jSONObject2.getString("channel"));
                }
            }
            if (jSONObject3.length() > 0) {
                MLog.d("constructMessage:" + jSONObject3.toString());
                UMRTLog.i(UMRTLog.RTLOG_TAG, "constructMessage: " + jSONObject3.toString());
            }
        } catch (Throwable th) {
            MLog.e(th);
        }
    }

    public void a(Object obj, int i) {
        try {
            switch (i) {
                case 4097:
                    if (UMGlobalContext.getInstance().isMainProcess(f25909a)) {
                        if (obj != null) {
                            e(obj);
                        }
                        if (t.equals(((JSONObject) obj).optString("__i"))) {
                            return;
                        }
                        a(false);
                        return;
                    }
                    UMProcessDBHelper.getInstance(f25909a).insertEventsInSubProcess(UMFrUtils.getSubProcessName(f25909a), new JSONArray().put(obj));
                    return;
                case 4098:
                    if (obj != null) {
                        e(obj);
                    }
                    if (t.equals(((JSONObject) obj).optString("__i"))) {
                        return;
                    }
                    a(false);
                    return;
                case 4099:
                    r.a(f25909a);
                    return;
                case a.f25920d /* 4100 */:
                    j.a(f25909a);
                    return;
                case a.f25921e /* 4101 */:
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> PROFILE_SIGNIN");
                    g(obj);
                    return;
                case a.f25922f /* 4102 */:
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> PROFILE_SIGNOFF");
                    f(obj);
                    return;
                case a.f25923g /* 4103 */:
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> START_SESSION");
                    q.a().a(f25909a, obj);
                    synchronized (this.w) {
                        this.v = true;
                    }
                    return;
                case a.f25924h /* 4104 */:
                    q.a().c(f25909a, obj);
                    return;
                case a.i /* 4105 */:
                    d();
                    return;
                case a.j /* 4106 */:
                    h(obj);
                    return;
                default:
                    switch (i) {
                        case a.k /* 4352 */:
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> INSTANT_SESSION_START");
                            q.a().b(f25909a, obj);
                            synchronized (this.w) {
                                this.u = true;
                            }
                            return;
                        case a.l /* 4353 */:
                            a(obj, true);
                            return;
                        case a.m /* 4354 */:
                            c();
                            return;
                        default:
                            switch (i) {
                                case a.p /* 8195 */:
                                    com.umeng.analytics.b.a().a(obj);
                                    return;
                                case a.q /* 8196 */:
                                    com.umeng.analytics.b.a().m();
                                    return;
                                case a.r /* 8197 */:
                                    com.umeng.analytics.b.a().k();
                                    return;
                                case a.s /* 8198 */:
                                    if (TextUtils.isEmpty(q.a().b())) {
                                        return;
                                    }
                                    i();
                                    return;
                                case a.t /* 8199 */:
                                case a.u /* 8200 */:
                                    com.umeng.analytics.b.a().b(obj);
                                    return;
                                case a.v /* 8201 */:
                                    com.umeng.analytics.b.a().b((Object) null);
                                    return;
                                case a.w /* 8202 */:
                                    h();
                                    return;
                                default:
                                    return;
                            }
                    }
            }
        } catch (Throwable unused) {
        }
    }

    private JSONObject b(JSONObject jSONObject, long j) {
        try {
            if (m.a(jSONObject) <= j) {
                return jSONObject;
            }
            jSONObject = null;
            g.a(f25909a).a(true, false);
            g.a(f25909a).b();
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> Instant session packet overload !!! ");
            return null;
        } catch (Throwable unused) {
            return jSONObject;
        }
    }

    private void b(JSONObject jSONObject) {
        try {
            if (!g.a(f25909a).e()) {
                JSONObject g2 = g.a(f25909a).g();
                if (g2 != null) {
                    String optString = g2.optString("__av");
                    String optString2 = g2.optString("__vc");
                    if (TextUtils.isEmpty(optString)) {
                        jSONObject.put("app_version", UMUtils.getAppVersionName(f25909a));
                    } else {
                        jSONObject.put("app_version", optString);
                    }
                    if (TextUtils.isEmpty(optString2)) {
                        jSONObject.put("version_code", UMUtils.getAppVersionCode(f25909a));
                        return;
                    } else {
                        jSONObject.put("version_code", optString2);
                        return;
                    }
                }
                return;
            }
            jSONObject.put("app_version", UMUtils.getAppVersionName(f25909a));
            jSONObject.put("version_code", UMUtils.getAppVersionCode(f25909a));
        } catch (Throwable unused) {
        }
    }

    public void d(Object obj) {
        s();
        n();
        o();
        a(true);
    }

    private boolean d(boolean z) {
        if (this.f25910b == null) {
            this.f25910b = new c();
        }
        ReportPolicy.ReportStrategy c2 = this.f25910b.c();
        if (!(c2 instanceof ReportPolicy.DefconPolicy)) {
            return true;
        }
        if (z) {
            return ((ReportPolicy.DefconPolicy) c2).shouldSendMessageByInstant();
        }
        return c2.shouldSendMessage(false);
    }

    public void e() {
        if (d(false)) {
            k();
        }
    }

    public JSONObject b(boolean z) {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        JSONObject jSONObject = null;
        try {
            jSONObject = g.a(f25909a).a(z);
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            } else {
                try {
                    boolean has = jSONObject.has(com.umeng.analytics.pro.b.n);
                    jSONObject = jSONObject;
                    if (has) {
                        JSONArray jSONArray3 = jSONObject.getJSONArray(com.umeng.analytics.pro.b.n);
                        JSONArray jSONArray4 = new JSONArray();
                        int i = 0;
                        while (i < jSONArray3.length()) {
                            JSONObject jSONObject2 = (JSONObject) jSONArray3.get(i);
                            JSONArray optJSONArray = jSONObject2.optJSONArray(com.umeng.analytics.pro.b.s);
                            JSONArray optJSONArray2 = jSONObject2.optJSONArray(com.umeng.analytics.pro.b.t);
                            if (optJSONArray == null && optJSONArray2 != null) {
                                jSONObject2.put(com.umeng.analytics.pro.b.s, optJSONArray2);
                                jSONObject2.remove(com.umeng.analytics.pro.b.t);
                            }
                            if (optJSONArray != null && optJSONArray2 != null) {
                                ArrayList arrayList = new ArrayList();
                                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                                    arrayList.add((JSONObject) optJSONArray.get(i2));
                                }
                                for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                                    arrayList.add((JSONObject) optJSONArray2.get(i3));
                                }
                                JSONArraySortUtil jSONArraySortUtil = new JSONArraySortUtil();
                                jSONArraySortUtil.setCompareKey(com.umeng.analytics.pro.b.w);
                                Collections.sort(arrayList, jSONArraySortUtil);
                                JSONArray jSONArray5 = new JSONArray();
                                Iterator it = arrayList.iterator();
                                while (it.hasNext()) {
                                    jSONArray5.put((JSONObject) it.next());
                                }
                                jSONObject2.put(com.umeng.analytics.pro.b.s, jSONArray5);
                                jSONObject2.remove(com.umeng.analytics.pro.b.t);
                            }
                            if (jSONObject2.has(com.umeng.analytics.pro.b.s)) {
                                JSONArray optJSONArray3 = jSONObject2.optJSONArray(com.umeng.analytics.pro.b.s);
                                int i4 = 0;
                                while (i4 < optJSONArray3.length()) {
                                    JSONObject jSONObject3 = optJSONArray3.getJSONObject(i4);
                                    if (jSONObject3.has(com.umeng.analytics.pro.b.w)) {
                                        jSONArray2 = jSONArray3;
                                        jSONObject3.put("ts", jSONObject3.getLong(com.umeng.analytics.pro.b.w));
                                        jSONObject3.remove(com.umeng.analytics.pro.b.w);
                                    } else {
                                        jSONArray2 = jSONArray3;
                                    }
                                    i4++;
                                    jSONArray3 = jSONArray2;
                                }
                                jSONArray = jSONArray3;
                                jSONObject2.put(com.umeng.analytics.pro.b.s, optJSONArray3);
                                jSONObject2.put(com.umeng.analytics.pro.b.y, optJSONArray3.length());
                            } else {
                                jSONArray = jSONArray3;
                                jSONObject2.put(com.umeng.analytics.pro.b.y, 0);
                            }
                            jSONArray4.put(jSONObject2);
                            i++;
                            jSONArray3 = jSONArray;
                        }
                        jSONObject.put(com.umeng.analytics.pro.b.n, jSONArray4);
                        jSONObject = jSONObject;
                    }
                } catch (Exception e2) {
                    MLog.e("merge pages error");
                    e2.printStackTrace();
                    jSONObject = jSONObject;
                }
            }
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f25909a);
            if (sharedPreferences != null) {
                String string = sharedPreferences.getString("userlevel", "");
                if (!TextUtils.isEmpty(string)) {
                    jSONObject.put("userlevel", string);
                }
            }
            String[] a2 = com.umeng.analytics.c.a(f25909a);
            if (a2 != null && !TextUtils.isEmpty(a2[0]) && !TextUtils.isEmpty(a2[1])) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put(com.umeng.analytics.pro.b.L, a2[0]);
                jSONObject4.put(com.umeng.analytics.pro.b.M, a2[1]);
                if (jSONObject4.length() > 0) {
                    jSONObject.put(com.umeng.analytics.pro.b.K, jSONObject4);
                }
            }
            if (ABTest.getService(f25909a).isInTest()) {
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put(ABTest.getService(f25909a).getTestName(), ABTest.getService(f25909a).getGroupInfo());
                jSONObject.put(com.umeng.analytics.pro.b.J, jSONObject5);
            }
            n.a().a(jSONObject, f25909a);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public void a(boolean z) {
        if (c(z)) {
            if (!(this.f25910b.c() instanceof ReportPolicy.ReportQuasiRealtime)) {
                if (UMEnvelopeBuild.isReadyBuild(f25909a, UMLogDataProtocol.UMBusinessType.U_APP)) {
                    k();
                }
            } else {
                if (z) {
                    if (UMEnvelopeBuild.isOnline(f25909a)) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> send session start in policy ReportQuasiRealtime.");
                        k();
                        return;
                    }
                    return;
                }
                if (UMEnvelopeBuild.isReadyBuild(f25909a, UMLogDataProtocol.UMBusinessType.U_APP)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> send normal data in policy ReportQuasiRealtime.");
                    k();
                }
            }
        }
    }

    public void c(Object obj) {
        b(f25909a);
        d();
        if (d(false)) {
            k();
        }
    }

    public JSONObject a(long j) {
        if (TextUtils.isEmpty(u.a().d(f25909a))) {
            return null;
        }
        JSONObject b2 = b(false);
        int a2 = n.a().a(f25909a);
        if (b2.length() <= 0) {
            if (a2 != 3) {
                return null;
            }
        } else if (b2.length() == 1) {
            if (b2.optJSONObject(com.umeng.analytics.pro.b.K) != null && a2 != 3) {
                return null;
            }
            if (!TextUtils.isEmpty(b2.optString("userlevel")) && a2 != 3) {
                return null;
            }
        } else if (b2.length() == 2 && b2.optJSONObject(com.umeng.analytics.pro.b.K) != null && !TextUtils.isEmpty(b2.optString("userlevel")) && a2 != 3) {
            return null;
        }
        JSONObject m2 = m();
        if (m2 != null) {
            b(m2);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (a2 == 3) {
                jSONObject2.put("analytics", new JSONObject());
            } else if (b2 != null && b2.length() > 0) {
                jSONObject2.put("analytics", b2);
            }
            if (m2 != null && m2.length() > 0) {
                jSONObject.put("header", m2);
            }
            if (jSONObject2.length() > 0) {
                jSONObject.put("content", jSONObject2);
            }
            return a(jSONObject, j);
        } catch (Throwable unused) {
            return jSONObject;
        }
    }

    private void a(JSONObject jSONObject) {
        JSONObject f2;
        if (g.a(UMGlobalContext.getAppContext(f25909a)).c() || (f2 = g.a(UMGlobalContext.getAppContext(f25909a)).f()) == null) {
            return;
        }
        String optString = f2.optString("__av");
        String optString2 = f2.optString("__vc");
        try {
            if (TextUtils.isEmpty(optString)) {
                jSONObject.put("app_version", UMUtils.getAppVersionName(f25909a));
            } else {
                jSONObject.put("app_version", optString);
            }
            if (TextUtils.isEmpty(optString2)) {
                jSONObject.put("version_code", UMUtils.getAppVersionCode(f25909a));
            } else {
                jSONObject.put("version_code", optString2);
            }
        } catch (Throwable unused) {
        }
    }

    public void b(Object obj) {
        if (obj != null) {
            try {
                JSONObject jSONObject = (JSONObject) obj;
                if (jSONObject.length() > 0) {
                    if (jSONObject.has("exception")) {
                        if (101 != jSONObject.getInt("exception")) {
                            d(jSONObject);
                        }
                    } else {
                        d(jSONObject);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void b(Context context) {
        try {
            g.a(context).d();
            r();
        } catch (Throwable unused) {
        }
    }

    private JSONObject a(JSONObject jSONObject, long j) {
        try {
            if (m.a(jSONObject) <= j) {
                return jSONObject;
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject("header");
            jSONObject2.put(com.umeng.analytics.pro.b.ay, m.a(jSONObject));
            jSONObject.put("header", jSONObject2);
            return m.a(f25909a, j, jSONObject);
        } catch (Throwable unused) {
            return jSONObject;
        }
    }

    private boolean a(long j, int i) {
        if (j == 0) {
            return true;
        }
        if (System.currentTimeMillis() - j <= 28800000) {
            return i < 5000;
        }
        p();
        return true;
    }

    public void a(Object obj) {
        if (obj != null) {
            try {
                JSONObject jSONObject = (JSONObject) obj;
                if (jSONObject.length() > 0) {
                    if (jSONObject.has("exception")) {
                        if (101 != jSONObject.getInt("exception")) {
                            e(jSONObject);
                        }
                    } else {
                        e(jSONObject);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void a(Object obj, boolean z) {
        if (z) {
            if (d(true)) {
                j();
            }
        } else if (UMEnvelopeBuild.isOnline(f25909a) && d(true)) {
            j();
        }
    }
}
