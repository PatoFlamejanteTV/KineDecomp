package com.flurry.sdk;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f487a;
    final /* synthetic */ l b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, String str) {
        this.b = lVar;
        this.f487a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.e();
        try {
            this.b.h = new t(this.f487a);
        } catch (Exception e) {
            as.a(6, l.d, "initialization of FlurryDataSenderIndex error", e);
        }
    }
}
