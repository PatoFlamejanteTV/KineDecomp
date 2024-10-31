package com.google.android.gms.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

/* loaded from: classes.dex */
class fv implements GoogleApiClient.OnConnectionFailedListener {

    /* renamed from: a */
    final /* synthetic */ zzlo f1566a;
    final /* synthetic */ zzli b;

    public fv(zzli zzliVar, zzlo zzloVar) {
        this.b = zzliVar;
        this.f1566a = zzloVar;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
    public void a(ConnectionResult connectionResult) {
        this.f1566a.zzb((zzlo) new Status(8));
    }
}
