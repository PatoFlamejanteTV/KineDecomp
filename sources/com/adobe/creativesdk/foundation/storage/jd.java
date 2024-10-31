package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobePhotoCollection.java */
/* loaded from: classes.dex */
public class jd implements c.a.a.a.c<AdobeCSDKException> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.c f7307a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f7308b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.internal.analytics.l f7309c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ AdobePhotoCollection f7310d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public jd(c.a.a.a.c cVar, String str, com.adobe.creativesdk.foundation.internal.analytics.l lVar, AdobePhotoCollection adobePhotoCollection) {
        this.f7307a = cVar;
        this.f7308b = str;
        this.f7309c = lVar;
        this.f7310d = adobePhotoCollection;
    }

    @Override // c.a.a.a.c
    public void a(AdobeCSDKException adobeCSDKException) {
        String str;
        c.a.a.a.c cVar = this.f7307a;
        if (cVar != null) {
            cVar.a(adobeCSDKException);
        } else {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.WARN, AdobePhotoCollection.class.getSimpleName(), "Failed to create collection " + this.f7308b);
        }
        com.adobe.creativesdk.foundation.internal.analytics.l lVar = this.f7309c;
        AdobePhotoCollection adobePhotoCollection = this.f7310d;
        String str2 = adobePhotoCollection._GUID;
        str = adobePhotoCollection._name;
        com.adobe.creativesdk.foundation.internal.analytics.l lVar2 = this.f7309c;
        lVar.a(str2, str, "", "lr_album", null);
        this.f7309c.a("failure");
    }
}
