package com.nexstreaming.kinemaster.usage;

import android.app.Activity;
import android.app.Application;
import com.nexstreaming.app.general.util.G;
import com.nexstreaming.app.general.util.u;

/* compiled from: AppForegroundTracker.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a */
    private static c f23925a;

    /* renamed from: b */
    private final Application f23926b;

    /* renamed from: c */
    private int f23927c;

    /* renamed from: d */
    private int f23928d;

    /* renamed from: e */
    private int f23929e;

    /* renamed from: f */
    private boolean f23930f = false;

    /* renamed from: g */
    private boolean f23931g = true;

    /* renamed from: h */
    private G f23932h = new G();
    private G i = new G();
    private int j = io.fabric.sdk.android.services.common.a.DEFAULT_TIMEOUT;
    private u<a> k = new u<>();
    private Application.ActivityLifecycleCallbacks l = new com.nexstreaming.kinemaster.usage.a(this);

    /* compiled from: AppForegroundTracker.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(Activity activity, long j, boolean z);
    }

    private c(Application application) {
        this.f23926b = application;
        application.registerActivityLifecycleCallbacks(this.l);
    }

    public static /* synthetic */ int a(c cVar) {
        int i = cVar.f23929e;
        cVar.f23929e = i + 1;
        return i;
    }

    public static /* synthetic */ int b(c cVar) {
        int i = cVar.f23929e;
        cVar.f23929e = i - 1;
        return i;
    }

    public static /* synthetic */ int c(c cVar) {
        int i = cVar.f23927c;
        cVar.f23927c = i + 1;
        return i;
    }

    public static /* synthetic */ int d(c cVar) {
        int i = cVar.f23927c;
        cVar.f23927c = i - 1;
        return i;
    }

    public static /* synthetic */ int e(c cVar) {
        int i = cVar.f23928d;
        cVar.f23928d = i + 1;
        return i;
    }

    public static /* synthetic */ int f(c cVar) {
        int i = cVar.f23928d;
        cVar.f23928d = i - 1;
        return i;
    }

    private void b(Activity activity) {
        this.i.e();
        this.f23932h.c();
        this.f23932h.d();
    }

    private void c(Activity activity) {
        this.f23932h.e();
        long a2 = this.f23932h.a();
        if (a2 > this.j || this.f23931g) {
            boolean z = this.f23931g;
            this.f23931g = false;
            this.k.a(new b(this, activity, a2, z));
        }
        this.i.d();
    }

    public void a(a aVar) {
        this.k.a((u<a>) aVar);
    }

    public static c a(Application application) {
        c cVar = f23925a;
        if (cVar == null || cVar.f23926b != application) {
            c cVar2 = f23925a;
            if (cVar2 != null) {
                cVar2.a();
            }
            f23925a = new c(application);
        }
        return f23925a;
    }

    private void a() {
        this.f23926b.unregisterActivityLifecycleCallbacks(this.l);
    }

    public void a(Activity activity) {
        if (!this.f23930f && this.f23927c > 0) {
            this.f23930f = true;
            c(activity);
        } else {
            if (!this.f23930f || this.f23927c > 0) {
                return;
            }
            this.f23930f = false;
            b(activity);
        }
    }
}
