package com.google.android.gms.internal;

import android.content.Context;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class zznl<T extends IInterface> extends com.google.android.gms.common.internal.zzj<T> {
    /* JADX INFO: Access modifiers changed from: protected */
    public zznl(Context context, Looper looper, int i, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, com.google.android.gms.common.internal.zzf zzfVar) {
        super(context, looper, i, zzfVar, connectionCallbacks, onConnectionFailedListener);
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected Set<Scope> zzb(Set<Scope> set) {
        return com.google.android.gms.fitness.zza.a(set);
    }

    @Override // com.google.android.gms.common.internal.zzj, com.google.android.gms.common.api.Api.zzb
    public boolean zzlN() {
        return !zznk.zzau(getContext());
    }

    @Override // com.google.android.gms.common.internal.zzj
    public boolean zzpe() {
        return true;
    }
}
