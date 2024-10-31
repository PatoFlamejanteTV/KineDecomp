package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobePhotoCollection.java */
/* loaded from: classes.dex */
public class hd implements c.a.a.a.c<AdobeCSDKException> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.c f7281a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobePhotoCollection f7282b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public hd(AdobePhotoCollection adobePhotoCollection, c.a.a.a.c cVar) {
        this.f7282b = adobePhotoCollection;
        this.f7281a = cVar;
    }

    @Override // c.a.a.a.c
    public void a(AdobeCSDKException adobeCSDKException) {
        c.a.a.a.c cVar = this.f7281a;
        if (cVar != null) {
            cVar.a(adobeCSDKException);
        }
    }
}
