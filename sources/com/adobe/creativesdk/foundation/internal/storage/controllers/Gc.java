package com.adobe.creativesdk.foundation.internal.storage.controllers;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DesignLibraryItemsFragment.java */
/* loaded from: classes.dex */
public class Gc implements com.adobe.creativesdk.foundation.internal.collaboration.a.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.internal.collaboration.h f5651a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f5652b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Jc f5653c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Gc(Jc jc, com.adobe.creativesdk.foundation.internal.collaboration.h hVar, String str) {
        this.f5653c = jc;
        this.f5651a = hVar;
        this.f5652b = str;
    }

    @Override // com.adobe.creativesdk.foundation.internal.collaboration.a.b
    public void a(String str) {
        this.f5653c.l(str);
    }

    @Override // com.adobe.creativesdk.foundation.internal.collaboration.a.b
    public void onError(int i) {
        if (i == 404) {
            if (this.f5653c.T.q()) {
                this.f5653c.cb();
                return;
            } else {
                this.f5651a.a(this.f5652b, "application/vnd.adobe.library+dcx", this.f5653c.T.m(), true, true, new Fc(this));
                return;
            }
        }
        this.f5653c.bb();
    }
}
