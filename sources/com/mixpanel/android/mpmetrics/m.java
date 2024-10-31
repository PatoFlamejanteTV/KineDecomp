package com.mixpanel.android.mpmetrics;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import java.security.GeneralSecurityException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: MPConfig.java */
/* loaded from: classes.dex */
public class m {
    private static m w;
    private final int b;
    private final int c;
    private final int d;
    private final int e;
    private final boolean f;
    private final boolean g;
    private final boolean h;
    private final boolean i;
    private final boolean j;
    private final boolean k;
    private final String l;
    private final String m;
    private final String n;
    private final String o;
    private final String p;
    private final String q;
    private final boolean r;
    private final String s;
    private final String t;
    private final boolean u;
    private SSLSocketFactory v;

    /* renamed from: a, reason: collision with root package name */
    public static boolean f3036a = false;
    private static final Object x = new Object();

    public static m a(Context context) {
        synchronized (x) {
            if (w == null) {
                w = b(context.getApplicationContext());
            }
        }
        return w;
    }

    m(Bundle bundle, Context context) {
        SSLSocketFactory sSLSocketFactory = null;
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, null, null);
            sSLSocketFactory = sSLContext.getSocketFactory();
        } catch (GeneralSecurityException e) {
            Log.i("MixpanelAPI.Conf", "System has no SSL support. Built-in events editor will not be available", e);
        }
        this.v = sSLSocketFactory;
        f3036a = bundle.getBoolean("com.mixpanel.android.MPConfig.EnableDebugLogging", false);
        if (bundle.containsKey("com.mixpanel.android.MPConfig.AutoCheckForSurveys")) {
            Log.w("MixpanelAPI.Conf", "com.mixpanel.android.MPConfig.AutoCheckForSurveys has been deprecated in favor of com.mixpanel.android.MPConfig.AutoShowMixpanelUpdates. Please update this key as soon as possible.");
        }
        if (bundle.containsKey("com.mixpanel.android.MPConfig.DebugFlushInterval")) {
            Log.w("MixpanelAPI.Conf", "We do not support com.mixpanel.android.MPConfig.DebugFlushInterval anymore. There will only be one flush interval. Please, update your AndroidManifest.xml.");
        }
        this.b = bundle.getInt("com.mixpanel.android.MPConfig.BulkUploadLimit", 40);
        this.c = bundle.getInt("com.mixpanel.android.MPConfig.FlushInterval", 60000);
        this.d = bundle.getInt("com.mixpanel.android.MPConfig.DataExpiration", 432000000);
        this.e = bundle.getInt("com.mixpanel.android.MPConfig.MinimumDatabaseLimit", 20971520);
        this.f = bundle.getBoolean("com.mixpanel.android.MPConfig.DisableFallback", true);
        this.t = bundle.getString("com.mixpanel.android.MPConfig.ResourcePackageName");
        this.h = bundle.getBoolean("com.mixpanel.android.MPConfig.DisableGestureBindingUI", false);
        this.i = bundle.getBoolean("com.mixpanel.android.MPConfig.DisableEmulatorBindingUI", false);
        this.j = bundle.getBoolean("com.mixpanel.android.MPConfig.DisableAppOpenEvent", true);
        this.k = bundle.getBoolean("com.mixpanel.android.MPConfig.DisableViewCrawler", false);
        this.u = bundle.getBoolean("com.mixpanel.android.MPConfig.DisableDecideChecker", false);
        this.r = bundle.getBoolean("com.mixpanel.android.MPConfig.AutoCheckForSurveys", true) && bundle.getBoolean("com.mixpanel.android.MPConfig.AutoShowMixpanelUpdates", true);
        this.g = bundle.getBoolean("com.mixpanel.android.MPConfig.TestMode", false);
        String string = bundle.getString("com.mixpanel.android.MPConfig.EventsEndpoint");
        this.l = string == null ? "https://api.mixpanel.com/track?ip=1" : string;
        String string2 = bundle.getString("com.mixpanel.android.MPConfig.EventsFallbackEndpoint");
        this.m = string2 == null ? "http://api.mixpanel.com/track?ip=1" : string2;
        String string3 = bundle.getString("com.mixpanel.android.MPConfig.PeopleEndpoint");
        this.n = string3 == null ? "https://api.mixpanel.com/engage" : string3;
        String string4 = bundle.getString("com.mixpanel.android.MPConfig.PeopleFallbackEndpoint");
        this.o = string4 == null ? "http://api.mixpanel.com/engage" : string4;
        String string5 = bundle.getString("com.mixpanel.android.MPConfig.DecideEndpoint");
        this.p = string5 == null ? "https://decide.mixpanel.com/decide" : string5;
        String string6 = bundle.getString("com.mixpanel.android.MPConfig.DecideFallbackEndpoint");
        this.q = string6 == null ? "http://decide.mixpanel.com/decide" : string6;
        String string7 = bundle.getString("com.mixpanel.android.MPConfig.EditorUrl");
        this.s = string7 == null ? "wss://switchboard.mixpanel.com/connect/" : string7;
        if (f3036a) {
            Log.v("MixpanelAPI.Conf", "Mixpanel configured with:\n    AutoShowMixpanelUpdates " + q() + "\n    BulkUploadLimit " + a() + "\n    FlushInterval " + b() + "\n    DataExpiration " + c() + "\n    MinimumDatabaseLimit " + d() + "\n    DisableFallback " + e() + "\n    DisableAppOpenEvent " + h() + "\n    DisableViewCrawler " + i() + "\n    DisableDeviceUIBinding " + f() + "\n    DisableEmulatorUIBinding " + g() + "\n    EnableDebugLogging " + f3036a + "\n    TestMode " + j() + "\n    EventsEndpoint " + k() + "\n    PeopleEndpoint " + l() + "\n    DecideEndpoint " + m() + "\n    EventsFallbackEndpoint " + n() + "\n    PeopleFallbackEndpoint " + o() + "\n    DecideFallbackEndpoint " + p() + "\n    EditorUrl " + r() + "\n    DisableDecideChecker " + s() + "\n");
        }
    }

    public int a() {
        return this.b;
    }

    public int b() {
        return this.c;
    }

    public int c() {
        return this.d;
    }

    public int d() {
        return this.e;
    }

    public boolean e() {
        return this.f;
    }

    public boolean f() {
        return this.h;
    }

    public boolean g() {
        return this.i;
    }

    public boolean h() {
        return this.j;
    }

    public boolean i() {
        return this.k;
    }

    public boolean j() {
        return this.g;
    }

    public String k() {
        return this.l;
    }

    public String l() {
        return this.n;
    }

    public String m() {
        return this.p;
    }

    public String n() {
        return this.m;
    }

    public String o() {
        return this.o;
    }

    public String p() {
        return this.q;
    }

    public boolean q() {
        return this.r;
    }

    public String r() {
        return this.s;
    }

    public boolean s() {
        return this.u;
    }

    public String t() {
        return this.t;
    }

    public synchronized SSLSocketFactory u() {
        return this.v;
    }

    static m b(Context context) {
        String packageName = context.getPackageName();
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(packageName, 128).metaData;
            if (bundle == null) {
                bundle = new Bundle();
            }
            return new m(bundle, context);
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException("Can't configure Mixpanel with package name " + packageName, e);
        }
    }
}
