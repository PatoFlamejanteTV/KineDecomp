package com.adobe.creativesdk.foundation.internal.auth;

import com.adobe.creativesdk.foundation.internal.utils.logging.Level;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeAuthManager.java */
/* loaded from: classes.dex */
public class D implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ E f4798a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public D(E e2) {
        this.f4798a = e2;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "Authentication", "Calling logout() from emergency-logout");
        this.f4798a.f4804f = true;
        this.f4798a.k();
    }
}
