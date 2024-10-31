package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import com.adobe.creativesdk.foundation.adobeinternal.net.AdobeNetworkReachability;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeDCXController.java */
/* renamed from: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.ha, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class RunnableC0236ha implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ nb f4385a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Aa f4386b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ AdobeNetworkReachability.AdobeNetworkStatusCode f4387c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Aa f4388d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0236ha(Aa aa, nb nbVar, Aa aa2, AdobeNetworkReachability.AdobeNetworkStatusCode adobeNetworkStatusCode) {
        this.f4388d = aa;
        this.f4385a = nbVar;
        this.f4386b = aa2;
        this.f4387c = adobeNetworkStatusCode;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4385a.b(this.f4386b, this.f4387c);
    }
}
