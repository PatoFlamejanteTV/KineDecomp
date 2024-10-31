package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobePhotoCollection.java */
/* loaded from: classes.dex */
public class _c implements c.a.a.a.c<AdobeCSDKException> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.c f7194a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobePhotoCollection f7195b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ AdobePhotoCollection f7196c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public _c(AdobePhotoCollection adobePhotoCollection, c.a.a.a.c cVar, AdobePhotoCollection adobePhotoCollection2) {
        this.f7196c = adobePhotoCollection;
        this.f7194a = cVar;
        this.f7195b = adobePhotoCollection2;
    }

    @Override // c.a.a.a.c
    public void a(AdobeCSDKException adobeCSDKException) {
        String str;
        c.a.a.a.c cVar = this.f7194a;
        if (cVar != null) {
            cVar.a(adobeCSDKException);
            return;
        }
        Level level = Level.WARN;
        String simpleName = AdobePhotoCollection.class.getSimpleName();
        StringBuilder sb = new StringBuilder();
        sb.append("Failed to update assets to ");
        str = this.f7195b._name;
        sb.append(str);
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(level, simpleName, sb.toString());
    }
}
