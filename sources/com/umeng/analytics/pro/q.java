package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.pro.c;
import com.umeng.analytics.pro.g;
import com.umeng.analytics.pro.u;
import com.umeng.analytics.process.UMProcessDBDatasSender;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;
import java.lang.reflect.Method;
import org.json.JSONObject;

/* compiled from: SessionTracker.java */
/* loaded from: classes3.dex */
public class q implements u.a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f25953a = "session_start_time";

    /* renamed from: b, reason: collision with root package name */
    public static final String f25954b = "session_end_time";

    /* renamed from: c, reason: collision with root package name */
    public static final String f25955c = "session_id";

    /* renamed from: d, reason: collision with root package name */
    public static final String f25956d = "pre_session_id";

    /* renamed from: e, reason: collision with root package name */
    public static final String f25957e = "a_start_time";

    /* renamed from: f, reason: collision with root package name */
    public static final String f25958f = "a_end_time";

    /* renamed from: g, reason: collision with root package name */
    private static String f25959g = null;

    /* renamed from: h, reason: collision with root package name */
    private static Context f25960h = null;
    private static boolean i = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SessionTracker.java */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final q f25961a = new q();

        private a() {
        }
    }

    public static q a() {
        return a.f25961a;
    }

    public void b(Context context, Object obj) {
        long longValue;
        try {
            if (f25960h == null) {
                f25960h = UMGlobalContext.getAppContext(context);
            }
            if (obj == null) {
                longValue = System.currentTimeMillis();
            } else {
                longValue = ((Long) obj).longValue();
            }
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f25960h);
            if (sharedPreferences == null) {
                return;
            }
            String string = sharedPreferences.getString(b.aw, "");
            String appVersionName = UMUtils.getAppVersionName(f25960h);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            if (edit == null) {
                return;
            }
            if (!TextUtils.isEmpty(string) && !string.equals(appVersionName)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> requestNewInstantSessionIf: version upgrade");
                edit.putLong(f25953a, longValue);
                edit.commit();
                k.a(f25960h).a((Object) null, true);
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> force generate new session: session id = " + u.a().c(f25960h));
                i = true;
                a(f25960h, longValue, true);
                return;
            }
            if (u.a().e(f25960h)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> More then 30 sec from last session.");
                i = true;
                edit.putLong(f25953a, longValue);
                edit.commit();
                a(f25960h, longValue, false);
                return;
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> less then 30 sec from last session, do nothing.");
            i = false;
        } catch (Throwable unused) {
        }
    }

    public void c(Context context, Object obj) {
        try {
            if (f25960h == null && context != null) {
                f25960h = context.getApplicationContext();
            }
            long longValue = ((Long) obj).longValue();
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            if (sharedPreferences == null) {
                return;
            }
            if (sharedPreferences.getLong(f25957e, 0L) == 0) {
                MLog.e("onPause called before onResume");
                return;
            }
            SharedPreferences.Editor edit = sharedPreferences.edit();
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onEndSessionInternal: write activity end time = " + longValue);
            edit.putLong(f25958f, longValue);
            edit.putLong(f25954b, longValue);
            edit.commit();
        } catch (Throwable unused) {
        }
    }

    private q() {
        u.a().a(this);
    }

    public void a(Context context, long j) {
        SharedPreferences.Editor edit;
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f25960h);
        if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null) {
            return;
        }
        edit.putLong(f25953a, j);
        edit.commit();
    }

    public void a(Context context, Object obj) {
        SharedPreferences.Editor edit;
        try {
            if (f25960h == null && context != null) {
                f25960h = context.getApplicationContext();
            }
            long longValue = ((Long) obj).longValue();
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f25960h);
            if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null) {
                return;
            }
            String string = sharedPreferences.getString(b.aw, "");
            String appVersionName = UMUtils.getAppVersionName(f25960h);
            if (TextUtils.isEmpty(string)) {
                edit.putInt("versioncode", Integer.parseInt(UMUtils.getAppVersionCode(context)));
                edit.putString(b.aw, appVersionName);
                edit.commit();
            } else if (!string.equals(appVersionName)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onStartSessionInternal: upgrade version: " + string + "-> " + appVersionName);
                int i2 = sharedPreferences.getInt("versioncode", 0);
                String string2 = sharedPreferences.getString("pre_date", "");
                String string3 = sharedPreferences.getString("pre_version", "");
                String string4 = sharedPreferences.getString(b.aw, "");
                edit.putInt("versioncode", Integer.parseInt(UMUtils.getAppVersionCode(context)));
                edit.putString(b.aw, appVersionName);
                edit.putString("vers_date", string2);
                edit.putString("vers_pre_version", string3);
                edit.putString("cur_version", string4);
                edit.putInt("vers_code", i2);
                edit.putString("vers_name", string);
                if (longValue - sharedPreferences.getLong(f25958f, 0L) < u.a().b()) {
                    edit.putLong(f25958f, 0L);
                }
                edit.commit();
                if (i) {
                    i = false;
                    b(f25960h, longValue);
                    c(f25960h, longValue);
                    return;
                }
                return;
            }
            if (i) {
                i = false;
                f25959g = b(context);
                MLog.i("Start new session: " + f25959g);
                UMRTLog.i(UMRTLog.RTLOG_TAG, "mSessionChanged flag has been set, Start new session: " + f25959g);
                return;
            }
            f25959g = sharedPreferences.getString(f25955c, null);
            edit.putLong(f25957e, longValue);
            edit.putLong(f25958f, 0L);
            edit.commit();
            MLog.i("Extend current session: " + f25959g);
            UMRTLog.i(UMRTLog.RTLOG_TAG, "Extend current session: " + f25959g);
            c(context);
            k.a(f25960h).a(false);
        } catch (Throwable unused) {
        }
    }

    private void c(Context context) {
        k.a(context).b(context);
        k.a(context).d();
    }

    public void c(Context context, long j) {
        if (PreferenceWrapper.getDefault(context) == null) {
            return;
        }
        try {
            k.a(f25960h).c((Object) null);
        } catch (Throwable unused) {
        }
    }

    public String c() {
        return a(f25960h);
    }

    private String b(Context context) {
        if (f25960h == null && context != null) {
            f25960h = context.getApplicationContext();
        }
        String d2 = u.a().d(f25960h);
        try {
            c(context);
            k.a(f25960h).d((Object) null);
        } catch (Throwable unused) {
        }
        return d2;
    }

    public boolean b(Context context, long j) {
        SharedPreferences sharedPreferences;
        String a2;
        boolean z = false;
        try {
            sharedPreferences = PreferenceWrapper.getDefault(context);
        } catch (Throwable unused) {
        }
        if (sharedPreferences == null || (a2 = u.a().a(f25960h)) == null) {
            return false;
        }
        long j2 = sharedPreferences.getLong(f25957e, 0L);
        long j3 = sharedPreferences.getLong(f25958f, 0L);
        if (j2 > 0 && j3 == 0) {
            z = true;
            c(f25960h, Long.valueOf(j));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(c.d.a.f25858g, j);
            JSONObject b2 = com.umeng.analytics.b.a().b();
            if (b2 != null && b2.length() > 0) {
                jSONObject.put("__sp", b2);
            }
            JSONObject c2 = com.umeng.analytics.b.a().c();
            if (c2 != null && c2.length() > 0) {
                jSONObject.put("__pp", c2);
            }
            g.a(context).a(a2, jSONObject, g.a.END);
            k.a(f25960h).e();
        }
        return z;
    }

    public String b() {
        return f25959g;
    }

    public String a(Context context, long j, boolean z) {
        String b2 = u.a().b(context);
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onInstantSessionInternal: current session id = " + b2);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("__e", j);
            JSONObject b3 = com.umeng.analytics.b.a().b();
            if (b3 != null && b3.length() > 0) {
                jSONObject.put("__sp", b3);
            }
            JSONObject c2 = com.umeng.analytics.b.a().c();
            if (c2 != null && c2.length() > 0) {
                jSONObject.put("__pp", c2);
            }
            g.a(context).a(b2, jSONObject, g.a.INSTANTSESSIONBEGIN);
            k.a(context).a(jSONObject, z);
        } catch (Throwable unused) {
        }
        return b2;
    }

    public String a(Context context) {
        try {
            if (f25959g == null) {
                return PreferenceWrapper.getDefault(context).getString(f25955c, null);
            }
        } catch (Throwable unused) {
        }
        return f25959g;
    }

    @Override // com.umeng.analytics.pro.u.a
    public void a(String str, String str2, long j, long j2) {
        a(f25960h, str2, j, j2);
        UMRTLog.i(UMRTLog.RTLOG_TAG, "saveSessionToDB: complete");
        if (AnalyticsConstants.SUB_PROCESS_EVENT) {
            Context context = f25960h;
            UMWorkDispatch.sendEvent(context, UMProcessDBDatasSender.UM_PROCESS_EVENT_KEY, UMProcessDBDatasSender.getInstance(context), Long.valueOf(System.currentTimeMillis()));
        }
    }

    @Override // com.umeng.analytics.pro.u.a
    public void a(String str, long j, long j2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a(str, j);
    }

    private void a(Context context, String str, long j, long j2) {
        if (TextUtils.isEmpty(f25959g)) {
            f25959g = u.a().a(f25960h);
        }
        if (TextUtils.isEmpty(str) || str.equals(f25959g)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(c.d.a.f25858g, j2);
            JSONObject b2 = com.umeng.analytics.b.a().b();
            if (b2 != null && b2.length() > 0) {
                jSONObject.put("__sp", b2);
            }
            JSONObject c2 = com.umeng.analytics.b.a().c();
            if (c2 != null && c2.length() > 0) {
                jSONObject.put("__pp", c2);
            }
            g.a(context).a(f25959g, jSONObject, g.a.END);
        } catch (Exception unused) {
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("__e", j);
            g.a(context).a(str, jSONObject2, g.a.BEGIN);
        } catch (Exception unused2) {
        }
        f25959g = str;
    }

    private void a(String str, long j) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f25960h);
        if (sharedPreferences == null) {
            return;
        }
        long j2 = sharedPreferences.getLong(f25954b, 0L);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("__ii", str);
            jSONObject.put("__e", j);
            jSONObject.put(c.d.a.f25858g, j2);
            double[] location = AnalyticsConfig.getLocation();
            if (location != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("lat", location[0]);
                jSONObject2.put("lng", location[1]);
                jSONObject2.put("ts", System.currentTimeMillis());
                jSONObject.put(c.d.a.f25856e, jSONObject2);
            }
            Class<?> cls = Class.forName("android.net.TrafficStats");
            Method method = cls.getMethod("getUidRxBytes", Integer.TYPE);
            Method method2 = cls.getMethod("getUidTxBytes", Integer.TYPE);
            int i2 = f25960h.getApplicationInfo().uid;
            if (i2 == -1) {
                return;
            }
            long longValue = ((Long) method.invoke(null, Integer.valueOf(i2))).longValue();
            long longValue2 = ((Long) method2.invoke(null, Integer.valueOf(i2))).longValue();
            if (longValue > 0 && longValue2 > 0) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(b.G, longValue);
                jSONObject3.put(b.F, longValue2);
                jSONObject.put(c.d.a.f25855d, jSONObject3);
            }
            g.a(f25960h).a(str, jSONObject, g.a.NEWSESSION);
            r.a(f25960h);
            j.a(f25960h);
        } catch (Throwable unused) {
        }
    }
}
