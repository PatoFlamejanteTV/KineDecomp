package com.adobe.creativesdk.foundation.internal.storage.a.b;

import com.adobe.creativesdk.foundation.network.AdobeNetworkException;

/* compiled from: AdobeStorageSession.java */
/* loaded from: classes.dex */
class J implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AdobeNetworkException f5317a;

    /* renamed from: b */
    final /* synthetic */ M f5318b;

    public J(M m, AdobeNetworkException adobeNetworkException) {
        this.f5318b = m;
        this.f5317a = adobeNetworkException;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f5318b.f5322a.a(this.f5317a);
    }
}
