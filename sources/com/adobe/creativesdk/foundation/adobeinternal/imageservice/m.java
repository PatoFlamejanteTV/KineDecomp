package com.adobe.creativesdk.foundation.adobeinternal.imageservice;

import com.adobe.creativesdk.foundation.network.AdobeNetworkException;
import com.adobe.creativesdk.foundation.storage.sd;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeImageSession.java */
/* loaded from: classes.dex */
public class m implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ sd f4037a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobeNetworkException f4038b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ t f4039c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(t tVar, sd sdVar, AdobeNetworkException adobeNetworkException) {
        this.f4039c = tVar;
        this.f4037a = sdVar;
        this.f4038b = adobeNetworkException;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4037a.a((sd) this.f4038b);
    }
}
