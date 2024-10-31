package com.umeng.analytics.pro;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.pro.c;
import com.umeng.analytics.pro.g;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMLog;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: AutoViewPageTracker.java */
/* loaded from: classes3.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    public static String f25900a;

    /* renamed from: e, reason: collision with root package name */
    private static JSONArray f25901e = new JSONArray();

    /* renamed from: f, reason: collision with root package name */
    private static Object f25902f = new Object();

    /* renamed from: g, reason: collision with root package name */
    private Application f25906g;

    /* renamed from: d, reason: collision with root package name */
    private final Map<String, Long> f25905d = new HashMap();

    /* renamed from: h, reason: collision with root package name */
    private boolean f25907h = false;

    /* renamed from: b, reason: collision with root package name */
    boolean f25903b = false;

    /* renamed from: c, reason: collision with root package name */
    Application.ActivityLifecycleCallbacks f25904c = new Application.ActivityLifecycleCallbacks() { // from class: com.umeng.analytics.pro.j.1
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            if (AnalyticsConfig.AUTO_ACTIVITY_PAGE_COLLECTION != MobclickAgent.PageMode.AUTO) {
                return;
            }
            j.this.b(activity);
            com.umeng.analytics.b.a().i();
            j.this.f25903b = false;
            try {
                if (UMConfigure.isDebugLog()) {
                    String name = activity.getClass().getName();
                    if (name.equals(com.umeng.analytics.b.a().f())) {
                        return;
                    }
                    UMLog.aq(h.r, 0, "\\|", new String[]{"@"}, new String[]{name}, null, null);
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            if (AnalyticsConfig.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.AUTO && activity != null) {
                j jVar = j.this;
                if (!jVar.f25903b) {
                    jVar.a(activity);
                    com.umeng.analytics.b.a().h();
                    return;
                }
                jVar.f25903b = false;
                if (!TextUtils.isEmpty(j.f25900a)) {
                    if (j.f25900a.equals(activity.getPackageName() + "." + activity.getLocalClassName())) {
                        return;
                    }
                    j.this.a(activity);
                    com.umeng.analytics.b.a().h();
                    return;
                }
                j.f25900a = activity.getPackageName() + "." + activity.getLocalClassName();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            if (AnalyticsConfig.AUTO_ACTIVITY_PAGE_COLLECTION != MobclickAgent.PageMode.AUTO) {
                return;
            }
            try {
                if (UMConfigure.isDebugLog()) {
                    String name = activity.getClass().getName();
                    if (name.equals(com.umeng.analytics.b.a().g())) {
                        return;
                    }
                    UMLog.aq(h.s, 0, "\\|", new String[]{"@"}, new String[]{name.substring(0, name.length() - 1)}, null, null);
                }
            } catch (Throwable unused) {
            }
        }
    };

    public j(Context context) {
        this.f25906g = null;
        synchronized (this) {
            if (this.f25906g == null && context != null) {
                if (context instanceof Activity) {
                    this.f25906g = ((Activity) context).getApplication();
                } else if (context instanceof Application) {
                    this.f25906g = (Application) context;
                }
                if (this.f25906g != null) {
                    b(context);
                }
            }
        }
    }

    public void c() {
        b((Activity) null);
        b();
    }

    private void b(Context context) {
        if (this.f25907h) {
            return;
        }
        this.f25907h = true;
        Application application = this.f25906g;
        if (application == null || Build.VERSION.SDK_INT < 14) {
            return;
        }
        application.registerActivityLifecycleCallbacks(this.f25904c);
    }

    public boolean a() {
        return this.f25907h;
    }

    public static void a(Context context) {
        String jSONArray;
        if (context != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                synchronized (f25902f) {
                    jSONArray = f25901e.toString();
                    f25901e = new JSONArray();
                }
                if (jSONArray.length() > 0) {
                    jSONObject.put(c.d.a.f25854c, new JSONArray(jSONArray));
                    g.a(context).a(q.a().c(), jSONObject, g.a.AUTOPAGE);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void b() {
        this.f25907h = false;
        Application application = this.f25906g;
        if (application != null) {
            if (Build.VERSION.SDK_INT >= 14) {
                application.unregisterActivityLifecycleCallbacks(this.f25904c);
            }
            this.f25906g = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Activity activity) {
        long j;
        long j2;
        try {
            synchronized (this.f25905d) {
                if (f25900a == null && activity != null) {
                    f25900a = activity.getPackageName() + "." + activity.getLocalClassName();
                }
                j = 0;
                if (TextUtils.isEmpty(f25900a) || !this.f25905d.containsKey(f25900a)) {
                    j2 = 0;
                } else {
                    long longValue = this.f25905d.get(f25900a).longValue();
                    long currentTimeMillis = System.currentTimeMillis() - longValue;
                    this.f25905d.remove(f25900a);
                    j = currentTimeMillis;
                    j2 = longValue;
                }
            }
            synchronized (f25902f) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(b.u, f25900a);
                    jSONObject.put("duration", j);
                    jSONObject.put(b.w, j2);
                    jSONObject.put("type", 0);
                    f25901e.put(jSONObject);
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable unused2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Activity activity) {
        f25900a = activity.getPackageName() + "." + activity.getLocalClassName();
        synchronized (this.f25905d) {
            this.f25905d.put(f25900a, Long.valueOf(System.currentTimeMillis()));
        }
    }
}
