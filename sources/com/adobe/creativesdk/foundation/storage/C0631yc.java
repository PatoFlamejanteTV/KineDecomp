package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;

/* compiled from: AdobePhotoAsset.java */
/* renamed from: com.adobe.creativesdk.foundation.storage.yc, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0631yc implements c.a.a.a.c<AdobeCSDKException> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AdobePhotoAsset f7479a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ sd f7480b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f7481c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0631yc(AdobePhotoAsset adobePhotoAsset, sd sdVar, String str) {
        this.f7479a = adobePhotoAsset;
        this.f7480b = sdVar;
        this.f7481c = str;
    }

    @Override // c.a.a.a.c
    public void a(AdobeCSDKException adobeCSDKException) {
        this.f7479a.handleCommonUploadCompletionBookKeeping();
        if (adobeCSDKException instanceof AdobeNetworkException) {
            if (((AdobeNetworkException) adobeCSDKException).getErrorCode() == AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorCancelled) {
                this.f7480b.a();
                return;
            }
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.INFO, AdobePhotoAsset.class.getSimpleName(), "Failed to create photo asset " + this.f7481c);
            return;
        }
        if (adobeCSDKException instanceof AdobePhotoException) {
            this.f7480b.a((sd) adobeCSDKException);
            return;
        }
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, AdobePhotoAsset.class.getSimpleName(), "Failed to create photo asset " + this.f7481c);
    }
}
