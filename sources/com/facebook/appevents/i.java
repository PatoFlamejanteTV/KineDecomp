package com.facebook.appevents;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AppEventQueue.java */
/* loaded from: classes.dex */
public class i implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ FlushReason f9174a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(FlushReason flushReason) {
        this.f9174a = flushReason;
    }

    @Override // java.lang.Runnable
    public void run() {
        m.b(this.f9174a);
    }
}
