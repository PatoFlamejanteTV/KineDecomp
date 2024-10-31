package com.adobe.creativesdk.foundation.adobeinternal.imageservice;

import com.adobe.creativesdk.foundation.network.AdobeNetworkException;
import com.adobe.creativesdk.foundation.storage.sd;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeImageSession.java */
/* loaded from: classes.dex */
public class p implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ sd f4047a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobeNetworkException f4048b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ t f4049c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(t tVar, sd sdVar, AdobeNetworkException adobeNetworkException) {
        this.f4049c = tVar;
        this.f4047a = sdVar;
        this.f4048b = adobeNetworkException;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4047a.a((sd) this.f4048b);
    }
}
