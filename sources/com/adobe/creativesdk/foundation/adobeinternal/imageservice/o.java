package com.adobe.creativesdk.foundation.adobeinternal.imageservice;

import com.adobe.creativesdk.foundation.network.AdobeNetworkException;
import com.adobe.creativesdk.foundation.storage.sd;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeImageSession.java */
/* loaded from: classes.dex */
public class o implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ sd f4044a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobeNetworkException f4045b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ t f4046c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(t tVar, sd sdVar, AdobeNetworkException adobeNetworkException) {
        this.f4046c = tVar;
        this.f4044a = sdVar;
        this.f4045b = adobeNetworkException;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4044a.a((sd) this.f4045b);
    }
}
