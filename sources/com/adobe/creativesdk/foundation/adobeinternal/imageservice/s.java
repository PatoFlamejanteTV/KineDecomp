package com.adobe.creativesdk.foundation.adobeinternal.imageservice;

import com.adobe.creativesdk.foundation.network.AdobeNetworkException;
import com.adobe.creativesdk.foundation.storage.sd;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeImageSession.java */
/* loaded from: classes.dex */
public class s implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ sd f4057a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobeNetworkException f4058b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ t f4059c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(t tVar, sd sdVar, AdobeNetworkException adobeNetworkException) {
        this.f4059c = tVar;
        this.f4057a = sdVar;
        this.f4058b = adobeNetworkException;
    }

    @Override // java.lang.Runnable
    public void run() {
        sd sdVar = this.f4057a;
        if (sdVar != null) {
            sdVar.a((sd) this.f4058b);
        }
    }
}
