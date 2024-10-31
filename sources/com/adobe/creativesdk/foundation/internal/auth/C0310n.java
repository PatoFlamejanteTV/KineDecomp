package com.adobe.creativesdk.foundation.internal.auth;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;

/* compiled from: AdobeAuthIdentityManagementService.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.auth.n */
/* loaded from: classes.dex */
class C0310n implements c.a.a.a.c<AdobeCSDKException> {

    /* renamed from: a */
    final /* synthetic */ String f4902a;

    /* renamed from: b */
    final /* synthetic */ String f4903b;

    /* renamed from: c */
    final /* synthetic */ C0311o f4904c;

    public C0310n(C0311o c0311o, String str, String str2) {
        this.f4904c = c0311o;
        this.f4902a = str;
        this.f4903b = str2;
    }

    @Override // c.a.a.a.c
    public void a(AdobeCSDKException adobeCSDKException) {
        this.f4904c.f4905a.a(this.f4902a, this.f4903b);
    }
}
