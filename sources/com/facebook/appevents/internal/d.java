package com.facebook.appevents.internal;

import android.content.Context;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ActivityLifecycleTracker.java */
/* loaded from: classes.dex */
class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ e f9187a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(e eVar) {
        this.f9187a = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        AtomicInteger atomicInteger;
        Object obj;
        l lVar;
        String str;
        atomicInteger = ActivityLifecycleTracker.foregroundActivityCount;
        if (atomicInteger.get() <= 0) {
            e eVar = this.f9187a;
            Context context = eVar.f9189b;
            String str2 = eVar.f9190c;
            lVar = ActivityLifecycleTracker.currentSession;
            str = ActivityLifecycleTracker.appId;
            m.a(context, str2, lVar, str);
            l.a();
            l unused = ActivityLifecycleTracker.currentSession = null;
        }
        obj = ActivityLifecycleTracker.currentFutureLock;
        synchronized (obj) {
            ScheduledFuture unused2 = ActivityLifecycleTracker.currentFuture = null;
        }
    }
}
