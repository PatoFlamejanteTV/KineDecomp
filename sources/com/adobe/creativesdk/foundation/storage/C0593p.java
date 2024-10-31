package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.internal.cache.AdobeCommonCacheHitLocation;
import com.adobe.creativesdk.foundation.internal.cache.AdobeCommonCacheOptions;
import java.util.EnumSet;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeAssetFile.java */
/* renamed from: com.adobe.creativesdk.foundation.storage.p, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0593p implements com.adobe.creativesdk.foundation.internal.cache.e<byte[]> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ sd f7375a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ B f7376b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ AdobeAssetFile f7377c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0593p(AdobeAssetFile adobeAssetFile, sd sdVar, B b2) {
        this.f7377c = adobeAssetFile;
        this.f7375a = sdVar;
        this.f7376b = b2;
    }

    @Override // com.adobe.creativesdk.foundation.internal.cache.e
    public void a(byte[] bArr, AdobeCommonCacheHitLocation adobeCommonCacheHitLocation) {
        String a2;
        C0589o c0589o = new C0589o(this, bArr);
        com.adobe.creativesdk.foundation.internal.cache.d b2 = com.adobe.creativesdk.foundation.internal.cache.d.b();
        a2 = this.f7377c.a();
        b2.b(a2, "modified-data", EnumSet.of(AdobeCommonCacheOptions.AdobeCommonCacheKeepInMemoryCache), "com.adobe.cc.storage", c0589o, this.f7376b.f6928a);
    }

    @Override // com.adobe.creativesdk.foundation.internal.cache.e
    public void a() {
        this.f7377c.getDataForPage(0, this.f7375a);
    }
}
