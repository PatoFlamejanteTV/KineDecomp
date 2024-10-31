package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fr implements GoogleApiClient.ConnectionCallbacks {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzli f1562a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fr(zzli zzliVar) {
        this.f1562a = zzliVar;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public void a(Bundle bundle) {
        this.f1562a.zzabt.lock();
        try {
            this.f1562a.zzacj.onConnected(bundle);
        } finally {
            this.f1562a.zzabt.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public void a_(int i) {
        this.f1562a.zzabt.lock();
        try {
            this.f1562a.zzacj.onConnectionSuspended(i);
        } finally {
            this.f1562a.zzabt.unlock();
        }
    }
}
