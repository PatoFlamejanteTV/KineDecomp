package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zzch;
import java.lang.Thread;

@VisibleForTesting
/* loaded from: classes.dex */
public class ExceptionReporter implements Thread.UncaughtExceptionHandler {

    /* renamed from: a, reason: collision with root package name */
    private final Thread.UncaughtExceptionHandler f10322a;

    /* renamed from: b, reason: collision with root package name */
    private final Tracker f10323b;

    /* renamed from: c, reason: collision with root package name */
    private final Context f10324c;

    /* renamed from: d, reason: collision with root package name */
    private ExceptionParser f10325d;

    /* renamed from: e, reason: collision with root package name */
    private GoogleAnalytics f10326e;

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        String str;
        if (this.f10325d != null) {
            str = this.f10325d.a(thread != null ? thread.getName() : null, th);
        } else {
            str = "UncaughtException";
        }
        String valueOf = String.valueOf(str);
        zzch.zzab(valueOf.length() != 0 ? "Reporting uncaught exception: ".concat(valueOf) : new String("Reporting uncaught exception: "));
        this.f10323b.a(new HitBuilders.ExceptionBuilder().a(str).a(true).a());
        if (this.f10326e == null) {
            this.f10326e = GoogleAnalytics.a(this.f10324c);
        }
        GoogleAnalytics googleAnalytics = this.f10326e;
        googleAnalytics.d();
        googleAnalytics.b().zzcs().zzcj();
        if (this.f10322a != null) {
            zzch.zzab("Passing exception to the original handler");
            this.f10322a.uncaughtException(thread, th);
        }
    }
}
