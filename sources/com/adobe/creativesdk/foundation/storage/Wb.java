package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.internal.net.C0324c;

/* compiled from: AdobePSDCompositeXfer.java */
/* loaded from: classes.dex */
class Wb implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Mb f7156a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Xb f7157b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Wb(Xb xb, Mb mb) {
        this.f7157b = xb;
        this.f7156a = mb;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.adobe.creativesdk.foundation.adobeinternal.storage.psd.e eVar = this.f7157b.f7172g;
        if (eVar != null) {
            eVar.a(this.f7156a);
        }
        this.f7157b.f7170e.e();
        C0324c c0324c = this.f7157b.f7170e;
        c0324c.a(c0324c.g());
    }
}
