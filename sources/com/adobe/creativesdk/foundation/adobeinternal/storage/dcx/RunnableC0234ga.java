package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import com.adobe.creativesdk.foundation.adobeinternal.net.AdobeNetworkReachability;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeDCXController.java */
/* renamed from: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.ga, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class RunnableC0234ga implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ nb f4379a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Aa f4380b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ AdobeNetworkReachability.AdobeNetworkStatusCode f4381c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Aa f4382d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0234ga(Aa aa, nb nbVar, Aa aa2, AdobeNetworkReachability.AdobeNetworkStatusCode adobeNetworkStatusCode) {
        this.f4382d = aa;
        this.f4379a = nbVar;
        this.f4380b = aa2;
        this.f4381c = adobeNetworkStatusCode;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4379a.a(this.f4380b, this.f4381c);
    }
}
