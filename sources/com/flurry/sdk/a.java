package com.flurry.sdk;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.flurry.sdk.af;
import com.flurry.sdk.w;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class a implements af.a, ay, w.a, Thread.UncaughtExceptionHandler {

    /* renamed from: a, reason: collision with root package name */
    private static final String f445a = a.class.getSimpleName();
    private static a b;
    private boolean d;
    private w e;
    private g g;
    private String c = "";
    private Map<String, w> f = new HashMap();

    /* renamed from: com.flurry.sdk.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0026a {

        /* renamed from: a, reason: collision with root package name */
        public int f446a;
    }

    private a() {
        az.a().a(this);
        am.a().a(this);
        g();
    }

    private void g() {
        af a2 = ae.a();
        this.d = ((Boolean) a2.a("CaptureUncaughtExceptions")).booleanValue();
        a2.a("CaptureUncaughtExceptions", (af.a) this);
        as.a(4, f445a, "initSettings, CrashReportingEnabled = " + this.d);
        String str = (String) a2.a("VesionName");
        a2.a("VesionName", (af.a) this);
        al.a(str);
        as.a(4, f445a, "initSettings, VersionName = " + str);
    }

    @Override // com.flurry.sdk.af.a
    public void a(String str, Object obj) {
        if (str.equals("CaptureUncaughtExceptions")) {
            this.d = ((Boolean) obj).booleanValue();
            as.a(4, f445a, "onSettingUpdate, CrashReportingEnabled = " + this.d);
        } else {
            if (str.equals("VesionName")) {
                String str2 = (String) obj;
                al.a(str2);
                as.a(4, f445a, "onSettingUpdate, VersionName = " + str2);
                return;
            }
            as.a(6, f445a, "onSettingUpdate internal error!");
        }
    }

    public static a a() {
        if (b == null) {
            b = new a();
        }
        return b;
    }

    public int b() {
        int intValue = ((Integer) ae.a().a("AgentVersion")).intValue();
        as.a(4, f445a, "getAgentVersion() = " + intValue);
        return intValue;
    }

    public void a(Context context, String str) {
        w wVar;
        az.a().b();
        ai.a().b();
        h();
        if (this.f.isEmpty()) {
            ai.a().c();
        }
        if (this.f.containsKey(str)) {
            wVar = this.f.get(str);
        } else {
            wVar = new w(context, str, this);
            wVar.a(b(context));
            this.f.put(str, wVar);
        }
        wVar.c();
        a(wVar);
    }

    public void a(Context context) {
        w c = c();
        if (c != null) {
            c.d();
        }
    }

    private void h() {
        if (this.g == null) {
            this.g = new g();
        }
    }

    private Map<String, List<String>> b(Context context) {
        Bundle extras;
        if (!(context instanceof Activity) || (extras = ((Activity) context).getIntent().getExtras()) == null) {
            return null;
        }
        as.a(3, f445a, "Launch Options Bundle is present " + extras.toString());
        HashMap hashMap = new HashMap();
        for (String str : extras.keySet()) {
            if (str != null) {
                Object obj = extras.get(str);
                String obj2 = obj != null ? obj.toString() : "null";
                hashMap.put(str, new ArrayList(Arrays.asList(obj2)));
                as.a(3, f445a, "Launch options Key: " + str + ". Its value: " + obj2);
            }
        }
        return hashMap;
    }

    void a(w wVar) {
        this.e = wVar;
    }

    public w c() {
        return this.e;
    }

    public void a(String str) {
        w c = c();
        if (c != null) {
            c.a(str, null, false);
        }
    }

    public void a(String str, Map<String, String> map) {
        w c = c();
        if (c != null) {
            c.a(str, map, false);
        }
    }

    public void a(String str, boolean z) {
        w c = c();
        if (c != null) {
            c.a(str, null, z);
        }
    }

    public void a(String str, Map<String, String> map, boolean z) {
        w c = c();
        if (c != null) {
            c.a(str, map, z);
        }
    }

    public void b(String str) {
        w c = c();
        if (c != null) {
            c.a(str, (Map<String, String>) null);
        }
    }

    public void b(String str, Map<String, String> map) {
        w c = c();
        if (c != null) {
            c.a(str, map);
        }
    }

    public void a(String str, String str2, Throwable th) {
        w c = c();
        if (c != null) {
            c.a(str, str2, th.getClass().getName(), th);
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        th.printStackTrace();
        if (this.d) {
            String str = "";
            StackTraceElement[] stackTrace = th.getStackTrace();
            if (stackTrace != null && stackTrace.length > 0) {
                StringBuilder sb = new StringBuilder();
                if (th.getMessage() != null) {
                    sb.append(" (" + th.getMessage() + ")\n");
                }
                str = sb.toString();
            } else if (th.getMessage() != null) {
                str = th.getMessage();
            }
            com.flurry.a.a.a("uncaught", str, th);
        }
        for (w wVar : new HashMap(this.f).values()) {
            if (wVar != null) {
                wVar.e();
            }
        }
        ai.a().f();
    }

    public static int d() {
        return 0;
    }

    public Location e() {
        return ai.a().e();
    }

    public g f() {
        return this.g;
    }

    @Override // com.flurry.sdk.ay
    public void a(boolean z) {
    }

    @Override // com.flurry.sdk.w.a
    public void c(String str) {
        if (!this.f.containsKey(str)) {
            as.a(6, f445a, "Ended session is not in the session map! Maybe it was already destroyed.");
        } else {
            w c = c();
            if (c != null && TextUtils.equals(c.j(), str)) {
                a((w) null);
            }
            this.f.remove(str);
        }
        if (this.f.isEmpty()) {
            as.a(5, f445a, "LocationProvider is going to be unsubscribed");
            ai.a().d();
        }
    }
}
