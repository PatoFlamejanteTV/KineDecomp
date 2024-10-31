package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;

/* compiled from: AdobePhotoAsset.java */
/* renamed from: com.adobe.creativesdk.foundation.storage.hc, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0564hc implements c.a.a.a.c<AdobeCSDKException> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ sd f7279a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobePhotoAsset f7280b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0564hc(AdobePhotoAsset adobePhotoAsset, sd sdVar) {
        this.f7280b = adobePhotoAsset;
        this.f7279a = sdVar;
    }

    @Override // c.a.a.a.c
    public void a(AdobeCSDKException adobeCSDKException) {
        String str;
        String str2;
        this.f7280b.handleCommonUploadCompletionBookKeeping();
        if (adobeCSDKException instanceof AdobeNetworkException) {
            if (((AdobeNetworkException) adobeCSDKException).getErrorCode() == AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorCancelled) {
                this.f7279a.a();
                return;
            }
            Level level = Level.INFO;
            String simpleName = AdobePhotoAsset.class.getSimpleName();
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to upload photo asset ");
            str2 = this.f7280b._name;
            sb.append(str2);
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(level, simpleName, sb.toString());
            return;
        }
        if (adobeCSDKException instanceof AdobePhotoException) {
            this.f7279a.a((sd) adobeCSDKException);
            return;
        }
        Level level2 = Level.ERROR;
        String simpleName2 = AdobePhotoAsset.class.getSimpleName();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Failed to upload photo asset ");
        str = this.f7280b._name;
        sb2.append(str);
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(level2, simpleName2, sb2.toString());
    }
}
