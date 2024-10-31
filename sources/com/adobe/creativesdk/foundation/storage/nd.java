package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;

/* compiled from: AdobePhotoCollection.java */
/* loaded from: classes.dex */
class nd implements c.a.a.a.c<AdobeCSDKException> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.c f7365a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobePhotoCollection f7366b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ AdobePhotoCollection f7367c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public nd(AdobePhotoCollection adobePhotoCollection, c.a.a.a.c cVar, AdobePhotoCollection adobePhotoCollection2) {
        this.f7367c = adobePhotoCollection;
        this.f7365a = cVar;
        this.f7366b = adobePhotoCollection2;
    }

    @Override // c.a.a.a.c
    public void a(AdobeCSDKException adobeCSDKException) {
        String str;
        c.a.a.a.c cVar = this.f7365a;
        if (cVar != null) {
            cVar.a(adobeCSDKException);
            return;
        }
        Level level = Level.WARN;
        String simpleName = AdobePhotoCollection.class.getSimpleName();
        StringBuilder sb = new StringBuilder();
        sb.append("Failed to refresh collection ");
        str = this.f7366b._name;
        sb.append(str);
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(level, simpleName, sb.toString());
    }
}
