package com.adobe.creativesdk.foundation.internal.storage.a.b;

import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0225c;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.ib;
import com.adobe.creativesdk.foundation.internal.storage.a.b.ra;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeStorageSession.java */
/* loaded from: classes.dex */
public class ia implements ra.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ib f5421a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C0225c f5422b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ ra f5423c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ia(ra raVar, ib ibVar, C0225c c0225c) {
        this.f5423c = raVar;
        this.f5421a = ibVar;
        this.f5422b = c0225c;
    }

    @Override // com.adobe.creativesdk.foundation.storage.ud
    public void a(double d2) {
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ra.b
    public void a(AdobeNetworkException adobeNetworkException) {
        if (adobeNetworkException.getData() != null) {
            com.adobe.creativesdk.foundation.internal.net.l lVar = (com.adobe.creativesdk.foundation.internal.net.l) adobeNetworkException.getData().get("Response");
            if (lVar != null) {
                a(lVar);
                return;
            } else {
                this.f5421a.a(null, adobeNetworkException);
                return;
            }
        }
        this.f5421a.a(null, ra.a(adobeNetworkException));
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ra.b
    public void a(com.adobe.creativesdk.foundation.internal.net.l lVar) {
        int g2 = lVar.g();
        this.f5421a.a(this.f5422b, (g2 == 200 || g2 == 204 || g2 == 404) ? null : ra.a(lVar));
    }
}
