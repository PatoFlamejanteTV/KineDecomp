package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.zzkk;

/* loaded from: classes.dex */
public final class zzki extends com.google.android.gms.common.internal.zzj<zzkk> {
    private final Bundle zzSa;

    public zzki(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, Auth.zza zzaVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 16, zzfVar, connectionCallbacks, onConnectionFailedListener);
        this.zzSa = zzaVar == null ? new Bundle() : zzaVar.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzj
    /* renamed from: zzau, reason: merged with bridge method [inline-methods] */
    public zzkk zzW(IBinder iBinder) {
        return zzkk.zza.zzaw(iBinder);
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzfK() {
        return "com.google.android.gms.auth.service.START";
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzfL() {
        return "com.google.android.gms.auth.api.internal.IAuthService";
    }

    @Override // com.google.android.gms.common.internal.zzj, com.google.android.gms.common.api.Api.zzb
    public boolean zzlN() {
        com.google.android.gms.common.internal.zzf zzpa = zzpa();
        return (TextUtils.isEmpty(zzpa.a()) || zzpa.a(Auth.g).isEmpty()) ? false : true;
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected Bundle zzly() {
        return this.zzSa;
    }
}
