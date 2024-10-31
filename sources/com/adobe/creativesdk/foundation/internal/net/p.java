package com.adobe.creativesdk.foundation.internal.net;

import com.adobe.creativesdk.foundation.network.AdobeNetworkException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeNetworkHttpService.java */
/* loaded from: classes.dex */
public class p implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ F f5139a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ E f5140b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ A f5141c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(A a2, F f2, E e2) {
        this.f5141c = a2;
        this.f5139a = f2;
        this.f5140b = e2;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f5139a != null) {
            this.f5139a.a(new AdobeNetworkException(AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorCancelled, null));
        }
        this.f5140b.e();
    }
}
