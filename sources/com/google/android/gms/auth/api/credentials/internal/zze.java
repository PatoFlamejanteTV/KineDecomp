package com.google.android.gms.auth.api.credentials.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.credentials.internal.zzh;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzj;

/* loaded from: classes.dex */
public final class zze extends zzj<zzh> {

    /* renamed from: a, reason: collision with root package name */
    private final Auth.AuthCredentialsOptions f797a;

    public zze(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, Auth.AuthCredentialsOptions authCredentialsOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 68, zzfVar, connectionCallbacks, onConnectionFailedListener);
        this.f797a = authCredentialsOptions;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzj
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public zzh zzW(IBinder iBinder) {
        return zzh.zza.a(iBinder);
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzfK() {
        return "com.google.android.gms.auth.api.credentials.service.START";
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzfL() {
        return "com.google.android.gms.auth.api.credentials.internal.ICredentialsService";
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected Bundle zzly() {
        return this.f797a == null ? new Bundle() : this.f797a.a();
    }
}
