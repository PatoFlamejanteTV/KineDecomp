package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.GoogleApiManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class A implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ GoogleApiManager.zaa f10712a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public A(GoogleApiManager.zaa zaaVar) {
        this.f10712a = zaaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f10712a.o();
    }
}
