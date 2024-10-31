package com.adobe.creativesdk.foundation.auth;

import com.adobe.creativesdk.foundation.auth.AdobeAuthSessionHelper;

/* compiled from: AdobeAuthSessionHelper.java */
/* loaded from: classes.dex */
class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AdobeAuthException f4709a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ i f4710b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(i iVar, AdobeAuthException adobeAuthException) {
        this.f4710b = iVar;
        this.f4709a = adobeAuthException;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4710b.f4711a.f4694b.a(AdobeAuthSessionHelper.AdobeAuthStatus.AdobeAuthContinuableEvent, this.f4709a);
    }
}
