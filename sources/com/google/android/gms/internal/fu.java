package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
class fu implements GoogleApiClient.ConnectionCallbacks {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AtomicReference f1565a;
    final /* synthetic */ zzlo b;
    final /* synthetic */ zzli c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fu(zzli zzliVar, AtomicReference atomicReference, zzlo zzloVar) {
        this.c = zzliVar;
        this.f1565a = atomicReference;
        this.b = zzloVar;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public void a(Bundle bundle) {
        this.c.zza((GoogleApiClient) this.f1565a.get(), this.b, true);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public void a_(int i) {
    }
}
