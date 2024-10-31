package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;

/* compiled from: AdobeDCXCompositeXfer.java */
/* renamed from: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.u */
/* loaded from: classes.dex */
class RunnableC0260u implements Runnable {

    /* renamed from: a */
    final /* synthetic */ rb f4456a;

    /* renamed from: b */
    final /* synthetic */ AdobeCSDKException f4457b;

    public RunnableC0260u(rb rbVar, AdobeCSDKException adobeCSDKException) {
        this.f4456a = rbVar;
        this.f4457b = adobeCSDKException;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4456a.a(this.f4457b);
    }
}
