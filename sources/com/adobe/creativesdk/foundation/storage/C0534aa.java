package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.internal.cache.AdobeCommonCacheHitLocation;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeAssetFolder.java */
/* renamed from: com.adobe.creativesdk.foundation.storage.aa, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0534aa implements com.adobe.creativesdk.foundation.internal.cache.e<Map<String, Object>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ byte[] f7197a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C0538ba f7198b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0534aa(C0538ba c0538ba, byte[] bArr) {
        this.f7198b = c0538ba;
        this.f7197a = bArr;
    }

    @Override // com.adobe.creativesdk.foundation.internal.cache.e
    public void a(Map<String, Object> map, AdobeCommonCacheHitLocation adobeCommonCacheHitLocation) {
        String str = (String) map.get("etag");
        if (str != null && str.equals(this.f7198b.f7208d.etag)) {
            try {
                this.f7198b.f7205a.b(new JSONObject(new String(this.f7197a)));
                return;
            } catch (JSONException e2) {
                this.f7198b.f7206b.a(new AdobeAssetException(AdobeAssetErrorCode.AdobeAssetErrorUnexpectedResponse));
                e2.printStackTrace();
                return;
            }
        }
        com.adobe.creativesdk.foundation.internal.cache.d.b().a(this.f7198b.f7208d.GUID, "com.adobe.cc.storage");
        C0538ba c0538ba = this.f7198b;
        c0538ba.f7208d.b((c.a.a.a.b<JSONObject>) c0538ba.f7205a, (c.a.a.a.c<AdobeAssetException>) c0538ba.f7206b);
    }

    @Override // com.adobe.creativesdk.foundation.internal.cache.e
    public void a() {
        C0538ba c0538ba = this.f7198b;
        c0538ba.f7208d.b((c.a.a.a.b<JSONObject>) c0538ba.f7205a, (c.a.a.a.c<AdobeAssetException>) c0538ba.f7206b);
    }
}
