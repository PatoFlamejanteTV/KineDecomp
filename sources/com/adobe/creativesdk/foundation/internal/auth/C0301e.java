package com.adobe.creativesdk.foundation.internal.auth;

import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeAuthIdentityManagementService.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.auth.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0301e implements com.adobe.creativesdk.foundation.internal.net.F {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.internal.net.F f4881a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobeAuthIdentityManagementService f4882b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0301e(AdobeAuthIdentityManagementService adobeAuthIdentityManagementService, com.adobe.creativesdk.foundation.internal.net.F f2) {
        this.f4882b = adobeAuthIdentityManagementService;
        this.f4881a = f2;
    }

    @Override // com.adobe.creativesdk.foundation.internal.net.F
    public void a(com.adobe.creativesdk.foundation.internal.net.l lVar) {
        if (lVar.g() == 200) {
            this.f4881a.a(lVar);
        } else {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "AuthIMS", "");
            this.f4881a.a(new AdobeNetworkException(AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorBadRequest));
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.net.F
    public void a(AdobeNetworkException adobeNetworkException) {
        this.f4881a.a(adobeNetworkException);
    }
}
