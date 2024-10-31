package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.internal.zzae;
import java.lang.Thread;
import java.util.Map;

/* loaded from: classes.dex */
public class ExceptionReporter implements Thread.UncaughtExceptionHandler {

    /* renamed from: a, reason: collision with root package name */
    private final Thread.UncaughtExceptionHandler f684a;
    private final Tracker b;
    private final Context c;
    private ExceptionParser d;
    private GoogleAnalytics e;

    GoogleAnalytics a() {
        if (this.e == null) {
            this.e = GoogleAnalytics.a(this.c);
        }
        return this.e;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        String str = "UncaughtException";
        if (this.d != null) {
            str = this.d.a(thread != null ? thread.getName() : null, th);
        }
        zzae.a("Reporting uncaught exception: " + str);
        this.b.a((Map<String, String>) new HitBuilders.ExceptionBuilder().a(str).a(true).a());
        GoogleAnalytics a2 = a();
        a2.i();
        a2.j();
        if (this.f684a != null) {
            zzae.a("Passing exception to the original handler");
            this.f684a.uncaughtException(thread, th);
        }
    }
}
