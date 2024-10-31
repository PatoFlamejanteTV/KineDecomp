package com.adobe.creativesdk.foundation.auth;

import com.adobe.creativesdk.foundation.auth.AdobeAuthSessionHelper;

/* compiled from: AdobeAuthSessionHelper.java */
/* loaded from: classes.dex */
class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ g f4705a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(g gVar) {
        this.f4705a = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4705a.f4708a.f4694b.a(AdobeAuthSessionHelper.AdobeAuthStatus.AdobeAuthLoggedOut, null);
    }
}
