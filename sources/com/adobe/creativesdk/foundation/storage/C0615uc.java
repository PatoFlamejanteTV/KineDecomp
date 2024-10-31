package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.internal.cache.AdobeCommonCacheOptions;
import java.util.EnumSet;

/* compiled from: AdobePhotoAsset.java */
/* renamed from: com.adobe.creativesdk.foundation.storage.uc, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0615uc implements c.a.a.a.b<byte[]> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0623wc f7446a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0615uc(C0623wc c0623wc) {
        this.f7446a = c0623wc;
    }

    @Override // c.a.a.a.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(byte[] bArr) {
        this.f7446a.f7463d.handleCommonDownloadCompletionBookKeeping();
        this.f7446a.f7460a.b(bArr);
        com.adobe.creativesdk.foundation.internal.cache.d b2 = com.adobe.creativesdk.foundation.internal.cache.d.b();
        C0623wc c0623wc = this.f7446a;
        b2.a(bArr, c0623wc.f7463d._GUID, c0623wc.f7461b, EnumSet.of(AdobeCommonCacheOptions.AdobeCommonCacheKeepInMemoryCache, AdobeCommonCacheOptions.AdobeCommonCacheKeepOnDiskCache), "com.adobe.cc.photo", new C0611tc(this));
    }
}
