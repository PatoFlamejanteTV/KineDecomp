package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.measurement.internal.zzm;

/* loaded from: classes.dex */
public class zzo extends com.google.android.gms.common.internal.zzj<zzm> {
    public zzo(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 93, zzfVar, connectionCallbacks, onConnectionFailedListener);
    }

    @Override // com.google.android.gms.common.internal.zzj
    /* renamed from: a */
    public zzm zzW(IBinder iBinder) {
        return zzm.zza.a(iBinder);
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzfK() {
        return "com.google.android.gms.measurement.START";
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzfL() {
        return "com.google.android.gms.measurement.internal.IMeasurementService";
    }
}
