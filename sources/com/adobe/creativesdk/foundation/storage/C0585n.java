package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.internal.utils.logging.Level;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeAssetFile.java */
/* renamed from: com.adobe.creativesdk.foundation.storage.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0585n implements com.adobe.creativesdk.foundation.internal.storage.a.b.va {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ sd f7357a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f7358b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ AdobeAssetFile f7359c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0585n(AdobeAssetFile adobeAssetFile, sd sdVar, int i) {
        this.f7359c = adobeAssetFile;
        this.f7357a = sdVar;
        this.f7358b = i;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.va
    public void a(com.adobe.creativesdk.foundation.internal.storage.model.resources.f fVar) {
        this.f7359c.dataRequest = null;
        if (fVar != null) {
            this.f7357a.b(true);
        }
    }

    @Override // com.adobe.creativesdk.foundation.storage.ud
    public void a(double d2) {
        this.f7357a.a(d2);
    }

    @Override // c.a.a.a.c
    public void a(AdobeAssetException adobeAssetException) {
        if (adobeAssetException != null && adobeAssetException.getErrorCode() == AdobeAssetErrorCode.AdobeAssetErrorCancelled) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.INFO, "AssetFile.getPage", "Data Request for page " + this.f7358b + " in " + this.f7359c.href + "has been cancelled");
            this.f7357a.a();
            return;
        }
        if (adobeAssetException != null) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.INFO, "AssetFile.getPage", "Data Request for page " + this.f7358b + " in " + this.f7359c.href + "ended in error", adobeAssetException);
            this.f7357a.a((sd) adobeAssetException);
        }
    }
}
