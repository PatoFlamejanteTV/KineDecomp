package com.adobe.creativesdk.foundation.internal.storage.a.b;

import com.adobe.creativesdk.foundation.network.AdobeNetworkException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeStorageSession.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.a.b.t, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0349t implements com.adobe.creativesdk.foundation.internal.net.F {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.internal.net.F f5474a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C0350u f5475b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0349t(C0350u c0350u, com.adobe.creativesdk.foundation.internal.net.F f2) {
        this.f5475b = c0350u;
        this.f5474a = f2;
    }

    @Override // com.adobe.creativesdk.foundation.internal.net.F
    public void a(com.adobe.creativesdk.foundation.internal.net.l lVar) {
        if (lVar.g() == 202) {
            new C0332b(10L, this.f5475b.f5478c, new C0348s(this)).a(lVar);
        } else {
            this.f5474a.a(lVar);
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.net.F
    public void a(AdobeNetworkException adobeNetworkException) {
        this.f5474a.a(adobeNetworkException);
    }
}
