package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.GoogleApiManager;

/* loaded from: classes.dex */
final class B implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ ConnectionResult f10713a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ GoogleApiManager.zaa f10714b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public B(GoogleApiManager.zaa zaaVar, ConnectionResult connectionResult) {
        this.f10714b = zaaVar;
        this.f10713a = connectionResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f10714b.onConnectionFailed(this.f10713a);
    }
}
