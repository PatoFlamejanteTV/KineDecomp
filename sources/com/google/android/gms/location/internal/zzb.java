package com.google.android.gms.location.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.internal.zzi;

/* loaded from: classes.dex */
public class zzb extends com.google.android.gms.common.internal.zzj<zzi> {

    /* renamed from: a */
    protected final zzp<zzi> f1857a;
    private final String b;

    public zzb(Context context, Looper looper, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, String str, com.google.android.gms.common.internal.zzf zzfVar) {
        super(context, looper, 23, zzfVar, connectionCallbacks, onConnectionFailedListener);
        this.f1857a = new a(this);
        this.b = str;
    }

    @Override // com.google.android.gms.common.internal.zzj
    /* renamed from: a */
    public zzi zzW(IBinder iBinder) {
        return zzi.zza.a(iBinder);
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzfK() {
        return "com.google.android.location.internal.GoogleLocationManagerService.START";
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzfL() {
        return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected Bundle zzly() {
        Bundle bundle = new Bundle();
        bundle.putString("client_name", this.b);
        return bundle;
    }
}
