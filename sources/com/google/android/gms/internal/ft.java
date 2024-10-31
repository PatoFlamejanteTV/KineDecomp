package com.google.android.gms.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ft implements GoogleApiClient.OnConnectionFailedListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Api f1564a;
    final /* synthetic */ int b;
    final /* synthetic */ zzli c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ft(zzli zzliVar, Api api, int i) {
        this.c = zzliVar;
        this.f1564a = api;
        this.b = i;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
    public void a(ConnectionResult connectionResult) {
        this.c.zzabt.lock();
        try {
            this.c.zzacj.zza(connectionResult, this.f1564a, this.b);
        } finally {
            this.c.zzabt.unlock();
        }
    }
}
