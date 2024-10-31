package com.adobe.creativesdk.foundation.internal.auth;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeAuthIdentityManagementService.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.auth.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0304h implements c.a.a.a.c<AdobeCSDKException> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.c f4887a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobeAuthIdentityManagementService f4888b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0304h(AdobeAuthIdentityManagementService adobeAuthIdentityManagementService, c.a.a.a.c cVar) {
        this.f4888b = adobeAuthIdentityManagementService;
        this.f4887a = cVar;
    }

    @Override // c.a.a.a.c
    public void a(AdobeCSDKException adobeCSDKException) {
        c.a.a.a.c cVar = this.f4887a;
        if (cVar != null) {
            cVar.a(adobeCSDKException);
        } else {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "AuthIMS", "Could not get profile date from service", adobeCSDKException);
        }
    }
}
