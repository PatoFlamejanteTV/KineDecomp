package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.network.AdobeNetworkException;

/* compiled from: AdobeAssetPSDFile.java */
/* loaded from: classes.dex */
class Ea implements com.adobe.creativesdk.foundation.adobeinternal.imageservice.v {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ sd f6955a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobeAssetPSDFile f6956b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.internal.storage.model.resources.f f6957c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ea(sd sdVar, AdobeAssetPSDFile adobeAssetPSDFile, com.adobe.creativesdk.foundation.internal.storage.model.resources.f fVar) {
        this.f6955a = sdVar;
        this.f6956b = adobeAssetPSDFile;
        this.f6957c = fVar;
    }

    @Override // com.adobe.creativesdk.foundation.storage.ud
    public void a(double d2) {
        this.f6955a.a(d2);
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.imageservice.v
    public void a(com.adobe.creativesdk.foundation.adobeinternal.imageservice.b bVar) {
        AdobeAssetPSDFile adobeAssetPSDFile = this.f6956b;
        adobeAssetPSDFile.etag = this.f6957c.f6613e;
        this.f6955a.b(adobeAssetPSDFile);
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.imageservice.v
    public void a(AdobeNetworkException adobeNetworkException) {
        this.f6955a.a((sd) adobeNetworkException);
    }
}
