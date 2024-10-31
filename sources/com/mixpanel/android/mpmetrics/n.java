package com.mixpanel.android.mpmetrics;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import com.mixpanel.android.mpmetrics.InAppNotification;
import com.mixpanel.android.mpmetrics.UpdateDisplayState;
import com.mixpanel.android.mpmetrics.a;
import com.mixpanel.android.mpmetrics.f;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: MixpanelAPI.java */
/* loaded from: classes.dex */
public class n {
    private static final Map<String, Map<Context, n>> m = new HashMap();
    private static final aa n = new aa();
    private static final af o = new af();
    private static Future<SharedPreferences> p;

    /* renamed from: a, reason: collision with root package name */
    private final Context f3037a;
    private final com.mixpanel.android.mpmetrics.a b;
    private final m c;
    private final String d;
    private final d e;
    private final com.mixpanel.android.viewcrawler.j f;
    private final w g;
    private final g h;
    private final com.mixpanel.android.viewcrawler.h i;
    private final com.mixpanel.android.mpmetrics.f j;
    private final Map<String, String> k;
    private final Map<String, Long> l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MixpanelAPI.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(n nVar);
    }

    /* compiled from: MixpanelAPI.java */
    /* loaded from: classes.dex */
    public interface c {
        void a();

        void a(double d, JSONObject jSONObject);

        void a(Activity activity);

        void a(String str);

        void a(String str, double d);

        void a(String str, InAppNotification inAppNotification);

        void a(String str, Object obj);

        void a(String str, JSONObject jSONObject);

        void a(JSONObject jSONObject);

        void b(Activity activity);

        void b(String str);

        void b(String str, Object obj);

        void c(String str);

        c d(String str);
    }

    /* compiled from: MixpanelAPI.java */
    /* loaded from: classes.dex */
    private interface g extends f.a {
    }

    public static ae<Boolean> a(String str, boolean z) {
        return o.a(str, z);
    }

    public static ae<Integer> a(String str, int i) {
        return o.a(str, i);
    }

    n(Context context, Future<SharedPreferences> future, String str) {
        this(context, future, str, m.a(context));
    }

    n(Context context, Future<SharedPreferences> future, String str, m mVar) {
        this.f3037a = context;
        this.d = str;
        this.l = new HashMap();
        this.e = new d(this, null);
        this.c = mVar;
        HashMap hashMap = new HashMap();
        hashMap.put("$android_lib_version", "4.8.0");
        hashMap.put("$android_os", "Android");
        hashMap.put("$android_os_version", Build.VERSION.RELEASE == null ? "UNKNOWN" : Build.VERSION.RELEASE);
        hashMap.put("$android_manufacturer", Build.MANUFACTURER == null ? "UNKNOWN" : Build.MANUFACTURER);
        hashMap.put("$android_brand", Build.BRAND == null ? "UNKNOWN" : Build.BRAND);
        hashMap.put("$android_model", Build.MODEL == null ? "UNKNOWN" : Build.MODEL);
        try {
            PackageInfo packageInfo = this.f3037a.getPackageManager().getPackageInfo(this.f3037a.getPackageName(), 0);
            hashMap.put("$android_app_version", packageInfo.versionName);
            hashMap.put("$android_app_version_code", Integer.toString(packageInfo.versionCode));
        } catch (PackageManager.NameNotFoundException e2) {
            Log.e("MixpanelAPI.API", "Exception getting app version name", e2);
        }
        this.k = Collections.unmodifiableMap(hashMap);
        this.f = b(context, str);
        this.i = h();
        this.g = a(context, future, str);
        this.h = g();
        this.j = a(str, this.h, this.f);
        String c2 = this.g.c();
        this.j.a(c2 == null ? this.g.b() : c2);
        this.b = f();
        if (!this.c.s()) {
            this.b.a(this.j);
        }
        e();
        if (i()) {
            a("$app_open", (JSONObject) null);
        }
        this.f.a();
    }

    public static n a(Context context, String str) {
        Map<Context, n> map;
        n nVar = null;
        if (str != null && context != null) {
            synchronized (m) {
                Context applicationContext = context.getApplicationContext();
                if (p == null) {
                    p = n.a(context, "com.mixpanel.android.mpmetrics.ReferralInfo", null);
                }
                Map<Context, n> map2 = m.get(str);
                if (map2 == null) {
                    HashMap hashMap = new HashMap();
                    m.put(str, hashMap);
                    map = hashMap;
                } else {
                    map = map2;
                }
                nVar = map.get(applicationContext);
                if (nVar == null && com.mixpanel.android.mpmetrics.e.a(applicationContext)) {
                    nVar = new n(applicationContext, p, str);
                    a(context, nVar);
                    map.put(applicationContext, nVar);
                }
                a(context);
            }
        }
        return nVar;
    }

    public void a(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.l) {
            this.l.put(str, Long.valueOf(currentTimeMillis));
        }
    }

    public void a(String str, JSONObject jSONObject) {
        Long l;
        synchronized (this.l) {
            l = this.l.get(str);
            this.l.remove(str);
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            for (Map.Entry<String, String> entry : this.g.a().entrySet()) {
                jSONObject2.put(entry.getKey(), entry.getValue());
            }
            this.g.a(jSONObject2);
            double currentTimeMillis = System.currentTimeMillis() / 1000.0d;
            jSONObject2.put("time", (long) currentTimeMillis);
            jSONObject2.put("distinct_id", b());
            if (l != null) {
                jSONObject2.put("$duration", currentTimeMillis - (l.longValue() / 1000.0d));
            }
            if (jSONObject != null) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject2.put(next, jSONObject.get(next));
                }
            }
            this.b.a(new a.C0057a(str, jSONObject2, this.d));
            if (this.i != null) {
                this.i.a(str);
            }
        } catch (JSONException e2) {
            Log.e("MixpanelAPI.API", "Exception tracking event " + str, e2);
        }
    }

    public void a() {
        this.b.b();
    }

    public String b() {
        return this.g.b();
    }

    public void a(JSONObject jSONObject) {
        this.g.c(jSONObject);
    }

    public void a(ab abVar) {
        this.g.a(abVar);
    }

    public c c() {
        return this.e;
    }

    public Map<String, String> d() {
        return this.k;
    }

    @TargetApi(16)
    void e() {
        if (Build.VERSION.SDK_INT >= 16 && this.c.q()) {
            if (this.f3037a.getApplicationContext() instanceof Application) {
                ((Application) this.f3037a.getApplicationContext()).registerActivityLifecycleCallbacks(new u(this));
            } else {
                Log.i("MixpanelAPI.API", "Context is not an Application, Mixpanel will not automatically show surveys, in-app notifications, or A/B test experiments.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(a aVar) {
        synchronized (m) {
            Iterator<Map<Context, n>> it = m.values().iterator();
            while (it.hasNext()) {
                Iterator<n> it2 = it.next().values().iterator();
                while (it2.hasNext()) {
                    aVar.a(it2.next());
                }
            }
        }
    }

    com.mixpanel.android.mpmetrics.a f() {
        return com.mixpanel.android.mpmetrics.a.a(this.f3037a);
    }

    w a(Context context, Future<SharedPreferences> future, String str) {
        return new w(future, n.a(context, "com.mixpanel.android.mpmetrics.MixpanelAPI_" + str, new o(this)));
    }

    com.mixpanel.android.mpmetrics.f a(String str, f.a aVar, com.mixpanel.android.viewcrawler.j jVar) {
        return new com.mixpanel.android.mpmetrics.f(str, aVar, jVar);
    }

    g g() {
        o oVar = null;
        if (Build.VERSION.SDK_INT >= 16) {
            return new e(this, oVar);
        }
        Log.i("MixpanelAPI.API", "Surveys and Notifications are not supported on this Android OS Version");
        return new f(this, oVar);
    }

    com.mixpanel.android.viewcrawler.j b(Context context, String str) {
        if (Build.VERSION.SDK_INT < 16) {
            Log.i("MixpanelAPI.API", "SDK version is lower than 16. Web Configuration, A/B Testing, and Dynamic Tweaks are disabled.");
            return new b(o);
        }
        if (this.c.i()) {
            Log.i("MixpanelAPI.API", "DisableViewCrawler is set to true. Web Configuration, A/B Testing, and Dynamic Tweaks are disabled.");
            return new b(o);
        }
        return new com.mixpanel.android.viewcrawler.k(this.f3037a, this.d, this, o);
    }

    com.mixpanel.android.viewcrawler.h h() {
        if (this.f instanceof com.mixpanel.android.viewcrawler.k) {
            return (com.mixpanel.android.viewcrawler.h) this.f;
        }
        return null;
    }

    boolean i() {
        return !this.c.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MixpanelAPI.java */
    /* loaded from: classes.dex */
    public class d implements c {
        private d() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ d(n nVar, o oVar) {
            this();
        }

        @Override // com.mixpanel.android.mpmetrics.n.c
        public void a(String str) {
            synchronized (n.this.g) {
                n.this.g.a(str);
                n.this.j.a(str);
            }
            n.this.j();
        }

        @Override // com.mixpanel.android.mpmetrics.n.c
        public void a(JSONObject jSONObject) {
            try {
                JSONObject jSONObject2 = new JSONObject(n.this.k);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject2.put(next, jSONObject.get(next));
                }
                n.this.b(c("$set", jSONObject2));
            } catch (JSONException e) {
                Log.e("MixpanelAPI.API", "Exception setting people properties", e);
            }
        }

        @Override // com.mixpanel.android.mpmetrics.n.c
        public void a(String str, Object obj) {
            try {
                a(new JSONObject().put(str, obj));
            } catch (JSONException e) {
                Log.e("MixpanelAPI.API", "set", e);
            }
        }

        public void a(Map<String, ? extends Number> map) {
            try {
                n.this.b(c("$add", new JSONObject(map)));
            } catch (JSONException e) {
                Log.e("MixpanelAPI.API", "Exception incrementing properties", e);
            }
        }

        @Override // com.mixpanel.android.mpmetrics.n.c
        public void a(String str, JSONObject jSONObject) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(str, jSONObject);
                n.this.b(c("$merge", jSONObject2));
            } catch (JSONException e) {
                Log.e("MixpanelAPI.API", "Exception merging a property", e);
            }
        }

        @Override // com.mixpanel.android.mpmetrics.n.c
        public void a(String str, double d) {
            HashMap hashMap = new HashMap();
            hashMap.put(str, Double.valueOf(d));
            a(hashMap);
        }

        @Override // com.mixpanel.android.mpmetrics.n.c
        public void b(String str, Object obj) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(str, obj);
                n.this.b(c("$append", jSONObject));
            } catch (JSONException e) {
                Log.e("MixpanelAPI.API", "Exception appending a property", e);
            }
        }

        public void a(String str, JSONArray jSONArray) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(str, jSONArray);
                n.this.b(c("$union", jSONObject));
            } catch (JSONException e) {
                Log.e("MixpanelAPI.API", "Exception unioning a property");
            }
        }

        public InAppNotification b() {
            return n.this.j.b(n.this.c.j());
        }

        public void a(InAppNotification inAppNotification) {
            if (inAppNotification != null) {
                a("$campaign_delivery", inAppNotification);
                c d = n.this.c().d(d());
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
                JSONObject a2 = inAppNotification.a();
                try {
                    a2.put("$time", simpleDateFormat.format(new Date()));
                } catch (JSONException e) {
                    Log.e("MixpanelAPI.API", "Exception trying to track an in-app notification seen", e);
                }
                d.b("$campaigns", Integer.valueOf(inAppNotification.b()));
                d.b("$notifications", a2);
            }
        }

        public Survey c() {
            return n.this.j.a(n.this.c.j());
        }

        @Override // com.mixpanel.android.mpmetrics.n.c
        public void a(Activity activity) {
            if (Build.VERSION.SDK_INT >= 16) {
                a((Survey) null, activity);
            }
        }

        @Override // com.mixpanel.android.mpmetrics.n.c
        public void b(Activity activity) {
            if (Build.VERSION.SDK_INT >= 16) {
                a((InAppNotification) null, activity);
            }
        }

        @Override // com.mixpanel.android.mpmetrics.n.c
        public void a(String str, InAppNotification inAppNotification) {
            n.this.a(str, inAppNotification.a());
        }

        @Override // com.mixpanel.android.mpmetrics.n.c
        public void a() {
            JSONArray c = n.this.j.c();
            if (c != null) {
                n.this.f.b(c);
            }
        }

        @Override // com.mixpanel.android.mpmetrics.n.c
        public void a(double d, JSONObject jSONObject) {
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("$amount", d);
                jSONObject2.put("$time", simpleDateFormat.format(date));
                if (jSONObject != null) {
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        jSONObject2.put(next, jSONObject.get(next));
                    }
                }
                b("$transactions", jSONObject2);
            } catch (JSONException e) {
                Log.e("MixpanelAPI.API", "Exception creating new charge", e);
            }
        }

        @Override // com.mixpanel.android.mpmetrics.n.c
        public void c(String str) {
            synchronized (n.this.g) {
                if (n.this.g.c() != null) {
                    n.this.g.b(str);
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(str);
                    a("$android_devices", jSONArray);
                }
            }
        }

        @Override // com.mixpanel.android.mpmetrics.n.c
        public void b(String str) {
            if (com.mixpanel.android.mpmetrics.e.b(n.this.f3037a)) {
                String e = n.this.g.e();
                if (e == null) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        e(str);
                        return;
                    } else {
                        f(str);
                        return;
                    }
                }
                n.a(new q(this, e));
                return;
            }
            Log.i("MixpanelAPI.API", "Can't register for push notification services. Push notifications will not work.");
            Log.i("MixpanelAPI.API", "See log tagged " + com.mixpanel.android.mpmetrics.e.f3028a + " above for details.");
        }

        public String d() {
            return n.this.g.c();
        }

        @Override // com.mixpanel.android.mpmetrics.n.c
        public c d(String str) {
            if (str == null) {
                return null;
            }
            return new r(this, str);
        }

        private JSONObject c(String str, Object obj) throws JSONException {
            JSONObject jSONObject = new JSONObject();
            String d = d();
            jSONObject.put(str, obj);
            jSONObject.put("$token", n.this.d);
            jSONObject.put("$time", System.currentTimeMillis());
            if (d != null) {
                jSONObject.put("$distinct_id", d);
            }
            return jSONObject;
        }

        @TargetApi(21)
        private void e(String str) {
            n.this.b.a(str);
        }

        @TargetApi(19)
        private void f(String str) {
            try {
                if (m.f3036a) {
                    Log.v("MixpanelAPI.API", "Registering a new push id");
                }
                Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
                intent.putExtra("app", PendingIntent.getBroadcast(n.this.f3037a, 0, new Intent(), 0));
                intent.putExtra("sender", str);
                n.this.f3037a.startService(intent);
            } catch (SecurityException e) {
                Log.w("MixpanelAPI.API", e);
            }
        }

        private void a(Survey survey, Activity activity) {
            if (Build.VERSION.SDK_INT < 16) {
                if (m.f3036a) {
                    Log.v("MixpanelAPI.API", "Will not show survey, os version is too low.");
                    return;
                }
                return;
            }
            if (!com.mixpanel.android.mpmetrics.e.c(activity.getApplicationContext())) {
                if (m.f3036a) {
                    Log.v("MixpanelAPI.API", "Will not show survey, application isn't configured appropriately.");
                    return;
                }
                return;
            }
            ReentrantLock a2 = UpdateDisplayState.a();
            a2.lock();
            try {
                if (UpdateDisplayState.b()) {
                    return;
                }
                if (survey == null) {
                    survey = c();
                }
                if (survey == null) {
                    return;
                }
                UpdateDisplayState.DisplayState.SurveyState surveyState = new UpdateDisplayState.DisplayState.SurveyState(survey);
                int a3 = UpdateDisplayState.a(surveyState, d(), n.this.d);
                if (a3 <= 0) {
                    Log.e("MixpanelAPI.API", "DisplayState Lock is in an inconsistent state! Please report this issue to Mixpanel");
                    return;
                }
                s sVar = new s(this, surveyState, activity, a3);
                a2.unlock();
                com.mixpanel.android.mpmetrics.c.a(activity, sVar);
            } finally {
                a2.unlock();
            }
        }

        private void a(InAppNotification inAppNotification, Activity activity) {
            if (Build.VERSION.SDK_INT < 16) {
                if (m.f3036a) {
                    Log.v("MixpanelAPI.API", "Will not show notifications, os version is too low.");
                    return;
                }
                return;
            }
            activity.runOnUiThread(new t(this, inAppNotification, activity));
        }
    }

    /* compiled from: MixpanelAPI.java */
    /* renamed from: com.mixpanel.android.mpmetrics.n$1, reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3038a = new int[InAppNotification.Type.values().length];

        static {
            try {
                f3038a[InAppNotification.Type.MINI.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f3038a[InAppNotification.Type.TAKEOVER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MixpanelAPI.java */
    /* loaded from: classes.dex */
    public class f implements g {
        private f() {
        }

        /* synthetic */ f(n nVar, o oVar) {
            this();
        }

        @Override // com.mixpanel.android.mpmetrics.f.a
        public void a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MixpanelAPI.java */
    /* loaded from: classes.dex */
    public class e implements g, Runnable {
        private final Set<v> b;
        private final Executor c;

        private e() {
            this.b = new HashSet();
            this.c = Executors.newSingleThreadExecutor();
        }

        /* synthetic */ e(n nVar, o oVar) {
            this();
        }

        @Override // com.mixpanel.android.mpmetrics.f.a
        public void a() {
            this.c.execute(this);
        }

        @Override // java.lang.Runnable
        public synchronized void run() {
            Iterator<v> it = this.b.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MixpanelAPI.java */
    /* loaded from: classes.dex */
    public class b implements com.mixpanel.android.viewcrawler.j {
        private final af b;

        public b(af afVar) {
            this.b = afVar;
        }

        @Override // com.mixpanel.android.viewcrawler.j
        public void a() {
        }

        @Override // com.mixpanel.android.viewcrawler.j
        public void a(JSONArray jSONArray) {
        }

        @Override // com.mixpanel.android.viewcrawler.j
        public void b(JSONArray jSONArray) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(JSONObject jSONObject) {
        if (jSONObject.has("$distinct_id")) {
            this.b.a(jSONObject);
        } else {
            this.g.b(jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        JSONArray d2 = this.g.d();
        if (d2 != null) {
            a(d2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONArray jSONArray) {
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                this.b.a(jSONArray.getJSONObject(i));
            } catch (JSONException e2) {
                Log.e("MixpanelAPI.API", "Malformed people record stored pending identity, will not send it.", e2);
            }
        }
    }

    private static void a(Context context, n nVar) {
        try {
            Class<?> cls = Class.forName("android.support.v4.a.f");
            cls.getMethod("registerReceiver", BroadcastReceiver.class, IntentFilter.class).invoke(cls.getMethod("getInstance", Context.class).invoke(null, context), new p(nVar), new IntentFilter("com.parse.bolts.measurement_event"));
        } catch (ClassNotFoundException e2) {
            Log.d("MixpanelAPI.AL", "To enable App Links tracking android.support.v4 must be installed: " + e2.getMessage());
        } catch (IllegalAccessException e3) {
            Log.d("MixpanelAPI.AL", "App Links tracking will not be enabled due to this exception: " + e3.getMessage());
        } catch (NoSuchMethodException e4) {
            Log.d("MixpanelAPI.AL", "To enable App Links tracking android.support.v4 must be installed: " + e4.getMessage());
        } catch (InvocationTargetException e5) {
            Log.d("MixpanelAPI.AL", "Failed to invoke LocalBroadcastManager.registerReceiver() -- App Links tracking will not be enabled due to this exception", e5);
        }
    }

    private static void a(Context context) {
        if (context instanceof Activity) {
            try {
                Class.forName("a.c").getMethod("getTargetUrlFromInboundIntent", Context.class, Intent.class).invoke(null, context, ((Activity) context).getIntent());
                return;
            } catch (ClassNotFoundException e2) {
                Log.d("MixpanelAPI.AL", "Please install the Bolts library >= 1.1.2 to track App Links: " + e2.getMessage());
                return;
            } catch (IllegalAccessException e3) {
                Log.d("MixpanelAPI.AL", "Unable to detect inbound App Links: " + e3.getMessage());
                return;
            } catch (NoSuchMethodException e4) {
                Log.d("MixpanelAPI.AL", "Please install the Bolts library >= 1.1.2 to track App Links: " + e4.getMessage());
                return;
            } catch (InvocationTargetException e5) {
                Log.d("MixpanelAPI.AL", "Failed to invoke bolts.AppLinks.getTargetUrlFromInboundIntent() -- Unable to detect inbound App Links", e5);
                return;
            }
        }
        Log.d("MixpanelAPI.AL", "Context is not an instance of Activity. To detect inbound App Links, pass an instance of an Activity to getInstance.");
    }
}
