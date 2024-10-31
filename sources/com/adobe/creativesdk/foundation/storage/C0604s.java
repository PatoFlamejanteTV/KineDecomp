package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.internal.utils.logging.Level;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeAssetFile.java */
/* renamed from: com.adobe.creativesdk.foundation.storage.s, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0604s implements com.adobe.creativesdk.foundation.internal.storage.a.b.va {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ sd f7407a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f7408b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ AdobeAssetFile f7409c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0604s(AdobeAssetFile adobeAssetFile, sd sdVar, int i) {
        this.f7409c = adobeAssetFile;
        this.f7407a = sdVar;
        this.f7408b = i;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.va
    public void a(com.adobe.creativesdk.foundation.internal.storage.model.resources.f fVar) {
        this.f7409c.dataRequest = null;
        if (fVar != null) {
            this.f7407a.b(null);
        }
    }

    @Override // com.adobe.creativesdk.foundation.storage.ud
    public void a(double d2) {
        this.f7407a.a(d2);
    }

    @Override // c.a.a.a.c
    public void a(AdobeAssetException adobeAssetException) {
        if (adobeAssetException != null && adobeAssetException.getErrorCode() == AdobeAssetErrorCode.AdobeAssetErrorCancelled) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.INFO, "AssetFile.getPage", "Data Request for page " + this.f7408b + " in " + this.f7409c.href + "has been cancelled");
            this.f7407a.a();
            return;
        }
        if (adobeAssetException != null) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.INFO, "AssetFile.getPage", "Data Request for page " + this.f7408b + " in " + this.f7409c.href + "ended in error", adobeAssetException);
            this.f7407a.a((sd) adobeAssetException);
        }
    }
}
