package com.facebook.appevents.internal;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ActivityLifecycleTracker.java */
/* loaded from: classes.dex */
public class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ long f9188a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Context f9189b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f9190c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(long j, Context context, String str) {
        this.f9188a = j;
        this.f9189b = context;
        this.f9190c = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        l lVar;
        l lVar2;
        AtomicInteger atomicInteger;
        long j;
        l lVar3;
        Object obj;
        ScheduledExecutorService scheduledExecutorService;
        int sessionTimeoutInSeconds;
        lVar = ActivityLifecycleTracker.currentSession;
        if (lVar == null) {
            l unused = ActivityLifecycleTracker.currentSession = new l(Long.valueOf(this.f9188a), null);
        }
        lVar2 = ActivityLifecycleTracker.currentSession;
        lVar2.a(Long.valueOf(this.f9188a));
        atomicInteger = ActivityLifecycleTracker.foregroundActivityCount;
        if (atomicInteger.get() <= 0) {
            d dVar = new d(this);
            obj = ActivityLifecycleTracker.currentFutureLock;
            synchronized (obj) {
                scheduledExecutorService = ActivityLifecycleTracker.singleThreadExecutor;
                sessionTimeoutInSeconds = ActivityLifecycleTracker.getSessionTimeoutInSeconds();
                ScheduledFuture unused2 = ActivityLifecycleTracker.currentFuture = scheduledExecutorService.schedule(dVar, sessionTimeoutInSeconds, TimeUnit.SECONDS);
            }
        }
        j = ActivityLifecycleTracker.currentActivityAppearTime;
        AutomaticAnalyticsLogger.logActivityTimeSpentEvent(this.f9190c, j > 0 ? (this.f9188a - j) / 1000 : 0L);
        lVar3 = ActivityLifecycleTracker.currentSession;
        lVar3.j();
    }
}
