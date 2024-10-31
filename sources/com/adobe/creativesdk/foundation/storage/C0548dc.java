package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;

/* compiled from: AdobePhotoAsset.java */
/* renamed from: com.adobe.creativesdk.foundation.storage.dc, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0548dc implements c.a.a.a.c<AdobeCSDKException> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.internal.analytics.l f7230a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.c f7231b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ AdobePhotoAsset f7232c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0548dc(AdobePhotoAsset adobePhotoAsset, com.adobe.creativesdk.foundation.internal.analytics.l lVar, c.a.a.a.c cVar) {
        this.f7232c = adobePhotoAsset;
        this.f7230a = lVar;
        this.f7231b = cVar;
    }

    @Override // c.a.a.a.c
    public void a(AdobeCSDKException adobeCSDKException) {
        String str;
        this.f7230a.a("failure");
        if (adobeCSDKException instanceof AdobePhotoException) {
            this.f7231b.a((AdobePhotoException) adobeCSDKException);
            return;
        }
        Level level = Level.ERROR;
        String simpleName = AdobePhotoAsset.class.getSimpleName();
        StringBuilder sb = new StringBuilder();
        sb.append("Failed to delete photo asset ");
        str = this.f7232c._name;
        sb.append(str);
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(level, simpleName, sb.toString());
    }
}
