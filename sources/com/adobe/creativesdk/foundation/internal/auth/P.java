package com.adobe.creativesdk.foundation.internal.auth;

import com.adobe.creativesdk.foundation.internal.auth.I;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeAuthSignInActivity.java */
/* loaded from: classes.dex */
public class P extends O {

    /* renamed from: e, reason: collision with root package name */
    private static final String f4848e = "P";

    /* renamed from: f, reason: collision with root package name */
    private ba f4849f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f4851h = false;

    /* renamed from: g, reason: collision with root package name */
    private boolean f4850g = false;

    private void a(ba baVar) {
        I.c cVar = baVar.f4877a;
        if (cVar != null && !this.f4851h) {
            b(cVar.f4822a);
        } else {
            this.f4844a.t();
        }
    }

    public void e() {
        ba baVar = new ba();
        baVar.f4878b = true;
        if (this.f4844a == null) {
            b(baVar);
        } else {
            a(baVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0031  */
    @Override // com.adobe.creativesdk.foundation.internal.auth.N
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.adobe.creativesdk.foundation.auth.AdobeAuthException r5) {
        /*
            r4 = this;
            r0 = 1
            r1 = 0
            if (r5 == 0) goto L26
            com.adobe.creativesdk.foundation.internal.auth.ba r2 = r4.f4849f
            if (r2 == 0) goto L26
            com.adobe.creativesdk.foundation.internal.auth.I$c r2 = r2.f4877a
            if (r2 == 0) goto L26
            com.adobe.creativesdk.foundation.auth.AdobeAuthErrorCode r2 = r5.getErrorCode()
            com.adobe.creativesdk.foundation.auth.AdobeAuthErrorCode r3 = com.adobe.creativesdk.foundation.auth.AdobeAuthErrorCode.ADOBE_AUTH_ERROR_CODE_OFFLINE
            if (r2 == r3) goto L26
            com.adobe.creativesdk.foundation.internal.auth.AdobeAuthSignInActivity r2 = r4.f4844a
            if (r2 != 0) goto L27
            boolean r2 = com.adobe.creativesdk.foundation.internal.auth.AdobeAuthSignInActivity.s()
            if (r2 != 0) goto L26
            r4.f4851h = r0
            com.adobe.creativesdk.foundation.internal.auth.ba r5 = r4.f4849f
            r4.b(r5)
            return
        L26:
            r0 = 0
        L27:
            if (r0 == 0) goto L31
            r4.f4850g = r1
            com.adobe.creativesdk.foundation.internal.auth.AdobeAuthSignInActivity r5 = r4.f4844a
            r5.t()
            goto L34
        L31:
            super.a(r5)
        L34:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adobe.creativesdk.foundation.internal.auth.P.a(com.adobe.creativesdk.foundation.auth.AdobeAuthException):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.auth.N
    public void a(String str, String str2) {
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, f4848e, "handle IMS result");
        if (this.f4850g) {
            return;
        }
        AdobeAuthIdentityManagementService K = AdobeAuthIdentityManagementService.K();
        I.c cVar = new I.c();
        cVar.f4824c = K.u();
        cVar.f4822a = K.r();
        cVar.f4823b = K.s();
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, f4848e, "adding account explicity : id:  " + cVar.f4824c);
        AdobeAuthSignInActivity.a(cVar);
    }

    public void a(I.c cVar) {
        if (cVar != null && cVar.f4822a != null) {
            this.f4850g = true;
        }
        ba baVar = new ba();
        baVar.f4877a = cVar;
        this.f4849f = baVar;
        if (this.f4844a == null) {
            b(baVar);
        } else {
            a(baVar);
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.auth.O, com.adobe.creativesdk.foundation.internal.auth.N
    protected void a(Object obj) {
        a((ba) obj);
    }
}
