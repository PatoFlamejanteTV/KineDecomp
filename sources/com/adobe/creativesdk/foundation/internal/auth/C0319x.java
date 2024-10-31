package com.adobe.creativesdk.foundation.internal.auth;

import com.adobe.creativesdk.foundation.network.AdobeNetworkException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeAuthIdentityManagementService.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.auth.x, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0319x implements com.adobe.creativesdk.foundation.internal.net.F {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ W f4928a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobeAuthIdentityManagementService f4929b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0319x(AdobeAuthIdentityManagementService adobeAuthIdentityManagementService, W w) {
        this.f4929b = adobeAuthIdentityManagementService;
        this.f4928a = w;
    }

    @Override // com.adobe.creativesdk.foundation.internal.net.F
    public void a(com.adobe.creativesdk.foundation.internal.net.l lVar) {
        this.f4928a.onSuccess();
    }

    @Override // com.adobe.creativesdk.foundation.internal.net.F
    public void a(AdobeNetworkException adobeNetworkException) {
        this.f4928a.onSuccess();
    }
}
