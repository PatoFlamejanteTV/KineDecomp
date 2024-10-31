package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
final class r implements GoogleApiClient.ConnectionCallbacks {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ AtomicReference f10851a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ StatusPendingResult f10852b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ zaaw f10853c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(zaaw zaawVar, AtomicReference atomicReference, StatusPendingResult statusPendingResult) {
        this.f10853c = zaawVar;
        this.f10851a = atomicReference;
        this.f10852b = statusPendingResult;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        this.f10853c.a((GoogleApiClient) this.f10851a.get(), this.f10852b, true);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public final void onConnectionSuspended(int i) {
    }
}
