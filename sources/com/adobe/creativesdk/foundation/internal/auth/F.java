package com.adobe.creativesdk.foundation.internal.auth;

import android.view.View;
import com.adobe.creativesdk.foundation.auth.AdobeAuthErrorCode;
import com.adobe.creativesdk.foundation.auth.AdobeAuthException;

/* compiled from: AdobeAuthSignInActivity.java */
/* loaded from: classes.dex */
class F implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AdobeAuthSignInActivity f4812a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public F(AdobeAuthSignInActivity adobeAuthSignInActivity) {
        this.f4812a = adobeAuthSignInActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean unused = AdobeAuthSignInActivity.f4778b = true;
        this.f4812a.c(new AdobeAuthException(AdobeAuthErrorCode.ADOBE_AUTH_ERROR_CODE_USER_CANCELLED));
        this.f4812a.finish();
    }
}
