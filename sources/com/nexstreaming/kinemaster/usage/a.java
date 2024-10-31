package com.nexstreaming.kinemaster.usage;

import android.app.Activity;
import android.app.Application;
import com.nexstreaming.app.general.util.m;
import com.nexstreaming.app.general.util.u;

/* compiled from: AppForegroundTracker.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static a f4404a;
    private final Application b;
    private int c;
    private int d;
    private int e;
    private boolean f = false;
    private boolean g = true;
    private u h = new u();
    private u i = new u();
    private int j = 10000;
    private m<InterfaceC0079a> k = new m<>();
    private Application.ActivityLifecycleCallbacks l = new b(this);

    /* compiled from: AppForegroundTracker.java */
    /* renamed from: com.nexstreaming.kinemaster.usage.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0079a {
        void a(Activity activity, long j, boolean z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int a(a aVar) {
        int i = aVar.e;
        aVar.e = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int b(a aVar) {
        int i = aVar.c;
        aVar.c = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int c(a aVar) {
        int i = aVar.d;
        aVar.d = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int d(a aVar) {
        int i = aVar.d;
        aVar.d = i - 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int e(a aVar) {
        int i = aVar.c;
        aVar.c = i - 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int f(a aVar) {
        int i = aVar.e;
        aVar.e = i - 1;
        return i;
    }

    public void a(InterfaceC0079a interfaceC0079a) {
        this.k.a((m<InterfaceC0079a>) interfaceC0079a);
    }

    public static a a(Application application) {
        if (f4404a == null || f4404a.b != application) {
            if (f4404a != null) {
                f4404a.a();
            }
            f4404a = new a(application);
        }
        return f4404a;
    }

    private a(Application application) {
        this.b = application;
        application.registerActivityLifecycleCallbacks(this.l);
    }

    private void a() {
        this.b.unregisterActivityLifecycleCallbacks(this.l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Activity activity) {
        if (!this.f && this.c > 0) {
            this.f = true;
            b(activity);
        } else if (this.f && this.c <= 0) {
            this.f = false;
            c(activity);
        }
    }

    private void b(Activity activity) {
        this.h.b();
        long e = this.h.e();
        if (e > this.j || this.g) {
            boolean z = this.g;
            this.g = false;
            this.k.a(new c(this, activity, e, z));
        }
        this.i.a();
    }

    private void c(Activity activity) {
        this.i.b();
        this.h.c();
        this.h.a();
    }
}
