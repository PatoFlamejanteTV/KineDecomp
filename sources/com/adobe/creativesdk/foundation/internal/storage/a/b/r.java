package com.adobe.creativesdk.foundation.internal.storage.a.b;

import com.adobe.creativesdk.foundation.network.AdobeNetworkException;

/* compiled from: AdobeStorageSession.java */
/* loaded from: classes.dex */
public class r implements Runnable {

    /* renamed from: a */
    final /* synthetic */ com.adobe.creativesdk.foundation.internal.net.F f5470a;

    /* renamed from: b */
    final /* synthetic */ AdobeNetworkException f5471b;

    /* renamed from: c */
    final /* synthetic */ C0350u f5472c;

    public r(C0350u c0350u, com.adobe.creativesdk.foundation.internal.net.F f2, AdobeNetworkException adobeNetworkException) {
        this.f5472c = c0350u;
        this.f5470a = f2;
        this.f5471b = adobeNetworkException;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f5470a.a(this.f5471b);
    }
}
