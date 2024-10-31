package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzlb;
import com.google.android.gms.internal.zzli;
import java.util.Iterator;

/* loaded from: classes.dex */
public class zzlf implements zzlj {
    private final zzli zzabr;

    public zzlf(zzli zzliVar) {
        this.zzabr = zzliVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <A extends Api.zzb> void zza(zzli.f<A> fVar) throws DeadObjectException {
        this.zzabr.zzb(fVar);
        Api.zzb zza = this.zzabr.zza((Api.zzc<Api.zzb>) fVar.zznx());
        if (zza.isConnected() || !this.zzabr.zzach.containsKey(fVar.zznx())) {
            fVar.zzb(zza);
        } else {
            fVar.zzv(new Status(17));
        }
    }

    @Override // com.google.android.gms.internal.zzlj
    public void begin() {
        while (!this.zzabr.zzaca.isEmpty()) {
            try {
                zza(this.zzabr.zzaca.remove());
            } catch (DeadObjectException e) {
                Log.w("GACConnected", "Service died while flushing queue", e);
            }
        }
    }

    @Override // com.google.android.gms.internal.zzlj
    public void connect() {
    }

    @Override // com.google.android.gms.internal.zzlj
    public void disconnect() {
        this.zzabr.zzach.clear();
        this.zzabr.zznY();
        this.zzabr.zzg(null);
        this.zzabr.zzabZ.a();
    }

    @Override // com.google.android.gms.internal.zzlj
    public String getName() {
        return "CONNECTED";
    }

    @Override // com.google.android.gms.internal.zzlj
    public void onConnected(Bundle bundle) {
    }

    @Override // com.google.android.gms.internal.zzlj
    public void onConnectionSuspended(int i) {
        if (i == 1) {
            this.zzabr.zzoe();
        }
        Iterator<zzli.f<?>> it = this.zzabr.zzacm.iterator();
        while (it.hasNext()) {
            it.next().zzw(new Status(8, "The connection to Google Play services was lost"));
        }
        this.zzabr.zzg(null);
        this.zzabr.zzabZ.a(i);
        this.zzabr.zzabZ.a();
        if (i == 2) {
            this.zzabr.connect();
        }
    }

    @Override // com.google.android.gms.internal.zzlj
    public <A extends Api.zzb, R extends Result, T extends zzlb.zza<R, A>> T zza(T t) {
        return (T) zzb(t);
    }

    @Override // com.google.android.gms.internal.zzlj
    public void zza(ConnectionResult connectionResult, Api<?> api, int i) {
    }

    @Override // com.google.android.gms.internal.zzlj
    public <A extends Api.zzb, T extends zzlb.zza<? extends Result, A>> T zzb(T t) {
        try {
            zza((zzli.f) t);
        } catch (DeadObjectException e) {
            this.zzabr.zza(new fl(this, this));
        }
        return t;
    }
}
