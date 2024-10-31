package com.facebook.appevents;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AppEventsLogger.java */
/* loaded from: classes.dex */
public final class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AppEventsLogger f252a;
    final /* synthetic */ long b;
    final /* synthetic */ String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AppEventsLogger appEventsLogger, long j, String str) {
        this.f252a = appEventsLogger;
        this.b = j;
        this.c = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f252a.logAppSessionResumeEvent(this.b, this.c);
    }
}
