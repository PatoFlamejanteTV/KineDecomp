package com.google.android.gms.location.internal;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;

/* loaded from: classes.dex */
public class zzl extends zzb {
    private final zzk b;

    public zzl(Context context, Looper looper, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, String str) {
        this(context, looper, connectionCallbacks, onConnectionFailedListener, str, com.google.android.gms.common.internal.zzf.a(context));
    }

    public zzl(Context context, Looper looper, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, String str, com.google.android.gms.common.internal.zzf zzfVar) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, str, zzfVar);
        this.b = new zzk(context, this.f1857a);
    }

    @Override // com.google.android.gms.common.internal.zzj, com.google.android.gms.common.api.Api.zzb
    public void disconnect() {
        synchronized (this.b) {
            if (isConnected()) {
                try {
                    this.b.a();
                    this.b.b();
                } catch (Exception e) {
                    Log.e("LocationClientImpl", "Client disconnected before listeners could be cleaned up", e);
                }
            }
            super.disconnect();
        }
    }

    @Override // com.google.android.gms.common.internal.zzj
    public boolean zzpe() {
        return true;
    }
}
