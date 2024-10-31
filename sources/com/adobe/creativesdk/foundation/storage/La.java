package com.adobe.creativesdk.foundation.storage;

import android.os.Handler;
import com.adobe.creativesdk.foundation.internal.cache.AdobeCommonCacheHitLocation;
import com.adobe.creativesdk.foundation.internal.cache.AdobeCommonCacheOptions;
import java.util.EnumSet;

/* compiled from: AdobeAssetPSDFile.java */
/* loaded from: classes.dex */
class La implements com.adobe.creativesdk.foundation.internal.cache.e<byte[]> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ sd f7040a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Integer f7041b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Integer f7042c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ AdobeAssetFileRenditionType f7043d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ C0582ma f7044e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ String f7045f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ Handler f7046g;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ AdobeAssetPSDFile f7047h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public La(AdobeAssetPSDFile adobeAssetPSDFile, sd sdVar, Integer num, Integer num2, AdobeAssetFileRenditionType adobeAssetFileRenditionType, C0582ma c0582ma, String str, Handler handler) {
        this.f7047h = adobeAssetPSDFile;
        this.f7040a = sdVar;
        this.f7041b = num;
        this.f7042c = num2;
        this.f7043d = adobeAssetFileRenditionType;
        this.f7044e = c0582ma;
        this.f7045f = str;
        this.f7046g = handler;
    }

    @Override // com.adobe.creativesdk.foundation.internal.cache.e
    public void a(byte[] bArr, AdobeCommonCacheHitLocation adobeCommonCacheHitLocation) {
        com.adobe.creativesdk.foundation.internal.cache.d.b().b(this.f7047h.resourceItem().f6609a, "modified-data", EnumSet.of(AdobeCommonCacheOptions.AdobeCommonCacheKeepInMemoryCache), "com.adobe.cc.storage", new Ka(this, bArr), this.f7046g);
    }

    @Override // com.adobe.creativesdk.foundation.internal.cache.e
    public void a() {
        this.f7047h.getRenditionFromServerForLayer(this.f7041b, this.f7042c, this.f7043d, this.f7044e, this.f7045f, this.f7040a, this.f7046g);
    }
}
