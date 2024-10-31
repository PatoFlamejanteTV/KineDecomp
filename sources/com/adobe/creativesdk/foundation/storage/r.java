package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.internal.cache.AdobeCommonCacheHitLocation;
import com.adobe.creativesdk.foundation.internal.cache.AdobeCommonCacheOptions;
import java.util.EnumSet;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeAssetFile.java */
/* loaded from: classes.dex */
public class r implements com.adobe.creativesdk.foundation.internal.cache.e<byte[]> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ sd f7394a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f7395b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ E f7396c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ AdobeAssetFile f7397d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(AdobeAssetFile adobeAssetFile, sd sdVar, String str, E e2) {
        this.f7397d = adobeAssetFile;
        this.f7394a = sdVar;
        this.f7395b = str;
        this.f7396c = e2;
    }

    @Override // com.adobe.creativesdk.foundation.internal.cache.e
    public void a(byte[] bArr, AdobeCommonCacheHitLocation adobeCommonCacheHitLocation) {
        String a2;
        C0597q c0597q = new C0597q(this);
        com.adobe.creativesdk.foundation.internal.cache.d b2 = com.adobe.creativesdk.foundation.internal.cache.d.b();
        a2 = this.f7397d.a();
        b2.b(a2, "modified-data", EnumSet.of(AdobeCommonCacheOptions.AdobeCommonCacheKeepInMemoryCache), "com.adobe.cc.storage", c0597q, this.f7396c.f6953a);
    }

    @Override // com.adobe.creativesdk.foundation.internal.cache.e
    public void a() {
        this.f7397d.getDataForPageSaveToDevice(0, this.f7394a, this.f7395b);
    }
}
