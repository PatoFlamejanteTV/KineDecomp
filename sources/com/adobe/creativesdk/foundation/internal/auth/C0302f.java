package com.adobe.creativesdk.foundation.internal.auth;

import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeAuthIdentityManagementService.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.auth.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0302f implements com.adobe.creativesdk.foundation.internal.net.F {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Z f4883a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobeAuthIdentityManagementService f4884b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0302f(AdobeAuthIdentityManagementService adobeAuthIdentityManagementService, Z z) {
        this.f4884b = adobeAuthIdentityManagementService;
        this.f4883a = z;
    }

    @Override // com.adobe.creativesdk.foundation.internal.net.F
    public void a(com.adobe.creativesdk.foundation.internal.net.l lVar) {
        if (lVar.g() == 200) {
            this.f4883a.a(lVar);
        } else {
            this.f4883a.a(new AdobeNetworkException(AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorBadRequest));
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.net.F
    public void a(AdobeNetworkException adobeNetworkException) {
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "AuthIMS", "Network error during refresh access token ", adobeNetworkException);
        this.f4883a.a(adobeNetworkException);
    }
}
