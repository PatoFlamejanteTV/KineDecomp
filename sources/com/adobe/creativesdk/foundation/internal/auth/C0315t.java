package com.adobe.creativesdk.foundation.internal.auth;

import com.adobe.creativesdk.foundation.auth.AdobeAuthErrorCode;
import com.adobe.creativesdk.foundation.auth.AdobeAuthException;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;
import java.util.Date;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeAuthIdentityManagementService.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.auth.t, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0315t implements Z {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ V f4917a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobeAuthIdentityManagementService f4918b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0315t(AdobeAuthIdentityManagementService adobeAuthIdentityManagementService, V v) {
        this.f4918b = adobeAuthIdentityManagementService;
        this.f4917a = v;
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0074  */
    @Override // com.adobe.creativesdk.foundation.internal.net.F
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.adobe.creativesdk.foundation.internal.net.l r8) {
        /*
            r7 = this;
            com.adobe.creativesdk.foundation.internal.utils.logging.Level r0 = com.adobe.creativesdk.foundation.internal.utils.logging.Level.DEBUG
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Inside getAccessTokenWithAuthCode(), authTokenHandler onSuccess() callback"
            r1.append(r2)
            java.util.Date r2 = new java.util.Date
            r2.<init>()
            java.lang.String r2 = r2.toString()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "AuthIMS"
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(r0, r2, r1)
            java.lang.String r0 = r8.d()
            r1 = 0
            if (r0 == 0) goto L59
            com.adobe.creativesdk.foundation.internal.utils.k r0 = new com.adobe.creativesdk.foundation.internal.utils.k     // Catch: org.json.JSONException -> L4d
            java.lang.String r8 = r8.d()     // Catch: org.json.JSONException -> L4d
            r0.<init>(r8)     // Catch: org.json.JSONException -> L4d
            java.lang.String r8 = "userId"
            java.lang.String r8 = r0.a(r8)     // Catch: org.json.JSONException -> L49
            java.lang.String r3 = "access_token"
            java.lang.String r3 = r0.a(r3)     // Catch: org.json.JSONException -> L46
            java.lang.String r4 = "error"
            java.lang.String r1 = r0.a(r4)     // Catch: org.json.JSONException -> L44
            goto L5c
        L44:
            r4 = move-exception
            goto L51
        L46:
            r4 = move-exception
            r3 = r1
            goto L51
        L49:
            r4 = move-exception
            r8 = r1
            r3 = r8
            goto L51
        L4d:
            r4 = move-exception
            r8 = r1
            r0 = r8
            r3 = r0
        L51:
            com.adobe.creativesdk.foundation.internal.utils.logging.Level r5 = com.adobe.creativesdk.foundation.internal.utils.logging.Level.ERROR
            java.lang.String r6 = "JSON Error"
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(r5, r2, r6, r4)
            goto L5c
        L59:
            r8 = r1
            r0 = r8
            r3 = r0
        L5c:
            if (r3 == 0) goto L74
            com.adobe.creativesdk.foundation.internal.auth.AdobeAuthIdentityManagementService r1 = r7.f4918b
            r2 = 0
            r1.a(r0, r2)
            com.adobe.creativesdk.foundation.internal.auth.AdobeAuthIdentityManagementService r0 = r7.f4918b
            com.adobe.creativesdk.foundation.internal.auth.r r1 = new com.adobe.creativesdk.foundation.internal.auth.r
            r1.<init>(r7, r8, r3)
            com.adobe.creativesdk.foundation.internal.auth.s r2 = new com.adobe.creativesdk.foundation.internal.auth.s
            r2.<init>(r7, r8, r3)
            com.adobe.creativesdk.foundation.internal.auth.AdobeAuthIdentityManagementService.a(r0, r3, r1, r2)
            goto L90
        L74:
            if (r1 == 0) goto L90
            com.adobe.creativesdk.foundation.internal.auth.AdobeAuthIMSInfoNeeded r8 = com.adobe.creativesdk.foundation.internal.auth.AdobeAuthIMSInfoNeeded.valueOf(r1)
            com.adobe.creativesdk.foundation.internal.auth.AdobeAuthIMSInfoNeeded r0 = com.adobe.creativesdk.foundation.internal.auth.AdobeAuthIMSInfoNeeded.AdobeAuthIMSInfoNeededUnknownError
            if (r8 != r0) goto L8b
            com.adobe.creativesdk.foundation.internal.auth.V r8 = r7.f4917a
            com.adobe.creativesdk.foundation.auth.AdobeAuthException r0 = new com.adobe.creativesdk.foundation.auth.AdobeAuthException
            com.adobe.creativesdk.foundation.auth.AdobeAuthErrorCode r1 = com.adobe.creativesdk.foundation.auth.AdobeAuthErrorCode.ADOBE_AUTH_ERROR_CODE_UNKNOWN_ERROR
            r0.<init>(r1)
            r8.a(r0)
            goto L90
        L8b:
            com.adobe.creativesdk.foundation.internal.auth.V r0 = r7.f4917a
            r0.a(r8)
        L90:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adobe.creativesdk.foundation.internal.auth.C0315t.a(com.adobe.creativesdk.foundation.internal.net.l):void");
    }

    @Override // com.adobe.creativesdk.foundation.internal.auth.Z
    public void b() {
        this.f4917a.a(new AdobeAuthException(AdobeAuthErrorCode.ADOBE_AUTH_ERROR_CODE_CLIENT_SECRET_REQUIRED));
    }

    @Override // com.adobe.creativesdk.foundation.internal.auth.Z
    public void c() {
        this.f4917a.a(new AdobeAuthException(AdobeAuthErrorCode.ADOBE_AUTH_ERROR_CODE_CLIENT_ID_REQUIRED));
    }

    @Override // com.adobe.creativesdk.foundation.internal.net.F
    public void a(AdobeNetworkException adobeNetworkException) {
        AdobeAuthException a2;
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AuthIMS", "Inside getAccessTokenWithAuthCode(), authTokenHandler onError() callback" + new Date().toString());
        V v = this.f4917a;
        a2 = this.f4918b.a(adobeNetworkException);
        v.a(a2);
    }

    @Override // com.adobe.creativesdk.foundation.internal.auth.Z
    public void a() {
        this.f4917a.a(new AdobeAuthException(AdobeAuthErrorCode.ADOBE_AUTH_ERROR_CODE_DEVICE_ID_REQUIRED));
    }
}
