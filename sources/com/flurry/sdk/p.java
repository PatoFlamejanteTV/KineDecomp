package com.flurry.sdk;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f490a;
    final /* synthetic */ String b;
    final /* synthetic */ l c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(l lVar, String str, String str2) {
        this.c = lVar;
        this.f490a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.c.e();
        if (!this.c.h.a(this.f490a, this.b)) {
            as.a(6, l.d, "Internal error. Block wasn't deleted with id = " + this.f490a);
        }
        if (!this.c.e.remove(this.f490a)) {
            as.a(6, l.d, "Internal error. Block with id = " + this.f490a + " was not in progress state");
        }
    }
}
