package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

/* renamed from: com.google.android.gms.common.api.internal.s, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C0814s implements GoogleApiClient.OnConnectionFailedListener {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ StatusPendingResult f10854a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0814s(zaaw zaawVar, StatusPendingResult statusPendingResult) {
        this.f10854a = statusPendingResult;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        this.f10854a.a((StatusPendingResult) new Status(8));
    }
}
