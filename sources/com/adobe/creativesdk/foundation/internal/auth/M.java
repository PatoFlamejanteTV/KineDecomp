package com.adobe.creativesdk.foundation.internal.auth;

import com.adobe.creativesdk.foundation.auth.AdobeAuthErrorCode;
import com.adobe.creativesdk.foundation.auth.AdobeAuthException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeAuthSignInActivity.java */
/* loaded from: classes.dex */
public class M implements V {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ N f4843a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public M(N n) {
        this.f4843a = n;
    }

    @Override // com.adobe.creativesdk.foundation.internal.auth.V
    public void a(String str, String str2) {
        AdobeAuthIdentityManagementService K = AdobeAuthIdentityManagementService.K();
        if (K.x() != null) {
            K.p(null);
            K.r("fb");
        } else {
            K.r("ims");
        }
        this.f4843a.a(str, str2);
        this.f4843a.a((AdobeAuthException) null);
    }

    @Override // com.adobe.creativesdk.foundation.internal.auth.V
    public void a(AdobeAuthException adobeAuthException) {
        this.f4843a.a(adobeAuthException);
    }

    @Override // com.adobe.creativesdk.foundation.internal.auth.V
    public void a(AdobeAuthIMSInfoNeeded adobeAuthIMSInfoNeeded) {
        this.f4843a.a(new AdobeAuthException(AdobeAuthErrorCode.ADOBE_AUTH_ERROR_CODE_USER_CANCELLED));
    }
}
