package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class F implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zace f10736a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public F(zace zaceVar) {
        this.f10736a = zaceVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zach zachVar;
        zachVar = this.f10736a.f10915h;
        zachVar.b(new ConnectionResult(4));
    }
}
