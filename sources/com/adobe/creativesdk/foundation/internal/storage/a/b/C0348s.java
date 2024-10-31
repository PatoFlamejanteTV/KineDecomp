package com.adobe.creativesdk.foundation.internal.storage.a.b;

import com.adobe.creativesdk.foundation.network.AdobeNetworkException;

/* compiled from: AdobeStorageSession.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.a.b.s, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0348s implements sa {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0349t f5473a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0348s(C0349t c0349t) {
        this.f5473a = c0349t;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.sa
    public void a(com.adobe.creativesdk.foundation.internal.net.l lVar) {
        C0350u c0350u = this.f5473a.f5475b;
        this.f5473a.f5474a.a(c0350u.f5479d.a(lVar, c0350u.f5476a));
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.sa
    public void b(com.adobe.creativesdk.foundation.internal.net.l lVar) {
        C0350u c0350u = this.f5473a.f5475b;
        this.f5473a.f5474a.a(c0350u.f5479d.a(lVar, c0350u.f5476a));
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.sa
    public void a(AdobeNetworkException adobeNetworkException) {
        this.f5473a.f5474a.a(adobeNetworkException);
    }
}
