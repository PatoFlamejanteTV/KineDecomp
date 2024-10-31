package com.adobe.creativesdk.foundation.internal.auth;

import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;
import java.util.Date;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeAuthIdentityManagementService.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.auth.q, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0313q implements com.adobe.creativesdk.foundation.internal.net.F {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Z f4909a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobeAuthIdentityManagementService f4910b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0313q(AdobeAuthIdentityManagementService adobeAuthIdentityManagementService, Z z) {
        this.f4910b = adobeAuthIdentityManagementService;
        this.f4909a = z;
    }

    @Override // com.adobe.creativesdk.foundation.internal.net.F
    public void a(com.adobe.creativesdk.foundation.internal.net.l lVar) {
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AuthIMS", "Inside getAccessTokenWithDeviceToken(), onSuccess() callback " + new Date().toString());
        this.f4909a.a(lVar);
    }

    @Override // com.adobe.creativesdk.foundation.internal.net.F
    public void a(AdobeNetworkException adobeNetworkException) {
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AuthIMS", "Inside getAccessTokenWithDeviceToken(), onError() callback " + new Date().toString());
        this.f4909a.a(adobeNetworkException);
    }
}
