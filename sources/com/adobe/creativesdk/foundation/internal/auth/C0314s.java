package com.adobe.creativesdk.foundation.internal.auth;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;

/* compiled from: AdobeAuthIdentityManagementService.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.auth.s, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0314s implements c.a.a.a.c<AdobeCSDKException> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f4914a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f4915b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ C0315t f4916c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0314s(C0315t c0315t, String str, String str2) {
        this.f4916c = c0315t;
        this.f4914a = str;
        this.f4915b = str2;
    }

    @Override // c.a.a.a.c
    public void a(AdobeCSDKException adobeCSDKException) {
        this.f4916c.f4917a.a(this.f4914a, this.f4915b);
    }
}
