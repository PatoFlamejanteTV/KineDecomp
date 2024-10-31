package com.adobe.creativesdk.foundation.internal.storage.a.b;

/* compiled from: AdobeStorageSession.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.a.b.f */
/* loaded from: classes.dex */
class RunnableC0336f implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Number f5398a;

    /* renamed from: b */
    final /* synthetic */ Number f5399b;

    /* renamed from: c */
    final /* synthetic */ Number f5400c;

    /* renamed from: d */
    final /* synthetic */ C0339i f5401d;

    public RunnableC0336f(C0339i c0339i, Number number, Number number2, Number number3) {
        this.f5401d = c0339i;
        this.f5398a = number;
        this.f5399b = number2;
        this.f5400c = number3;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f5401d.f5418a.a(this.f5398a, this.f5399b, this.f5400c);
    }
}
