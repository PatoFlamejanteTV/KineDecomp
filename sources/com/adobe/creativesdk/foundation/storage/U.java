package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.internal.cache.AdobeCommonCacheHitLocation;
import com.adobe.creativesdk.foundation.internal.cache.AdobeCommonCacheOptions;
import java.util.EnumSet;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeAssetFile.java */
/* loaded from: classes.dex */
public class U implements com.adobe.creativesdk.foundation.internal.cache.e<byte[]> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ sd f7134a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobeAssetFileRenditionType f7135b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ C0582ma f7136c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f7137d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ C0632z f7138e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ AdobeAssetFile f7139f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public U(AdobeAssetFile adobeAssetFile, sd sdVar, AdobeAssetFileRenditionType adobeAssetFileRenditionType, C0582ma c0582ma, int i, C0632z c0632z) {
        this.f7139f = adobeAssetFile;
        this.f7134a = sdVar;
        this.f7135b = adobeAssetFileRenditionType;
        this.f7136c = c0582ma;
        this.f7137d = i;
        this.f7138e = c0632z;
    }

    @Override // com.adobe.creativesdk.foundation.internal.cache.e
    public void a(byte[] bArr, AdobeCommonCacheHitLocation adobeCommonCacheHitLocation) {
        String a2;
        T t = new T(this, bArr);
        com.adobe.creativesdk.foundation.internal.cache.d b2 = com.adobe.creativesdk.foundation.internal.cache.d.b();
        a2 = this.f7139f.a();
        b2.b(a2, "modified-data", EnumSet.of(AdobeCommonCacheOptions.AdobeCommonCacheKeepInMemoryCache), "com.adobe.cc.storage", t, this.f7138e.f7482a);
    }

    @Override // com.adobe.creativesdk.foundation.internal.cache.e
    public void a() {
        this.f7139f.a(this.f7135b, this.f7136c, this.f7137d, this.f7134a);
    }
}
