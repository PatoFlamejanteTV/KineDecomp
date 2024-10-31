package com.adobe.creativesdk.foundation.internal.auth;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;

/* compiled from: AdobeAuthIdentityManagementService.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.auth.k */
/* loaded from: classes.dex */
class C0307k implements c.a.a.a.c<AdobeCSDKException> {

    /* renamed from: a */
    final /* synthetic */ String f4894a;

    /* renamed from: b */
    final /* synthetic */ String f4895b;

    /* renamed from: c */
    final /* synthetic */ C0308l f4896c;

    public C0307k(C0308l c0308l, String str, String str2) {
        this.f4896c = c0308l;
        this.f4894a = str;
        this.f4895b = str2;
    }

    @Override // c.a.a.a.c
    public void a(AdobeCSDKException adobeCSDKException) {
        this.f4896c.f4897a.a(this.f4894a, this.f4895b);
    }
}
