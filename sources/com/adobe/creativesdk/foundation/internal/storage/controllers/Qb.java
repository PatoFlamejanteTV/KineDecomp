package com.adobe.creativesdk.foundation.internal.storage.controllers;

import com.adobe.creativesdk.foundation.internal.storage.controllers.Rb;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CCFilesListView.java */
/* loaded from: classes.dex */
public class Qb implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Rb f5791a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Qb(Rb rb) {
        this.f5791a = rb;
    }

    @Override // java.lang.Runnable
    public void run() {
        Rb.c cVar;
        Rb rb = this.f5791a;
        cVar = rb.m;
        rb.a(cVar.f5808c);
        this.f5791a.m = null;
    }
}
