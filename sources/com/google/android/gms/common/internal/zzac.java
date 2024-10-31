package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

/* loaded from: classes.dex */
public class zzac<T extends IInterface> extends zzj<T> {

    /* renamed from: a */
    private final Api.zzd<T> f1002a;

    public zzac(Context context, Looper looper, int i, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, zzf zzfVar, Api.zzd zzdVar) {
        super(context, looper, i, zzfVar, connectionCallbacks, onConnectionFailedListener);
        this.f1002a = zzdVar;
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected T zzW(IBinder iBinder) {
        return this.f1002a.a(iBinder);
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected void zzc(int i, T t) {
        this.f1002a.a(i, t);
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzfK() {
        return this.f1002a.a();
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzfL() {
        return this.f1002a.b();
    }
}
