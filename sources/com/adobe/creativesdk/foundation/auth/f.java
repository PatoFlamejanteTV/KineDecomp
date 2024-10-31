package com.adobe.creativesdk.foundation.auth;

import com.adobe.creativesdk.foundation.auth.AdobeAuthSessionHelper;

/* compiled from: AdobeAuthSessionHelper.java */
/* loaded from: classes.dex */
class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AdobeAuthException f4706a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ g f4707b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(g gVar, AdobeAuthException adobeAuthException) {
        this.f4707b = gVar;
        this.f4706a = adobeAuthException;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4707b.f4708a.f4694b.a(AdobeAuthSessionHelper.AdobeAuthStatus.AdobeAuthLogoutAttemptFailed, this.f4706a);
    }
}
