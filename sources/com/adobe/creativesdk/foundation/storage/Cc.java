package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;
import com.facebook.internal.AnalyticsEvents;

/* compiled from: AdobePhotoAsset.java */
/* loaded from: classes.dex */
class Cc implements c.a.a.a.c<AdobeCSDKException> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AdobePhotoAsset f6941a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.internal.analytics.l f6942b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ sd f6943c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f6944d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Cc(AdobePhotoAsset adobePhotoAsset, com.adobe.creativesdk.foundation.internal.analytics.l lVar, sd sdVar, String str) {
        this.f6941a = adobePhotoAsset;
        this.f6942b = lVar;
        this.f6943c = sdVar;
        this.f6944d = str;
    }

    @Override // c.a.a.a.c
    public void a(AdobeCSDKException adobeCSDKException) {
        this.f6941a.handleCommonUploadCompletionBookKeeping();
        if (adobeCSDKException instanceof AdobeNetworkException) {
            if (((AdobeNetworkException) adobeCSDKException).getErrorCode() == AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorCancelled) {
                this.f6942b.a(AnalyticsEvents.PARAMETER_SHARE_OUTCOME_CANCELLED);
                this.f6943c.a();
                return;
            }
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.INFO, AdobePhotoAsset.class.getSimpleName(), "Failed to create photo asset " + this.f6944d);
            this.f6942b.a("failure");
            return;
        }
        if (adobeCSDKException instanceof AdobePhotoException) {
            this.f6943c.a((sd) adobeCSDKException);
        } else {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, AdobePhotoAsset.class.getSimpleName(), "Failed to create photo asset " + this.f6944d);
        }
        this.f6942b.a("failure");
    }
}
