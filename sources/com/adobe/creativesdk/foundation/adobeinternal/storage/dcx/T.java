package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import com.adobe.creativesdk.foundation.internal.net.C0324c;

/* compiled from: AdobeDCXCompositeXfer.java */
/* loaded from: classes.dex */
class T implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ U f4237a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public T(U u) {
        this.f4237a = u;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4237a.f4239a.a(false);
        rb rbVar = this.f4237a.f4246h;
        if (rbVar != null) {
            rbVar.onSuccess();
        }
        this.f4237a.f4239a.e();
        C0324c c0324c = this.f4237a.f4239a;
        c0324c.b(c0324c.g());
    }
}
