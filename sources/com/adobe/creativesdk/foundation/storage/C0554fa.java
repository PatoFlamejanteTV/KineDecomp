package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.internal.cache.AdobeCommonCacheOptions;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/* compiled from: AdobeAssetFolder.java */
/* renamed from: com.adobe.creativesdk.foundation.storage.fa, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0554fa implements c.a.a.a.b<Boolean> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ RunnableC0562ha f7243a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0554fa(RunnableC0562ha runnableC0562ha) {
        this.f7243a = runnableC0562ha;
    }

    @Override // c.a.a.a.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(Boolean bool) {
        if (bool.booleanValue()) {
            if (this.f7243a.f7273b.f7288d.etag != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("modified", this.f7243a.f7273b.f7288d.modificationDate);
                hashMap.put("etag", this.f7243a.f7273b.f7288d.etag);
                com.adobe.creativesdk.foundation.internal.cache.d.b().a((Map) hashMap, this.f7243a.f7273b.f7288d.getGUID(), "modified-data", EnumSet.of(AdobeCommonCacheOptions.AdobeCommonCacheKeepInMemoryCache, AdobeCommonCacheOptions.AdobeCommonCacheKeepOnDiskCache), "com.adobe.cc.storage");
                return;
            }
            return;
        }
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "AdobeAssetFolder:getPageDataFromServer", String.format("Adding to caches is failed for %s", this.f7243a.f7273b.f7288d.href));
    }
}
