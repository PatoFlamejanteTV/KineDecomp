package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;

/* compiled from: AdobePhotoAsset.java */
/* renamed from: com.adobe.creativesdk.foundation.storage.mc, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0584mc implements c.a.a.a.c<AdobeCSDKException> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ sd f7353a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobePhotoAsset f7354b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0584mc(AdobePhotoAsset adobePhotoAsset, sd sdVar) {
        this.f7354b = adobePhotoAsset;
        this.f7353a = sdVar;
    }

    @Override // c.a.a.a.c
    public void a(AdobeCSDKException adobeCSDKException) {
        String str;
        String str2;
        this.f7354b.handleCommonUploadCompletionBookKeeping();
        if (adobeCSDKException instanceof AdobeNetworkException) {
            if (((AdobeNetworkException) adobeCSDKException).getErrorCode() == AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorCancelled) {
                this.f7353a.a();
                return;
            }
            Level level = Level.INFO;
            String simpleName = AdobePhotoAsset.class.getSimpleName();
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to upload rendition for photo asset ");
            str2 = this.f7354b._name;
            sb.append(str2);
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(level, simpleName, sb.toString());
            return;
        }
        if (adobeCSDKException instanceof AdobePhotoException) {
            this.f7353a.a((sd) adobeCSDKException);
            return;
        }
        Level level2 = Level.ERROR;
        String simpleName2 = AdobePhotoAsset.class.getSimpleName();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Failed to upload rendition for photo asset ");
        str = this.f7354b._name;
        sb2.append(str);
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(level2, simpleName2, sb2.toString());
    }
}
