package com.adobe.creativesdk.foundation.internal.storage.a.b;

import com.adobe.creativesdk.foundation.network.AdobeNetworkException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeStorageSession.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.a.b.q, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0347q implements com.adobe.creativesdk.foundation.internal.net.F {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.internal.net.F f5466a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C0350u f5467b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0347q(C0350u c0350u, com.adobe.creativesdk.foundation.internal.net.F f2) {
        this.f5467b = c0350u;
        this.f5466a = f2;
    }

    @Override // com.adobe.creativesdk.foundation.internal.net.F
    public void a(com.adobe.creativesdk.foundation.internal.net.l lVar) {
        this.f5466a.a(lVar);
    }

    @Override // com.adobe.creativesdk.foundation.internal.net.F
    public void a(AdobeNetworkException adobeNetworkException) {
        this.f5466a.a(adobeNetworkException);
    }
}
