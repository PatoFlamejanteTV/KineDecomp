package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;

/* compiled from: AdobePhotoAsset.java */
/* renamed from: com.adobe.creativesdk.foundation.storage.vc, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0619vc implements c.a.a.a.c<AdobeCSDKException> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0623wc f7454a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0619vc(C0623wc c0623wc) {
        this.f7454a = c0623wc;
    }

    @Override // c.a.a.a.c
    public void a(AdobeCSDKException adobeCSDKException) {
        String str;
        String str2;
        this.f7454a.f7463d.handleCommonUploadCompletionBookKeeping();
        if (adobeCSDKException instanceof AdobeNetworkException) {
            if (((AdobeNetworkException) adobeCSDKException).getErrorCode() == AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorCancelled) {
                this.f7454a.f7460a.a();
                return;
            }
            Level level = Level.INFO;
            String simpleName = AdobePhotoAsset.class.getSimpleName();
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to download data for photo asset ");
            str2 = this.f7454a.f7463d._name;
            sb.append(str2);
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(level, simpleName, sb.toString());
            return;
        }
        if (adobeCSDKException instanceof AdobePhotoException) {
            this.f7454a.f7460a.a((sd) adobeCSDKException);
            return;
        }
        Level level2 = Level.ERROR;
        String simpleName2 = AdobePhotoAsset.class.getSimpleName();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Failed to download data for photo asset ");
        str = this.f7454a.f7463d._name;
        sb2.append(str);
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(level2, simpleName2, sb2.toString());
    }
}
