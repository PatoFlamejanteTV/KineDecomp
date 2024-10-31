package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.internal.cache.AdobeCommonCacheHitLocation;
import com.adobe.creativesdk.foundation.internal.cache.AdobeCommonCacheOptions;
import java.util.EnumSet;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeAssetFolder.java */
/* renamed from: com.adobe.creativesdk.foundation.storage.ba, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0538ba implements com.adobe.creativesdk.foundation.internal.cache.e<byte[]> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.b f7205a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.c f7206b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ X f7207c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ C0578la f7208d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0538ba(C0578la c0578la, c.a.a.a.b bVar, c.a.a.a.c cVar, X x) {
        this.f7208d = c0578la;
        this.f7205a = bVar;
        this.f7206b = cVar;
        this.f7207c = x;
    }

    @Override // com.adobe.creativesdk.foundation.internal.cache.e
    public void a(byte[] bArr, AdobeCommonCacheHitLocation adobeCommonCacheHitLocation) {
        com.adobe.creativesdk.foundation.internal.cache.d.b().b(this.f7208d.getGUID(), "modified-data", EnumSet.of(AdobeCommonCacheOptions.AdobeCommonCacheKeepInMemoryCache, AdobeCommonCacheOptions.AdobeCommonCacheKeepOnDiskCache), "com.adobe.cc.storage", new C0534aa(this, bArr), this.f7207c.f7160a);
    }

    @Override // com.adobe.creativesdk.foundation.internal.cache.e
    public void a() {
        this.f7208d.b((c.a.a.a.b<JSONObject>) this.f7205a, (c.a.a.a.c<AdobeAssetException>) this.f7206b);
    }
}
