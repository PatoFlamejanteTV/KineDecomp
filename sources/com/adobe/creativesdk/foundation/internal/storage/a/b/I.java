package com.adobe.creativesdk.foundation.internal.storage.a.b;

import com.adobe.creativesdk.foundation.network.AdobeNetworkException;

/* compiled from: AdobeStorageSession.java */
/* loaded from: classes.dex */
class I implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AdobeNetworkException f5315a;

    /* renamed from: b */
    final /* synthetic */ M f5316b;

    public I(M m, AdobeNetworkException adobeNetworkException) {
        this.f5316b = m;
        this.f5315a = adobeNetworkException;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f5316b.f5322a.a(this.f5315a);
    }
}
