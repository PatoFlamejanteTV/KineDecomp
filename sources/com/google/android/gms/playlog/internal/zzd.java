package com.google.android.gms.playlog.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.zzqd;

/* loaded from: classes.dex */
public class zzd implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    /* renamed from: a, reason: collision with root package name */
    private final zzqd.zza f2149a;
    private zzf b = null;
    private boolean c = true;

    public zzd(zzqd.zza zzaVar) {
        this.f2149a = zzaVar;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public void a(Bundle bundle) {
        this.b.a(false);
        if (this.c && this.f2149a != null) {
            this.f2149a.zzBr();
        }
        this.c = false;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
    public void a(ConnectionResult connectionResult) {
        this.b.a(true);
        if (this.c && this.f2149a != null) {
            if (connectionResult.a()) {
                this.f2149a.zzf(connectionResult.d());
            } else {
                this.f2149a.zzBs();
            }
        }
        this.c = false;
    }

    public void a(zzf zzfVar) {
        this.b = zzfVar;
    }

    public void a(boolean z) {
        this.c = z;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public void a_(int i) {
        this.b.a(true);
    }
}
