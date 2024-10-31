package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.internal.zze;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzx;

/* loaded from: classes.dex */
public class zzg extends zzj<zze> {

    /* renamed from: a, reason: collision with root package name */
    private final com.google.android.gms.auth.api.signin.zzg f813a;

    public zzg(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, com.google.android.gms.auth.api.signin.zzg zzgVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 87, zzfVar, connectionCallbacks, onConnectionFailedListener);
        this.f813a = (com.google.android.gms.auth.api.signin.zzg) zzx.a(zzgVar);
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
