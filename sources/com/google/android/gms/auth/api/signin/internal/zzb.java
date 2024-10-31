package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInConfig;
import com.google.android.gms.auth.api.signin.internal.zze;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzj;

/* loaded from: classes.dex */
public class zzb extends zzj<zze> {

    /* renamed from: a, reason: collision with root package name */
    private final GoogleSignInConfig f809a;

    public zzb(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, GoogleSignInConfig googleSignInConfig, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 91, zzfVar, connectionCallbacks, onConnectionFailedListener);
        this.f809a = googleSignInConfig == null ? GoogleSignInConfig.d : googleSignInConfig;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzj
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public zze zzW(IBinder iBinder) {
        return zze.zza.a(iBinder);
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzfK() {
        return "com.google.android.gms.auth.api.signin.service.START";
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzfL() {
        return "com.google.android.gms.auth.api.signin.internal.ISignInService";
    }
}
