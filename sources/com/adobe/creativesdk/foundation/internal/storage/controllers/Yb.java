package com.adobe.creativesdk.foundation.internal.storage.controllers;

import com.adobe.creativesdk.foundation.internal.auth.AdobeAuthIdentityManagementService;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CCFilesWithUploadFragment.java */
/* loaded from: classes.dex */
public class Yb implements Zc {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean f5894a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C0415hc f5895b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Yb(C0415hc c0415hc, boolean z) {
        this.f5895b = c0415hc;
        this.f5894a = z;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Zc
    public void a() {
        this.f5895b.Aa();
        this.f5895b.e(false);
        com.adobe.creativesdk.foundation.internal.collaboration.h.c().a(this.f5895b.Ga().getHref().toString(), AdobeAuthIdentityManagementService.K().e(), new Wb(this, this.f5895b.getActivity()));
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Zc
    public void b() {
    }
}
