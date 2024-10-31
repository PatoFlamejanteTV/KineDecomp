package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;

/* compiled from: AdobeDCXCompositeXfer.java */
/* loaded from: classes.dex */
class P implements Runnable {

    /* renamed from: a */
    final /* synthetic */ qb f4220a;

    /* renamed from: b */
    final /* synthetic */ AdobeCSDKException f4221b;

    public P(qb qbVar, AdobeCSDKException adobeCSDKException) {
        this.f4220a = qbVar;
        this.f4221b = adobeCSDKException;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4220a.a(null, this.f4221b);
    }
}
