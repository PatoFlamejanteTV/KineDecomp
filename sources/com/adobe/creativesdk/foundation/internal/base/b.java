package com.adobe.creativesdk.foundation.internal.base;

import android.app.Activity;
import com.adobe.creativesdk.foundation.auth.AdobeAuthErrorCode;
import com.adobe.creativesdk.foundation.auth.AdobeAuthException;
import com.adobe.creativesdk.foundation.auth.AdobeAuthSessionHelper;
import com.adobe.creativesdk.foundation.auth.j;
import com.adobe.creativesdk.foundation.auth.k;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeTOUHandlerActivity.java */
/* loaded from: classes.dex */
public class b implements AdobeAuthSessionHelper.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AdobeTOUHandlerActivity f4939a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AdobeTOUHandlerActivity adobeTOUHandlerActivity) {
        this.f4939a = adobeTOUHandlerActivity;
    }

    @Override // com.adobe.creativesdk.foundation.auth.AdobeAuthSessionHelper.a
    public void a(AdobeAuthSessionHelper.AdobeAuthStatus adobeAuthStatus, AdobeAuthException adobeAuthException) {
        if (AdobeAuthSessionHelper.AdobeAuthStatus.AdobeAuthContinuableEvent == adobeAuthStatus) {
            AdobeAuthErrorCode errorCode = adobeAuthException.getErrorCode();
            if (errorCode == AdobeAuthErrorCode.ADOBE_AUTH_ERROR_CODE_AGE_VERIFICATION || errorCode == AdobeAuthErrorCode.ADOBE_AUTH_ERROR_CODE_UPDATED_TOU || errorCode == AdobeAuthErrorCode.ADOBE_AUTH_ERROR_CODE_EMAIL_VERIFICATION) {
                j.a aVar = new j.a();
                aVar.a((Activity) this.f4939a);
                aVar.a(errorCode);
                k.a().b(aVar.a());
            }
        }
    }
}
