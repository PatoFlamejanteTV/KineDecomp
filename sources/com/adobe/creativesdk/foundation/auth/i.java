package com.adobe.creativesdk.foundation.auth;

import android.os.Handler;
import com.adobe.creativesdk.foundation.auth.AdobeAuthSessionHelper;
import com.adobe.creativesdk.foundation.internal.auth.aa;

/* compiled from: AdobeAuthSessionHelper.java */
/* loaded from: classes.dex */
class i implements aa {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AdobeAuthSessionHelper f4711a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(AdobeAuthSessionHelper adobeAuthSessionHelper) {
        this.f4711a = adobeAuthSessionHelper;
    }

    @Override // com.adobe.creativesdk.foundation.internal.auth.aa
    public void a(AdobeAuthException adobeAuthException) {
        AdobeAuthSessionHelper adobeAuthSessionHelper = this.f4711a;
        Handler handler = adobeAuthSessionHelper.f4700h;
        if (handler != null) {
            handler.post(new h(this, adobeAuthException));
        } else {
            adobeAuthSessionHelper.f4694b.a(AdobeAuthSessionHelper.AdobeAuthStatus.AdobeAuthContinuableEvent, adobeAuthException);
        }
    }
}
