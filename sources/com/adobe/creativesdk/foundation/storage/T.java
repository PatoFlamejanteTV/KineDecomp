package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.internal.cache.AdobeCommonCacheHitLocation;
import java.util.Map;

/* compiled from: AdobeAssetFile.java */
/* loaded from: classes.dex */
class T implements com.adobe.creativesdk.foundation.internal.cache.e<Map<String, Object>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ byte[] f7122a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ U f7123b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public T(U u, byte[] bArr) {
        this.f7123b = u;
        this.f7122a = bArr;
    }

    @Override // com.adobe.creativesdk.foundation.internal.cache.e
    public void a(Map<String, Object> map, AdobeCommonCacheHitLocation adobeCommonCacheHitLocation) {
        String a2;
        String str = (String) map.get("md5");
        if (str != null && str.equals(this.f7123b.f7139f.md5Hash)) {
            this.f7123b.f7134a.b(this.f7122a);
            return;
        }
        com.adobe.creativesdk.foundation.internal.cache.d b2 = com.adobe.creativesdk.foundation.internal.cache.d.b();
        a2 = this.f7123b.f7139f.a();
        b2.a(a2, "com.adobe.cc.storage");
        U u = this.f7123b;
        u.f7139f.a(u.f7135b, u.f7136c, u.f7137d, u.f7134a);
    }

    @Override // com.adobe.creativesdk.foundation.internal.cache.e
    public void a() {
        U u = this.f7123b;
        u.f7139f.a(u.f7135b, u.f7136c, u.f7137d, u.f7134a);
    }
}
