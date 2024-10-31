package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;

/* compiled from: AdobePhotoAsset.java */
/* renamed from: com.adobe.creativesdk.foundation.storage.qc, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0600qc implements c.a.a.a.c<AdobeCSDKException> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0603rc f7393a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0600qc(C0603rc c0603rc) {
        this.f7393a = c0603rc;
    }

    @Override // c.a.a.a.c
    public void a(AdobeCSDKException adobeCSDKException) {
        String str;
        String str2;
        this.f7393a.f7406c.handleCommonDownloadCompletionBookKeeping();
        if (adobeCSDKException instanceof AdobeNetworkException) {
            if (((AdobeNetworkException) adobeCSDKException).getErrorCode() == AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorCancelled) {
                this.f7393a.f7404a.a();
                return;
            }
            Level level = Level.INFO;
            String simpleName = AdobePhotoAsset.class.getSimpleName();
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to download data for photo asset ");
            str2 = this.f7393a.f7406c._name;
            sb.append(str2);
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(level, simpleName, sb.toString());
            return;
        }
        if (adobeCSDKException instanceof AdobePhotoException) {
            this.f7393a.f7404a.a((sd) adobeCSDKException);
            return;
        }
        Level level2 = Level.ERROR;
        String simpleName2 = AdobePhotoAsset.class.getSimpleName();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Failed to download data for photo asset ");
        str = this.f7393a.f7406c._name;
        sb2.append(str);
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(level2, simpleName2, sb2.toString());
    }
}
