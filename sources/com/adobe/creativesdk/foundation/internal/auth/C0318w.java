package com.adobe.creativesdk.foundation.internal.auth;

import com.adobe.creativesdk.foundation.auth.AdobeAuthErrorCode;
import com.adobe.creativesdk.foundation.auth.AdobeAuthException;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;
import java.util.Date;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AdobeAuthIdentityManagementService.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.auth.w */
/* loaded from: classes.dex */
public class C0318w implements Z {

    /* renamed from: a */
    final /* synthetic */ String f4925a;

    /* renamed from: b */
    final /* synthetic */ V f4926b;

    /* renamed from: c */
    final /* synthetic */ AdobeAuthIdentityManagementService f4927c;

    public C0318w(AdobeAuthIdentityManagementService adobeAuthIdentityManagementService, String str, V v) {
        this.f4927c = adobeAuthIdentityManagementService;
        this.f4925a = str;
        this.f4926b = v;
    }

    @Override // com.adobe.creativesdk.foundation.internal.net.F
    public void a(com.adobe.creativesdk.foundation.internal.net.l lVar) {
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AuthIMS", "Inside getAccessTokenWithDeviceToken(), authTokenHandler onSuccess() callback" + new Date().toString());
        try {
            com.adobe.creativesdk.foundation.internal.utils.k kVar = new com.adobe.creativesdk.foundation.internal.utils.k(lVar.d());
            String a2 = kVar.a("userId");
            String a3 = kVar.a("access_token");
            String a4 = kVar.b("error") ? kVar.a("error") : null;
            if (a3 != null) {
                this.f4927c.a(kVar, true);
                this.f4927c.l(this.f4925a);
                this.f4927c.a(a3, (c.a.a.a.b<JSONObject>) new C0316u(this, a2, a3), (c.a.a.a.c<AdobeCSDKException>) new C0317v(this, a2, a3));
            } else if (a4 != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("info", Integer.valueOf(lVar.g()));
                this.f4926b.a(new AdobeAuthException(AdobeAuthErrorCode.ADOBE_AUTH_ERROR_CODE_UNKNOWN_ERROR, hashMap));
            }
        } catch (JSONException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "AuthIMS", "Error in parsing response for access token", e2);
            this.f4927c.a(e2, this.f4926b);
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.auth.Z
    public void b() {
        this.f4926b.a(new AdobeAuthException(AdobeAuthErrorCode.ADOBE_AUTH_ERROR_CODE_CLIENT_ID_REQUIRED));
    }

    @Override // com.adobe.creativesdk.foundation.internal.auth.Z
    public void c() {
        this.f4926b.a(new AdobeAuthException(AdobeAuthErrorCode.ADOBE_AUTH_ERROR_CODE_CLIENT_ID_REQUIRED));
    }

    @Override // com.adobe.creativesdk.foundation.internal.net.F
    public void a(AdobeNetworkException adobeNetworkException) {
        AdobeAuthException a2;
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AuthIMS", "Inside getAccessTokenWithDeviceToken(), authTokenHandler onError() callback" + new Date().toString());
        V v = this.f4926b;
        a2 = this.f4927c.a(adobeNetworkException);
        v.a(a2);
    }

    @Override // com.adobe.creativesdk.foundation.internal.auth.Z
    public void a() {
        this.f4926b.a(new AdobeAuthException(AdobeAuthErrorCode.ADOBE_AUTH_ERROR_CODE_DEVICE_ID_REQUIRED));
    }
}
