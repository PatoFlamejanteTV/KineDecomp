package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.internal.cache.AdobeCommonCacheOptions;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import java.util.EnumSet;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeAssetFile.java */
/* renamed from: com.adobe.creativesdk.foundation.storage.u, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0612u implements com.adobe.creativesdk.foundation.internal.storage.a.b.va {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ sd f7433a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f7434b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ AdobeAssetFile f7435c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0612u(AdobeAssetFile adobeAssetFile, sd sdVar, int i) {
        this.f7435c = adobeAssetFile;
        this.f7433a = sdVar;
        this.f7434b = i;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.va
    public void a(com.adobe.creativesdk.foundation.internal.storage.model.resources.f fVar) {
        String a2;
        String a3;
        this.f7435c.dataRequest = null;
        if (fVar != null) {
            com.adobe.creativesdk.foundation.internal.cache.d b2 = com.adobe.creativesdk.foundation.internal.cache.d.b();
            byte[] d2 = fVar.d();
            a2 = this.f7435c.a();
            a3 = this.f7435c.a();
            b2.a(d2, a2, a3, EnumSet.of(AdobeCommonCacheOptions.AdobeCommonCacheKeepInMemoryCache, AdobeCommonCacheOptions.AdobeCommonCacheKeepOnDiskCache), "com.adobe.cc.storage", new C0608t(this));
            this.f7433a.b(fVar.d());
        }
    }

    @Override // com.adobe.creativesdk.foundation.storage.ud
    public void a(double d2) {
        this.f7433a.a(d2);
    }

    @Override // c.a.a.a.c
    public void a(AdobeAssetException adobeAssetException) {
        if (adobeAssetException != null && adobeAssetException.getErrorCode() == AdobeAssetErrorCode.AdobeAssetErrorCancelled) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.INFO, "AssetFile.getPage", "Data Request for page " + this.f7434b + " in " + this.f7435c.href + "has been cancelled");
            this.f7433a.a();
            return;
        }
        if (adobeAssetException != null) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.INFO, "AssetFile.getPage", "Data Request for page " + this.f7434b + " in " + this.f7435c.href + "ended in error", adobeAssetException);
            this.f7433a.a((sd) adobeAssetException);
        }
    }
}
