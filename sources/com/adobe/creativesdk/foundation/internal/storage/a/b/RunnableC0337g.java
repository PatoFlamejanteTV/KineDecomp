package com.adobe.creativesdk.foundation.internal.storage.a.b;

import com.adobe.creativesdk.foundation.storage.AdobeAssetErrorCode;
import com.adobe.creativesdk.foundation.storage.AdobeAssetException;

/* compiled from: AdobeStorageSession.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.a.b.g */
/* loaded from: classes.dex */
class RunnableC0337g implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0339i f5409a;

    public RunnableC0337g(C0339i c0339i) {
        this.f5409a = c0339i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f5409a.f5418a.a(new AdobeAssetException(AdobeAssetErrorCode.AdobeAssetErrorUnexpectedResponse));
    }
}
