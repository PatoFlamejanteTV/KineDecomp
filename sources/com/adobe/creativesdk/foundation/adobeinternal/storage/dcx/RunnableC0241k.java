package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import com.adobe.creativesdk.foundation.internal.net.C0324c;

/* compiled from: AdobeDCXCompositeXfer.java */
/* renamed from: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class RunnableC0241k implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0233g f4399a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ CallableC0243l f4400b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0241k(CallableC0243l callableC0243l, C0233g c0233g) {
        this.f4400b = callableC0243l;
        this.f4399a = c0233g;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4400b.f4404a.a(false);
        qb qbVar = this.f4400b.f4408e;
        if (qbVar != null) {
            qbVar.a(this.f4399a);
        }
        this.f4400b.f4404a.e();
        C0324c c0324c = this.f4400b.f4404a;
        c0324c.b(c0324c.g());
    }
}
