package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

/* loaded from: classes.dex */
public class fw implements ResultCallback<Status> {

    /* renamed from: a */
    final /* synthetic */ zzlo f1567a;
    final /* synthetic */ boolean b;
    final /* synthetic */ GoogleApiClient c;
    final /* synthetic */ zzli d;

    public fw(zzli zzliVar, zzlo zzloVar, boolean z, GoogleApiClient googleApiClient) {
        this.d = zzliVar;
        this.f1567a = zzloVar;
        this.b = z;
        this.c = googleApiClient;
    }

    @Override // com.google.android.gms.common.api.ResultCallback
    /* renamed from: a */
    public void onResult(Status status) {
        if (status.d() && this.d.isConnected()) {
            this.d.reconnect();
        }
        this.f1567a.zzb((zzlo) status);
        if (this.b) {
            this.c.disconnect();
        }
    }
}
