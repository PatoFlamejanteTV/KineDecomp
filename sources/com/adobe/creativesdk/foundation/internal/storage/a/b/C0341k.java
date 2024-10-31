package com.adobe.creativesdk.foundation.internal.storage.a.b;

import com.adobe.creativesdk.foundation.internal.storage.a.b.ra;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeStorageSession.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.a.b.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0341k implements ra.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ wa f5427a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ra f5428b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ ra f5429c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0341k(ra raVar, wa waVar, ra raVar2) {
        this.f5429c = raVar;
        this.f5427a = waVar;
        this.f5428b = raVar2;
    }

    @Override // com.adobe.creativesdk.foundation.storage.ud
    public void a(double d2) {
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ra.b
    public void a(com.adobe.creativesdk.foundation.internal.net.l lVar) {
        if (lVar.g() == 200) {
            this.f5427a.onComplete();
        } else if (lVar.g() == 202) {
            new C0332b(1L, this.f5428b, new C0340j(this)).a(lVar);
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ra.b
    public void a(AdobeNetworkException adobeNetworkException) {
        this.f5427a.a(ra.a(adobeNetworkException));
    }
}
