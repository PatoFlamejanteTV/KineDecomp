package com.adobe.creativesdk.foundation.internal.storage.a.b;

import com.adobe.creativesdk.foundation.network.AdobeNetworkException;

/* compiled from: AdobeStorageSession.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.a.b.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0340j implements sa {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0341k f5424a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0340j(C0341k c0341k) {
        this.f5424a = c0341k;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.sa
    public void a(com.adobe.creativesdk.foundation.internal.net.l lVar) {
        this.f5424a.f5427a.onComplete();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.sa
    public void b(com.adobe.creativesdk.foundation.internal.net.l lVar) {
        this.f5424a.f5427a.a(ra.a(lVar));
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.sa
    public void a(AdobeNetworkException adobeNetworkException) {
        this.f5424a.f5427a.a(ra.a(adobeNetworkException));
    }
}
