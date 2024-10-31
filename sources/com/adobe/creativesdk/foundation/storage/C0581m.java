package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.internal.cache.AdobeCommonCacheOptions;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import java.util.EnumSet;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeAssetFile.java */
/* renamed from: com.adobe.creativesdk.foundation.storage.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0581m implements com.adobe.creativesdk.foundation.internal.storage.a.b.ua {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AdobeAssetFileRenditionType f7343a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C0582ma f7344b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f7345c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ sd f7346d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ AdobeAssetFile f7347e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0581m(AdobeAssetFile adobeAssetFile, AdobeAssetFileRenditionType adobeAssetFileRenditionType, C0582ma c0582ma, int i, sd sdVar) {
        this.f7347e = adobeAssetFile;
        this.f7343a = adobeAssetFileRenditionType;
        this.f7344b = c0582ma;
        this.f7345c = i;
        this.f7346d = sdVar;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ua
    public void a(byte[] bArr) {
        String a2;
        String a3;
        this.f7347e.renditionRequest = null;
        if (bArr != null) {
            com.adobe.creativesdk.foundation.internal.cache.d b2 = com.adobe.creativesdk.foundation.internal.cache.d.b();
            a2 = this.f7347e.a();
            a3 = this.f7347e.a(this.f7343a, this.f7344b, this.f7345c);
            b2.a(bArr, a2, a3, EnumSet.of(AdobeCommonCacheOptions.AdobeCommonCacheKeepInMemoryCache, AdobeCommonCacheOptions.AdobeCommonCacheKeepOnDiskCache), "com.adobe.cc.storage", new C0577l(this));
        }
        this.f7346d.b(bArr);
    }

    @Override // com.adobe.creativesdk.foundation.storage.ud
    public void a(double d2) {
        this.f7346d.a(d2);
    }

    @Override // c.a.a.a.c
    public void a(AdobeAssetException adobeAssetException) {
        if (adobeAssetException != null && adobeAssetException.getErrorCode() == AdobeAssetErrorCode.AdobeAssetErrorCancelled) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.INFO, "AssetFile.getRendition", "Renditon Request for " + this.f7347e.href + "has been cancelled");
            this.f7346d.a();
            return;
        }
        if (adobeAssetException != null) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.INFO, "AssetFile.getRendition", "Renditon Request for " + this.f7347e.href + "ended in error", adobeAssetException);
            this.f7346d.a((sd) adobeAssetException);
        }
    }
}
