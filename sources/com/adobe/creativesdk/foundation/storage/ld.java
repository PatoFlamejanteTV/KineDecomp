package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;

/* compiled from: AdobePhotoCollection.java */
/* loaded from: classes.dex */
class ld implements c.a.a.a.c<AdobeCSDKException> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.c f7340a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobePhotoCollection f7341b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ AdobePhotoCollection f7342c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ld(AdobePhotoCollection adobePhotoCollection, c.a.a.a.c cVar, AdobePhotoCollection adobePhotoCollection2) {
        this.f7342c = adobePhotoCollection;
        this.f7340a = cVar;
        this.f7341b = adobePhotoCollection2;
    }

    @Override // c.a.a.a.c
    public void a(AdobeCSDKException adobeCSDKException) {
        String str;
        c.a.a.a.c cVar = this.f7340a;
        if (cVar != null) {
            cVar.a(adobeCSDKException);
            return;
        }
        Level level = Level.WARN;
        String simpleName = AdobePhotoCollection.class.getSimpleName();
        StringBuilder sb = new StringBuilder();
        sb.append("Failed to update collection ");
        str = this.f7341b._name;
        sb.append(str);
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(level, simpleName, sb.toString());
    }
}
