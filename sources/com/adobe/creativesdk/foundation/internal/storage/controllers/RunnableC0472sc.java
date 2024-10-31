package com.adobe.creativesdk.foundation.internal.storage.controllers;

import com.adobe.creativesdk.foundation.internal.storage.controllers.C0477tc;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DesignLibraryCollectionFragment.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.sc, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class RunnableC0472sc implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0477tc f6400a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0472sc(C0477tc c0477tc) {
        this.f6400a = c0477tc;
    }

    @Override // java.lang.Runnable
    public void run() {
        C0477tc.b bVar;
        C0477tc.b bVar2;
        C0477tc.b bVar3;
        bVar = this.f6400a.U;
        if (bVar != null) {
            bVar2 = this.f6400a.U;
            if (bVar2.f6425a != null) {
                bVar3 = this.f6400a.U;
                bVar3.f6425a.setVisibility(8);
            }
        }
    }
}
