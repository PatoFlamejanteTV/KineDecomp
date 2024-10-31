package com.adobe.creativesdk.foundation.auth;

import android.os.Handler;
import com.adobe.creativesdk.foundation.auth.AdobeAuthSessionHelper;
import com.adobe.creativesdk.foundation.internal.auth.Y;

/* compiled from: AdobeAuthSessionHelper.java */
/* loaded from: classes.dex */
class g implements Y {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AdobeAuthSessionHelper f4708a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(AdobeAuthSessionHelper adobeAuthSessionHelper) {
        this.f4708a = adobeAuthSessionHelper;
    }

    @Override // com.adobe.creativesdk.foundation.internal.auth.Y
    public void a(AdobeAuthException adobeAuthException) {
        AdobeAuthSessionHelper adobeAuthSessionHelper = this.f4708a;
        AdobeAuthSessionHelper.a aVar = adobeAuthSessionHelper.f4694b;
        if (aVar != null) {
            Handler handler = adobeAuthSessionHelper.f4700h;
            if (handler != null) {
                handler.post(new f(this, adobeAuthException));
            } else {
                aVar.a(AdobeAuthSessionHelper.AdobeAuthStatus.AdobeAuthLogoutAttemptFailed, adobeAuthException);
            }
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.auth.Y
    public void onSuccess() {
        AdobeAuthSessionHelper adobeAuthSessionHelper = this.f4708a;
        AdobeAuthSessionHelper.a aVar = adobeAuthSessionHelper.f4694b;
        if (aVar != null) {
            Handler handler = adobeAuthSessionHelper.f4700h;
            if (handler != null) {
                handler.post(new e(this));
            } else {
                aVar.a(AdobeAuthSessionHelper.AdobeAuthStatus.AdobeAuthLoggedOut, null);
            }
        }
    }
}
