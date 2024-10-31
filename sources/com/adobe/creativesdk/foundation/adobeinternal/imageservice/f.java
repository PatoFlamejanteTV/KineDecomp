package com.adobe.creativesdk.foundation.adobeinternal.imageservice;

import com.adobe.creativesdk.foundation.network.AdobeNetworkException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeImageSession.java */
/* loaded from: classes.dex */
public class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ v f4004a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobeNetworkException f4005b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ t f4006c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(t tVar, v vVar, AdobeNetworkException adobeNetworkException) {
        this.f4006c = tVar;
        this.f4004a = vVar;
        this.f4005b = adobeNetworkException;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4004a.a(this.f4005b);
    }
}
