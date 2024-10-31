package com.adobe.creativesdk.foundation.internal.storage.controllers;

import com.adobe.creativesdk.foundation.internal.storage.controllers.C0449nd;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MobileCreationPackageItemsFragment.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.od, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0454od implements com.adobe.creativesdk.foundation.storage.vd {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0449nd.b f6363a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0454od(C0449nd.b bVar) {
        this.f6363a = bVar;
    }

    @Override // com.adobe.creativesdk.foundation.storage.vd
    public void a() {
        C0449nd.b bVar = this.f6363a;
        if (bVar.f6352a == null) {
            return;
        }
        C0449nd c0449nd = C0449nd.this;
        c0449nd.h(c0449nd.T.getName());
        this.f6363a.f6352a.c();
    }
}
