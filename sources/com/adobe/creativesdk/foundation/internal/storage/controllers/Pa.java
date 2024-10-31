package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.app.Activity;
import com.adobe.creativesdk.foundation.auth.AdobeAuthErrorCode;
import com.adobe.creativesdk.foundation.auth.AdobeAuthException;
import com.adobe.creativesdk.foundation.auth.AdobeAuthSessionHelper;
import com.adobe.creativesdk.foundation.auth.j;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;

/* compiled from: AdobeUxAssetBrowserV2Activity.java */
/* loaded from: classes.dex */
class Pa implements AdobeAuthSessionHelper.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AdobeUxAssetBrowserV2Activity f5782a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Pa(AdobeUxAssetBrowserV2Activity adobeUxAssetBrowserV2Activity) {
        this.f5782a = adobeUxAssetBrowserV2Activity;
    }

    @Override // com.adobe.creativesdk.foundation.auth.AdobeAuthSessionHelper.a
    public void a(AdobeAuthSessionHelper.AdobeAuthStatus adobeAuthStatus, AdobeAuthException adobeAuthException) {
        c.a.a.a.a.a.a b2 = c.a.a.a.a.a.a.b();
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "UxAssetBrowserV2", "Auth status " + adobeAuthStatus);
        if (AdobeAuthSessionHelper.AdobeAuthStatus.AdobeAuthLoggedIn == adobeAuthStatus) {
            c.a.a.a.a.b.a.c.g.b();
            this.f5782a.u();
            return;
        }
        if (AdobeAuthSessionHelper.AdobeAuthStatus.AdobeAuthContinuableEvent == adobeAuthStatus) {
            AdobeAuthErrorCode errorCode = adobeAuthException.getErrorCode();
            if (errorCode == AdobeAuthErrorCode.ADOBE_AUTH_ERROR_CODE_AGE_VERIFICATION || errorCode == AdobeAuthErrorCode.ADOBE_AUTH_ERROR_CODE_UPDATED_TOU || errorCode == AdobeAuthErrorCode.ADOBE_AUTH_ERROR_CODE_EMAIL_VERIFICATION) {
                j.a aVar = new j.a();
                aVar.a((Activity) this.f5782a);
                aVar.a(errorCode);
                com.adobe.creativesdk.foundation.auth.k.a().b(aVar.a());
                return;
            }
            return;
        }
        if (adobeAuthException != null && adobeAuthException.getErrorCode() == AdobeAuthErrorCode.ADOBE_AUTH_ERROR_CODE_USER_CANCELLED) {
            this.f5782a.finish();
            return;
        }
        j.a aVar2 = new j.a();
        aVar2.a((Activity) this.f5782a);
        aVar2.a(2002);
        b2.a(aVar2.a());
    }
}
