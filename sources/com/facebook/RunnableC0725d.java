package com.facebook;

import com.facebook.AccessToken;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AccessTokenManager.java */
/* renamed from: com.facebook.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class RunnableC0725d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AccessToken.AccessTokenRefreshCallback f9247a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AccessTokenManager f9248b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0725d(AccessTokenManager accessTokenManager, AccessToken.AccessTokenRefreshCallback accessTokenRefreshCallback) {
        this.f9248b = accessTokenManager;
        this.f9247a = accessTokenRefreshCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f9248b.refreshCurrentAccessTokenImpl(this.f9247a);
    }
}
