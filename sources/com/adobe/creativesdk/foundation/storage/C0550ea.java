package com.adobe.creativesdk.foundation.storage;

import android.os.Handler;

/* compiled from: AdobeAssetFolder.java */
/* renamed from: com.adobe.creativesdk.foundation.storage.ea, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0550ea implements c.a.a.a.c<AdobeAssetException> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ RunnableC0562ha f7237a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0550ea(RunnableC0562ha runnableC0562ha) {
        this.f7237a = runnableC0562ha;
    }

    @Override // c.a.a.a.c
    public void a(AdobeAssetException adobeAssetException) {
        C0566ia c0566ia = this.f7237a.f7273b;
        Handler handler = c0566ia.f7285a;
        if (handler != null) {
            handler.post(new RunnableC0546da(this, adobeAssetException));
        } else {
            c0566ia.f7286b.a(adobeAssetException);
        }
    }
}
