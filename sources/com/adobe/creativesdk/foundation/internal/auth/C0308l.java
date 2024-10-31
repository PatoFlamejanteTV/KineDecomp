package com.adobe.creativesdk.foundation.internal.auth;

import com.adobe.creativesdk.foundation.auth.AdobeAuthErrorCode;
import com.adobe.creativesdk.foundation.auth.AdobeAuthException;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AdobeAuthIdentityManagementService.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.auth.l */
/* loaded from: classes.dex */
public class C0308l implements Z {

    /* renamed from: a */
    final /* synthetic */ V f4897a;

    /* renamed from: b */
    final /* synthetic */ AdobeAuthIdentityManagementService f4898b;

    public C0308l(AdobeAuthIdentityManagementService adobeAuthIdentityManagementService, V v) {
        this.f4898b = adobeAuthIdentityManagementService;
        this.f4897a = v;
    }

    @Override // com.adobe.creativesdk.foundation.internal.net.F
    public void a(com.adobe.creativesdk.foundation.internal.net.l lVar) {
        try {
            com.adobe.creativesdk.foundation.internal.utils.k kVar = new com.adobe.creativesdk.foundation.internal.utils.k(lVar.d());
            String a2 = kVar.a("userId");
            String a3 = kVar.a("access_token");
            this.f4898b.h(null);
            if (a3 != null) {
                this.f4898b.a(kVar, false);
                this.f4898b.a(a3, (c.a.a.a.b<JSONObject>) new C0306j(this, a2, a3), (c.a.a.a.c<AdobeCSDKException>) new C0307k(this, a2, a3));
            } else {
                d();
            }
        } catch (JSONException e2) {
            this.f4898b.a(e2, this.f4897a);
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.auth.Z
    public void b() {
        this.f4897a.a(new AdobeAuthException(AdobeAuthErrorCode.ADOBE_AUTH_ERROR_CODE_CLIENT_SECRET_REQUIRED));
    }

    @Override // com.adobe.creativesdk.foundation.internal.auth.Z
    public void c() {
        this.f4897a.a(new AdobeAuthException(AdobeAuthErrorCode.ADOBE_AUTH_ERROR_CODE_CLIENT_ID_REQUIRED));
    }

    public void d() {
        this.f4898b.v(null);
        this.f4898b.a(this.f4897a);
    }

    @Override // com.adobe.creativesdk.foundation.internal.net.F
    public void a(AdobeNetworkException adobeNetworkException) {
        JSONObject b2;
        AdobeAuthException a2;
        AdobeAuthException b3;
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobeAuthIdentityManagementService.signIn", String.format("IMS error using refresh token: %s", adobeNetworkException.getDescription()));
        b2 = this.f4898b.b(adobeNetworkException);
        if (adobeNetworkException.getStatusCode().intValue() == 400 && b2 != null) {
            b3 = this.f4898b.b(b2);
            this.f4898b.h(b2.optString("jump"));
            this.f4898b.g(b3.getErrorCode().toString());
            this.f4897a.a(b3);
            return;
        }
        if (adobeNetworkException.getStatusCode().intValue() != 400 && adobeNetworkException.getStatusCode().intValue() != 401) {
            this.f4898b.h(null);
            a2 = this.f4898b.a(adobeNetworkException);
            this.f4897a.a(a2);
        } else {
            this.f4898b.h(null);
            d();
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.auth.Z
    public void a() {
        this.f4897a.a(new AdobeAuthException(AdobeAuthErrorCode.ADOBE_AUTH_ERROR_CODE_DEVICE_ID_REQUIRED));
    }
}
