package com.facebook.appevents;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AppEventsLogger.java */
/* loaded from: classes.dex */
public final class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AppEventsLogger f253a;
    final /* synthetic */ long b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AppEventsLogger appEventsLogger, long j) {
        this.f253a = appEventsLogger;
        this.b = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f253a.logAppSessionSuspendEvent(this.b);
    }
}
