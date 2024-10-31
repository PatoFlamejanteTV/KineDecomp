package com.adobe.creativesdk.foundation.internal.storage.controllers;

import com.adobe.creativesdk.foundation.internal.auth.AdobeAuthIdentityManagementService;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CCFilesWithUploadFragment.java */
/* loaded from: classes.dex */
public class _b implements Zc {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f5901a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ boolean f5902b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ C0415hc f5903c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public _b(C0415hc c0415hc, String str, boolean z) {
        this.f5903c = c0415hc;
        this.f5901a = str;
        this.f5902b = z;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Zc
    public void a() {
        this.f5903c.Aa();
        this.f5903c.e(false);
        com.adobe.creativesdk.foundation.internal.collaboration.h.c().a(this.f5901a, AdobeAuthIdentityManagementService.K().e(), new Zb(this, this.f5903c.getActivity()));
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Zc
    public void b() {
    }
}
