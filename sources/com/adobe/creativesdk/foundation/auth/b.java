package com.adobe.creativesdk.foundation.auth;

import com.adobe.creativesdk.foundation.auth.AdobeAuthSessionHelper;

/* compiled from: AdobeAuthSessionHelper.java */
/* loaded from: classes.dex */
class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ d f4701a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(d dVar) {
        this.f4701a = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4701a.f4704a.f4694b.a(AdobeAuthSessionHelper.AdobeAuthStatus.AdobeAuthLoggedIn, null);
    }
}
