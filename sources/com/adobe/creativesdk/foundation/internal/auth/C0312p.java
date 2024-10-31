package com.adobe.creativesdk.foundation.internal.auth;

import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;
import java.util.Date;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeAuthIdentityManagementService.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.auth.p, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0312p implements com.adobe.creativesdk.foundation.internal.net.F {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Z f4907a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobeAuthIdentityManagementService f4908b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0312p(AdobeAuthIdentityManagementService adobeAuthIdentityManagementService, Z z) {
        this.f4908b = adobeAuthIdentityManagementService;
        this.f4907a = z;
    }

    @Override // com.adobe.creativesdk.foundation.internal.net.F
    public void a(com.adobe.creativesdk.foundation.internal.net.l lVar) {
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AuthIMS", "Inside getAccessTokenWithAuthCode(), onSuccess() callback" + new Date().toString());
        if (lVar.g() == 200) {
            this.f4907a.a(lVar);
        } else {
            this.f4907a.a(new AdobeNetworkException(AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorBadRequest));
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.net.F
    public void a(AdobeNetworkException adobeNetworkException) {
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AuthIMS", "Inside getAccessTokenWithAuthCode(), onError() callback" + new Date().toString());
        this.f4907a.a(adobeNetworkException);
    }
}
