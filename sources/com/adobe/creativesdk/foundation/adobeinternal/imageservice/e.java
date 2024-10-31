package com.adobe.creativesdk.foundation.adobeinternal.imageservice;

import com.adobe.creativesdk.foundation.network.AdobeNetworkException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeImageSession.java */
/* loaded from: classes.dex */
public class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ v f4001a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobeNetworkException f4002b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ t f4003c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(t tVar, v vVar, AdobeNetworkException adobeNetworkException) {
        this.f4003c = tVar;
        this.f4001a = vVar;
        this.f4002b = adobeNetworkException;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4001a.a(this.f4002b);
    }
}
