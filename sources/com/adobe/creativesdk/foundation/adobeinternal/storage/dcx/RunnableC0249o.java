package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import com.adobe.creativesdk.foundation.internal.net.C0324c;

/* compiled from: AdobeDCXCompositeXfer.java */
/* renamed from: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class RunnableC0249o implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0233g f4420a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ CallableC0251p f4421b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0249o(CallableC0251p callableC0251p, C0233g c0233g) {
        this.f4421b = callableC0251p;
        this.f4420a = c0233g;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4421b.f4424a.a(false);
        qb qbVar = this.f4421b.f4429f;
        if (qbVar != null) {
            qbVar.a(this.f4420a);
        }
        this.f4421b.f4424a.e();
        C0324c c0324c = this.f4421b.f4424a;
        c0324c.b(c0324c.g());
    }
}
