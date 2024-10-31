package com.google.android.gms.internal.config;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation;

/* loaded from: classes2.dex */
abstract class g<R extends Result> extends BaseImplementation.ApiMethodImpl<R, zzw> {
    public g(GoogleApiClient googleApiClient) {
        super(zze.API, googleApiClient);
    }

    protected abstract void a(Context context, zzah zzahVar) throws RemoteException;

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected /* synthetic */ void a(zzw zzwVar) throws RemoteException {
        zzw zzwVar2 = zzwVar;
        a(zzwVar2.getContext(), (zzah) zzwVar2.getService());
    }
}
