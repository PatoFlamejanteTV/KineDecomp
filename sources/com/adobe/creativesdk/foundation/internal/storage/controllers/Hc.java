package com.adobe.creativesdk.foundation.internal.storage.controllers;

import com.adobe.creativesdk.foundation.internal.storage.controllers.Jc;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DesignLibraryItemsFragment.java */
/* loaded from: classes.dex */
public class Hc implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Jc f5661a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Hc(Jc jc) {
        this.f5661a = jc;
    }

    @Override // java.lang.Runnable
    public void run() {
        Jc.c cVar;
        Jc.c cVar2;
        Jc.c cVar3;
        cVar = this.f5661a.aa;
        if (cVar != null) {
            cVar2 = this.f5661a.aa;
            if (cVar2.f5691a != null) {
                cVar3 = this.f5661a.aa;
                cVar3.f5691a.setVisibility(8);
            }
        }
    }
}
