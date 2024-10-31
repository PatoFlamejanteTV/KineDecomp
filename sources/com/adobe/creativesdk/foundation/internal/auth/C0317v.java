package com.adobe.creativesdk.foundation.internal.auth;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;

/* compiled from: AdobeAuthIdentityManagementService.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.auth.v */
/* loaded from: classes.dex */
class C0317v implements c.a.a.a.c<AdobeCSDKException> {

    /* renamed from: a */
    final /* synthetic */ String f4922a;

    /* renamed from: b */
    final /* synthetic */ String f4923b;

    /* renamed from: c */
    final /* synthetic */ C0318w f4924c;

    public C0317v(C0318w c0318w, String str, String str2) {
        this.f4924c = c0318w;
        this.f4922a = str;
        this.f4923b = str2;
    }

    @Override // c.a.a.a.c
    public void a(AdobeCSDKException adobeCSDKException) {
        this.f4924c.f4926b.a(this.f4922a, this.f4923b);
    }
}
