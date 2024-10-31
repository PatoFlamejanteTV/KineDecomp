package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.internal.cache.AdobeCommonCacheHitLocation;
import java.util.Map;

/* compiled from: AdobeAssetFile.java */
/* renamed from: com.adobe.creativesdk.foundation.storage.q, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0597q implements com.adobe.creativesdk.foundation.internal.cache.e<Map<String, Object>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ r f7387a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0597q(r rVar) {
        this.f7387a = rVar;
    }

    @Override // com.adobe.creativesdk.foundation.internal.cache.e
    public void a(Map<String, Object> map, AdobeCommonCacheHitLocation adobeCommonCacheHitLocation) {
        String a2;
        String str = (String) map.get("md5");
        if (str != null && str.equals(this.f7387a.f7397d.md5Hash)) {
            this.f7387a.f7394a.b(null);
            return;
        }
        com.adobe.creativesdk.foundation.internal.cache.d b2 = com.adobe.creativesdk.foundation.internal.cache.d.b();
        a2 = this.f7387a.f7397d.a();
        b2.a(a2, "com.adobe.cc.storage");
        r rVar = this.f7387a;
        rVar.f7397d.getDataForPageSaveToDevice(0, rVar.f7394a, rVar.f7395b);
    }

    @Override // com.adobe.creativesdk.foundation.internal.cache.e
    public void a() {
        r rVar = this.f7387a;
        rVar.f7397d.getDataForPageSaveToDevice(0, rVar.f7394a, rVar.f7395b);
    }
}
