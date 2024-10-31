package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.internal.cache.AdobeCommonCacheOptions;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/* compiled from: AdobeAssetFile.java */
/* renamed from: com.adobe.creativesdk.foundation.storage.t, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0608t implements c.a.a.a.b<Boolean> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0612u f7424a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0608t(C0612u c0612u) {
        this.f7424a = c0612u;
    }

    @Override // c.a.a.a.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(Boolean bool) {
        String a2;
        if (bool.booleanValue()) {
            if (this.f7424a.f7435c.md5Hash != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("md5", this.f7424a.f7435c.md5Hash);
                hashMap.put("modified", this.f7424a.f7435c.modificationDate);
                hashMap.put("etag", this.f7424a.f7435c.etag);
                com.adobe.creativesdk.foundation.internal.cache.d b2 = com.adobe.creativesdk.foundation.internal.cache.d.b();
                a2 = this.f7424a.f7435c.a();
                b2.a((Map) hashMap, a2, "modified-data", EnumSet.of(AdobeCommonCacheOptions.AdobeCommonCacheKeepInMemoryCache, AdobeCommonCacheOptions.AdobeCommonCacheKeepOnDiskCache), "com.adobe.cc.storage");
                return;
            }
            return;
        }
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "AdobeAssetFile:getData", String.format("Adding to caches is failed for %s", this.f7424a.f7435c.href));
    }
}
