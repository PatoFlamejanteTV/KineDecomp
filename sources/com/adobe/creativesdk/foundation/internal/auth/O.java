package com.adobe.creativesdk.foundation.internal.auth;

import com.adobe.creativesdk.foundation.internal.utils.logging.Level;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeAuthSignInActivity.java */
/* loaded from: classes.dex */
public class O extends N {

    /* renamed from: d, reason: collision with root package name */
    private static final String f4847d = "O";

    @Override // com.adobe.creativesdk.foundation.internal.auth.N
    protected void a(Object obj) {
    }

    @Override // com.adobe.creativesdk.foundation.internal.auth.N
    public void a(String str) {
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, f4847d, "received Auth Code check");
        AdobeAuthIdentityManagementService.K().a(str, a());
    }

    @Override // com.adobe.creativesdk.foundation.internal.auth.N
    public void b(String str) {
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, f4847d, "received Device Token check");
        AdobeAuthIdentityManagementService.K().b(str, a());
    }
}
