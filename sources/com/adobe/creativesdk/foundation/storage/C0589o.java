package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.internal.cache.AdobeCommonCacheHitLocation;
import java.util.Map;

/* compiled from: AdobeAssetFile.java */
/* renamed from: com.adobe.creativesdk.foundation.storage.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0589o implements com.adobe.creativesdk.foundation.internal.cache.e<Map<String, Object>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ byte[] f7368a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C0593p f7369b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0589o(C0593p c0593p, byte[] bArr) {
        this.f7369b = c0593p;
        this.f7368a = bArr;
    }

    @Override // com.adobe.creativesdk.foundation.internal.cache.e
    public void a(Map<String, Object> map, AdobeCommonCacheHitLocation adobeCommonCacheHitLocation) {
        String a2;
        String str = (String) map.get("md5");
        if (str != null && str.equals(this.f7369b.f7377c.md5Hash)) {
            this.f7369b.f7375a.b(this.f7368a);
            return;
        }
        com.adobe.creativesdk.foundation.internal.cache.d b2 = com.adobe.creativesdk.foundation.internal.cache.d.b();
        a2 = this.f7369b.f7377c.a();
        b2.a(a2, "com.adobe.cc.storage");
        C0593p c0593p = this.f7369b;
        c0593p.f7377c.getDataForPage(0, c0593p.f7375a);
    }

    @Override // com.adobe.creativesdk.foundation.internal.cache.e
    public void a() {
        C0593p c0593p = this.f7369b;
        c0593p.f7377c.getDataForPage(0, c0593p.f7375a);
    }
}
