package com.adobe.creativesdk.foundation.storage;

import com.facebook.GraphResponse;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobePhotoCollection.java */
/* loaded from: classes.dex */
public class id implements c.a.a.a.b<AdobePhotoCollection> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.b f7294a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.internal.analytics.l f7295b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public id(c.a.a.a.b bVar, com.adobe.creativesdk.foundation.internal.analytics.l lVar) {
        this.f7294a = bVar;
        this.f7295b = lVar;
    }

    @Override // c.a.a.a.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(AdobePhotoCollection adobePhotoCollection) {
        String str;
        c.a.a.a.b bVar = this.f7294a;
        if (bVar != null) {
            bVar.b(adobePhotoCollection);
            com.adobe.creativesdk.foundation.internal.analytics.l lVar = this.f7295b;
            String str2 = adobePhotoCollection._GUID;
            str = adobePhotoCollection._name;
            com.adobe.creativesdk.foundation.internal.analytics.l lVar2 = this.f7295b;
            lVar.a(str2, str, "", "lr_album", null);
            this.f7295b.a(GraphResponse.SUCCESS_KEY);
        }
    }
}
