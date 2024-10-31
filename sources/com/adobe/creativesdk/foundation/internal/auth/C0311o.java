package com.adobe.creativesdk.foundation.internal.auth;

import com.adobe.creativesdk.foundation.auth.AdobeAuthErrorCode;
import com.adobe.creativesdk.foundation.auth.AdobeAuthException;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AdobeAuthIdentityManagementService.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.auth.o */
/* loaded from: classes.dex */
public class C0311o implements Z {

    /* renamed from: a */
    final /* synthetic */ V f4905a;

    /* renamed from: b */
    final /* synthetic */ AdobeAuthIdentityManagementService f4906b;

    public C0311o(AdobeAuthIdentityManagementService adobeAuthIdentityManagementService, V v) {
        this.f4906b = adobeAuthIdentityManagementService;
        this.f4905a = v;
    }

    private void d() {
        this.f4906b.l(null);
        this.f4906b.a(this.f4905a);
    }

    @Override // com.adobe.creativesdk.foundation.internal.net.F
    public void a(com.adobe.creativesdk.foundation.internal.net.l lVar) {
        String str;
        String str2;
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AuthIMS", "Inside getAccessTokenWithDeviceToken(), authTokenHandler onSuccess() callback" + new Date().toString());
        try {
            this.f4906b.h(null);
            com.adobe.creativesdk.foundation.internal.utils.k kVar = new com.adobe.creativesdk.foundation.internal.utils.k(lVar.d());
            String a2 = kVar.a("userId");
            String a3 = kVar.a("access_token");
            if (a3 != null) {
                this.f4906b.a(kVar, true);
                AdobeAuthIdentityManagementService adobeAuthIdentityManagementService = this.f4906b;
                str = this.f4906b.m;
                adobeAuthIdentityManagementService.l(str);
                AdobeAuthIdentityManagementService adobeAuthIdentityManagementService2 = this.f4906b;
                str2 = this.f4906b.m;
                adobeAuthIdentityManagementService2.w(str2);
                this.f4906b.a(a3, (c.a.a.a.b<JSONObject>) new C0309m(this, a2, a3), (c.a.a.a.c<AdobeCSDKException>) new C0310n(this, a2, a3));
            } else {
                d();
            }
        } catch (JSONException e2) {
            this.f4906b.a(e2, this.f4905a);
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.auth.Z
    public void b() {
        this.f4905a.a(new AdobeAuthException(AdobeAuthErrorCode.ADOBE_AUTH_ERROR_CODE_CLIENT_SECRET_REQUIRED));
    }

    @Override // com.adobe.creativesdk.foundation.internal.auth.Z
    public void c() {
        this.f4905a.a(new AdobeAuthException(AdobeAuthErrorCode.ADOBE_AUTH_ERROR_CODE_CLIENT_ID_REQUIRED));
    }

    @Override // com.adobe.creativesdk.foundation.internal.net.F
    public void a(AdobeNetworkException adobeNetworkException) {
        JSONObject b2;
        AdobeAuthException a2;
        AdobeAuthException b3;
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AuthIMS", "Inside getAccessTokenWithDeviceToken(), authTokenHandler onError() callback" + new Date().toString());
        b2 = this.f4906b.b(adobeNetworkException);
        if (adobeNetworkException.getStatusCode().intValue() == 400 && b2 != null) {
            b3 = this.f4906b.b(b2);
            this.f4906b.h(b2.optString("jump"));
            this.f4906b.g(b3.getErrorCode().toString());
            this.f4905a.a(b3);
            return;
        }
        if (adobeNetworkException.getStatusCode().intValue() != 400 && adobeNetworkException.getStatusCode().intValue() != 401) {
            this.f4906b.h(null);
            a2 = this.f4906b.a(adobeNetworkException);
            this.f4905a.a(a2);
        } else {
            this.f4906b.h(null);
            d();
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.auth.Z
    public void a() {
        this.f4905a.a(new AdobeAuthException(AdobeAuthErrorCode.ADOBE_AUTH_ERROR_CODE_DEVICE_ID_REQUIRED));
    }
}
