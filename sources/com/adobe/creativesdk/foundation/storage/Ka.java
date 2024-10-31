package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.internal.cache.AdobeCommonCacheHitLocation;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeAssetPSDFile.java */
/* loaded from: classes.dex */
public class Ka implements com.adobe.creativesdk.foundation.internal.cache.e<Map<String, Object>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ byte[] f7033a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ La f7034b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ka(La la, byte[] bArr) {
        this.f7034b = la;
        this.f7033a = bArr;
    }

    @Override // com.adobe.creativesdk.foundation.internal.cache.e
    public void a(Map<String, Object> map, AdobeCommonCacheHitLocation adobeCommonCacheHitLocation) {
        String str = (String) map.get("md5");
        if (str != null && str.equals(this.f7034b.f7047h.md5Hash)) {
            sd sdVar = this.f7034b.f7040a;
            if (sdVar != null) {
                sdVar.b(this.f7033a);
                return;
            }
            return;
        }
        com.adobe.creativesdk.foundation.internal.cache.d.b().a(this.f7034b.f7047h.resourceItem().f6609a, "com.adobe.cc.storage");
        La la = this.f7034b;
        la.f7047h.getRenditionFromServerForLayer(la.f7041b, la.f7042c, la.f7043d, la.f7044e, la.f7045f, la.f7040a, la.f7046g);
    }

    @Override // com.adobe.creativesdk.foundation.internal.cache.e
    public void a() {
        La la = this.f7034b;
        la.f7047h.getRenditionFromServerForLayer(la.f7041b, la.f7042c, la.f7043d, la.f7044e, la.f7045f, la.f7040a, la.f7046g);
    }
}
