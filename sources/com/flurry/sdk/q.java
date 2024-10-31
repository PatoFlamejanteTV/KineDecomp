package com.flurry.sdk;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f491a;
    final /* synthetic */ l b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(l lVar, String str) {
        this.b = lVar;
        this.f491a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.e();
        if (!this.b.e.remove(this.f491a)) {
            as.a(6, l.d, "Internal error. Block with id = " + this.f491a + " was not in progress state");
        }
    }
}
