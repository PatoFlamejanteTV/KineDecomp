package com.facebook.appevents;

import com.facebook.appevents.AppEventsLogger;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AppEventsLogger.java */
/* loaded from: classes.dex */
public final class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AppEventsLogger.FlushReason f255a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(AppEventsLogger.FlushReason flushReason) {
        this.f255a = flushReason;
    }

    @Override // java.lang.Runnable
    public void run() {
        AppEventsLogger.flushAndWait(this.f255a);
    }
}
