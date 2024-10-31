package com.adobe.creativesdk.foundation.auth;

import com.adobe.creativesdk.foundation.auth.AdobeAuthSessionHelper;

/* compiled from: AdobeAuthSessionHelper.java */
/* loaded from: classes.dex */
class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AdobeAuthException f4702a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ d f4703b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(d dVar, AdobeAuthException adobeAuthException) {
        this.f4703b = dVar;
        this.f4702a = adobeAuthException;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4703b.f4704a.f4694b.a(AdobeAuthSessionHelper.AdobeAuthStatus.AdobeAuthLoginAttemptFailed, this.f4702a);
    }
}
