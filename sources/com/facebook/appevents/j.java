package com.facebook.appevents;

import com.facebook.appevents.AppEventsLogger;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AppEventQueue.java */
/* loaded from: classes.dex */
public class j implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AccessTokenAppIdPair f9202a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AppEvent f9203b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(AccessTokenAppIdPair accessTokenAppIdPair, AppEvent appEvent) {
        this.f9202a = accessTokenAppIdPair;
        this.f9203b = appEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        f fVar;
        ScheduledFuture scheduledFuture;
        ScheduledExecutorService scheduledExecutorService;
        Runnable runnable;
        f fVar2;
        fVar = m.f9211b;
        fVar.a(this.f9202a, this.f9203b);
        if (AppEventsLogger.getFlushBehavior() != AppEventsLogger.FlushBehavior.EXPLICIT_ONLY) {
            fVar2 = m.f9211b;
            if (fVar2.a() > 100) {
                m.b(FlushReason.EVENT_THRESHOLD);
                return;
            }
        }
        scheduledFuture = m.f9213d;
        if (scheduledFuture == null) {
            scheduledExecutorService = m.f9212c;
            runnable = m.f9214e;
            ScheduledFuture unused = m.f9213d = scheduledExecutorService.schedule(runnable, 15L, TimeUnit.SECONDS);
        }
    }
}
