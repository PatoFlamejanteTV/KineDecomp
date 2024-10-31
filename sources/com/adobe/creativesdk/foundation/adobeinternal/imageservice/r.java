package com.adobe.creativesdk.foundation.adobeinternal.imageservice;

import com.adobe.creativesdk.foundation.network.AdobeNetworkException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeImageSession.java */
/* loaded from: classes.dex */
public class r implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ v f4054a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobeNetworkException f4055b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ t f4056c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(t tVar, v vVar, AdobeNetworkException adobeNetworkException) {
        this.f4056c = tVar;
        this.f4054a = vVar;
        this.f4055b = adobeNetworkException;
    }

    @Override // java.lang.Runnable
    public void run() {
        v vVar = this.f4054a;
        if (vVar != null) {
            vVar.a(this.f4055b);
        }
    }
}
