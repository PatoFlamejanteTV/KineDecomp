package com.adobe.creativesdk.foundation.adobeinternal.imageservice;

import com.adobe.creativesdk.foundation.network.AdobeNetworkException;
import com.adobe.creativesdk.foundation.storage.sd;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeImageSession.java */
/* loaded from: classes.dex */
public class l implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ sd f4034a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobeNetworkException f4035b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ t f4036c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(t tVar, sd sdVar, AdobeNetworkException adobeNetworkException) {
        this.f4036c = tVar;
        this.f4034a = sdVar;
        this.f4035b = adobeNetworkException;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4034a.a((sd) this.f4035b);
    }
}
