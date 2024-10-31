package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.internal.net.C0324c;

/* compiled from: AdobePSDCompositeXfer.java */
/* loaded from: classes.dex */
class Rb implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Sb f7103a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Rb(Sb sb) {
        this.f7103a = sb;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f7103a.f7116e.e();
        C0324c c0324c = this.f7103a.f7116e;
        c0324c.a(c0324c.g());
        com.adobe.creativesdk.foundation.adobeinternal.storage.psd.f fVar = this.f7103a.f7119h;
        if (fVar != null) {
            fVar.a(true);
        }
    }
}
