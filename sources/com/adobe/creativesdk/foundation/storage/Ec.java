package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;

/* compiled from: AdobePhotoAsset.java */
/* loaded from: classes.dex */
class Ec implements c.a.a.a.c<AdobeCSDKException> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.c f6963a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobePhotoAsset f6964b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ec(AdobePhotoAsset adobePhotoAsset, c.a.a.a.c cVar) {
        this.f6964b = adobePhotoAsset;
        this.f6963a = cVar;
    }

    @Override // c.a.a.a.c
    public void a(AdobeCSDKException adobeCSDKException) {
        String str;
        if (adobeCSDKException instanceof AdobePhotoException) {
            this.f6963a.a((AdobePhotoException) adobeCSDKException);
            return;
        }
        Level level = Level.ERROR;
        String simpleName = AdobePhotoAsset.class.getSimpleName();
        StringBuilder sb = new StringBuilder();
        sb.append("Failed to refresh photo asset ");
        str = this.f6964b._name;
        sb.append(str);
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(level, simpleName, sb.toString());
    }
}
