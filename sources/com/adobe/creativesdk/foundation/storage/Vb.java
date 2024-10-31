package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;

/* compiled from: AdobePSDCompositeXfer.java */
/* loaded from: classes.dex */
class Vb implements Runnable {

    /* renamed from: a */
    final /* synthetic */ com.adobe.creativesdk.foundation.adobeinternal.storage.psd.f f7148a;

    /* renamed from: b */
    final /* synthetic */ AdobeCSDKException f7149b;

    public Vb(com.adobe.creativesdk.foundation.adobeinternal.storage.psd.f fVar, AdobeCSDKException adobeCSDKException) {
        this.f7148a = fVar;
        this.f7149b = adobeCSDKException;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.adobe.creativesdk.foundation.adobeinternal.storage.psd.f fVar = this.f7148a;
        if (fVar != null) {
            fVar.a(this.f7149b);
        }
    }
}
