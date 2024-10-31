package com.facebook.appevents;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AppEventsLogger.java */
/* loaded from: classes.dex */
public class o implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AppEventsLogger f9216a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ long f9217b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f9218c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(AppEventsLogger appEventsLogger, long j, String str) {
        this.f9216a = appEventsLogger;
        this.f9217b = j;
        this.f9218c = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f9216a.logAppSessionResumeEvent(this.f9217b, this.f9218c);
    }
}
