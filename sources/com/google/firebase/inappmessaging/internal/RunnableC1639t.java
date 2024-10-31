package com.google.firebase.inappmessaging.internal;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* renamed from: com.google.firebase.inappmessaging.internal.t */
/* loaded from: classes2.dex */
final /* synthetic */ class RunnableC1639t implements Runnable {

    /* renamed from: a */
    private final ForegroundNotifier f17996a;

    private RunnableC1639t(ForegroundNotifier foregroundNotifier) {
        this.f17996a = foregroundNotifier;
    }

    public static Runnable a(ForegroundNotifier foregroundNotifier) {
        return new RunnableC1639t(foregroundNotifier);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f17996a.f17760b = (r1.f17760b && r1.f17761c) ? false : r0.f17760b;
    }
}
