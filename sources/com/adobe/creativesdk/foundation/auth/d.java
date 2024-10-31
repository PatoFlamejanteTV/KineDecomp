package com.adobe.creativesdk.foundation.auth;

import android.os.Handler;
import com.adobe.creativesdk.foundation.auth.AdobeAuthSessionHelper;
import com.adobe.creativesdk.foundation.internal.auth.X;

/* compiled from: AdobeAuthSessionHelper.java */
/* loaded from: classes.dex */
class d implements X {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AdobeAuthSessionHelper f4704a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(AdobeAuthSessionHelper adobeAuthSessionHelper) {
        this.f4704a = adobeAuthSessionHelper;
    }

    @Override // com.adobe.creativesdk.foundation.internal.auth.X
    public void a(AdobeAuthUserProfile adobeAuthUserProfile) {
        AdobeAuthSessionHelper adobeAuthSessionHelper = this.f4704a;
        AdobeAuthSessionHelper.a aVar = adobeAuthSessionHelper.f4694b;
        if (aVar != null) {
            Handler handler = adobeAuthSessionHelper.f4700h;
            if (handler != null) {
                handler.post(new b(this));
            } else {
                aVar.a(AdobeAuthSessionHelper.AdobeAuthStatus.AdobeAuthLoggedIn, null);
            }
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.auth.X
    public void a(AdobeAuthException adobeAuthException) {
        AdobeAuthSessionHelper adobeAuthSessionHelper = this.f4704a;
        AdobeAuthSessionHelper.a aVar = adobeAuthSessionHelper.f4694b;
        if (aVar != null) {
            Handler handler = adobeAuthSessionHelper.f4700h;
            if (handler != null) {
                handler.post(new c(this, adobeAuthException));
            } else {
                aVar.a(AdobeAuthSessionHelper.AdobeAuthStatus.AdobeAuthLoginAttemptFailed, adobeAuthException);
            }
        }
    }
}
