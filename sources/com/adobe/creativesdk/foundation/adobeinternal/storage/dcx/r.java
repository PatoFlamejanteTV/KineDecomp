package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import com.adobe.creativesdk.foundation.internal.net.C0324c;

/* compiled from: AdobeDCXCompositeXfer.java */
/* loaded from: classes.dex */
class r implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0233g f4438a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ CallableC0256s f4439b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(CallableC0256s callableC0256s, C0233g c0233g) {
        this.f4439b = callableC0256s;
        this.f4438a = c0233g;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4439b.f4443a.a(false);
        qb qbVar = this.f4439b.f4449g;
        if (qbVar != null) {
            qbVar.a(this.f4438a);
        }
        this.f4439b.f4443a.e();
        C0324c c0324c = this.f4439b.f4443a;
        c0324c.b(c0324c.g());
    }
}
