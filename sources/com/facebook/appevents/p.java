package com.facebook.appevents;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AppEventsLogger.java */
/* loaded from: classes.dex */
public class p implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AppEventsLogger f9219a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ long f9220b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(AppEventsLogger appEventsLogger, long j) {
        this.f9219a = appEventsLogger;
        this.f9220b = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f9219a.logAppSessionSuspendEvent(this.f9220b);
    }
}
