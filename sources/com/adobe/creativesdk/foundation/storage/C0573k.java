package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.internal.cache.AdobeCommonCacheOptions;
import java.io.UnsupportedEncodingException;
import java.util.EnumSet;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeAssetFile.java */
/* renamed from: com.adobe.creativesdk.foundation.storage.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0573k implements com.adobe.creativesdk.foundation.internal.storage.a.b.ua {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.b f7311a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.c f7312b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ AdobeAssetFile f7313c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0573k(AdobeAssetFile adobeAssetFile, c.a.a.a.b bVar, c.a.a.a.c cVar) {
        this.f7313c = adobeAssetFile;
        this.f7311a = bVar;
        this.f7312b = cVar;
    }

    @Override // com.adobe.creativesdk.foundation.storage.ud
    public void a(double d2) {
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ua
    public void a(byte[] bArr) {
        String a2;
        if (bArr != null) {
            JSONObject jSONObject = null;
            try {
                jSONObject = com.adobe.creativesdk.foundation.internal.storage.model.util.i.a(new String(bArr, "UTF-8"));
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
            this.f7311a.b(jSONObject);
            com.adobe.creativesdk.foundation.internal.cache.d b2 = com.adobe.creativesdk.foundation.internal.cache.d.b();
            a2 = this.f7313c.a();
            b2.a(bArr, a2, "video-data", EnumSet.of(AdobeCommonCacheOptions.AdobeCommonCacheKeepInMemoryCache, AdobeCommonCacheOptions.AdobeCommonCacheKeepOnDiskCache), "com.adobe.cc.storage", new C0569j(this));
        }
    }

    @Override // c.a.a.a.c
    public void a(AdobeAssetException adobeAssetException) {
        this.f7312b.a(adobeAssetException);
    }
}
