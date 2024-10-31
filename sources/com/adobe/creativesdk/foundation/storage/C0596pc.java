package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.internal.cache.AdobeCommonCacheOptions;
import java.util.EnumSet;

/* compiled from: AdobePhotoAsset.java */
/* renamed from: com.adobe.creativesdk.foundation.storage.pc, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0596pc implements c.a.a.a.b<byte[]> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0603rc f7383a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0596pc(C0603rc c0603rc) {
        this.f7383a = c0603rc;
    }

    @Override // c.a.a.a.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(byte[] bArr) {
        this.f7383a.f7406c.handleCommonDownloadCompletionBookKeeping();
        this.f7383a.f7404a.b(bArr);
        com.adobe.creativesdk.foundation.internal.cache.d b2 = com.adobe.creativesdk.foundation.internal.cache.d.b();
        C0603rc c0603rc = this.f7383a;
        b2.a(bArr, c0603rc.f7406c._GUID, c0603rc.f7405b, EnumSet.of(AdobeCommonCacheOptions.AdobeCommonCacheKeepInMemoryCache, AdobeCommonCacheOptions.AdobeCommonCacheKeepOnDiskCache), "com.adobe.cc.photo", new C0592oc(this));
    }
}
