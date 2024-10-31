package com.adobe.creativesdk.foundation.internal.storage.controllers;

import com.adobe.creativesdk.foundation.internal.storage.controllers.Jc;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DesignLibraryItemsFragment.java */
/* loaded from: classes.dex */
public class Kc implements c.a.a.a.a.b.a.a.c {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Jc.b f5704a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Kc(Jc.b bVar) {
        this.f5704a = bVar;
    }

    @Override // c.a.a.a.a.b.a.a.c
    public void a() {
        Jc.a aVar = this.f5704a.f5689a;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // c.a.a.a.a.b.a.a.c
    public void b() {
        Jc jc = Jc.this;
        jc.h(jc.T.m());
        Jc.b bVar = this.f5704a;
        bVar.f5689a.a(Jc.this.T.h());
    }
}
